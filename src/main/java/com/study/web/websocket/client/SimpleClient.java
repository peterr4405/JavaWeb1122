package com.study.web.websocket.client;

import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class SimpleClient {

    public static void main(String[] args) throws Exception {
        URI uri = new URI("ws://localhost:8080/JavaWeb1122/websocket/server");
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(new SimpleClient(), uri);

        Thread.sleep(10_000);

        session.close();

    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.printf("Client say: %s 已進入\n", session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        System.out.printf("%s 傳來: %s\n", session.getId(), message);
        if (session.isOpen()) {
            session.getAsyncRemote().sendText("訊息: " + message + ", sessionID: " + session.getId());
        }

    }

    @OnClose
    public void onClose(Session session) {

    }
}
