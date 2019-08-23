package com.app.TravelBookingSystemNew;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import beanClasses.Login;
import repositoryClass.IndexDao;

@Path("index")
public class IndexRestClass {
	@Context
	HttpServletResponse response;
	@Context
	HttpSession session;
	@Context
	HttpServletRequest request;
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("validate")
    public String validate(Login login) throws IOException
    {
    	IndexDao indexDao=new IndexDao();
    	boolean result=indexDao.check(login);
    	if(result==true)
    		return "accept";
    	else 
    		return "declined";
    }
}