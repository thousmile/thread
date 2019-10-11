package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 21:16
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class EmptyExceptionHandler {

    public static void main(String[] args) {
        var threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.getParent());
        System.out.println(threadGroup.getParent().getParent());
        var thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println(1 / 0);
        }, "Test-Thread");
        thread.start();

    }

}
