package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: WangChenChen<9 3 2 5 6 0 4 3 5 @ qq.com>
 * @date: 2019/9/28 7:55
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadGroupDaemon {

    public static void main(String[] args) throws InterruptedException {
        var group1 = new ThreadGroup("group-1");
        var group2 = new ThreadGroup("group-2");
        new Thread(group1, () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "group-1-t-1").start();

        new Thread(group2, () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "group-2-t-2").start();
        group1.setDaemon(true);

        TimeUnit.SECONDS.sleep(3);
        System.out.println("group1.isDestroyed(): " + group1.isDestroyed());
        System.out.println("group2.isDestroyed(): " + group2.isDestroyed());

    }


}
