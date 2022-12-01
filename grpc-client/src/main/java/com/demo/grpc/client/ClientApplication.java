package com.demo.grpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 客户端服务启动类
 * YangKuo 2022/5/31 11:44
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(ClientApplication.class, args);
        System.out.println("启动环境====" + configurableApplicationContext.getEnvironment().getActiveProfiles()[0]);
        synchronized (ClientApplication.class) {
            while (true) {
                try {
                    ClientApplication.class.wait();
                } catch (Throwable ignored) {
                }
            }
        }
    }

}
