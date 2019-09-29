package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 线程休眠
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 16:05
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadSleepTests {

    public static void main(String[] args) {
        new Thread(() -> {
            var startTime = System.currentTimeMillis();
            sleep(3000L);
            var endTime = System.currentTimeMillis();
        }).start();

        var startTime = System.currentTimeMillis();
        sleep(3000L);
        var endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread total spend %d ms", (endTime - startTime)));
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
