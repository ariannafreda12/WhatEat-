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
		
	if(ub.getUsername()!="Chef" && upm.saveRecipe(rb.getTitle(), rb.getPreparation(), rb.getDifficulty(), rb.getCategory(), rb.getTime(), rb.getNecessary(), ub.getUsername())){
	if ((rm.reviewRecipe(rb.getTitle(), rb.getReview()))==true) {
		rm.addReviewRecipe(ub.getUsername(), rb.getTitle());
	}else  {
			System.out.println("Sorry");
	}}
	%><jsp:forward page="profile.jsp"></jsp:forward>
				
	