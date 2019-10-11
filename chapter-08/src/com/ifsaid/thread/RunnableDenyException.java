package com.ifsaid.thread;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 22:10
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }

    public RunnableDenyException() {
    }
}
