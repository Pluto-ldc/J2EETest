package com.pluto.wechat.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pluto.wechat.pojo.Message;
import com.pluto.wechat.service.MessageService;
import com.pluto.wechat.util.MessageType;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

@RestController
public class MessageController {

	@Autowired
	MessageService messageService;

	@GetMapping("/")
	public String validate(String signature, String timestamp, String nonce, String echostr) {
		if (StrUtil.hasEmpty(signature, timestamp, nonce, echostr)) {
			return null;
		}
		String token = "plutoldc";
		List<String> paramList = Arrays.asList(token, timestamp, nonce);
		Collections.sort(paramList);
		String sha1 = SecureUtil.sha1(paramList.get(0) + paramList.get(1) + paramList.get(2));
		return sha1.equals(signature) ? echostr : null;
	}

	@PostMapping(value = "/", produces = MediaType.TEXT_XML_VALUE)
	public Object test(@RequestBody Message messageReceive) {

		Message messageReply = messageService.before(messageReceive);

		switch (messageReceive.getMsgType()) {
		case MessageType.TEXT: {
			messageReply = messageService.textMessageValidate(messageReceive);
			break;
		}
		case MessageType.IMAGE: {
			messageReply = messageService.imageMessageValidate(messageReceive);
			break;
		}
		case MessageType.VOICE: {
			messageReply = messageService.voiceMessageValidate(messageReceive);
			break;
		}
		case MessageType.VIDEO: {
			messageReply = messageService.videoMessageValidate(messageReceive);
			break;
		}
		case MessageType.SHORT_VIDEO: {
			messageReply = messageService.shortvideoMessageValidate(messageReceive);
			break;
		}
		case MessageType.LINK: {
			messageReply = messageService.linkMessageValidate(messageReceive);
			break;
		}
		case MessageType.LOCATION: {
			messageReply = messageService.locationMessageValidate(messageReceive);
			break;
		}
		case MessageType.EVENT: {
			messageReply = messageService.eventMessageValidate(messageReceive);
			break;
		}
		default:
			messageReply = messageService.otherMessageValidate(messageReceive);
		}
		messageReply = messageService.after();
		return messageReply;

	}

}
