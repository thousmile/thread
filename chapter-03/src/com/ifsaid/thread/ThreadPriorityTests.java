package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 线程的优先级
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 16:54
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadPriorityTests {

    public static void main(String[] args) {
        // test1();
        test2();
    }


    /**
     * @description: 线程的优先级不能超过所在线程组的最大优先级
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/9/24 16:59
     */
    public static void test1() {
        var group = new ThreadGroup("test-group");
        group.setMaxPriority(7);
        var thread = new Thread(group, "t1");
        thread.setPriority(10);
        System.out.println("Thread.Priority: " + thread.getPriority());
    }


    /**
     * @description: 子线程的优先级取决于，父线程的优先级
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/9/24 17:01
     */
    public static void test2() {
        var t1 = new Thread();
        System.out.println("t1.Priority: " + t1.getPriority());

        var t2 = new Thread(() -> {
            var t3 = new Thread();
            System.out.println("t3.Priority: " + t3.getPriority());
        });
        t2.setPriority(6);
        t2.start();

        System.out.println("t2.Priority: " + t2.getPriority());


    }
}
