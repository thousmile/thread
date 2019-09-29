package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 线程组 测试
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 15:12
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadGroupTests {

    public static void main(String[] args) {
        var group = new ThreadGroup("test-group");

        var t1 = new Thread("t1");

        var t2 = new Thread(group, "t2");

        var mainThreadGroup = Thread.currentThread().getThreadGroup();

        System.out.println("mainThreadGroup.getName: " + mainThreadGroup.getName());
        System.out.println("t1.getName: " + t1.getThreadGroup().getName());
        System.out.println("t2.getName: " + t2.getThreadGroup().getName());
        System.out.println("t2 and group : " + (t2.getThreadGroup().getName() == group.getName()));

    }

}
