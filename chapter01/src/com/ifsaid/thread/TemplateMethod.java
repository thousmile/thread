package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 模板方式设计模式
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/24 13:49
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class TemplateMethod {

    public final void print(String message) {
        System.out.println("#########################");
        wrapPrint(message);
        System.out.println("#########################");
    }

    protected void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };
        t1.print("Hello World");

        TemplateMethod t2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("-" + message + "-");
            }
        };
        t2.print("Hello World");

    }

}
