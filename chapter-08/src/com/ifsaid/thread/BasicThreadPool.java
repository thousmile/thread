package com.ifsaid.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 22:26
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class BasicThreadPool extends Thread implements ThreadPool {

    private final int initSize;

    private final int maxSize;

    private final int coreSize;

    private final int activeSize;

    private final ThreadFactory factory;

    private final RunnableQueue queue;

    private volatile boolean isShutdown = false;

    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    private final static DenyPolicy DISCARD_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();

    private final long keepAliveTime;

    private final TimeUnit timeUnit;

    public BasicThreadPool(int initSize,
                           int maxSize,
                           int coreSize,
                           int activeSize,
                           ThreadFactory factory,
                           int queueSize,
                           DenyPolicy denyPolicy,
                           long keepAliveTime,
                           TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.activeSize = activeSize;
        this.factory = factory;
        this.queue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
    }

    private void init(){
        start();
        for (int i = 0; i < initSize; i++) {
            newThread();
        }
    }

    private void newThread() {
    }


    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public int getInitSize() {
        return 0;
    }

    @Override
    public int getMaxSize() {
        return 0;
    }

    @Override
    public int getCoreSize() {
        return 0;
    }

    @Override
    public int getQueueSize() {
        return 0;
    }

    @Override
    public int getActiveCount() {
        return 0;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }
}
