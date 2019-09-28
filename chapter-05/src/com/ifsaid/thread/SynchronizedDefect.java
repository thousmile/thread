package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: WangChenChen<9 3 2 5 6 0 4 3 5 @ qq.com>
 * @date: 2019/9/27 21:57
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class SynchronizedDefect {

    public synchronized void syncMethod() {
        System.out.println(Thread.currentThread().getName() + " sleep.");
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var defect = new SynchronizedDefect();
        var t1 = new Thread(defect::syncMethod, "T1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(2);

        var t2 = new Thread(defect::syncMethod, "T2");
        t2.start();

        TimeUnit.MILLISECONDS.sleep(2);

        t2.interrupt();

        System.out.println("interrupted : " + t2.isInterrupted());
        System.out.println("state :" + t2.getState());

    }
}
