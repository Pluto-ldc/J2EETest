package com.pluto.wechat.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "xml")
public class Message {

	@JacksonXmlProperty(localName = "ToUserName")
	private String toUserName;
	@JacksonXmlProperty(localName = "FromUserName")
	private String fromUserName;
	@JacksonXmlProperty(localName = "CreateTime")
	private String createTime;
	@JacksonXmlProperty(localName = "MsgType")
	private String msgType;
	@JacksonXmlProperty(localName = "Content")
	private String content;
	@JacksonXmlProperty(localName = "MsgId")
	private String msgId;
	@JacksonXmlProperty(localName = "PicUrl")
	private String picUrl;
	@JacksonXmlProperty(localName = "MediaId")
	private String mediaId;
	@JacksonXmlProperty(localName = "Format")
	private String format;
	@JacksonXmlProperty(localName = "Recognition")
	private String recognition;	
	@JacksonXmlProperty(localName = "ThumbMediaId")
	private String thumbMediaId;	
	@JacksonXmlProperty(localName = "Label")
	private String label;
	@JacksonXmlProperty(localName = "Location_X")
	private String location_X;
	@JacksonXmlProperty(localName = "Location_Y")
	private String location_Y;
	@JacksonXmlProperty(localName = "Scale")
	private String scale;
	@JacksonXmlProperty(localName = "Url")
	private String url;
	@JacksonXmlProperty(localName = "Event")
	private String event;

	public Message(String toUserName, String fromUserName) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
	}

	public Message() {
		super();
	}

}