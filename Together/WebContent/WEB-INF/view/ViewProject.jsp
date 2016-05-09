<%@ page import="java.io.*,java.util.*,java.sql.*,model.User,util.SQLHelper,util.Tags"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>Fighter</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/style_user.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/user_infor.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>
<body>
<!-- Nav --->
<div class="col l6 s12">
    <nav class="light-blue lighten-1" role="navigation">
        <div class="nav-wrapper container">
            <ul class="left"><li><a id="logo-container" href="#" class="brand-logo left">Fighter</a></li></ul>
            <ul class="head-line right hide-on-med-and-down">
                <li class="active"><a href="#">找合伙人</a></li>
                <li><a href="#">创业项目</a></li>
                <li><a onclick="Materialize.toast('敬请期待！', 2000,'',function(){alert('Your toast was dismissed')})">轻合伙人</a></li>
                <li><a href="#">个人主页</a></li>

            </ul>
        </div>
    </nav>
</div>
<br/><br/>
<!-- end of Nav --->

<!-- container -->
<!------------ guide ----------->
<ul id="dropdown1" class="dropdown-content">
    <li><a href="#!">南校</a></li><li class="divider"></li>
    <li><a href="#!">东校</a></li><li class="divider"></li>
    <li><a href="#!">珠海校区</a></li><li class="divider"></li>
    <li><a href="#!">北校</a></li><li class="divider"></li>
</ul>

<ul id="dropdownMajor" class="dropdown-content">
    <li><a href="#!">计算机专业</a></li><li class="divider"></li>
    <li><a href="#!">医学</a></li><li class="divider"></li>
    <li><a href="#!">金融专业</a></li><li class="divider"></li>
    <li><a href="#!">生物科学</a></li><li class="divider"></li>
    <li><a href="#!">心理学</a></li><li class="divider"></li>
</ul>

<nav>
    <div class="nav-wrapper">
        <ul class="right hide-on-med-and-down">   
            <!-- Dropdown Trigger -->   
            <li><a class="dropdown-button" href="#!" data-activates="dropdownMajor">专业方向 <i class="material-icons right">arrow_drop_down</i></a> </li>
            <li><a class="dropdown-button" href="#!" data-activates="dropdown1">校区 <i class="material-icons right">arrow_drop_down</i></a> </li>
        </ul>
    </div>
</nav>
<!------------ The END of guide ----------->

<div class="container">
    <div class="row">
        <div class="col s8 m4">
            <div class="card blue-grey darken-1">
                <div class="card-content white-text">
                    <div class="center">	<img class="head-img" src="source/lufei.jpg"/>	</div>
                    <div class="card-title center">路飞</div>
                    <p>我是要成为海贼王的男人。哈哈哈</p>
                </div>
                <hr/>
                <div>
                    <div class="chip">乐天派</div>
                    <div class="chip">吃货</div>
                </div>
                <br/>

            </div>
        </div>
    </div>


    <div class="section">
    <% 
    	/*
	    Cookie cookie = null;
		Cookie[] cookies = null;
	    // 获取与该域相关的 Cookies 的数组
	    cookies = request.getCookies();
	    if( cookies != null ){
	         out.println("<h2>查找 Cookies 名称和值</h2>");
	         for (int i = 0; i < cookies.length; i++){
	            cookie = cookies[i];
	            out.print("名称：" + cookie.getName( ) + "，");
	            out.print("值：" + cookie.getValue( )+" <br/>");
	         }
	      }else{
	          out.println("<h2>未找到 Cookies</h2>");
	      }
	    */
    %>
    </div>

</div>

<footer class="page-footer orange">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Company Bio</h5>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">Made by Team D </div>
    </div>
</footer>


<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>

</body>
</html>

