<%@ page language="java" import="java.util.* ,com.po.Student"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>山东科技大学济南校区学生信息修改</title>

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
							class="label label-primary" style="font-size:medium"> 学生信息
						</span>
					</header>
					<div class="panel-body">
						<form method="post" action="Student_updateStudent">
							<div class="modal-dialog">
								<div class="modal-content">

									<div class="modal-body" style="padding: 100px 100px 10px;">
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												学&nbsp;&nbsp;号: </label> <input name="sid"
												value="${student.getSid()}" type="text" readonly="readonly">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												姓&nbsp;&nbsp;名: </label> <input name="sname"
												value="${student.getSname()}" type="text">


										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												英文名:&nbsp;</label> <input name="englishname"
												value="${student.getEnglishname() } " type="text">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												性&nbsp;&nbsp;别: </label>
											<!-- <input name="sex"
												value="${student.getSex() }" type="text">-->

											<%
												if ("男".equals(session.getAttribute("sex1"))) {
											%>
											<label><input name="sex" type="radio" value="男"
												checked />男 </label> <label><input name="sex" type="radio"
												value="女" />女 </label>
											<%
												session.removeAttribute("sex");
												} else {
											%>
											<label><input name="sex" type="radio" value="男" />男
											</label> <label><input name="sex" type="radio" value="女"
												checked />女 </label>
											<%
												session.removeAttribute("sex");
												}
											%>


										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 身份证号: </label> <input
												name="number" value="${student.getNumber() }" type="text">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 政治面貌: </label> <select
												name="political">
												<%
													if ("共青团员".equals(session.getAttribute("political1"))) {
												%>
												<option value="共青团员">共青团员</option>
												<option value="党员">党员</option>
												<option value="群众">群众</option>
												<option value="无">无</option>
												<%
													session.removeAttribute("political1");
													}

													else if ("党员".equals(session.getAttribute("political1"))) {
												%>

												<option value="党员">党员</option>
												<option value="共青团员">共青团员</option>
												<option value="群众">群众</option>
												<option value="无">无</option>
												<%
													session.removeAttribute("political1");
													}

													else if ("".equals(session.getAttribute("political1"))) {
												%>

												<option value="">无</option>
												<option value="共青团员">共青团员</option>
												<option value="党员">党员</option>
												<option value="群众">群众</option>

												<%
													session.removeAttribute("political1");
													}

													else if ("群众".equals(session.getAttribute("political1"))) {
												%>
												<option value="群众">群众</option>

												<option value="共青团员">共青团员</option>
												<option value="党员">党员</option>
												<option value="">无</option>
												<%
													session.removeAttribute("political1");
													}
												%>
											</select>
											<!--  											<input
												name="political" value="${student.getPolitical() }"
												type="text">
												-->
										</div>






										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												民&nbsp;&nbsp;族: </label> <input name="national"
												value="${student.getNational() }" type="text">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 入学时间: </label> <input
												name="amissionTime" value="${student.getAmissionTime() }"
												type="text">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 毕业时间: </label> <input
												name="graduationTime"
												value="${student.getGraduationTime() }" type="text">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												系:&nbsp;&nbsp;&nbsp; </label>
											<!--  <input name="colleagesname"
												value="${student.getColleages().getCname() }" type="text">
												-->
											<select name="colleagesname">
												<%
													if ("财经系".equals(session.getAttribute("colleagesname1"))) {
												%>
												<option value="财经系">财经系</option>
												<option value="电气信息系">电气信息系</option>
												<%
													session.removeAttribute("colleagesname1");
													}

													else if ("电气信息系".equals(session.getAttribute("colleagesname1"))) {
												%>
												<option value="电气信息系">电气信息系</option>
												<option value="财经系">财经系</option>

												<%
													session.removeAttribute("colleagesname1");
													}
												%>
											</select>







										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												专&nbsp;&nbsp;业: </label> 
												<!--  <input name="professionsname"
												value="${student.getProfessions().getPname() }" type="text">
												-->
												
												
												
												<select name="professionsname">
												<%
													if ("财经系".equals(session.getAttribute("colleagesname2"))) {
												%>
												<option value="${student.getProfessions().getPname() }">${student.getProfessions().getPname() }</option>
												<option value="国际经济与贸易">国际经济与贸易</option>
												<option value="金融学">金融学</option>
												<option value="会计学">会计学</option>
												
												
												
												<%
													session.removeAttribute("colleagesname2");
													}

													else if ("电气信息系".equals(session.getAttribute("colleagesname2"))) {
												%>
												<option value="${student.getProfessions().getPname() }">${student.getProfessions().getPname() }</option>
												<option value="电气工程及其自动化">电气工程及其自动化</option>
												<option value="计算机科学与技术">计算机科学与技术</option>
												<option value="通信工程">通信工程</option>
												<option value="信息管理与信息系统">信息管理与信息系统</option>

												<%
													session.removeAttribute("colleagesname2");
													}
												%>
											</select>
												
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												班&nbsp;&nbsp;级: </label>
												<!--   <input name="classnamename"
												value="${student.getClassName().getCname()}" type="text">
												-->
												
												
												<select name="classnamename">
												<%
													if ("财经系".equals(session.getAttribute("colleagesname3"))) {
												%>
												<option value="${student.getClassName().getCname()}">${student.getClassName().getCname()}</option>
												<option value="国际经济与贸易2017-1">国际经济与贸易2017-1</option>
												<option value="国际经济与贸易2017-2">国际经济与贸易2017-2</option>
												<option value="国际经济与贸易2017-3">国际经济与贸易2017-3</option>
												<option value="金融学2017-1">金融学2017-1</option>
												<option value="金融学2017-2">金融学2017-2</option>
												<option value="金融学2017-3">金融学2017-3</option>
												<option value="金融学2017-4">金融学2017-4</option>
												<option value="会计学2017-1">会计学2017-1</option>
												<option value="会计学2017-2">会计学2017-2</option>
												<option value="会计学2017-3">会计学2017-3</option>
												<option value="会计学2017-4">会计学2017-4</option>
												<option value="国际经济与贸易2014-1">国际经济与贸易2014-1</option>
												<option value="国际经济与贸易2014-2">国际经济与贸易2014-2</option>
												<option value="国际经济与贸易2014-3">国际经济与贸易2014-3</option>
												<option value="金融学2014-1">金融学2014-1</option>
												<option value="金融学2014-2">金融学2014-2</option>
												<option value="金融学2014-3">金融学2014-3</option>
												<option value="会计学2014-1">会计学2014-1</option>
												<option value="会计学2014-2">会计学2014-2</option>
												<option value="会计学2014-3">会计学2014-3</option>
												<option value="会计学2014-4">会计学2014-4</option>
												<option value="中英教改2014">中英教改2014</option>
												<option value="国际经济与贸易2015-1">国际经济与贸易2015-1</option>
												<option value="国际经济与贸易2015-2">国际经济与贸易2015-2</option>
												<option value="国际经济与贸易2015-3">国际经济与贸易2015-3</option>
												<option value="金融学2015-1">金融学2015-1</option>
												<option value="金融学2015-2">金融学2015-2</option>
												<option value="金融学2015-3">金融学2015-3</option>
												<option value="会计学2015-1">会计学2015-1</option>
												<option value="会计学2015-2">会计学2015-2</option>
												<option value="会计学2015-3">会计学2015-3</option>
												<option value="会计学2015-4">会计学2015-4</option>
												<option value="中英教改2015">中英教改2015</option>
												<option value="国际经济与贸易2016-1">国际经济与贸易2016-1</option>
												<option value="国际经济与贸易2016-2">国际经济与贸易2016-2</option>
												<option value="国际经济与贸易2016-3">国际经济与贸易2016-3</option>
												<option value="金融学2016-1">金融学2016-1</option>
												<option value="金融学2016-2">金融学2016-2</option>
												<option value="金融学2016-3">金融学2016-3</option>
												<option value="金融学2016-4">金融学2016-4</option>
												<option value="会计学2016-1">会计学2016-1</option>
												<option value="会计学2016-2">会计学2016-2</option>
												<option value="会计学2016-3">会计学2016-3</option>
												<option value="会计学2016-4">会计学2016-4</option>
												<%
													session.removeAttribute("colleagesname3");
													}

													else if ("电气信息系".equals(session.getAttribute("colleagesname3"))) {
												%>
												<option value="${student.getClassName().getCname()}">${student.getClassName().getCname()}</option>
												<option value="电气工程及其自动化2017-1">电气工程及其自动化2017-1</option>
												<option value="电气工程及其自动化2017-2">电气工程及其自动化2017-2</option>
												<option value="电气工程及其自动化2017-3">电气工程及其自动化2017-3</option>
												<option value="信息管理与信息系统2017-1">信息管理与信息系统2017-1</option>
												<option value="信息管理与信息系统2017-2">信息管理与信息系统2017-2</option>
												<option value="信息管理与信息系统2017-3">信息管理与信息系统2017-3</option>
												<option value="通信工程2017-1">通信工程2017-1</option>
												<option value="通信工程2017-2">通信工程2017-2</option>
												<option value="通信工程2017-3">通信工程2017-3</option>
												<option value="计算机科学与技术2017-1">计算机科学与技术2017-1</option>
												<option value="计算机科学与技术2017-2">计算机科学与技术2017-2</option>
												<option value="计算机科学与技术2017-3">计算机科学与技术2017-3</option>
												<option value="计算机科学与技术2017-4">计算机科学与技术2017-4</option>
												<option value="国际经济与贸易2014-1">国际经济与贸易2014-1</option>
												<option value="国际经济与贸易2014-2">国际经济与贸易2014-2</option>
												<option value="国际经济与贸易2014-3">国际经济与贸易2014-3</option>
												<option value="电气工程及其自动化2014-1">电气工程及其自动化2014-1</option>
												<option value="电气工程及其自动化2014-2">电气工程及其自动化2014-2</option>
												<option value="电气工程及其自动化2014-3">电气工程及其自动化2014-3</option>
												<option value="信息管理与信息系统2014-1">信息管理与信息系统2014-1</option>
												<option value="信息管理与信息系统2014-2">信息管理与信息系统2014-2</option>
												<option value="通信工程2014-1">通信工程2014-1</option>
												<option value="通信工程2014-2">通信工程2014-2</option>
												<option value="通信工程2014-3">通信工程2014-3</option>
												<option value="计算机科学与技术2014-1">计算机科学与技术2014-1</option>
												<option value="计算机科学与技术2014-2">计算机科学与技术2014-2</option>
												<option value="计算机科学与技术2014-3">计算机科学与技术2014-3</option>
												<option value="电气工程及其自动化2015-1">电气工程及其自动化2015-1</option>
												<option value="电气工程及其自动化2015-2">电气工程及其自动化2015-2</option>
												<option value="电气工程及其自动化2015-3">电气工程及其自动化2015-3</option>
												<option value="信息管理与信息系统2015-1">信息管理与信息系统2015-1</option>
												<option value="信息管理与信息系统2015-2">信息管理与信息系统2015-2</option>
												<option value="信息管理与信息系统2015-3">信息管理与信息系统2015-3</option>
												<option value="通信工程2015-1">通信工程2015-1</option>
												<option value="通信工程2015-2">通信工程2015-2</option>
												<option value="通信工程2015-3">通信工程2015-3</option>
												<option value="计算机科学与技术2015-1">计算机科学与技术2015-1</option>
												<option value="计算机科学与技术2015-2">计算机科学与技术2015-2</option>
												<option value="计算机科学与技术2015-3">计算机科学与技术2015-3</option>
												<option value="计算机科学与技术2015-4">计算机科学与技术2015-4</option>
												<option value="中澳教改2015-1">中澳教改2015-1</option>
												<option value="中澳教改2015-2">中澳教改2015-2</option>
												<option value="电气工程及其自动化2016-1">电气工程及其自动化2016-1</option>
												<option value="电气工程及其自动化2016-2">电气工程及其自动化2016-2</option>
												<option value="电气工程及其自动化2016-3">电气工程及其自动化2016-3</option>
												<option value="信息管理与信息系统2016-1">信息管理与信息系统2016-1</option>
												<option value="信息管理与信息系统2016-2">信息管理与信息系统2016-2</option>
												<option value="信息管理与信息系统2016-3">信息管理与信息系统2016-3</option>
												<option value="通信工程2016-1">通信工程2016-1</option>
												<option value="通信工程2016-2">通信工程2016-2</option>
												<option value="通信工程2016-3">通信工程2016-3</option>
												<option value="计算机科学与技术2016-1">计算机科学与技术2016-1</option>
												<option value="计算机科学与技术2016-2">计算机科学与技术2016-2</option>
												<option value="计算机科学与技术2016-3">计算机科学与技术2016-3</option>
												<option value="计算机科学与技术2016-4">计算机科学与技术2016-4</option>

												<%
													session.removeAttribute("colleagesname3");
													}
												%>
											</select>	
												
												
												
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium">
												备&nbsp;&nbsp;注: </label> <input name="note"
												value="${student.getNote() }" type="text">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 是否在校:
											   </label> <!--<input
												name="status" value="${student.getStatus() }" type="text">
												-->
												
											<select name="status">
												
												<option value="${student.getStatus() }">${student.getStatus() }</option>
												<option value="在校">在校</option>
												<option value="离校">离校</option>
												<option value="休学">休学</option>
												<option value="退学">退学</option>
												<option value="出国">出国</option>
												
												
												
											</select>	
												
												
										</div>


										<div class="modal-footer">
											<button class="btn btn-default" type="submit">确认修改</button>
										</div>
									</div>

								</div>
							</div>
						</form>
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
