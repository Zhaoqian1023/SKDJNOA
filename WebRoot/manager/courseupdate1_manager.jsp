<%@ page language="java"
	import="java.util.* ,com.po.Course,com.po.Teacher" pageEncoding="UTF-8"%>
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
<script src="js/geo1.js"></script>
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
						<form method="post" action="Course_updateCourse">

							<table border="1">
								<tr>

									<th style="font-size: 18px">课程代码</th>
									<th style="font-size: 18px">课程名</th>
									<th style="font-size: 18px">课程类别</th>
									<th style="font-size: 18px">学分</th>
									<th style="font-size: 18px">学时</th>
									<th style="font-size: 18px">学年</th>
									<th style="font-size: 18px">开始周</th>
									<th style="font-size: 18px">结束周</th>
									<th style="font-size: 18px">任课教师工号</th>
									<th style="font-size: 18px">是否为考察课</th>
								</tr>
								<c:forEach items="${clist}" var="att">
									<tr>
										<td align="center" style="font-size: 15px"><input
											name="cid1" type=text size="8" value="${att.getCid()}"></td>
										<td align="center" style="font-size: 15px"><input
											name="cname1" type=text size="50" value="${att.getCname() }"></td>
										<td align="center" style="font-size: 15px"><select
											name="category1">
												<option value="${att.getCategory()}">${att.getCategory()}
												</option>
												<option value="必修">必修</option>
												<option value="选修">选修</option>
												<option value="公选">公选</option>
										</select></td>
										<td align="center" style="font-size: 15px"><input
											name="credits1" type=text size="2"
											value="${att.getCredits() }"></td>
										<td align="center" style="font-size: 15px"><input
											name="time1" type=text size="3" value="${att.getTime()}"></td>
											
											
											


										<td align="center" style="font-size: 15px">
												<input
											name="year1" readonly type=text size="11"
											value="${att.getYear() }">
										</td>
										<td align="center" style="font-size: 15px"><input
											name="beginTime1" type=text size="3"
											value="${att.getBeginTime() }"></td>
										<td align="center" style="font-size: 15px"><input
											name="endTime1" type=text size="3"
											value="${att.getEndTime()}"></td>
										<td align="center" style="font-size: 15px"><input
											name="teachers1" type=text size="8"
											value="${att.getTeachers().getTid()}"></td>


										<td align="center" style="font-size: 15px"><select
											name="examFlag1">
												<option value="${att.getExamFlag()}">${att.getExamFlag()==0 ? "非考察课" : "考察课"}
												</option>
												<option value="0">非考察课</option>
												<option value="1">考察课</option>
										</select></td>

									</tr>

								</c:forEach>

							</table>
							<div class="modal-footer">
								<button class="btn btn-default">
									<a href="coursefind_manager.jsp">返&nbsp;&nbsp;回</a>
								</button>
								&nbsp;&nbsp;
								<button class="btn btn-default" type="submit">提交修改</button>
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
