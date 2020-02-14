<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "logic.controller.LoginManager"%>
     <%@ page import = "java.util.StringTokenizer"%>
      <%@ page import = "java.util.regex.Pattern"%>
       <%@ page import = "java.util.regex.Matcher"%>
        <%@ page import = "logic.exception.EmailNotValidexception"%>
      
    
<jsp:useBean id="loginBean" scope="request" class="logic.bean.UserBean"/>
             
<%

	LoginManager lm = LoginManager.getInstance();


	String email = request.getParameter("email") ;
	String user = request.getParameter( "username" ) ;
	String pass = request.getParameter( "password" ) ;
	
	try{
		
			if (user.length()>=6 && pass.length()>=6){
        	
			    if (lm.register(user, pass, email)){
				    %> <script type="text/javascript">
					window.alert("Success!!!\nRegistration successful");
			 		 </script>
			 		 <jsp:forward page="index.html"></jsp:forward>
				 <% 
	            } else {
	            	%> <script type="text/javascript">
	    			window.alert("Registration failed.\n User already registered");
	    			</script>
	    			<%session.setAttribute("email","");
	    			session.setAttribute("username","");
	    			session.setAttribute("password","");     			
	            }
			
        } else {
        	%> <script type="text/javascript">
	    	window.alert("Attention! \n The password must be at least six characters");
	  		</script><%		
        } 
	}
	
	
	finally{
		}
%>
  