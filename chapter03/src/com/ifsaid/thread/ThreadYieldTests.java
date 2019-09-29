package com.ifsaid.thread;

import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 线程礼让
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 16:05
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadYieldTests {

    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(index->{
            return new Thread(() -> {
                if (index == 1) {
                    Thread.yield();
                }
                System.out.println(index);
            });
        }).forEach(Thread::start);
    }

}
