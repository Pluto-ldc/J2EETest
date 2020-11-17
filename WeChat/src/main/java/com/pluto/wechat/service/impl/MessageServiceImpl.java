package com.pluto.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluto.wechat.handle.TextMessageHandle;
import com.pluto.wechat.pojo.Message;
import com.pluto.wechat.service.MessageService;
import com.pluto.wechat.util.MessageType;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private TextMessageHandle twMessageHandle;

	private Message messageReply = null;

	@Override
	public Message before(Message messageReceive) {
		this.messageReply = new Message(messageReceive.getFromUserName(), messageReceive.getToUserName());
		return messageReply;
	}

	@Override
	public Message after() {
		messageReply.setCreateTime(String.valueOf(System.currentTimeMillis() / 1000));
		return messageReply;
	}

	@Override
	public Message otherMessageValidate(Message messageReceive) {
		messageReply.setContent("无法识别的消息！");
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

	@Override
	public Message textMessageValidate(Message messageReceive) {
		messageReply.setContent(twMessageHandle.init(messageReceive.getContent()));
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

	@Override
	public Message imageMessageValidate(Message messageReceive) {
		messageReply.setContent("图片消息！"+messageReceive.toString());
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

	@Override
	public Message voiceMessageValidate(Message messageReceive) {
		messageReply.setContent("声音消息！"+messageReceive.toString());
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

	@Override
	public Message videoMessageValidate(Message messageReceive) {
		messageReply.setContent("视频消息！"+messageReceive.toString());
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

	@Override
	public Message shortvideoMessageValidate(Message messageReceive) {
		messageReply.setContent("小视频消息！"+messageReceive.toString());
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

	@Override
	public Message locationMessageValidate(Message messageReceive) {
		messageReply.setContent("位置消息！"+messageReceive.toString());
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

	@Override
	public Message linkMessageValidate(Message messageReceive) {
		messageReply.setContent("超链接消息！"+messageReceive.toString());
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

	@Override
	public Message eventMessageValidate(Message messageReceive) {
		messageReply.setContent("事件消息！"+messageReceive.toString());
		messageReply.setMsgType(MessageType.TEXT);
		return messageReply;
	}

}
