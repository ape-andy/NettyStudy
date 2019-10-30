package com.netty.day8;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到客户端信息");
        System.out.println(msg);
        if(msg instanceof Person){
            Person person = (Person) msg;
            System.out.println(person.toString());
        }

        Person person2 = new Person("lisis", 22, "北京");
        ctx.writeAndFlush(person2);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接建立");
//        Person person = new Person("张三", 19, null);
        Person person = new Person();
        person.setAddress("南京");
        ctx.writeAndFlush(person);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
