package com.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
      DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三")
                .setAddress("南京")
                .setAge(30)
                .build();
      byte[] student2ByteArray = student.toByteArray();

      DataInfo.Student student1 = DataInfo.Student.parseFrom(student2ByteArray);
        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getAddress());
    }
}
