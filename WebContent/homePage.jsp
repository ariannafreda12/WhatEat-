<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import = "logic.controller.UserProfileManager"%>
    <%@ page import = "logic.controller.LoginManager"%>
    <%@ page import = "logic.model.UserProfile"%>
    <%@ page import = "logic.model.User"%>
    <%@ page import = "java.util.ArrayList"%>
    <%@ page import = "logic.controller.RecipeManager"%>
    <%@ page import = "logic.model.Recipe"%>
    <%@ page import = "java.net.URLEncoder"%>
    <%@ page import = "logic.bean.RecipeBean"%>
    <%@ page import = "logic.bean.UserBean"%>
    <%@ page import = "logic.controller.UserProfileManager"%>   
    <%@ page import = "java.util.Set"%>
    <%@ page import = "java.util.HashSet"%>    
    
    
    <% UserProfileManager upm= UserProfileManager.getInstance();
    LoginManager lm = LoginManager.getInstance();
    Recipe daily = new Recipe();	
	UserProfile fav = new UserProfile();
	UserBean ub= lm.getUser();
    RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb= new RecipeBean();
    %>
    
<!DOCTYPE html>
<html style="font-size: 20px;">
<style>
.hiButtonHome {
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
    right : 60px;
    top: 6px;
    align:center;
}
.myButtonHome {
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
.myButtonHome:hover {
	background-color:transparent;
}
.myButtonHome:active {
	position:relative;
	top:1px;
}
table{
align:center;
width:60%;
align:center;
font-family:montserrat
}
.logout{
	background-color:transparent;
	outline: none;
	display:inline-block;
	cursor:pointer;
	color:black;
	font-family:Montserrat;
	font-size:4 px;
	font-style:italic;
	padding:0.2px 1px;
	position : absolute;
    right : 15px;
    top: -10px;
    align:center;
}
</style>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="WhatEat?!">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>WhatEat?! - HomePage</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
    <link rel="stylesheet" href="HomePage.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>

    <link id="u-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i|Lobster:400|Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">

  
    <meta property="og:title" content="HomePage">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
    <link rel="canonical" href="index.html">
    <meta property="og:url" content="index.html">
</head>

<body class="u-body u-image" style="background-position: 50% 50%; background-image: url(&quot;images/54e8d24a495aae14f6da8c7dda79367d1d38d6ed5b586c4870277bd09145c559b0_12801.jpg&quot;);">
    <header class="u-align-left u-border-2 u-border-white u-clearfix u-custom-color-2 u-header u-sticky u-header" id="sec-5feb">
        <div class="u-clearfix u-sheet u-valign-top u-sheet-1">
            <img src="images/icon.png" alt="" class="u-image u-image-default u-image-1" data-image-width="980" data-image-height="981">
            <h2 class="u-custom-font u-font-Lobster u-text u-text-black u-text-default u-text-1">WhatEat?!</h2></div> 
        <label class="hiButtonHome"><%out.println(" Hi " + ub.getUsername());%></label>
        </div>
        <a href="index.html" class="logout"><img src="images\5fe7d3404c4fad0bffd8992cc62b3f791d37d6ec4e507441752b7cd1904ec7_1280.png" width="35" height="35" style="right:30px; align:right"></a>
    </header>
    <section class="u-align-left u-clearfix u-image u-section-1" id="sec-3dad" data-image-width="1280" data-image-height="847">
        <div class="u-clearfix u-sheet u-sheet-1">
            <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
                <div class="u-gutter-0 u-layout">
                    <div class="u-layout-row">
                        <div class="u-size-30">
                            <div class="u-layout-col">
                                <div class="u-container-style u-layout-cell u-left-cell u-size-60 u-layout-cell-1">
                                    <div class="u-container-layout u-container-layout-1">
                                        <p class="u-align-center u-custom-font u-heading-font u-text u-text-default u-text-1">Discover popular recipes</p>
                                        <div class="u-align-center u-container-style u-group u-opacity u-opacity-40 u-palette-3-light-3 u-group-1">
                                            <div class="u-container-layout u-container-layout-2">
                                               <table class="u-custom-font u-font-montserrat u-text u-text-6">
													<tr>
													<th >Title</th>
													<th>Likes</th>
														<%
														Set<Recipe> poprecipes = new HashSet<>();
														RecipeManager rec = RecipeManager.getInstance();
														poprecipes = rec.popularRecipe();
																if (poprecipes!= null) {
																	//cycle for found recipes
																		for(Recipe s : poprecipes) {
															     		//add title to the list
																	%>
																	 </tr>
																	 <tr>
																	 <form action="recipe.jsp" method="post">
																	 <td>
            														<input type="submit" name="recipe" href="recipe.jsp" class="myButtonHome" value="<%out.println(s.getTitle());%>"></form></td>
																	 <td><%out.println(s.getReview());%></td>
																	   </tr>
																	   <%  } } %>
																	   </table>
																	   
																	   <br>
                                        <form action="search.jsp" method="post">
                                        <input type="submit" class="u-border-radius-19 u-btn u-button-style u-btn-1" value="Search a new recipe">
                                        </form>
                                            </div>
                                        </div>
                                        <p class="u-align-center u-custom-font u-heading-font u-text u-text-3">Search a cooking class near you</p>
                                        <div class="u-container-style u-group u-opacity u-opacity-40 u-palette-3-light-3 u-group-2">
                                            <div class="u-container-layout u-valign-bottom u-container-layout-3">
                                                <form method="get" action ="homePage.jsp">
                                            	<input type="text" placeholder="Enter city" name="city" required size= 40/>
                                            	<br>
                                        	    <br>
                                                <input type="submit" value="Find it!" class="u-border-radius-19 u-btn u-button-style u-btn-1"/>
                                                <%
                                                String testoRicerca = "cooking course in ";
                                                String text = request.getParameter("city");
                                                String valoreQ="";
                                    			String valoreQ2="";
                                                if (!((text)==null)){
                                                	valoreQ = URLEncoder.encode(testoRicerca, "UTF-8");
                                    				valoreQ2 = URLEncoder.encode(text, "UTF-8");
                                                	String url = "https://www.google.com/search?q=" + valoreQ + valoreQ2;
                                                	response.sendRedirect(url);
                                                }
                                                %>
                                           </form>
                                            </div>
                                        </div>
                                                                             
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="u-size-30">
                            <div class="u-layout-col">
                                <div class="u-container-style u-layout-cell u-right-cell u-size-60 u-layout-cell-2">
                                    <div class="u-container-layout u-container-layout-4">
                                       <% if (lm.getUser().getUsername()=="Chef" || upm.favRecipe(ub.getUsername())==null)  {
        									daily=RecipeManager.dailyRecipe(); 
        									%>
        									<label name="label1" class="-align-center u-custom-font u-heading-font u-text u-text-default u-text-1"><%out.println("Try daily recipe");%></label>
                                        	<div class="u-container-style u-group u-opacity u-opacity-40 u-palette-3-light-3 u-group-3">
                                            <div class="u-container-layout u-container-layout-6">
        									<table class="table">
        									<th></th>
        									<h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-weight:bold; font-size:24px"><%out.println(daily.getTitle());%></h6>
        									<h9 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px">Category:&nbsp;&nbsp;<%out.println(daily.getCategory());%></h9><br>
        									<h9 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px">Difficulty:&nbsp;&nbsp;<%out.println(daily.getDifficulty());%></h9><br>
        									<h9 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px">Time:&nbsp;&nbsp;<%out.println(daily.getTime());%></h9><br><br>
        									<h9 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px">Ingredients:&nbsp;&nbsp;<br><%out.println(daily.getNecessary());%></h9><br><br>
        									<h9 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px">Preparation:&nbsp;&nbsp;<br><%out.println(daily.getPreparation());%></h9>     
       									 </table>   
       									 </div>
                                        </div>
       									 
           									 <%
        									} else  { 
        										fav=UserProfileManager.favRecipe(lm.getUser().getUsername());
        								 %>
        									<label name="label1" class="-align-center u-custom-font u-heading-font u-text u-text-default u-text-1"><%out.println("One of your favourite recipe");%></label>
                                        	<div class="u-container-style u-group u-opacity u-opacity-40 u-palette-3-light-3 u-group-3">
                                            <div class="u-container-layout u-container-layout-6">
        									<table class="table">
        									<th></th>
        	   								<h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-weight:bold; font-size:24px"><%out.println(fav.getTitle());%></a></h6>
            								<h9 name="cat" class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px" >&nbsp;Category:&nbsp;&nbsp;<%out.println(fav.getCategory());%></h9><br>
            								<h9 name="diff" class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px" >&nbsp;Difficulty:&nbsp;&nbsp;<%out.println(fav.getDifficulty());%></h9><br>
            								<h9 name="time" class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px" >&nbsp;Time:&nbsp;&nbsp;<%out.println(fav.getTime());%></h9><br><br>
            								<h9 name="nec" class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px" >&nbsp;Ingredients:&nbsp;&nbsp;<br><%out.println(fav.getNecessary());%></h9><br><br>
            								<h9 name="prep" class="u-align-center u-custom-font u-font-montserrat u-text u-text-6" style="font-size:18px" >&nbsp;Preparation:&nbsp;&nbsp;<br><%out.println(fav.getPreparation());%></h9>   
           									</table>  
           									</div>
                                        </div>  <% 
        								}%>    
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

     <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-bd34">
        <div class="u-clearfix u-sheet u-sheet-1">
            <p class="u-custom-font u-small-text u-text u-text-variant u-text-1">Progetto ISPW 2019 -2020
                <br>Arianna Freda - Alessia Minotti - Michela Lattanzi
            </p>
        </div>
  </footer>
</body>

</html>