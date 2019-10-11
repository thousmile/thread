package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: RunanbleQueue主要用于存放提交的 Runnable,该 Runnable是一个 BlockedQueue,并且有 limit的限制
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 22:00
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public interface RunnableQueue {

    /**
     * @description: 当有新任务来时，会先进 offer
     * @date: 2019/10/11 22:02
     */
    void offer(Runnable runnable);


    /**
     * @description: 工作线程通过 take 获取 Runnable
     * @date: 2019/10/11 22:02
     */
    Runnable take() throws InterruptedException;


    /**
     * @description: 获取列队中的任务数量
     * @date: 2019/10/11 22:02
     */
    int size();

}
