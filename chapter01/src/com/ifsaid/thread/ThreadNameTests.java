package com.ifsaid.thread;

import java.util.stream.IntStream;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 多线程命名
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 9:10
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadNameTests {

    private final static String THREAD_NAME_PREFIX = "ALEX-";

    public static void main(String[] args) {
        IntStream.range(0, 5).mapToObj(index -> {
            return new Thread(
                    () -> System.out.println(Thread.currentThread().getName()),
                    THREAD_NAME_PREFIX + index
            );
        }).forEach(Thread::start);
    }


}
