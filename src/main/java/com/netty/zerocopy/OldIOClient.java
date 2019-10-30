package com.netty.zerocopy;


import java.io.*;
import java.net.Socket;

public class OldIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8899);
        String fileName = "E:\\火狐下载\\spark-2.4.4-bin-hadoop2.7.tgz";

        InputStream inputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();
        while ((readCount = inputStream.read(buffer)) >= 0){


            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送总字节数：" + total + ", 总耗时：" + (System.currentTimeMillis() - startTime) );

        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
