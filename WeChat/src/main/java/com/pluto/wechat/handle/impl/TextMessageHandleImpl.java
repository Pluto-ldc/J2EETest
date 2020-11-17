package com.pluto.wechat.handle.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pluto.wechat.handle.TextMessageHandle;

import cn.hutool.core.util.StrUtil;

@Service
public class TextMessageHandleImpl implements TextMessageHandle {

	private String msgReply = null;
	private List<String> params = null;

	@Override
	public String init(String msgReceive) {
		// 将获取到的信息通过空格格式化为参数列表
		this.params = new ArrayList<String>(Arrays.asList(msgReceive.split(" ")));
		// 检查参数列表是否含有空值，如果有就移除
		for (int i = 0; i < params.size(); i++) {
			if (StrUtil.isBlankOrUndefined(params.get(i))) {
				params.remove(i);
				i--;
			}
		}
		if (params.size() == 1) {
			msgReply = "接受到了一个参数";
		} else if (params.size() == 2) {
			msgReply = "接受到了两个参数";
		} else if (params.size() == 3) {
			msgReply = "接受到了三个参数";
		} else if (params.size() == 4) {
			msgReply = "接受到了四个参数";
		} else {
			msgReply = "参数格式化异常";
		}

		return msgReply;
	}

}
