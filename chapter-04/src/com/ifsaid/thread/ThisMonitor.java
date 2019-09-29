package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 描述
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/27 15:13
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThisMonitor {

    public synchronized void method1() {
        System.out.println(currentThread().getName() + "enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        System.out.println(currentThread().getName() + "enter to method2");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1, "t1").start();
        new Thread(thisMonitor::method2, "t2").start();
    }

}
