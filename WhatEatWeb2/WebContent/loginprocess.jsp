<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "controller.LoginManager"%>
    <%@ page import = "exception.UsernameNotFoundException"%>

    
   <jsp:include page="index.html"></jsp:include>

<jsp:useBean id="user" class="bean.UserBean" scope="session"></jsp:useBean>
<jsp:setProperty name="user" property="*"/>

<%
	LoginManager lm = LoginManager.getInstance();
	user.setUsername(request.getParameter("username"));
	user.setPassword(request.getParameter("password"));	
	try{
        if (user.validate()) {
        	
        	user.setEmail(lm.login(request.getParameter("username"),request.getParameter("password")).getEmail());
        	lm.setUser(user);
            %>
            <jsp:forward page="homePage.jsp"></jsp:forward>
        <%
        } else {
        	throw new UsernameNotFoundException();
        	  }

			} catch(UsernameNotFoundException e) {
				%> <script type="text/javascript">
    	    	window.alert("Attention! \n Incorrect username or password");
    	    	</script>
    	  	<%
			}
			finally{
				
	}
      %>