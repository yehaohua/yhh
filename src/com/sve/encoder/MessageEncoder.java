package com.sve.encoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.sve.bean.Message;

public class MessageEncoder implements Encoder.Text<Message>{
	@Override
    public String encode(Message msg) throws EncodeException {
		System.out.println("解码");
        return msg.getSymbol();//获得运算符
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
    	 System.out.println("MessageEncoder------初始化");
    }

    @Override
    public void destroy() {
    	System.out.println("MessageEncoder------销毁");
    }
}
