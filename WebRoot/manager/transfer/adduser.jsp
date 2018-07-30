<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	  
      <title>操作结果信息</title>
	  
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
           <%
						if(session.getAttribute("addusererror2")!=null){
							%>
							<h2>该教师不存在</h2>
							<% 
							session.removeAttribute("addusererror2");
						}
						
						%>
						 <%
						if(session.getAttribute("addusererror1")!=null){
							%>
							<h2>该用户以添加</h2>
							<% 
							session.removeAttribute("addusererror1");
						}
						
						%>
						<%
						if(session.getAttribute("addusersuccess")!=null){
							%>
							<h1>用户添加成功</h1>
							<% 
							session.removeAttribute("addusersuccess");
						}
						
						%>
						<%
						if(session.getAttribute("addusererror")!=null){
							%>
							<h1>用户添加失败</h1>
							<% 
							session.removeAttribute("addusererror");
						}
						
						%>
						<%
						if(session.getAttribute("delusersuccess")!=null){
							%>
							<h1>用户删除成功</h1>
							<% 
							session.removeAttribute("delusersuccess");
						}
						
						%>
						<%
						if(session.getAttribute("delusererror")!=null){
							%>
							<h1>用户删除失败</h1>
							<% 
							session.removeAttribute("delusererror");
						}
						
						%>
            <p class="page-404"><a href="<%=basePath %>manager/index_manager.jsp">返回主页</a></p>
         </section>
		 <!-- END MAIN CONTENT --> 
      </div>
   </body>
</html>
