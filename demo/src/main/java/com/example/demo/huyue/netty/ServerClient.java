package com.example.demo.huyue.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author huyue01@sinovatech.com 2020/1/31 21:47
 */
public class ServerClient{

    public void run() {
        //主线程组，用于接收客户端的请求，但是不做任何的具体的业务，老板一样接待客户
        EventLoopGroup boss = new NioEventLoopGroup(1);
        //工作线程，处理其他任务
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(boss,worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChildChannelHandler());

            //绑定端口
            ChannelFuture channelFuture = server.bind(8080).sync();

            System.out.println("服务器启动完成，监听端口：8080");

            //等待服务监听并关闭
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        ServerClient client = new ServerClient();
        client.run();
    }
}
