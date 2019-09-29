package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 模拟售票窗口 重写 Thread.run() 方法
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 13:55
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class TicketWindow extends Thread {

    // 柜台名称
    private final String name;

    // 每天最多受理50笔业务
    private final static int Max = 50;

    private static int index;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= Max) {
            System.out.println("柜台：" + name + " 当前号码是: " + (index++));
        }
    }


    public static void main(String[] args) {
        new TicketWindow("一号出号机").start();
        new TicketWindow("二号出号机").start();
        new TicketWindow("三号出号机").start();
        new TicketWindow("四号出号机").start();
    }

}
