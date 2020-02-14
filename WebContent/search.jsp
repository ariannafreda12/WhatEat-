<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "logic.controller.LoginManager"%>  
    <%@ page import = "logic.bean.UserBean"%>
    
<!DOCTYPE html>
<html style="font-size: 16px;">
<style>
.home{
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
.hiButton {
	background-color: white;
	opacity: 0.7;
	border-radius:6px;
	border:0px solid #dcdcdc;
	display:inline-block;
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
font-family:montserrat;
font-size:18px;
cellspacing:2;
cellpadding: 2;
width:70%;
left:230px;
vertical-align:top;
text-align:left;
text-vertical-align:top;
}
.td{
vertical-align:top;
text-vertical-align:top;
width:15%;
}

</style>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="WhatEat?!">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Search</title>
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

<body data-home-page="Search.html" data-home-page-title="Search" class="u-body u-image" style="background-position: 50% 50%; background-attachment: fixed; background-image: url(&quot;images/54e8d24a495aae14f6da8c7dda79367d1d38d6ed5b586c4870277bd09145c458bc_1280.jpg&quot;);">
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
                            <a class="u-button-style u-nav-link u-text-active-white u-text-hover-palette-5-dark-2 u-text-palette-5-dark-3" style="padding: 10px;">Recipe</a>
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
            <div><h1 class="u-text u-text-body-color u-title u-text-1">WhatEat?!</h1> <label class="hiButton"><%out.println(" Hi " + ub.getUsername());%></label><a href="homePage.jsp" class="home"><img src="images\homeIcon.png" width="40" height="35" style="right:20px; align:right"></a></div> 
        </div>
    </header>
    <form action="searchDB.jsp" method="post">
    <section class="u-align-center u-clearfix u-image u-section-1" id="carousel_ff8f" data-image-width="1280" data-image-height="848">
    
        <div class="u-clearfix u-sheet u-sheet-1">
            <h4 style = "font-family:montserrat" class="u-custom-font u-text u-text-1">Which meal to prepare??</h4>
            <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-1">
                <div class="u-gutter-0 u-layout">
                    <div class="u-layout-row">
                        <div class="u-container-style u-layout-cell u-left-cell u-size-10 u-size-30-md u-layout-cell-1">
                            <div class="u-container-layout u-valign-top u-container-layout-1">
                                <img src="images/54e8d5415753ae01f7c5d57cc42030761d37d7f85254794971297cd3924b_12801.jpg" alt="" class="u-border-1 u-border-grey-dark-1 u-border-radius-10 u-expanded-width u-image u-image-round u-image-1" data-image-width="1280"
                                    data-image-height="853">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6"><input type="radio" name="category" value="starters" checked>&nbsp;Starters </h6>
                            </div>
                        </div>
                        <div class="u-container-style u-layout-cell u-size-10 u-size-30-md u-layout-cell-2">
                            <div class="u-container-layout u-valign-top u-container-layout-2">
                                <img src="images/55e5d1444a55a414f6da8c7dda79367d1d38d6ed5b586c4870277bd0914ac25dbe_1280.jpg" alt="" class="u-border-1 u-border-grey-dark-1 u-border-radius-20 u-expanded-width u-image u-image-round u-image-2"
                                    data-image-width="1280" data-image-height="697">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6"><input type="radio" name="category" value="main course">&nbsp;Main course </h6>
                            </div>
                        </div>
                        <div class="u-container-style u-layout-cell u-size-10 u-size-30-md u-layout-cell-3">
                            <div class="u-container-layout u-valign-top u-container-layout-3">
                                <img src="images/57e1d0464b51ae14f6da8c7dda79367d1d38d6ed5b586c4870277bd09144c350b1_1280.jpg" alt="" class="u-border-1 u-border-grey-dark-1 u-border-radius-20 u-expanded-width u-image u-image-round u-image-3"
                                    data-image-width="1280" data-image-height="853">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6"><input type="radio" name="category" value="second course">&nbsp;Second course</h6>
                            </div>
                        </div>
                        <div class="u-container-style u-layout-cell u-size-10 u-size-30-md u-layout-cell-4">
                            <div class="u-container-layout u-valign-top u-container-layout-4">
                                <img src="images/57e1d1424856ae14f6da8c7dda79367d1d38d6ed5b586c4870277bd0914acd50bd_12801.jpg" alt="" class="u-border-1 u-border-grey-dark-1 u-border-radius-20 u-image u-image-round u-image-4" data-image-width="1280"
                                    data-image-height="848">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6"><input type="radio" name="category" value="side">&nbsp;Side</h6>
                            </div>
                        </div>
                        <div class="u-align-center u-container-style u-layout-cell u-size-10 u-size-30-md u-layout-cell-5">
                            <div class="u-container-layout u-valign-top u-container-layout-5">
                                <img src="images/53e6dc434d57b108f5d08460962934761237d6ed5a4c704c7d2f7fd29044c658_1280.jpg" alt="" class="u-border-1 u-border-grey-dark-1 u-border-radius-20 u-expanded-width u-image u-image-round u-image-5"
                                    data-image-width="1280" data-image-height="853">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6"><input type="radio" name="category" value="breakfast">&nbsp;Breakfast </h6>
                            </div>
                        </div>
                        <div class="u-container-style u-layout-cell u-right-cell u-size-10 u-size-30-md u-layout-cell-6">
                            <div class="u-container-layout u-valign-top u-container-layout-6">
                                <img src="images/50e9d5434e52b108f5d08460962934761237d6ed5a4c704c7d2f7fdd9144cd5d_12801.jpg" alt="" class="u-border-1 u-border-grey-dark-1 u-border-radius-20 u-expanded-width u-image u-image-round u-image-6"
                                    data-image-width="1280" data-image-height="853">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6"><input type="radio" name="category" value="dessert">&nbsp;Dessert</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <h4 style = "font-family:montserrat" class="u-custom-font u-text u-text-default u-text-8">Choose a difficulty level:</h4>
            <div class="u-clearfix u-gutter-0 u-layout-wrap u-layout-wrap-2">
                <div class="u-layout">
                    <div class="u-layout-row">
                        <div class="u-container-style u-layout-cell u-left-cell u-size-20 u-layout-cell-7">
                            <div class="u-container-layout u-valign-top u-container-layout-7">
                                <div class="u-custom-color-3 u-shape u-shape-circle u-shape-1"></div>
                                <img class="u-expand-resize u-image u-image-7" src="images/55e0dc424e54b108f5d08460962934761237d6ed5a4c704c7d2f7fdd9049c551_1280.png" data-image-width="1280" data-image-height="1280">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6">
                                <br><input type="radio" name="difficulty" value="beginner" checked> Beginner</h6>  
                            </div>
                        </div>
                        <div class="u-container-style u-layout-cell u-size-20 u-layout-cell-8">
                            <div class="u-container-layout u-container-layout-8">
                                <div class="u-custom-color-3 u-shape u-shape-circle u-shape-2"></div>
                                <img class="u-expand-resize u-image u-image-8" src="images/55e0dc424e54b108f5d08460962934761237d6ed5a4c704c7d2f7fdd9049c551_1280.png" data-image-width="1280" data-image-height="1280">
                                <img class="u-expand-resize u-image u-image-9" src="images/55e0dc424e54b108f5d08460962934761237d6ed5a4c704c7d2f7fdd9049c551_1280.png" data-image-width="1280" data-image-height="1280">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6">
                    			<br><input type="radio" name="difficulty" value="medium"> Medium</h6>
                            </div>
                        </div>
                        <div class="u-container-style u-layout-cell u-right-cell u-size-20 u-layout-cell-9">
                            <div class="u-container-layout u-valign-top u-container-layout-9">
                                <div class="u-custom-color-3 u-shape u-shape-circle u-shape-3"></div>
                                <img class="u-expand-resize u-image u-image-10" src="images/55e0dc424e54b108f5d08460962934761237d6ed5a4c704c7d2f7fdd9049c551_1280.png" data-image-width="1280" data-image-height="1280">
                                <img class="u-expand-resize u-image u-image-11" src="images/55e0dc424e54b108f5d08460962934761237d6ed5a4c704c7d2f7fdd9049c551_1280.png" data-image-width="1280" data-image-height="1280">
                                <img class="u-expand-resize u-image u-image-12" src="images/55e0dc424e54b108f5d08460962934761237d6ed5a4c704c7d2f7fdd9049c551_1280.png" data-image-width="1280" data-image-height="1280">
                                <h6 class="u-align-center u-custom-font u-font-montserrat u-text u-text-6">
                    			<input type="radio" name="difficulty" value="advanced"> Advanced</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
             
            <h4 style = "font-family:montserrat" class="u-custom-font u-text u-text-default u-text-12">Select ingredients:</h4>
            <table class="table">
   	 
    <tr>
         <th id="varius"><br>Varius</th>
         <th id="sauces"><br>Sauces</th>
         <th id="herbspices"><br>Herbspices</th>
         <th id="snacks"><br>Snacks</th>
         
   	</tr>
    <%
    String[] varius = {"Butter", "Cheese", "Chocolate", "Eggs", "Flour", "Honey", "Jam", "Milk", "Oil", "Pasta", "Rice", "Salt", "Sugar", "Water", "Yeast", "Yoghurt"};
    String[] sauces = {"Ketchup", "Mayonnaise", "Mustard", "Vinegar"};
	String[] herbspices = {"Basil", "Chives", "Coriander", "Dill", "Origan", "Parsley", "Rosemary", "Sage", "Thyme", "Cinnamon", "Cumin", "Curry", "Nutmeg", "Paprika", "Pepper", "Saffron"};
	String[] snack = {"Olives", "Walnuts", "Peanuts", "Nuts"};
	String[] vegetables = {"Artichoke", "Asparagus", "Aubergine", "Avocado", "Beansprouts", "Beetroot", "Broad beans", "Broccoli", "Cabbage", "Carrot", "Cauliflower", "Celery", "Chilli pepper", "Courgette", "Cucumber", "French beans", "Garlic", "Ginger", "Leek","Lettuce", "Mushroom", "Onion", "Peas", "Pepper", "Potato", "Pumkin", "Radish", "Rocket", "Tomato", "Turnip", "Spinach", "Squash"};
	String[] fruit = {"Apple","Apricot", "Banana", "Blackberry", "Blueberry", "Cherry", "Coconut", "Fig", "Grape", "Kiwi", "Lemon", "Lime", "Mango", "Melon", "Orange", "Peach", "Pear", "Pineapple", "Plum", "Raspberry", "Strawberry"};
	String[] fish = {"Anchovy", "Cod", "Herring", "Mackerel", "Pilchard", "Plaice", "Salmon", "Sardine", "Sole", "Trout", "Tuna"};
	String[] meat = {"Bacon", "Beef", "Chicken", "Duck", "Ham", "Lamb", "Liver", "Nince", "Salami", "Sausage", "Turkey", "Veal"};
	%>	
		<tr>
		<td class="td"><%
		for(String s1 : varius) {
			%><br><input type="checkbox" name="ingr" value="<%out.println(s1);%>">  <%out.println(s1);}%></td><td class="td"><%
		
		for(String s2 : sauces) {
			%><br><input type="checkbox" name="ingr" value="<%out.println(s2);%>">  <%out.println(s2);}%></td><td class="td"><%
			
		for(String s3 : herbspices) {
			%><br><input type="checkbox" name="ingr" value="<%out.println(s3);%>">  <%out.println(s3);}%></td><td class="td"><%
		
		for(String s4 : snack) {
			%><br><input type="checkbox" name="ingr" value="<%out.println(s4);%>">  <%out.println(s4);}%></td></tr>
		
		<br>
		</table><table class="table">
		
		
		  <th id="vegetables"><br>Vegetables</th>
          <th id="fruit"><br>Fruit</th>
          <th id="fish"><br>Fish</th>
          <th id="meat"><br>Meat</th>
        </tr>
        
        <tr><td class="td"><%
        		 
		for(String s5 : vegetables) {
			%><br><input type="checkbox" name="ingr" value="<%out.println(s5);%>">  <%out.println(s5);}%></td><td class="td"><%
		
		for(String s6 : fruit) {
			%><br><input type="checkbox" name="ingr" value="<%out.println(s6);%>">  <%out.println(s6);}%></td><td class="td"><%
		
		for(String s7 : fish) {
			%><br><input type="checkbox" name="ingr" value="<%out.println(s7);%>">  <%out.println(s7);}%></td><td class="td"><%
		
		for(String s8 : meat) {
			%><br><input type="checkbox" name="ingr" value="<%out.println(s8);%>">  <%out.println(s8);}%></td>
</tr>	
			
</table>        
            <input style = "font-family:montserrat; font-size:20px;" type="submit" class="u-border-radius-8 u-btn u-btn-round u-button-style u-custom-font u-grey-10 u-text-black u-btn-1" value="Search">
        </div>
    </section>
</form>

    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-bd34">
        <div class="u-clearfix u-sheet u-sheet-1">
            <p class="u-custom-font u-font-montserrat u-small-text u-text u-text-variant u-text-1">Progetto ISPW 2019 -2020
                <br>Arianna Freda - Alessia Minotti - Michela Lattanzi
            </p>
        </div>
    </footer>
    
</body>

</html>