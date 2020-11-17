package com.pluto.wechat.service;

import com.pluto.wechat.pojo.Message;

public interface MessageService {
	/**
	 * 消息处理之前先转换发送和接收者
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message before(Message messageReceive);

	/**
	 * 消息处理之后添加时间戳
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message after();

	/**
	 * 处理文本消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message textMessageValidate(Message messageReceive);

	/**
	 * 处理图片消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message imageMessageValidate(Message messageReceive);

	/**
	 * 处理语音消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message voiceMessageValidate(Message messageReceive);

	/**
	 * 处理视频消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message videoMessageValidate(Message messageReceive);

	/**
	 * 处理小视频消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message shortvideoMessageValidate(Message messageReceive);

	/**
	 * 处理位置消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message locationMessageValidate(Message messageReceive);

	/**
	 * 处理超链接消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message linkMessageValidate(Message messageReceive);

	/**
	 * 处理事件消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message eventMessageValidate(Message messageReceive);

	/**
	 * 处理无法识别的消息
	 * 
	 * @param messageReceive
	 * @return
	 */
	Message otherMessageValidate(Message messageReceive);

}
