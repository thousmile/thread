package com.ifsaid.thread.lock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: WangChenChen<9 3 2 5 6 0 4 3 5 @ qq.com>
 * @date: 2019/9/27 22:04
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();


}
