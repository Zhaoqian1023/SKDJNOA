<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- BEGIN META -->
	  <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="">
      <meta name="author" content="Custom Theme">
	  <!-- END META -->
     
      <!-- BEGIN SHORTCUT ICON -->
	  <link rel="shortcut icon" href="<%=basePath %>admin/img/favicon.ico">
	  <!-- END SHORTCUT ICON -->
	  
      <title>录入成功</title>
	  
	  <!-- BEGIN STYLESHEET --> 
		<link href="<%=basePath %>admin/css/bootstrap.min.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
		<link href="<%=basePath %>admin/css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
		<link href="<%=basePath %>admin/assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON STYLESHEET -->
		<link href="<%=basePath %>admin/css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
		<link href="<%=basePath %>admin/css/style-responsive.css" rel="stylesheet"><!-- THEME BASIC RESPONSIVE  CSS -->
      <!--[if lt IE 9]>
      <script src="admin/js/html5shiv.js"></script>
      <script src="admin/js/respond.min.js"></script>
      <![endif]-->
	  <!-- END STYLESHEET --> 
   </head>
   <body class="body-404">
      <div class="container">
	     <!-- BEGIN MAIN CONTENT --> 
         <section class="error-wrapper">
            <h2>Entry successful!</h2>
            
            <form action="Source_query?page=coursegradefinal" method="post">
            
             <input type="text"  name="classId" style="display: none" value="${classId }">
             <input type="text"  name="courseId" style="display: none" value="${courseId }">
             <input type="text"  name="year" style="display: none" value="${year }">
             <br>
           <button type="submit" class="btn btn-primary" value="">Print - Final Transcript</button>
           <!-- <button type="submit" class="btn btn-primary" formaction="Source_query?page=courseandattendancegradefinal"  value="">平时成绩单打印</button> -->
           
            </form>
           <%--  <p class="page-404"><a href="<%=basePath %>admin/index.jsp">返回主页</a></p> --%>
           
         </section>
		 <!-- END MAIN CONTENT --> 
      </div>
   </body>
</html>
