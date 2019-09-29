package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 线程的打断，打断阻塞中的线程
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 17:21
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadInterruptTests {

    public static void main(String[] args) throws InterruptedException {
        test4();
    }


    /**
     * @description: 打断阻塞中的线程
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/9/24 17:29
     */
    public static void test1() throws InterruptedException {
        var t1 = new Thread(() -> {
            try {
                // 休眠一分钟
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Oh, i am be interrupted.");
            }
        }, "t1");
        t1.start();
        // 主线程 休眠 2 秒
        TimeUnit.SECONDS.sleep(2);
        // 打断线程 [t1] 休眠
        t1.interrupt();
    }

    /**
     * @description: TDD
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/9/24 17:33
     */
    public static void test2() throws InterruptedException {
        var t1 = new Thread(() -> {
            while (true) {

            }
        });
        t1.setDaemon(true);
        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println(String.format("Thread is Interrupted ? %s \n", t1.isInterrupted()));
        t1.interrupt();
        System.out.println(String.format("Thread is Interrupted ? %s \n", t1.isInterrupted()));
    }


    /**
     * @description: TDD
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/9/24 17:33
     */
    public static void test3() throws InterruptedException {
        var t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.printf("I am be interrupted ? %s \n\n", isInterrupted());
                    }
                }
            }
        };
        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println(String.format("Thread is Interrupted ? %s \n", t1.isInterrupted()));
        t1.interrupt();
        System.out.println(String.format("Thread is Interrupted ? %s \n", t1.isInterrupted()));
    }


    /**
     * @description:
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/9/24 17:42
     */
    public static void test4() {
        // 1.判断当前线程是否被中断
        System.out.printf("main thread is interrupted ? %s \n\n", Thread.interrupted());

        // 2.中断当前线程
        Thread.currentThread().interrupt();

        // 3.判断当前线程是否被中断
        System.out.printf("main thread is interrupted ? %s \n\n", Thread.currentThread().isInterrupted());

        try {
            // 4.当前线程执行可中断方法
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // 5.捕获中断信号
            System.out.println("I will be interrupted still.");
        }

    }


}
