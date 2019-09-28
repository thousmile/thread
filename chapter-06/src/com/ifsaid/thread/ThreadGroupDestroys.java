package com.ifsaid.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: WangChenChen<9 3 2 5 6 0 4 3 5 @ qq.com>
 * @date: 2019/9/28 7:55
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class ThreadGroupDestroys {

    public static void main(String[] args) {
        ThreadGroup testGroup = new ThreadGroup("testGroup");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("testGroup.isDestroyed(): " + testGroup.isDestroyed());
        mainGroup.list();
        testGroup.destroy();
        System.out.println("testGroup.isDestroyed(): " + testGroup.isDestroyed());
        mainGroup.list();
    }


}
