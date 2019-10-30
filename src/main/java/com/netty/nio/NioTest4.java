package com.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");
        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true){
            byteBuffer.clear();//注释掉会怎么样?
            int read = inputChannel.read(byteBuffer);
            System.out.println("read: " + read);
            if(read == -1){
                break;
            }
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
            System.out.println("read: " + read);
        }

        inputStream.close();
        outputStream.close();
    }
}
