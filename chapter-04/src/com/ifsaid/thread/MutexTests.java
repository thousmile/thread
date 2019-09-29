package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 互斥锁 练习
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/25 11:44
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class MutexTests {

    public static void main(String[] args) {
        var mutex = new MutexTests();
        for (int i = 0; i < 10; i++) {
            new Thread(mutex::accessResource).start();
        }
    }

    private final static Object MUTEX = new Object();

    public void accessResource() {
        synchronized (MUTEX) {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
