package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 线程工厂
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 22:05
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

@FunctionalInterface
public interface ThreadFactory {

    /**
     * @description: 创建线程
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/10/11 22:05
     */
    Thread createThread(Runnable runnable);

}
