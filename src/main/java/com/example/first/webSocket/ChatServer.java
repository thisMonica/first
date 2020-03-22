package com.example.first.webSocket;

import org.apache.commons.logging.LogFactory;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hu
 * @date 2020/3/21 17:12
 */
@ServerEndpoint("chat")//声明ws的名字
public class ChatServer {


//    static Log log= LogFactory.get(ChatServer.class);
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     *
     */
    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static ConcurrentHashMap<String,ChatServer> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收userId*/
    private String userId="";

    /**
     * 通道建立成功需要执行的动作
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("连接已经建立，sessionID：" + session.getId());

    }

    /**
     * 接受对方数据
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("开始接受数据：" + message);

    }

    public void onSend(String message) {
        System.out.println("开始接受数据：" + message);

    }

    @OnClose
    public void onClose() {
        System.out.println("连接已经关闭：");

    }






}
