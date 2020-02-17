<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "logic.model.Recipe"%>    
    <%@ page import = "logic.controller.RecipeManager"%>    
	<%@ page import = "logic.controller.LoginManager"%>
    <%@ page import = "logic.controller.RecipeManager"%>  
    <%@ page import = "logic.controller.UserProfileManager"%>   
    <%@ page import = "logic.bean.UserBean"%>
    <%@ page import = "logic.bean.RecipeBean"%>

<!DOCTYPE html>
<html style="font-size: 16px;">
<style>
.homeRecipe{
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
.hiButtonRecipe {
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
.table{
	width:70%
}
.Titlelabel{
	background-color:transparent;
	outline: none;
	display:inline-block;
	cursor:pointer;
	color:black;
	font-family:Montserrat;
	font-size:150%;
	font-style:italic;
    font-style:bold;
	position : absolute;
	left : 420px;
    top: 6px;
    align:center;
}
</style>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="WhatEat?!">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Recipe</title>
    <link rel="stylesheet" href="nicepage2.css" media="screen">
    <link rel="stylesheet" href="Recipe.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery2.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage2.js" defer=""></script>
    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Lobster:400|Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i|Amarante">

    <script type="application/ld+json">
        {
        		"@context": "http://schema.org",
        		"@type": "Organization",
        		"name": "",
        		"url": "index.html",
        		"logo": "images/icon1.png"
        }
    </script>
    
</head>

<body class="u-body">
    <header class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-border-2 u-border-white u-clearfix u-custom-color-4 u-header u-valign-top u-sticky"  id="sec-dfab">
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
            <div><h1 class="u-text u-text-body-color u-title u-text-1">WhatEat?!</h1> <label class="hiButtonRecipe"><b><i><%out.println(" Hi " + ub.getUsername());%></i></b></label><a href="homePage.jsp" class="homeRecipe"><img src="images\homeIcon.png" width="40" height="35" style="right:20px; align:right"></a></div> 
        </div>
    </header>
    
    <section class="u-clearfix u-image u-section-1" id="sec-c349" data-image-width="150" data-image-height="99">
    
    <br><br>    
        <div class="u-clearfix u-sheet u-sheet-1">
        
        <%
      
        RecipeManager rm= RecipeManager.getInstance();
    	RecipeBean rb=rm.getRecipe();
    	UserProfileManager upm= UserProfileManager.getInstance();
     	
        String title=request.getParameter("recipe").replaceAll("\r\n|\r|\n", "");
    	
    	Recipe rc = rm.chooseRecipe(title);
    	
    	if(rc!=null) { 
      		rb.setRecBeanTitle(rc.getTitle());
      		rb.setRecBeanPreparation(rc.getPreparation());
      		rb.setRecBeanNecessary(rc.getNecessary());
      		rb.setRecBeanTime(rc.getTime());
      		rb.setRecBeanReview(rc.getReview());
    		rm.setRecipe(rb);
    		System.out.println(rb.getRecBeanTitle());
    		
    	}
        %>
        <br>
        <div class="u-border-no-bottom u-border-no-left u-border-no-right u-border-no-top u-border-radius-32 u-container-style u-group u-opacity u-opacity-35 u-palette-3-light-3 u-shape-round u-group-1">
        <div class="u-container-layout u-container-layout-1">
        <table class="table">
        <th></th>
        <label class="Titlelabel" style="font-weight:bold"><%out.println(rb.getRecBeanTitle());%></label>
        <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6">Category:&nbsp;&nbsp;<%out.println(rb.getRecBeanCategory());%></h6>
        <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6">Difficulty:&nbsp;&nbsp;<%out.println(rb.getRecBeanDifficulty());%></h6>
        <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6">Time:&nbsp;&nbsp;<%out.println(rb.getrecBeanTime());%></h6>
        <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6">Ingredients:&nbsp;&nbsp;<br><%out.println(rb.getRecBeanNecessary());%></h6>
        <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6">Preparation:&nbsp;&nbsp;<br><%out.println(rb.getRecBeanPreparation());%></h6>      
        </table></div></div>   
        <br> 
        <%
        if(ub.getUsername()!="Chef" &&  upm.checkChef(ub.getUsername(),rb.getRecBeanTitle())==null){
        %><form action="fav.jsp" method="post">
        <u><input type="submit" class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" 
        name="fav" value="Add to favorites" style="background-color: #ffcc00; border-radius:6px; border:0px;cursor:pointer;
	color:black; font-family:Montserrat; font-size:18px; font-style:italic; padding:6px 24px;text-decoration:none;">     
    	</form><br>
    	<%
        }
        
        if(ub.getUsername()!="Chef" &&  upm.checkChef(ub.getUsername(),rb.getRecBeanTitle())!=null){
        %><form action="favRemove.jsp" method="post">
        <u><input type="submit" class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" 
        name="fav" value="Remove from favorites" style="background-color: #ffcc00; border-radius:6px; border:0px;cursor:pointer;
	color:black; font-family:Montserrat; font-size:18px; font-style:italic; padding:6px 24px;text-decoration:none;">     
    	</form>
    	<%
        }
        %>          
        
    	
    	<br>
    </section>


    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-bd34">
        <div class="u-clearfix u-sheet u-sheet-1">
            <p class="u-custom-font u-small-text u-text u-text-variant u-text-1">Progetto ISPW 2019 -2020
                <br>Arianna Freda - Alessia Minotti <br> Michela Lattanzi
            </p>
        </div>
    </footer>
   
</body>

</html>