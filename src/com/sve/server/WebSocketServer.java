package com.sve.server;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sve.bean.Message;
import com.sve.decoder.MessageDecoder;
import com.sve.encoder.MessageEncoder;

@ServerEndpoint(value = "/calculate",
decoders = {//设置组码的类
        MessageDecoder.class,
},
encoders = {//设置解码的类
        MessageEncoder.class
}
)
public class WebSocketServer {
	
    @OnClose
    public void onClosed(Session session) {
        System.out.println("onClosed");
    }
    
    public void handle(String result, Session session)
    {
    	try {
			session.getBasicRemote().sendObject((new Message(0,result,0)));//发送消息（一个Message对象）
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncodeException e) {
			e.printStackTrace();
		}
    }
    
    @OnMessage
    public void onMessage(Message message, Session session){
    	double result = 0 ;
        switch (message.getSymbol()){
            case Message.ADD_REQUEST:
            	result = message.getNum1() + message.getNum2();
            	handle(result+"",session);
                break;
            case Message.MINU_REQUEST:
            	result = message.getNum1() - message.getNum2();
            	handle(result+"",session);
                break;
            case Message.MULTI_REQUEST:
            	result = message.getNum1() * message.getNum2();
            	handle(result+"",session);
                break;
            case Message.DIV_REQUEST:
            	result = message.getNum1() / message.getNum2();
            	handle(result+"",session);
                break;
            default:
            	handle("",null);
        }
        System.out.println("结果为："+message.getNum1()+message.getSymbol()+message.getNum2()+"="+result);
    	}
    }
 