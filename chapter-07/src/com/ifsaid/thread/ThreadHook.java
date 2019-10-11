package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: Hook 现场
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 21:20
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("The hook thread 1 is running.");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The hook thread 1 will exit.");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("The hook thread 2 is running.");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The hook thread 2 will exit.");
        }));

        System.out.println("The program will is stopping.");
    }

}
