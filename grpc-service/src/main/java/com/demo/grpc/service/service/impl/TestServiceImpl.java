package com.demo.grpc.service.service.impl;

import com.demo.grpc.service.service.TestService;
import org.springframework.stereotype.Service;

/**
 * 测试服务接口实现
 * YangKuo 2022/12/1 14:50
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String testService(String test) {
        return test + "调用到了测试服务！";
    }

}
