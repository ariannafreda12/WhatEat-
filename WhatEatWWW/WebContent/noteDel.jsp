<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "bean.UserBean"%>
<%@ page import = "bean.NotesBean"%>
<%@ page import = "controller.LoginManager"%>
<%@ page import = "controller.RecipeManager"%>
<%@ page import = "controller.NotesManager"%>
<%@ page import = "model.Recipe"%>
<%@ page import = "model.User"%>

<%
	
LoginManager lm = LoginManager.getInstance();
UserBean u = lm.getUser();

NotesManager nm= NotesManager.getInstance();
NotesBean n=nm.getNote();

String note= request.getParameter("note").replaceAll("\r\n|\r|\n", "");

nm.deleteNotes(note, u.getUsername());

%><jsp:forward page="profile.jsp"></jsp:forward>


