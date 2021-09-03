package com.qyc.job.socket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/3 2:16 上午
 */
@Component
@ServerEndpoint("/job")
public class JobWebSocketServer {

    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    /**
     * 当客户端打开连接：1.添加会话对象
     */
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("建立socket连接");
        onlineSessions.put(session.getId(), session);

    }

    /**
     * 当客户端发送消息：
     * 约定传递的消息为JSON字符串
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {

    }

    /**
     * 当关闭连接
     */
    @OnClose
    public void onClose(Session session) {
        onlineSessions.remove(this);
    }

    /**
     * 当通信发生异常：打印错误日志
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 公共方法：发送信息给所有人
     */
    public void sendMessageToAll(String msg) {
        onlineSessions.forEach((id, session) -> {
            try {
                System.out.println("发送信息");
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
