<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import = "controller.LoginManager"%>
   <%@ page import = "controller.RecipeManager"%>    
   <%@ page import = "bean.UserBean"%>
   <%@ page import = "java.util.ArrayList"%>
    
<jsp:useBean id="meal" class="bean.RecipeBean" scope="session"></jsp:useBean>
<jsp:setProperty name="meal" property="*"/>
    
  <% 
	String category= "";
	String difficulty= "";
	ArrayList<String> ingList= new ArrayList<String>();
	
	
	LoginManager lm =LoginManager.getInstance();
	UserBean ub= lm.getUser();
	RecipeManager rm = RecipeManager.getInstance();
	
	if(request.getParameter("category")!=null && request.getParameter("difficulty")!=null && request.getParameterValues("ingr")!=null ){
		category = request.getParameter("category");
		meal.setCategory(category);
		difficulty = request.getParameter("difficulty");
		meal.setDifficulty(difficulty);
		String [] ing =request.getParameterValues("ingr");
		
		for(String s : ing){
			ingList.add(s.replaceAll("\r\n|\r|\n", ""));
		}
		
		meal.setIngredient(ingList);
		rm.setRecipe(meal);		
		
		%>
        <jsp:forward page="found.jsp"/>
    <%
	}
	%>