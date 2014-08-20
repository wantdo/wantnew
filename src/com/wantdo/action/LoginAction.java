package com.wantdo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionInvocation;
import com.wantdo.domain.CusDesc;
import com.wantdo.domain.CusDetail;
import com.wantdo.domain.Person;
import com.wantdo.service.IEcEordermstService;
import com.wantdo.service.IPersonService;

/**
 * 

* @ClassName: LoginAction 

* @Description: µÇÂ½Action

* @author sa luanx@wantdo.com

* @date 2014-4-16 ÏÂÎç5:59:45 

*
 */

public class LoginAction extends ActionSupport{
	
	private final Log logger=LogFactory.getLog(getClass());
	
	private IPersonService personService;
	private Person person;
	private IEcEordermstService ecEordermstService;
	private List<CusDesc> proList;
	
	public LoginAction() {
		super();
		proList=new ArrayList<CusDesc>();
		person = new Person();
	}
	@Override
	public String execute() throws Exception {
		String result = person.getUsername();
		
		/*logger.info("Person [username="+person.getUsername()+
				",password="+person.getPassword()+"]");*/
		//System.out.println("------------------->LoginAction");
		//System.out.println(ServletActionContext.getRequest().getSession().getAttribute("username"));
		/*if(ServletActionContext.getRequest().getSession().getAttribute("username") != null){
			proList=ecEordermstService.getAllProblems();
			proList.remove(proList.size() - 1);
			return result;
		}*/
		if (personService.checkLogin(person)) {
			//proList=ecEordermstService.getAllProblems();
			//proList.remove(proList.size() - 1);
			/*HttpServletRequest request=ServletActionContext.getRequest();
	        HttpSession session =request.getSession();
	        session.setAttribute("username", person.getUsername());*/
			ServletActionContext.getRequest().getSession().setAttribute("username", person.getUsername());
			//System.out.println("----------------->Ð´Èësession ");
			person = new Person();
			//ActionContext.getContext().getSession().put("username", person.getUsername());
			//System.out.println("----------------->Ð´Èësession "+ActionContext.getContext().getSession().get("username"));
			return result;
		}
		
		
		return result;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public IPersonService getPersonService() {
		return personService;
	}

	public void setPersonService(IPersonService personService) {
		this.personService = personService;
	}

	public IEcEordermstService getEcEordermstService() {
		return ecEordermstService;
	}

	public void setEcEordermstService(IEcEordermstService ecEordermstService) {
		this.ecEordermstService = ecEordermstService;
	}

	public List<CusDesc> getProList() {
		return proList;
	}

	public void setProList(List<CusDesc> proList) {
		this.proList = proList;
	}

	

}
