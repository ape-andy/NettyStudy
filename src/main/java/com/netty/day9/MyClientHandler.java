package com.netty.day9;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.serialization.ObjectDecoderInputStream;

import java.io.InputStream;
import java.io.ObjectInputStream;

public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到服务端信息");
        System.out.println(msg);
        Gson gson = new Gson();
        String str = gson.toJson(msg);
        Person person = gson.fromJson(str, Person.class);
        System.out.println(person.getAddress());
        System.out.println(person.getName());
        System.out.println(person.getAge());

//        ObjectDecoderInputStream odis = new ObjectDeco derInputStream((InputStream) msg);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接建立");
        super.channelActive(ctx);
//        Person person = new Person("zhangsan", 18, "nanjing");
        ctx.writeAndFlush("from client");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
