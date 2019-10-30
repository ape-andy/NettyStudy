package com.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * DirectByteBuffer
 */
public class NioTest8 {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("input2.txt");
        FileOutputStream outputStream = new FileOutputStream("output2.txt");
        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

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
