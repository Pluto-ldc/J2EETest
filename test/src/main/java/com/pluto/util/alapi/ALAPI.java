package com.pluto.util.alapi;

import java.io.File;

import com.pluto.util.alapi.param.ImgType;
import com.pluto.util.alapi.param.Main;
import com.pluto.util.alapi.param.UrlType;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;

/**
 * 常用API接口
 * 
 * @author pluto
 */
public class ALAPI {

	// Baseurl 所有的接口基于此链接，区别在于链接后拼接的参数
	private final String baseUrl = "https://v1.alapi.cn/api/";

	// 个人的token，每天有最大次数，每秒最多10次，不加也可，但次数会减少很多
	private final String token = "1hGSh27xqBOxtdNIPSxY";

	/**
	 * 图片上传接口
	 * 
	 * @param imgType 图片上传的目标
	 * @param img     被上传的图片
	 * @return JSONObject 返回Json字符串,例:<br>
	 *         {"code":200,"msg":"success","url":"https://www.baidu.com" }
	 */
	public JSONObject image(ImgType imgType, File img) {
		String type = imgType.getImgType();
		String url = null;
		Integer code = null;
		String response = HttpRequest.post(this.baseUrl + Main.image).form(Main.image.toString(), img)
				.form("type", type).form("token", this.token).execute().body();
		JSONObject jsonObject = new JSONObject(response);
		code = jsonObject.getInt("code");
		if (code == 200) {
			url = jsonObject.getJSONObject("data").getJSONObject("url").getStr(type);
		}
		return new JSONObject().accumulate("code", code).accumulate("url", url).accumulate("msg",
				jsonObject.getStr("msg"));
	}

	/**
	 * 长url转短url
	 * 
	 * @param urlType 目标url的域名类型
	 * @param longUrl 源url
	 * @return JSONObject 返回Json字符串,例:<br>
	 *         {"code":200,"msg":"success","longUrl":"https://www.baidu.com",
	 *         "shortUrl":"https://www.baidu.com"}
	 */
	public JSONObject url(UrlType urlType, String longUrl) {
		Integer type = urlType.getType();
		String long_url = longUrl;
		String short_url = null;
		Integer code = null;
		String response = HttpRequest.post(this.baseUrl + Main.url).form(Main.url.toString(), longUrl)
				.form("type", type).form("token", this.token).execute().body();
		JSONObject jsonObject = new JSONObject(response);
		code = jsonObject.getInt("code");
		if (code == 200) {
			long_url = jsonObject.getJSONObject("data").getStr("long_url");
			short_url = jsonObject.getJSONObject("data").getStr("short_url");
		}
		return new JSONObject().accumulate("code", code).accumulate("shortUrl", short_url)
				.accumulate("msg", jsonObject.getStr("msg")).accumulate("longUrl", long_url);

	}

	/**
	 * 查询IP信息
	 * 
	 * @param ip 要查询的ip
	 * @return 返回json字符串，例如:<br>
	 *         { "msg": "success", "code": 200, "data": { "endip":
	 *         "192.168.255.255", "isp": "", "ad_info": "", "ip": "192.168.1.1",
	 *         "beginip": "192.168.0.0", "pos": "", "location": "", "rectangle": ""
	 *         } }
	 */
	public JSONObject ip(String ip) {
		String response = HttpRequest.post(this.baseUrl + Main.ip)
				.form(Main.ip.toString(), ip)
				.form("format", "json")
				.form("token", this.token)
				.execute().body();
		JSONObject jsonObject = new JSONObject(response);
		jsonObject.remove("author");
		return jsonObject;
		
	}
	
}
