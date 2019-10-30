package com.netty.day8;

import java.io.ByteArrayOutputStream;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

/**
 * @author: andy
 * @date: 2019/9/1
 */
public class ObjectToBytes extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
        ObjectEncoderOutputStream encoderOs = new ObjectEncoderOutputStream(byteOs);
        encoderOs.writeObject(msg);
        out.writeBytes(byteOs.toByteArray());
    }
}
