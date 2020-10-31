package com.pluto.test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.*;;

public class Test {
	public static void main(String[] args) {
		try {

			Credential cred = new Credential("AKIDrzrSm2VatulNillqSnrjIabolSs1lkGV",
					"ZrLYUO1NeFl23nJYVHsDPMn0xczDUUHw");

			HttpProfile httpProfile = new HttpProfile();
			httpProfile.setEndpoint("sms.tencentcloudapi.com");

			ClientProfile clientProfile = new ClientProfile();
			clientProfile.setHttpProfile(httpProfile);

			SmsClient client = new SmsClient(cred, "", clientProfile);

			SendSmsRequest req = new SendSmsRequest();
			String[] phoneNumberSet1 = { "+8617638357365" };
			req.setPhoneNumberSet(phoneNumberSet1);

			String[] templateParamSet1 = { "123456" };
			req.setTemplateParamSet(templateParamSet1);

			req.setTemplateID("747111");
			req.setSmsSdkAppid("1400389445");
			req.setSign("叮咚的二十一");

			SendSmsResponse resp = client.SendSms(req);

			System.out.println(SendSmsResponse.toJsonString(resp));
		} catch (TencentCloudSDKException e) {
			System.out.println(e.toString());
		}

	}

	public static JsonObject sendSms() {
		try {
			Credential cred = new Credential("AKIDrzrSm2VatulNillqSnrjIabolSs1lkGV",
					"ZrLYUO1NeFl23nJYVHsDPMn0xczDUUHw");

			HttpProfile httpProfile = new HttpProfile();
			httpProfile.setEndpoint("sms.tencentcloudapi.com");

			ClientProfile clientProfile = new ClientProfile();
			clientProfile.setHttpProfile(httpProfile);

			SmsClient client = new SmsClient(cred, "", clientProfile);

			SendSmsRequest req = new SendSmsRequest();
			String[] phoneNumberSet1 = { "+8617638357365" };
			req.setPhoneNumberSet(phoneNumberSet1);

			String[] templateParamSet1 = { "123456" };
			req.setTemplateParamSet(templateParamSet1);

			req.setTemplateID("747111");
			req.setSmsSdkAppid("1400389445");
			req.setSign("叮咚的二十一");

			SendSmsResponse resp = client.SendSms(req);

			return (JsonObject) new JsonParser().parse(SendSmsResponse.toJsonString(resp));
		} catch (TencentCloudSDKException e) {
			System.out.println(e.toString());
		}
		return null;

	}

}