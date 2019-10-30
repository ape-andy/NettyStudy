package com.netty.day1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {


            @Override
            protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
                System.out.println(msg.getClass());
                System.out.println("远程客户端地址："+ctx.channel().remoteAddress());
                if(msg instanceof HttpRequest) {
                    HttpRequest httpRequest = (HttpRequest)msg;

                    URI uri = new URI(httpRequest.uri());
                    if("/favicon.ico".equals(uri.getPath())){
                        System.out.println("请求favicon.ico");
                        return;
                    }
                    System.out.println("请求方法名："+httpRequest.method().name());
                    System.out.println("请求地址："+httpRequest.uri());
                    ByteBuf content = Unpooled.copiedBuffer("Hello World!", CharsetUtil.UTF_8);
                    FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_0,
                            HttpResponseStatus.OK, content);
                    response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
                    response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
                    ctx.writeAndFlush(response);
                }
            }

            @Override
            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                System.out.println("channel active");
                super.channelActive(ctx);

            }

            @Override
            public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
                System.out.println("channel registered");
                super.channelRegistered(ctx);
            }

            @Override
            public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
                System.out.println("handler added");
                super.handlerAdded(ctx);
            }

            @Override
            public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
                System.out.println("channel unRegistered");
                super.channelUnregistered(ctx);
            }

            @Override
            public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                System.out.println("channel inactive");
                super.channelInactive(ctx);
            }
}
