package com.pluto.test;

import java.util.Arrays;
import java.util.Map;

public class SmsService implements ISmsService {

	private SmsUtil smsUtil;

	@Override
	public Boolean loginSms( String phoneNum,String randomNum) {
		smsUtil=new SmsUtil();
		Boolean isSuccess = null;
		try {
			Map<String, Object> reqMap = smsUtil.sendSmS(SmsUtil.LOGIN, Arrays.asList(phoneNum),
					Arrays.asList(randomNum));
			isSuccess = Integer.valueOf(reqMap.get("Fee").toString()) == 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

}
