package com.netty.day2;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;
import org.junit.Assert;

public class Test {

    @org.junit.Test
   public void test1(){
       int nThread = SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2);
       System.out.println(nThread);
       Assert.assertEquals(nThread, 16);

   }
}
