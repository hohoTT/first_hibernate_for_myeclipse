package com.wt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tt.hibernateSetting.HibernateSessionFactory;
import com.wt.bean.Users;

public class ShowUsersInfo extends HttpServlet {
	public ShowUsersInfo() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Session session = HibernateSessionFactory.getSession();
    	
    	Query query = session.createQuery("FROM Users");
    	
    	Iterator<Users> iterator = query.iterate();
    	
    	StringBuilder sb = new StringBuilder();
		
		sb.append("用户的信息如下所示 ： ").append("<br />").append("\n");
    	
    	while(iterator.hasNext()){
    		Users user = iterator.next();
    		
    		sb.append("Id : ").append(user.getId()).append("\n");
    		sb.append("Username : ").append(user.getUsername()).append("\n");
    		sb.append("Password : ").append(user.getPassword()).append("\n");
    		sb.append("Age : ").append(user.getAge()).append("<br />").append("\n");
    		
    	}
    	
    	
    	response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        
        out.println(sb);

    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
