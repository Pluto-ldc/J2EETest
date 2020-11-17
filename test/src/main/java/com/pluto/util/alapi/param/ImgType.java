package com.pluto.util.alapi.param;

public enum ImgType {

	SOUGOU("sogou"), ALI("ali"), ALAPI("alapi"), QIHU360("qihoo"), TOUTIAO("toutiao"), XIAOMI("xiaomi"), IMGTG("imgTg");

	private String imgType;

	ImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getImgType() {
		return imgType;
	}

}