package com.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class ByteBufTest1 {

    public static void main(String[] args) {
        ByteBuf buf = Unpooled.copiedBuffer("张hello world!", Charset.forName("utf-8"));

        if(buf.hasArray()){
            byte[] bytes = buf.array();
            System.out.println(new String(bytes, Charset.forName("utf-8")));

            System.out.println(buf);
            System.out.println(buf.arrayOffset());
            System.out.println(buf.readerIndex());
            System.out.println(buf.writerIndex());
            System.out.println(buf.capacity());
            System.out.println(buf.getCharSequence(0, 4, Charset.forName("utf-8")));
            int length = buf.readableBytes();
            System.out.println(length);

            for (int i = 0;  i < buf.readableBytes(); ++i){
                System.out.println((char)buf.getByte(i));
            }
        }
    }
}
