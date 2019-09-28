package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: WangChenChen<9 3 2 5 6 0 4 3 5 @ qq.com>
 * @date: 2019/9/28 21:12
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadGroupInterrupt {

    public static void main(String[] args) throws InterruptedException {
        var group = new ThreadGroup("group1");
        new Thread(group, () -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("t1 will exit.");
        }, "t1").start();
        new Thread(group, () -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("t2 will exit.");
        }, "t2").start();

        TimeUnit.MILLISECONDS.sleep(2);

        group.interrupt();

    }

}
