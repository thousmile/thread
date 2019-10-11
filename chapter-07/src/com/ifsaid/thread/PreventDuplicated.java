package com.ifsaid.thread;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/10/11 21:25
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

public class PreventDuplicated {

    private final static String LOCK_PATH = "C:\\Users\\smile\\";

    private final static String LOCK_FILE = ".lock";

    private final static String PERMISSIONS = "-a----";

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The program received kill SIGNAL.");
            getLockFile().toFile().delete();
        }));
        checkRunning();
        for (; ; ) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println("program is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if (path.toFile().exists()) {
            throw new RuntimeException("The program already running.");
        }
        Files.createFile(path, null);
    }

    private static Path getLockFile() {
        return Path.of(LOCK_PATH, LOCK_FILE);
    }
}
