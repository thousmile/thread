package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 任务列队满的时候，拒绝策略
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 22:06
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

@FunctionalInterface
public interface DenyPolicy {

    void reject(Runnable runnable, ThreadPool pool);

    /**
     * @description: 该拒绝策略会直接将任务丢弃
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/10/11 22:09
     */
    class DiscardDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool pool) {
            System.out.println("DiscardDenyPolicy...丢弃任务!!!");
        }
    }

    /**
     * @description: 该拒绝策略会向任务提交者抛出异常
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/10/11 22:09
     */
    class AbortDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool pool) {
            throw new RunnableDenyException("The runnable " + runnable + "will be abort.");
        }
    }

    /**
     * @description: 该拒绝策略会使任务在提交者所在的线程中执行任务
     * @author: Wang Chen Chen<932560435@qq.com>
     * @date: 2019/10/11 22:08
     */
    class RunnerDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool pool) {
            if (!pool.isShutdown()) {
                runnable.run();
            }
        }
    }

}
