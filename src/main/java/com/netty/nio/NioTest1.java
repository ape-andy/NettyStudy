package com.netty.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < 5; i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }
        //10
        System.out.println("before flip limit: " + buffer.limit());
        buffer.flip();
        //5
        System.out.println("after flip limit: " + buffer.limit());
        System.out.println("enter while loop");
        while(buffer.hasRemaining()){
            // 0 1 2 3 4
            System.out.println("position: " + buffer.position());
            //5
            System.out.println("limit: " + buffer.limit());
            //10
            System.out.println("capacity: "+ buffer.capacity());
            System.out.println(buffer.get());
        }
    }
}
