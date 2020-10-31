package com.pluto.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import cn.hutool.core.util.RandomUtil;

/*
 * 
 * curl 
 * -H 'Host: sms.tencentcloudapi.com' 
 * -H 'X-TC-Action: SendSms' 
 * -H 'X-TC-RequestClient: APIExplorer' 
 * -H 'X-TC-Timestamp: 1604128330' 
 * -H 'X-TC-Version: 2019-07-11' 
 * -H 'X-TC-Language: zh-CN' 
 * -H 'Content-Type: application/json' 
 * -H 'Authorization: TC3-HMAC-SHA256 Credential=AKIDrzrSm2VatulNillqSnrjIabolSs1lkGV/2020-10-31/sms/tc3_request, SignedHeaders=content-type;host, Signature=43672ae551f6c74f19133fbabafefdab961582bf2bc075cad33d441006cc6028' 
 * -d '{"PhoneNumberSet":["+8617638357365"],"TemplateParamSet":["123456"],"TemplateID":"747111","SmsSdkAppid":"1400389445","Sign":"叮咚的二十一"}'
 *  'https://sms.tencentcloudapi.com/'
 *  */

/*
 * 
 *
 OkHttpClient client = new OkHttpClient().newBuilder()
  .build();
MediaType mediaType = MediaType.parse("application/json");
RequestBody body = RequestBody.create(mediaType, "{\"PhoneNumberSet\":[\"+8617638357365\"],\"TemplateParamSet\":[\"123456\"],\"TemplateID\":\"747111\",\"SmsSdkAppid\":\"1400389445\",\"Sign\":\"叮咚的二十一\"}");
Request request = new Request.Builder()
  .url("https://sms.tencentcloudapi.com/")
  .method("POST", body)
  .addHeader("Host", "sms.tencentcloudapi.com")
  .addHeader("X-TC-Action", "SendSms")
  .addHeader("X-TC-RequestClient", "APIExplorer")
  .addHeader("X-TC-Timestamp", "1604134521")
  .addHeader("X-TC-Version", "2019-07-11")
  .addHeader("X-TC-Language", "zh-CN")
  .addHeader("Content-Type", "application/json")
  .addHeader("Authorization", "TC3-HMAC-SHA256 Credential=AKIDrzrSm2VatulNillqSnrjIabolSs1lkGV/2020-10-31/sms/tc3_request, SignedHeaders=content-type;host, Signature=e4fc6385b5bda4cb39e6aa0ea3ea197198fd15fafcb6637cd15d4810c8a70b6d")
  .build();
Response response = client.newCall(request).execute();
 * 
 * */

class Test0 {
	@Test
	void test() throws Exception {
		SmsUtil smsUtil = new SmsUtil();
		List<String> PhoneNumberSet = Arrays.asList("+8617638357365");
		List<String> TemplateParamSet = Arrays.asList("406875");
		Map<String, Object> reqJsonObject = smsUtil.sendSmS(SmsUtil.GENERAL, PhoneNumberSet, TemplateParamSet);
		System.out.println(reqJsonObject);
	}

	@Test
	void test2() throws Exception {
		ISmsService smsService=new SmsService();
		String randomNum=RandomUtil.randomNumbers(6);
		Boolean isSuccess = smsService.loginSms("+8617638357365",randomNum);
		System.out.println(randomNum);
		System.out.println(isSuccess);
	}
	
}
