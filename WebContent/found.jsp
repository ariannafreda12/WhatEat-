<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "logic.controller.LoginManager"%>
    <%@ page import = "logic.controller.RecipeManager"%>    
    <%@ page import = "logic.bean.UserBean"%>
    <%@ page import = "logic.bean.RecipeBean"%>
    <%@ page import = "logic.model.Recipe"%>   
    <%@ page import = "java.util.ArrayList"%>
    <%@ page import = "java.util.HashSet"%>
    <%@ page import = "java.util.List"%>
	<%@ page import = "java.util.Set"%>

<!DOCTYPE html>
<html style="font-size: 16px;">
<style>
.homeFound{
	background-color:transparent;
	outline: none;
	display:inline-block;
	cursor:pointer;
	color:black;
	padding:0.2px 1px;
	position : absolute;
    right : 40px;
    top: -14px;
    align:center;
}
.hiButtonFound {
	background-color: white;
	opacity: 0.7;
	border-radius:6px;
	border:0px solid #dcdcdc;
	display:inline-block;
	cursor:none;
	color:black;
	font-family:Montserrat;
	font-size:40 px;
	font-style:italic;
	padding:6px 30px;
	text-decoration:none;
	position : absolute;
    right : 100px;
    top: 6px;
    align:center;
}
.myButtonFound {
	background-color:transparent;
	border-radius:6px;
	border:0px solid #dcdcdc;
	display:inline-block;
	cursor:pointer;
	color:black;
	font-family:Montserrat;
	font-size:18px;
	font-style:italic;
	padding:6px 24px;
	text-decoration:underline;
}
.myButtonFound:hover {
	background-color:transparent;
}
.myButtonFound:active {
	position:relative;
	top:1px;
}
table {
  border-collapse: collapse;
  width: 80%;
  border: none;
  background-color: white;
  opacity:0.99;
  font-family:montserrat; 
  font-size: 14px;
  border:2px;
  cellspacing:2px;
  cellpadding:2px;
  align:center;
  left:100px;
  
 
}

th, td {
  padding: 8px;
  text-align: center;
  border-bottom: gray;
  width:15%
}

th {font-size: 16px}
tr:hover {background-color:#f5f5f5;}

}
</style>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="WhatEat?!">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Found recipes</title>
    <link rel="stylesheet" href="nicepage2.css" media="screen">
    <link rel="stylesheet" href="Search.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery2.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage2.js" defer=""></script>
    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Lobster:400|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i|Sofadi+One">

    <script type="application/ld+json">
        {
        		"@context": "http://schema.org",
        		"@type": "Organization",
        		"name": "",
        		"url": "index.html",
        		"logo": "images/icon1.png"
        }
    </script>
    <meta property="og:title" content="Search">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
    <link rel="canonical" href="index.html">
    <meta property="og:url" content="index.html">
</head>

<body data-home-page-title="Found recipes" class="u-body u-image" style="background-position: 50% 50%; background-attachment: fixed; background-image: url(&quot;images/54e8d24a495aae14f6da8c7dda79367d1d38d6ed5b586c4870277bd09145c458bc_1280.jpg&quot;);">
    <header class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-border-2 u-border-white u-clearfix u-custom-color-4 u-header u-valign-top u-sticky" id="sec-dfab">
        <div class="u-clearfix u-sheet u-sheet-1">
            <% LoginManager lm =LoginManager.getInstance();
        	UserBean ub= lm.getUser();
            if (ub.getUsername()=="Chef") {%><a href="Registration.html"> 
            <%}else{ %><a href="profile.jsp"> <%} %>
            <img class="u-image u-image-contain u-image-1" src="images/57e6d6404856a514f6da8c7dda79367d1d38d6ed5b586c4870277bd09048c058b0_1280.png" data-image-width="1280" data-image-height="1248">
            </a>
            <a href="index.html">
            <img class="u-image u-image-contain u-image-2" src="images/5fe7d3404c4fad0bffd8992cc62b3f791d37d6ec4e507441752b7cd1904ec7_1280.png" data-image-width="1280" data-image-height="1275">
            </a>
            <a href="homePage.jsp">
            <img class="u-image u-image-contain u-image-3" src="images/homeIcon.png" data-image-width="1280" data-image-height="1280">
            </a>
            <a href="" class="u-image u-logo u-image-4" data-image-width="980" data-image-height="981">
          <img src="images/icon1.png" class="u-logo-image u-logo-image-1" data-image-width="49.1177">
        </a>
            <nav class="u-align-left u-menu u-menu-dropdown u-offcanvas u-menu-1">
                <div class="menu-collapse u-custom-font u-font-montserrat" style="font-size: 1rem; letter-spacing: 0;">
                    <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-palette-5-dark-3" href="#">
              <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 302 302" style="undefined"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-0b31"></use></svg>
              <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-0b31" x="0px" y="0px" viewBox="0 0 302 302" style="enable-background:new 0 0 302 302;" xml:space="preserve" class="u-svg-content"><g><rect y="36" width="302" height="30"></rect><rect y="236" width="302" height="30"></rect><rect y="136" width="302" height="30"></rect>
</g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
            </a>
                </div>
                <div class="u-custom-menu u-nav-container">
                    <ul class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-custom-font u-font-montserrat u-nav u-spacing-0 u-unstyled u-nav-1">
                        <li class="u-nav-item">
                            <a class="u-button-style u-nav-link u-text-active-white u-text-hover-palette-5-dark-2 u-text-palette-5-dark-3" style="padding: 10px;">Search</a>
                        </li>
                        <li class="u-nav-item">
                            <a class="u-button-style u-nav-link u-text-active-white u-text-hover-palette-5-dark-2 u-text-palette-5-dark-3" style="padding: 10px;">Found recipes</a>
                        </li>
                        <li class="u-nav-item">
                            <a class="u-button-style u-nav-link u-text-active-white u-text-hover-palette-5-dark-2 u-text-palette-5-dark-3" href="Home.html" style="padding: 10px;">Recipe</a>
                        </li>
                        <li class="u-nav-item">
                            <a class="u-button-style u-nav-link u-text-active-white u-text-hover-palette-5-dark-2 u-text-palette-5-dark-3" style="padding: 10px;">        </a>
                        </li>
                        <li class="u-nav-item">
                            <a class="u-button-style u-nav-link u-text-active-white u-text-hover-palette-5-dark-2 u-text-palette-5-dark-3" style="padding: 10px;">        </a>
                        </li>
                        <li class="u-nav-item">
                            <a class="u-button-style u-nav-link u-text-active-white u-text-hover-palette-5-dark-2 u-text-palette-5-dark-3" style="padding: 10px;">        </a>
                        </li>
                    </ul>
                </div>
                <div class="u-custom-menu u-nav-container-collapse">
                    <div class="u-align-center u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
                        <div class="u-menu-close"></div>
                        <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
                            <li class="u-nav-item">
                                <a href="search.jsp" class="u-button-style u-nav-link" style="padding: 10px;">Search</a>
                            </li>
                            <li class="u-nav-item">
                                <a href="found.jsp" class="u-button-style u-nav-link" style="padding: 10px;">Found recipes</a>
                            </li>
                            <li class="u-nav-item">
                                <a class="u-button-style u-nav-link" style="padding: 10px;">Recipe</a>
                            </li>
                        </ul>
                    </div>
                    <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
                </div>
            </nav>
            <div><h1 class="u-text u-text-body-color u-title u-text-1">WhatEat?!</h1> <label class="hiButtonFound"><b><i><%out.println(" Hi " + ub.getUsername());%></i></b></label><a href="homePage.jsp" class="homeFound"><img src="images\homeIcon.png" width="40" height="35" style="right:20px; align:right"></a></div> 
        </div>
    </header>
   
	<section class="u-align-center u-clearfix u-section-1" id="sec-0da3">
   <br>
   <table class="table">
   	 
      <tr>
         <th id="title">Title</th>
         <th id="necessary">Necessary</th>
         <th id="time">Time</th>
         <th id="review">Review</th>
   
    <%
	Set <Recipe> recipe= new HashSet<>();	
    Set <Recipe> list= new HashSet<>();
    
	//instance of recipe manager for get difficulty, category and ingredient list
    RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb=rm.getRecipe();
	
	recipe=RecipeManager.foundIngredient(rb.getRecBeanIngredients(),rb.getRecBeanCategory(),rb.getRecBeanDifficulty()); 
	
		if (recipe!= null) {
		//cycle for found recipes
			
		Set<String> unique =  new HashSet<String>();
		List<String> dupes = new ArrayList<String>();
		ArrayList<Recipe> secondUnique = new ArrayList<Recipe>();
		
		for(Recipe a : recipe) {
			if(unique.contains(a.getTitle())) {
				dupes.add(a.getTitle());}
			else {
				unique.add(a.getTitle());
				secondUnique.add(a);
			}
				
		}
		if (secondUnique!= null) {	
		for(Recipe s : secondUnique) {
			
			%>
	 		
	        </tr>
	        
	        <tr>
	        <form action="recipe.jsp" method="post">
			<td ><input type="submit" class="myButtonFound" name="recipe" value="<%out.println(s.getTitle());%>"></form></td>
			<td class="tdprep"><%out.println(s.getNecessary());%></td>
			<td><%out.println(s.getTime());%></td>
			<td><%out.println(s.getReview());%></td>
			</tr>
			
			<%
		}
		}
			
	}
	%>
</table>
<br>
</body>

</html>