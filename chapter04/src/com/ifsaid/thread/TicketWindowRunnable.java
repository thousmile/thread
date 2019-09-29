package com.ifsaid.thread;

import java.util.List;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 模拟售票窗口  实现 Runnable 接口
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 13:55
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class TicketWindowRunnable implements Runnable {

    public static void main(String[] args) {
        var task = new TicketWindowRunnable();
        new Thread(task, "1号窗口").start();
        new Thread(task, "2号窗口").start();
        new Thread(task, "3号窗口").start();
    }

    private int index;

    private final static int MAX = 500;

    private final static Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX) {
            while (index <= MAX) {
                System.out.println("柜台：" + Thread.currentThread().getName() + " 当前号码是: " + (index++));
            }
        }
    }
}
