package com.example.demo.huyue.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author huyue01@sinovatech.com 2020/1/31 22:42
 */
public class Client {
    public void connect(int port, String host) {
        //工作线程组
        EventLoopGroup group = new NioEventLoopGroup();

        try {

            Bootstrap client = new Bootstrap();
            client.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChildChannelHandler());

            //发起异步连接
            ChannelFuture channelFuture = client.connect(host, port).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connect(8080,"127.0.0.1");
    }
}
