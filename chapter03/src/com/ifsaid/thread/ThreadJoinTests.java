package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 线程的 Join
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 17:51
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadJoinTests {

    public static void main(String[] args) throws InterruptedException {
        // 1.定义两个线程，保存在集合中
        var collect = IntStream.range(1, 3).mapToObj(seq -> {
            return new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " # " + i);
                    shortSleep();
                }
            }, String.format("thread-%s", String.valueOf(seq)));
        }).collect(Collectors.toList());

        // 2.启动线程
        collect.forEach(Thread::start);

        // 3.执行线程的jion方法
        for (Thread t : collect) {
            t.join();
        }

        // 4. main 线程循环输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " # " + i);
            shortSleep();
        }

    }


    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
