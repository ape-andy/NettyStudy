package com.netty.nio;

import java.nio.ByteBuffer;

public class NioTest5 {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(15);
        buffer.putLong(5100000000L);
        buffer.putDouble(65.32);
        buffer.putChar('我');
        buffer.putShort((short) 65);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());

    }
}
