<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Olive Enterprise">
<!-- END META -->

<!-- BEGIN SHORTCUT ICON -->
<!--<link rel="shortcut icon" href="img/favicon.ico">-->
<!-- END SHORTCUT ICON -->
<title>山东科技大学济南校区</title>

<!-- BEGIN STYLESHEET -->

<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- FONT AWESOME ICON CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/style-responsive.css" rel="stylesheet">
<!-- THEME RESPONSIVE CSS -->
<link href="assets/morris.js-0.4.3/morris.css" rel="stylesheet">
<!-- MORRIS CHART CSS -->
<!--dashboard calendar-->
<link href="css/clndr.css" rel="stylesheet">
<script type="text/javascript">
	function active() {
		$("#scoreinput").attr("class", "active");
	}
</script>
<script src="js/geo.js"></script>
</head>

<body onload="active(),setup()">
	<section id="container" class="">
		<!-- BEGIN HEADER -->
		<%@ include file="publicpage/head.jsp"%>
		<!-- END HEADER -->

		<!-- BEGIN SIDEBAR -->
		<%@ include file="publicpage/leftaside.jsp"%>
		<!-- END SIDEBAR -->

		<!-- START MAIN CONTENT -->
		<section id="main-content">
			<!-- START WRAPPER -->
			<section class="wrapper">

				<!-- START ROW -->
				<section class="panel">
					<header class="panel-heading">
						<i class="fa fa-hand-o-down"> </i> <span
							class="label label-primary" style="font-size:medium">
							请输入学生学号 </span>
					</header>
					<div class="panel-body">
						<form action="Student_queryStudent"
							method="post">
							<input type="text" name="sid"> 
									<button class="btn btn-primary" type="submit">确认查询</button>
								
						</form>
						<%
						if(session.getAttribute("updatesuccess")!=null){
							%>
							<h1>学生信息更新成功</h1>
							<% 
							session.removeAttribute("updatesuccess");
						}
						
						%>
						<% 
						if(session.getAttribute("updateerror")!=null){
							%>
							<h1>学生信息更新失败！</h1>
							<% 
							session.removeAttribute("updateerror");
						}
						
						%>
						<% 
						if(session.getAttribute("findstudenterror")!=null){
							%>
							<h1>未查询到此学生！</h1>
							<% 
							session.removeAttribute("findstudenterror");
						}
						
						%>
						<% 
						if(session.getAttribute("addstudenterror")!=null){
							%>
							<h1>添加学生失败！</h1>
							<% 
							session.removeAttribute("addstudenterror");
						}
						
						%>
						<% 
						if(session.getAttribute("addstudenterror1")!=null){
							%>
							<h1>添加学生失败，学号已存在！</h1>
							<% 
							session.removeAttribute("addstudenterror1");
						}
						
						%>
						<% 
						if(session.getAttribute("addstudentsuccess")!=null){
							%>
							<h1>添加学生成功！</h1>
							<% 
							session.removeAttribute("addstudentsuccess");
						}
						
						%>
						<% 
						if(session.getAttribute("delstudentsuccess")!=null){
							%>
							<h1>删除学生成功！</h1>
							<% 
							session.removeAttribute("delstudentsuccess");
						}
						
						%>
						<% 
						if(session.getAttribute("delstudenterror")!=null){
							%>
							<h1>删除学生失败！</h1>
							<% 
							session.removeAttribute("delstudenterror");
						}
						
						%>
				</section>

				<br> <br> <br>
				</div>
				<!-- START WRAPPER -->
			</section>
			<!-- END MAIN CONTENT -->

			<!-- START FOOTER -->
			<%@ include file="publicpage/footer.jsp"%>
			<!-- END FOOTER -->
		</section>
		<!-- START JS -->
		<script src="js/jquery-1.8.3.min.js"></script>
		<!-- BASIC JQUERY 1.8.3 LIB. JS -->
		<script src="js/bootstrap.min.js"></script>
		<!-- BOOTSTRAP JS -->
		<script src="js/jquery.dcjqaccordion.2.7.js"></script>
		<!-- ACCORDIN JS -->
		<script src="js/jquery.scrollTo.min.js"></script>
		<!-- SCROLLTO JS -->
		<script src="js/jquery.nicescroll.js"></script>
		<!-- NICESCROLL JS -->
		<script src="js/respond.min.js"></script>
		<!-- RESPOND JS -->
		<script src="js/jquery.sparkline.js"></script>
		<!-- SPARKLINE JS -->
		<script src="js/sparkline-chart.js"></script>
		<!-- SPARKLINE CHART JS -->
		<script src="js/common-scripts.js"></script>
		<!-- BASIC COMMON JS -->
		<script src="js/count.js"></script>
		<!-- COUNT JS -->
		<!--Morris-->
		<script src="assets/morris.js-0.4.3/morris.min.js"></script>
		<!-- MORRIS JS -->
		<script src="assets/morris.js-0.4.3/raphael-min.js"></script>
		<!-- MORRIS  JS -->
		<script src="js/chart.js"></script>
		<!-- CHART JS -->
		<!--Calendar-->
		<script src="js/calendar/clndr.js"></script>
		<!-- CALENDER JS -->
		<script src="js/calendar/evnt.calendar.init.js"></script>
		<!-- CALENDER EVENT JS -->
		<script src="js/calendar/moment-2.2.1.js"></script>
		<!-- CALENDER MOMENT JS -->
		<!--<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>&lt;!&ndash; UNDERSCORE JS &ndash;&gt;-->
		<script src="assets/jquery-knob/js/jquery.knob.js"></script>
		<!-- JQUERY KNOB JS -->
		<script>
			//knob
			$(".knob").knob();
		</script>
		<script type="text/javascript">
			function getKCM() {
				var dept = document.getElementById("s1").value;
				var grade = document.getElementById("s2").value;
				var professional = document.getElementById("s3").value;
				var msg = "professional=" + professional + "&category=全部课程";

				$.ajax({
					type : "post",
					url : "Course_byProfessional.action",
					data : msg,
					dataType : "text",
					async : false,
					success : function(result) {
						eval("var info=" + result);
						var x = document.getElementById("s4");
						for (i = 0; i < x.options.length; i++) {
							x.removeChild(x.options[i]);
						}
						for (i = 0; i < info.length; i++) {
							var option = document.createElement("option");
							option.text = info[i].value;
							x.add(option, x.options[i]);
						}
					},

				});

			}
		</script>

		<!-- END JS -->
	</section>
</body>
</html>
