<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "logic.bean.UserBean"%>
<%@ page import = "logic.bean.NotesBean"%>
<%@ page import = "logic.controller.LoginManager"%>
<%@ page import = "logic.controller.RecipeManager"%>
<%@ page import = "logic.controller.NotesManager"%>
<%@ page import = "logic.model.Recipe"%>
<%@ page import = "logic.model.User"%>

<%
	
LoginManager lm = LoginManager.getInstance();
UserBean u = lm.getUser();

NotesManager nm= NotesManager.getInstance();
NotesBean n=nm.getNote();

String newNote= request.getParameter("newNote");

nm.addNotes(newNote, u.getUsername());
%><jsp:forward page="profile.jsp"></jsp:forward>


