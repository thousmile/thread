package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 线程的关闭
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/25 9:57
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadExitTests {

    public static void main(String[] args) throws InterruptedException {
        test1();
    }


    /**
     * @description: 使用 interrupt() 方法退出线程
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/9/25 9:58
     */
    public static void test1() throws InterruptedException {
        var work = new Thread(() -> {
            System.out.println("I will start work");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("I will work！！！！！！！");
            }
            System.out.println("I will be exiting.");
        }, "Thread-Exit");
        work.start();
        TimeUnit.SECONDS.sleep(1000);
        System.out.println("System will be shutdown.");
        work.interrupt();
    }


    /**
     * @description: 使用 volatile 变量 退出线程
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/9/25 9:58
     */
    public static void test2() throws InterruptedException {
        var work = new Thread(new MyTask());
        work.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("System will be shutdown.");
        work.interrupt();
    }

    static class MyTask implements Runnable {

        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("I will start work");
            while (!closed && !Thread.currentThread().isInterrupted()) {
                System.out.println("I will work！！！！！！！");
            }
            System.out.println("I will be exiting.");
        }

        public void close() {
            Thread.currentThread().interrupt();
            this.closed = true;
        }

    }


}
