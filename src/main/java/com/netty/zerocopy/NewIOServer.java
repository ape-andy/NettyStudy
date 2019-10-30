package com.netty.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {

    public static void main(String[] args) throws IOException {

        InetSocketAddress address = new InetSocketAddress(8899);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        //端口tcp连接处于超时状态时，仍然可以绑定，需要在bind方法调用前调用
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            //配置成阻塞模式
            socketChannel.configureBlocking(true);

            int readCount = 0;

            while (-1 != readCount){
                readCount = socketChannel.read(byteBuffer);
                byteBuffer.clear();
            }
        }
    }
}
