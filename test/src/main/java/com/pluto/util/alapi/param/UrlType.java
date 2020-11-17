package com.pluto.util.alapi.param;

public enum UrlType {

	T_CN(1, "t.cn"), // 89
	URL_CN(2, "url.cn"), // 89
	DWZ_MK(3, "dwz.mk"), // 89
	SUO_IM(4, "suo.im"), // 89
	U_NU(5, "u.nu"), // 89
	MRW_SO(6, "mrw.so"), // 89
	SUO_NZ(7, "suo.nz"), // 89
	SOHU_GG(8, "sohu.gg");// 89

	private Integer type;

	private String info;

	private UrlType(Integer type, String info) {
		this.type = type;
		this.info = info;
	}

	public Integer getType() {
		return type;
	}

	public String getInfo() {
		return info;
	}

	
}
