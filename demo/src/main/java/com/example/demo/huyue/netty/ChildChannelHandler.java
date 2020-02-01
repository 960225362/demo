package com.example.demo.huyue.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author huyue01@sinovatech.com 2020/1/31 22:26
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new ServerHandler())
                .addLast(new ClientHandler());
    }
}
