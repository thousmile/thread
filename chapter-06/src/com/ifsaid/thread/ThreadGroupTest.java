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

public class ThreadGroupTest {

    public static void main(String[] args) throws InterruptedException {
        var threadGroupTest = new ThreadGroupTest();
        // threadGroupTest.testGroupParent();
        threadGroupTest.testEnumerate();
    }

    public void testEnumerate() throws InterruptedException {
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        Thread myThread = new Thread(myGroup, () -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread");

        myThread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

        var threadList = new Thread[mainThreadGroup.activeCount()];

        int recurseSize = mainThreadGroup.enumerate(threadList);

        System.out.println("recurseSize: " + recurseSize);

        recurseSize = mainThreadGroup.enumerate(threadList, false);

        System.out.println("recurseSize: " + recurseSize);

    }

    public void testGroupParent() {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

        var group1 = new ThreadGroup("group1");

        System.out.println(group1.getParent() == currentGroup);

        var group2 = new ThreadGroup(group1, "group2");

        System.out.println(group2.getParent() == group1);
    }

}
