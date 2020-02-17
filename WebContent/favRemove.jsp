<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "logic.controller.LoginManager"%> 
<%@ page import = "logic.controller.RecipeManager"%>
<%@ page import = "logic.controller.UserProfileManager"%> 
<%@ page import = "logic.bean.RecipeBean"%>
<%@ page import = "logic.bean.UserBean"%>      

<%    	
	RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb= rm.getRecipe();

	LoginManager lm = LoginManager.getInstance();
	UserBean ub = lm.getUser();

	UserProfileManager upm= UserProfileManager.getInstance();	
		
	if(ub.getUsername()!="Chef" && upm.deleteRecipe(rb.getRecBeanTitle(), ub.getUsername())){
	%><jsp:forward page="profile.jsp"></jsp:forward><%} %>
				
	