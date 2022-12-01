package com.demo.grpc.service.grpc.impl;

import com.demo.grpc.service.grpc.HelloGrpcReply;
import com.demo.grpc.service.grpc.HelloGrpcRequest;
import com.demo.grpc.service.grpc.HelloServiceGrpc;
import com.demo.grpc.service.service.TestService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * grpc服务接口实现
 * YangKuo 2022/12/1 14:52
 */
@GrpcService
public class HelloGrpcServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Autowired
    private TestService testService;

    @Override
    public void helloGrpc(HelloGrpcRequest request, StreamObserver<HelloGrpcReply> responseObserver) {
        String s = testService.testService(request.getInputString());
        HelloGrpcReply build = HelloGrpcReply.newBuilder()
                .setResult(request.getInputString() + "调用了helloGrpc" + "," + s)
                .build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }
}
