package com.wantdo.action;


import com.opensymphony.xwork2.ActionSupport;


//�ɹ�-->����
public class CusBackAction extends ActionSupport {
	
	private String variable;
	
	public CusBackAction() {
		super();
	}
	@Override
	public String execute() throws Exception {
		//System.out.println("*********************");
		System.out.println(variable);
		return SUCCESS;
	}
	
	
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	
}
