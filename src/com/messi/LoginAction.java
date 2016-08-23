package com.messi;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String passWord;
	private String userName;
	private HttpServletResponse response;
	private HttpServletRequest request;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String execute() throws Exception {
		if (getUserName().equals("messi") && getPassWord().equals("liu920923")) {
			ActionContext context = ActionContext.getContext();
			Integer integer = (Integer) context.getApplication().get("count");
			if (integer == null) {
				integer = 1;
			} else {
				integer++;
			}
			Cookie cookie = new Cookie("user", getUserName());
			cookie.setMaxAge(60 * 60);
			ServletActionContext.getResponse().addCookie(cookie);
			context.getApplication().put("count", integer);
			context.getSession().put("user", getUserName());
			context.getSession().put("tip", "你已经成功登陆");
			System.out.println(ServletActionContext.getResponse().equals(getResponse()));
			System.out.println("请求url： " + ServletActionContext.getRequest().getRequestURI());
			System.out.println("账号: " + getUserName() + "\r\n密码： " + getPassWord());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		setResponse(arg0);
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		setRequest(arg0);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
