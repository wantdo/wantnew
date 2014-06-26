package com.wantdo.domain;

import bsh.StringUtil;

/**
 * 

* @ClassName: Email 

* @Description: 邮件类

* @author sa luanx@wantdo.com

* @date 2014-3-31 上午11:29:36 

*
 */

public class Email {
	
	//发件人
	private String fromEmail;
	//收件人
	private String toEmail;
	//邮件主题
	private String subject;
	//邮件内容
	private String content;
	
	
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Email(String fromEmail, String toEmail, String subject,
			String content) {
		super();
		this.fromEmail = fromEmail;
		this.toEmail = toEmail;
		this.subject = subject;
		this.content = content;
	}



	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String[] getToEmail() {
		if (toEmail.length()==0) {
			return null;
		}else {
			return toEmail.split(";");
		}
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Email [fromEmail=" + fromEmail + ", toEmail=" + toEmail
				+ ", subject=" + subject + ", content=" + content + "]";
	}
	
	

}
