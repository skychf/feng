package com.skychf.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/{userid}")
@Slf4j
public class WebSocket {
    private Session session;
    private Integer userid;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(@PathParam("userid") Integer userid, Session session) {
        this.session = session;
        this.userid = userid;
        webSocketSet.add(this);

    }
    public void onClose() {
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message) {
        Integer sendUserid = Integer.parseInt(message.split("[|]")[1]);
        String sendMessage = message.split("[|]")[0];
        sendMessage(sendMessage, sendUserid);
    }

    public void sendMessage(String message, Integer userid) {
        for (WebSocket webSocket: webSocketSet) {
            log.info("websocket 广播消息：{}", message);
            try {
                if (webSocket.userid == userid) {
                    webSocket.session.getBasicRemote().sendText(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
