package shop.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 增强的Request
 * @author pluto
 *
 */
public class MyHttpServletRequest  extends HttpServletRequestWrapper{

	private HttpServletRequest request;
	
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	//增强request中的getParamter()方法
	@Override
	public String getParameter(String name) {
		//获得请求方式
		String method=request.getMethod();
		//根据不同请求进行不同的处理
		if ("GET".equalsIgnoreCase(method)) {
			String value=super.getParameter(name);
			try {
				if(value!=null) {
					value=new String(value.getBytes("UTF-8"),"UTF-8");
				}else {
					return null;
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}else if("POST".equalsIgnoreCase(method)) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.getParameter(name);
	}
	

}
