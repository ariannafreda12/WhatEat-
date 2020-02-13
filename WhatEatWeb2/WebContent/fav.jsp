<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "controller.LoginManager"%> 
<%@ page import = "controller.RecipeManager"%>
<%@ page import = "controller.UserProfileManager"%> 
<%@ page import = "bean.RecipeBean"%>
<%@ page import = "bean.UserBean"%>      

<%    	
	RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb= rm.getRecipe();

	LoginManager lm = LoginManager.getInstance();
	UserBean ub = lm.getUser();

	UserProfileManager upm= UserProfileManager.getInstance();	
		
	if(ub.getUsername()!="Chef" && upm.saveRecipe(rb.getRecBeanTitle(), rb.getRecBeanPreparation(), rb.getRecBeanDifficulty(), rb.getRecBeanCategory(), rb.getrecBeanTime(), rb.getRecBeanNecessary(), ub.getUsername())){
	rm.reviewRecipe(rb.getRecBeanTitle(), rb.getRecBeanReview());
		
	}else  {
			System.out.println("Sorry");
	}
	%><jsp:forward page="profile.jsp"></jsp:forward>
				
	