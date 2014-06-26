package com.wantdo.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.wantdo.domain.Email;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MailService {
	
	private JavaMailSender javaMailSender;
	private FreeMarkerConfigurer freeMarker;
	private TaskExecutor taskExecutor;
	
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public FreeMarkerConfigurer getFreeMarker() {
		return freeMarker;
	}
	public void setFreeMarker(FreeMarkerConfigurer freeMarker) {
		this.freeMarker = freeMarker;
	}
	
	public void sendMessage(Email email) throws MessagingException{
		if (email.getToEmail()==null||email.getToEmail().length==0) {
			System.out.println("û���ռ���");
		}
		if (email.getToEmail().length>3) {
			sendMailByAsynchronousMode(email);
			System.out.println("�ռ��˹��࣬�������첽��ʽ����");
		}else {
			sendMailBySynchronizationMode(email);
			System.out.println("������ͬ����ʽ����");
		}
	}
	
	/**
	 * 
	* @Title: sendMailByAsynchronousMode 
	* @Description: �첽�����ʼ�
	* @param @param email    �ʼ�
	* @return void    �������� 
	* @throws
	 */
	private void sendMailByAsynchronousMode(final Email email) {
		// TODO Auto-generated method stub
		taskExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					sendMailBySynchronizationMode(email);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * @throws MessagingException 
	 * 
	* @Title: sendMailBySynchronizationMode 
	* @Description: ͬ�������ʼ�
	* @param @param email   �ʼ�
	* @return void    �������� 
	* @throws
	 */
	private void sendMailBySynchronizationMode(Email email) throws MessagingException{
		// TODO Auto-generated method stub
		MimeMessage msg=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(msg,true,"GBK");
		helper.setFrom(email.getFromEmail());
		helper.setTo(email.getToEmail());
		helper.setSubject(email.getSubject());
		helper.setText(email.getContent(),true);
		javaMailSender.send(msg);
	}
	
	public String getMessage(Map<String, Object> map){		
		String htmlText="";
		Template tpl=null;
		try {
			tpl=freeMarker.getConfiguration().getTemplate("MainTemplate.ftl");
			htmlText=FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
			return htmlText;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}
	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	
}
