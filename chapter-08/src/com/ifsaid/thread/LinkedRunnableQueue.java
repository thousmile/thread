package com.ifsaid.thread;

import java.util.LinkedList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 22:19
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class LinkedRunnableQueue implements RunnableQueue {

    private final int limit;

    private final DenyPolicy denyPolicy;

    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    private final ThreadPool pool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool pool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.pool = pool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                denyPolicy.reject(runnable, pool);
            } else {
                // 将任务加入列队最后
                runnableList.addLast(runnable);
                // 唤醒阻塞中的线程
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            if (runnableList.isEmpty()) {
                try {
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
        }
        return runnableList.removeFirst();
    }

    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
