package com.pluto.test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class SmsUtil {

	// 定义常用短信正文模版id
	public static final String UPDATE_PHONE = "747116";
	public static final String RESET_PASSWORD = "747115";
	public static final String REEGISTER = "747114";
	public static final String LOGIN = "747112";
	public static final String GENERAL = "747111";

	private final Charset UTF8 = StandardCharsets.UTF_8;
	private final String SECRET_ID = "AKIDrzrSm2VatulNillqSnrjIabolSs1lkGV";
	private final String SECRET_KEY = "ZrLYUO1NeFl23nJYVHsDPMn0xczDUUHw";
	private final String service = "sms";
	private final String host = "sms.tencentcloudapi.com";
	private final String algorithm = "TC3-HMAC-SHA256";
	private final String signedHeaders = "content-type;host";
	private final String SmsSdkAppid = "1400389445";
	private final String Sign = "叮咚的二十一";

	private String credentialScope;
	private String timestamp;
	private String date;
	private JSONObject payloadJsonObject;

	private void setTime() {
		this.timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 注意时区，否则容易出错
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		this.date = sdf.format(new Date(Long.valueOf(timestamp + "000")));
	}

	private byte[] hmac256(byte[] key, String msg) throws Exception {
		Mac mac = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, mac.getAlgorithm());
		mac.init(secretKeySpec);
		return mac.doFinal(msg.getBytes(UTF8));
	}

	private String sha256Hex(String s) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] d = md.digest(s.getBytes(UTF8));
		return DatatypeConverter.printHexBinary(d).toLowerCase();
	}

	public String getCanonicalRequest(String TemplateID, List<String> PhoneNumberSet, List<String> TemplateParamSet)
			throws Exception {
		// ************* 步骤 1：拼接规范请求串 *************
		String httpRequestMethod = "POST";
		String canonicalUri = "/";
		String canonicalQueryString = "";
		String canonicalHeaders = "content-type:application/json\n" + "host:" + host + "\n";
		this.payloadJsonObject = JSONUtil.createObj().accumulate("PhoneNumberSet", PhoneNumberSet)
				.accumulate("TemplateParamSet", TemplateParamSet).accumulate("TemplateID", TemplateID)
				.accumulate("SmsSdkAppid", SmsSdkAppid).accumulate("Sign", Sign);
		String payload = payloadJsonObject.toString();
		String hashedRequestPayload = sha256Hex(payload);
		String canonicalRequest = httpRequestMethod + "\n" + canonicalUri + "\n" + canonicalQueryString + "\n"
				+ canonicalHeaders + "\n" + signedHeaders + "\n" + hashedRequestPayload;
		return canonicalRequest;
	}

	public String getStringToSign(String TemplateID, List<String> PhoneNumberSet, List<String> TemplateParamSet)
			throws Exception {
		// ************* 步骤 2：拼接待签名字符串 *************
		this.credentialScope = date + "/" + service + "/" + "tc3_request";
		String hashedCanonicalRequest = sha256Hex(getCanonicalRequest(TemplateID, PhoneNumberSet, TemplateParamSet));
		String stringToSign = algorithm + "\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;
		return stringToSign;
	}

	public String getSignature(String TemplateID, List<String> PhoneNumberSet, List<String> TemplateParamSet)
			throws Exception {
		// ************* 步骤 3：计算签名 *************
		byte[] secretDate = hmac256(("TC3" + SECRET_KEY).getBytes(UTF8), date);
		byte[] secretService = hmac256(secretDate, service);
		byte[] secretSigning = hmac256(secretService, "tc3_request");
		String signature = DatatypeConverter
				.printHexBinary(hmac256(secretSigning, getStringToSign(TemplateID, PhoneNumberSet, TemplateParamSet)))
				.toLowerCase();
		return signature;
	}

	public String getAuthorization(String TemplateID, List<String> PhoneNumberSet, List<String> TemplateParamSet)
			throws Exception {
		// ************* 步骤 4：拼接 Authorization *************
		String Signature = getSignature(TemplateID, PhoneNumberSet, TemplateParamSet);
		String authorization = algorithm + " " + "Credential=" + SECRET_ID + "/" + credentialScope + ", "
				+ "SignedHeaders=" + signedHeaders + ", " + "Signature=" + Signature;
		return authorization;
	}

	public Map<String, Object> sendSmS(String TemplateID, List<String> PhoneNumberSet, List<String> TemplateParamSet)
			throws Exception {
		this.setTime();
		String authorization = getAuthorization(TemplateID, PhoneNumberSet, TemplateParamSet);
		String response = HttpRequest.post("https://" + this.host).header("Host", host).header("X-TC-Action", "SendSms")
				.header("X-TC-Timestamp", this.timestamp).header("X-TC-Version", "2019-07-11")
				.header("X-TC-Language", "zh-CN").header("Content-Type", "application/json")
				.header("Authorization", authorization).body(payloadJsonObject.toString()).execute().body();
		JSONObject reqJsonObject = new JSONObject(response);
		JSONObject jsonObject = null;
		try {
			jsonObject= reqJsonObject.getJSONObject("Response").getJSONArray("SendStatusSet").getJSONObject(0);
		} catch (NullPointerException e) {
			jsonObject=reqJsonObject.accumulate("Exception", e.toString());
		}
		return jsonObject;
	}

}
