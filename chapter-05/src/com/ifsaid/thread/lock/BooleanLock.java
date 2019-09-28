package com.ifsaid.thread.lock;

import java.util.*;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.currentThread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: WangChenChen<9 3 2 5 6 0 4 3 5 @ qq.com>
 * @date: 2019/9/27 22:07
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class BooleanLock implements Lock {

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> lockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                lockedList.add(currentThread());
                this.wait();
            }
            lockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                var remainingmills = mills;
                var endMills = System.currentTimeMillis() - mills;
                while (locked) {
                    if (remainingmills <= 0) {
                        throw new TimeoutException("can not get the lock during " + mills +" ms.");
                    }

                    if (!lockedList.contains(currentThread())) {
                        lockedList.add(currentThread());
                        this.wait(remainingmills);
                        remainingmills = endMills - System.currentTimeMillis();
                    }
                }

                lockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock.")
                        .ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(lockedList);
    }
}
