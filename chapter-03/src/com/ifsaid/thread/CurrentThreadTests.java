package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 获取当前线程的引用
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 17:03
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class CurrentThreadTests {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                var tc = Thread.currentThread();
                System.out.println("tc == this： " + (tc == this));
                System.out.println(String.format("currentThread.getId: %s  this.getId: %s ", tc.getId(), this.getId()));
            }
        }.start();

        var name = Thread.currentThread().getName();
        System.out.println("main".equals(name));

    }

}
