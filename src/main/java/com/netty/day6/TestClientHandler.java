package com.netty.day6;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

       int randomInt = new Random().nextInt(3);

       System.out.println(randomInt);

       MyDataInfo.MyMessage myMessage = null;

       if(randomInt == 0){
           myMessage = MyDataInfo.MyMessage.newBuilder()
                   .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                   .setPerson(MyDataInfo.Person.newBuilder()
                           .setName("刘航")
                           .setAge(24)
                           .setAddress("宿迁")
                           .build())
                   .build();
       }else if(randomInt == 1){
           myMessage = MyDataInfo.MyMessage.newBuilder()
                   .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                   .setDog(MyDataInfo.Dog.newBuilder()
                           .setName("狗狗")
                           .setAge(6)
                           .build())
                   .build();
       }else {
           myMessage = MyDataInfo.MyMessage.newBuilder()
                   .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                   .setCat(MyDataInfo.Cat.newBuilder()
                           .setName("猫猫")
                           .setAge(7)
                           .build())
                   .build();
       }
        ctx.channel().writeAndFlush(myMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
