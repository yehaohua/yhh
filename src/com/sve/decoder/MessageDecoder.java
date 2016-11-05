package com.sve.decoder;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.sve.bean.Message;

public class MessageDecoder implements Decoder.Text<Message>{
	@Override
    public Message decode(String s) {
		System.out.println("组码");
        String[] tokens = s.split(":");//把S根据：分割之后放在字符串数组tokens里
        return new Message(new Double(tokens[1]), tokens[0], new Double(tokens[2]));
    }

    @Override
    public boolean willDecode(String s) {
    	System.out.println("判断是否是加减乘除中的一种情况");
        return s.startsWith(Message.ADD_REQUEST) ||
                s.startsWith(Message.MINU_REQUEST) ||
                s.startsWith(Message.MULTI_REQUEST) ||
               s.startsWith(Message.DIV_REQUEST);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        System.out.println("MessageDecoder------初始化");
    }

    @Override
    public void destroy() {
    	System.out.println("MessageDecoder------销毁");
    }
}
