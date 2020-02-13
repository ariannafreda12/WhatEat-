<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
    <%@ page import = "controller.LoginManager"%>
    <%@ page import = "bean.UserBean"%>
    <%@ page import = "exception.UsernameNotFoundException"%>
    <%@ page import = "exception.FieldsNotMatchingException"%>

  
 <% 
 LoginManager dbm = LoginManager.getInstance();
		boolean pChanged;
		try{
			String user =request.getParameter("username");
			String psw1 =request.getParameter("password");
			String psw2 = request.getParameter("password2");
			UserBean ub = new UserBean();
            ub.setUsername(user);
            
            if (psw1.length()<=6){
            	request.setAttribute("password","");
            	request.setAttribute("password2","");
            	%> <script type="text/javascript">
    	    	window.alert("Attention! \n The password must be at least six characters");
    	  		</script><%
    	  		
    		 }
            
             if (ub.foundUser()!= false) {
            	 if (!psw1.equals( psw2 )) {
             	   	throw new FieldsNotMatchingException();
            	 }else{
            	 
            	 pChanged= dbm.changePassword(user, psw1);
                   if(pChanged==true) {
               	  	%><jsp:forward page="index.html"></jsp:forward><% 
	  				
               		}
            	 }
            	
             }else {
            	 throw new UsernameNotFoundException();
             }
		}catch (UsernameNotFoundException e) {
			%> <script type="text/javascript">
	    	window.alert("Attention! \n User not found");
	  	</script><%
		}catch (FieldsNotMatchingException e) {
			%> <script type="text/javascript">
	    	window.alert("Attention! \n The two password fields do not match!");
	  	</script><%
		}
		finally{

		}
		%>