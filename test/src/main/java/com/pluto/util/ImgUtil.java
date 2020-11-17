package com.pluto.util;

import java.io.File;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;



public class ImgUtil {

	private final String host = "https://v1.alapi.cn/api/";

	/*
	 * ali 阿里云 sogou 搜狗 alapi Alapi qihoo 360奇虎 toutiao 头条 xiaomi 小米 imgTg imt.tg
	 */

	public static final String SOUGOU = "sogou";
	public static final String ALI = "ali";
	public static final String ALAPI = "alapi";
	public static final String QIHU360 = "qihoo";
	public static final String TOUTIAO = "toutiao";
	public static final String XIAOMI = "xiaomi";
	public static final String IMGTG = "imgTg";

	/*
	 * 1 返回 t.cn 短网址 2 返回 url.cn 短网址 3 返回 dwz.mk 短网址 4 返回 suo.im 短网址 5 返回 u.nu 短网址 6
	 * 返回 mrw.so 短网址 7 返回 suo.nz 短网址 8 返回 sohu.gg 短网址
	 */

	public static final Integer T_CN = 1;
	public static final Integer URL_CN = 2;
	public static final Integer DWZ_MK = 3;
	public static final Integer SUO_IM = 4;
	public static final Integer U_NU = 5;
	public static final Integer MRW_SO = 6;
	public static final Integer SUO_NZ = 7;
	public static final Integer SOHU_GG = 8;

	private final String token = "1hGSh27xqBOxtdNIPSxY";

	public JSONObject uploadImg(String type, File img) {
		String url = null;
		Integer code = null;
		String response = HttpRequest.post(host + "image").form("image", img).form("type", type)
				.form("token", this.token).execute().body();
		JSONObject jsonObject = new JSONObject(response);
		code = jsonObject.getInt("code");
		if (code == 200) {
			url = jsonObject.getJSONObject("data").getJSONObject("url").getStr(type);
		}
		return new JSONObject().accumulate("code", code).accumulate("url", url).accumulate("msg",
				jsonObject.getStr("msg"));
	}

	public JSONObject shortUrl(Integer type, String longUrl) {
		String long_url = longUrl;
		String short_url = null;
		Integer code = null;
		String response = HttpRequest.post(host + "url").form("url", longUrl).form("type", type)
				.form("token", this.token).execute().body();
		JSONObject jsonObject = new JSONObject(response);
		code = jsonObject.getInt("code");
		if (code == 200) {
			long_url = jsonObject.getJSONObject("data").getStr("long_url");
			short_url = jsonObject.getJSONObject("data").getStr("short_url");
		}
		return new JSONObject().accumulate("code", code).accumulate("shortUrl", short_url)
				.accumulate("msg", jsonObject.getStr("msg")).accumulate("longUrl", long_url);

	}

	public JSONObject imgUploadShortUrl(String imgType, File img, Integer urlType) {
		String longUrl = null;
		String shortUrl = null;
		Integer code = null;
		String msg = null;
		JSONObject upRes = this.uploadImg(imgType, img);
		code = upRes.getInt("code");
		msg = upRes.getStr("msg");
		if (code == 200) {
			longUrl = upRes.getStr("url");
			JSONObject urlRes = this.shortUrl(urlType, longUrl);
			code = urlRes.getInt("code");
			msg = urlRes.getStr("msg");
			if (code == 200) {
				longUrl = urlRes.getStr("longUrl");
				shortUrl = urlRes.getStr("shortUrl");
			}
		}
		return new JSONObject().accumulate("code", code).accumulate("msg", msg).accumulate("longUrl", longUrl)
				.accumulate("shortUrl", shortUrl);

	}

}
