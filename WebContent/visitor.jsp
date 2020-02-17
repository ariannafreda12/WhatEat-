<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "logic.controller.LoginManager"%>
     <%@ page import = "logic.bean.UserBean"%>

    
   <jsp:include page="index.html"></jsp:include>


<jsp:setProperty name="user" property="*"/>

<%
	LoginManager lm = LoginManager.getInstance();
	UserBean ub = new UserBean();
	ub.setUsername("Chef");
	ub.setEmail("chef@user.it");
	lm.setUser(ub);
			%>	
            <jsp:forward page="homePage.jsp"></jsp:forward>