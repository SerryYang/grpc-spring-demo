package com.demo.grpc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 服务端服务启动类
 * YangKuo 2022/5/31 11:47
 */
@SpringBootApplication
public class ServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(ServiceApplication.class, args);
        synchronized (ServiceApplication.class) {
            while (true) {
                try {
                    ServiceApplication.class.wait();
                } catch (Throwable ignored) {
                }
            }
        }
    }
}
