package com.wantdo.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wantdo.action.CusEditAction;
import com.wantdo.action.LoginAction;
import com.wantdo.domain.Person;

public class CheckLoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 2092930262572782343L;
	@Override  
    public String intercept(ActionInvocation actionInvocation) throws Exception {  
        //System.out.println("begin check login interceptor!");  
        // 对LoginAction不做该项拦截  
        Object action = actionInvocation.getAction();  
        if (action instanceof LoginAction) {  
            //System.out.println("exit check login, because this is login action.");  
            //UserInfoAction userinfoAction = (UserInfoAction)action;  
            return actionInvocation.invoke();  
        }  
        // 确认Session中是否存在Person  
        Map<String,Object> session = actionInvocation.getInvocationContext().getSession();  
        //Person person = (Person) session.get("username");  
        if (session.get("username") != null) {  
            // 存在的情况下进行后续操作。  
            //System.out.println("already login!");  
            return actionInvocation.invoke();  
        } else {  
            // 否则终止后续操作，返回LOGIN  
            //System.out.println("no login, forward login page!");  
            return "login";  
        }  
    }  
}
