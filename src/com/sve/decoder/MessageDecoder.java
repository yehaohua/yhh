package com.sve.decoder;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.sve.bean.Message;

public class MessageDecoder implements Decoder.Text<Message>{
	@Override
    public Message decode(String s) {
		System.out.println("����");
        String[] tokens = s.split(":");//��S���ݣ��ָ�֮������ַ�������tokens��
        return new Message(new Double(tokens[1]), tokens[0], new Double(tokens[2]));
    }

    @Override
    public boolean willDecode(String s) {
    	System.out.println("�ж��Ƿ��ǼӼ��˳��е�һ�����");
        return s.startsWith(Message.ADD_REQUEST) ||
                s.startsWith(Message.MINU_REQUEST) ||
                s.startsWith(Message.MULTI_REQUEST) ||
               s.startsWith(Message.DIV_REQUEST);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        System.out.println("MessageDecoder------��ʼ��");
    }

    @Override
    public void destroy() {
    	System.out.println("MessageDecoder------����");
    }
}
