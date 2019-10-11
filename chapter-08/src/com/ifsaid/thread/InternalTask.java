package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 22:14
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class InternalTask implements Runnable {

    private final RunnableQueue queue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable take = queue.take();
                take.run();
            } catch (InterruptedException e) {
                this.running = false;
                break;
            }
        }

    }

    public void stop() {
        this.running = false;
    }
}
