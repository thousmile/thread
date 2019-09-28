package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description:
 * @author: WangChenChen<9 3 2 5 6 0 4 3 5 @ qq.com>
 * @date: 2019/9/27 21:26
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class WaitNotifyTest {

    public static void main(String[] args) {

        /**
         * 如果没有在 synchronized ()中调用 wait() 或者 notify() 行下面代码中的任何一个方法,
         * testWait() testNotify() 会抛出 IllegalMonitorStateException 异常
         *
         * 同步代码的 monitor必须与执行 wait notify方法的对象一致,简单地说就是用哪个对象的 monitor进行同步,
         * 就只能用哪个对象进行wait和 notify操作。运行下面代码中的任何一个方法, testWait2() testNotify2()
         * 同样都会抛出 IllegalMonitorStateException异常信息
         * Exception in thread "main" java.lang.IllegalMonitorStateException
         * at java.base/java.lang.Object.notify(Native Method)
         * at com.ifsaid.thread.WaitNotifyTest.testNotify(WaitNotifyTest.java:30)
         * at com.ifsaid.thread.WaitNotifyTest.main(WaitNotifyTest.java:17)
         * */
        var waitTest = new WaitNotifyTest();
        /*
        waitTest.testWait();

        waitTest.testWait2();

        waitTest.testNotify();

        waitTest.testNotify2();
        */
    }



    private void testWait() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    private void testNotify() {
        this.notify();
    }


    private final static Object MONITOR = new Object();

    private synchronized void testWait2() {
        try {
            MONITOR.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void testNotify2() {
        MONITOR.notify();
    }

}
