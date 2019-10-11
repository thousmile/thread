package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 21:56
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public interface ThreadPool {

    /**
     * @description: 该方法接受提交 Runnable任务
     * @date: 2019/10/11 22:02
     */
    void execute(Runnable runnable);

    /**
     * @description: 关闭并且销毁线程池
     * @date: 2019/10/11 22:02
     */
    void shutdown();

    /**
     * @description: 返回线程池的初始线程数量
     * @date: 2019/10/11 22:02
     */
    int getInitSize();

    /**
     * @description: 返回线程池最大的线程数量
     * @date: 2019/10/11 22:02
     */
    int getMaxSize();

    /**
     * @description: 返回核心线程数量
     * @date: 2019/10/11 22:02
     */
    int getCoreSize();

    /**
     * @description: 返回当前线程池任务数量
     * @date: 2019/10/11 22:02
     */
    int getQueueSize();

    /**
     * @description: 返回线程池中当前活跃的线程数量
     * @date: 2019/10/11 22:02
     */
    int getActiveCount();

    /**
     * @description: 判断线程池是否已被销毁
     * @date: 2019/10/11 22:02
     */
    boolean isShutdown();


}
