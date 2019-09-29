package com.ifsaid.thread;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 模拟售票窗口  实现 Runnable 接口
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 13:55
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class TicketWindowRunnable {

    public static void main(String[] args) {
        var task = new Runnable() {
            private int index;

            private static final int MAX = 50;

            @Override
            public void run() {
                while (index <= MAX) {
                    System.out.println("柜台：" + Thread.currentThread().getName() + " 当前号码是: " + (index++));
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        List.of(
                new Thread(task, "1号窗口"),
                new Thread(task, "2号窗口"),
                new Thread(task, "3号窗口"),
                new Thread(task, "4号窗口")
        ).forEach(t -> t.start());

    }

}
