package com.netty.zerocopy;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OldIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);

        while (true){
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] byteArr = new byte[4096];
            while (true){
                int readCount = dataInputStream.read(byteArr, 0, byteArr.length);
                if(-1 == readCount){
                    break;
                }

            }

        }
    }
}
