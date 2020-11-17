package com.pluto.img;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.pluto.util.ImgUtil;
import com.pluto.util.alapi.ALAPI;
import com.pluto.util.alapi.param.ImgType;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;

public class ImgUpload {

	@Test
	void test0() {
		String response = HttpRequest.post("https://v1.alapi.cn/api/image")
				.form("image", new File("/Users/pluto/Desktop/0.jpg")).form("type", "sogou")
				.form("token", "1hGSh27xqBOxtdNIPSxY").execute().body();
		System.out.println(response);
	}
	@Test
	void test1() {
		ImgUtil imgUtil=new ImgUtil();
		File img=new  File("/Users/pluto/Desktop/0.jpg");
		JSONObject res=imgUtil.uploadImg(ImgUtil.SOUGOU, img);
		System.out.println(res);
	}
	@Test
	void test2() {
		ImgUtil imgUtil=new ImgUtil();
		String longUrl="https://img03.sogoucdn.com/app/a/100520146/95cbe7f7fc609bfe2eb7c6ec9c9aa8bd";
		JSONObject res=imgUtil.shortUrl(ImgUtil.T_CN, longUrl);
		System.out.println(res);
	}
	@Test
	void test3() {
		ImgUtil imgUtil=new ImgUtil();
		File img=new  File("/Users/pluto/Desktop/课程表.jpg");
		JSONObject res=imgUtil.imgUploadShortUrl(ImgUtil.SOUGOU, img, ImgUtil.DWZ_MK);
		System.out.println(res);
	}

	@Test
	void test4() {
		ALAPI alapi = new ALAPI();
		File img = new File("/Users/pluto/Desktop/0.jpg");
		JSONObject res = alapi.image(ImgType.SOUGOU, img);
		System.out.println(res);
	}
	@Test
	void test5() {
		ALAPI alapi = new ALAPI();
		JSONObject res = alapi.ip("192.168.1.1");
		System.out.println(res.toStringPretty());
	}
}
