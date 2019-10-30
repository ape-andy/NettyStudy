package com.netty.day8;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.serialization.ObjectDecoderInputStream;

/**
 * @author: andy
 * @date: 2019/9/1
 */
public class BytesToObject extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println(in.readerIndex());
        System.out.println(in.writerIndex());
        System.out.println(in.capacity());
        byte[] bytes = new byte[in.writerIndex()];
        for (int i = 0; i < in.writerIndex(); i++) {
            bytes[i] = in.readByte();
        }

        InputStream byteIs = new ByteArrayInputStream(bytes);
        ObjectDecoderInputStream decoderIs = new ObjectDecoderInputStream(byteIs);
        out.add(decoderIs.readObject());
    }
}
