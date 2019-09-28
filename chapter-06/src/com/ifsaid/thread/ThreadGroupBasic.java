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

public class ThreadGroupBasic {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group1");

        Thread thread = new Thread(group, () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread");
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("activeCount: " + mainGroup.activeCount());
        System.out.println("activeGroupCount: " + mainGroup.activeGroupCount());
        System.out.println("getMaxPriority: " + mainGroup.getMaxPriority());
        System.out.println("getName: " + mainGroup.getName());
        System.out.println("getParent: " + mainGroup.getParent());
        mainGroup.list();
        System.out.println("---------------------------------------");
        System.out.println("parentOf(group): " + mainGroup.parentOf(group));
        System.out.println("parentOf(mainGroup): " + mainGroup.parentOf(mainGroup));


    }

}
