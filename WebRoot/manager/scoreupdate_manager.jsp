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
<title>学生成绩修改</title>

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

<style type="text/css">
.wrapper{
width:1600px;
}
</style>

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
				<section class="panel" style="width: 1700px">
					<header class="panel-heading">
						<i class="fa fa-hand-o-down"> </i> <span
							class="label label-primary" style="font-size:medium"> 学生信息
						</span>
					</header>
					<div class="panel-body">
						<form method="post" action="Source_updateSource">

							<table border="1">
								<tr>

									<th style="font-size: 18px;text-align:center">学号</th>
									<th style="font-size: 18px;text-align:center">姓名</th>
									<th style="font-size: 18px;text-align:center">班级名</th>
									<th style="font-size: 18px;text-align:center">课程名</th>
									<th style="font-size: 18px;text-align:center">课程类别</th>
									<th style="font-size: 18px;text-align:center">考试周</th>
									<th style="font-size: 18px;text-align:center">学期</th>
									<th style="font-size: 18px;text-align:center">平时成绩</th>
									<th style="font-size: 18px;text-align:center">卷面成绩</th>
									<th style="font-size: 18px;text-align:center">最终成绩</th>
									<th style="font-size: 18px;text-align:center">重修一</th>
									<th style="font-size: 18px;text-align:center">重修二</th>
									<th style="font-size: 18px;text-align:center">重修三</th>
									<th style="font-size: 18px;text-align:center">备注</th>

								</tr>
								<c:forEach items="${list}" var="att">
									<tr>
										<td style="font-size: 15px"><input
											name="sid" type=text size="15" readonly style="text-align:center"
											value="${att.getStudentId()}"></td>
										<td style="font-size: 15px"><input
											name="sname" type=text size="8" readonly style="text-align:center"
											value="${att.getStudentName() }"></td>
										<td  style="font-size: 15px"><input
											name="classname" type=text size="35" readonly style="text-align:center"
											value="${att.getClassName()}"></td>
										<td style="font-size: 15px"><input
											name="coursename" type=text size="50" readonly style="text-align:center"
											value="${att.getCourse() }"></td>
										<td style="font-size: 15px"><input
											name="category" type=text size="10" readonly style="text-align:center"
											value="${att.getCategory()}"></td>
										<%-- <td style="font-size: 15px"><select
											name="examFlag1">
												<option value="${att.getExamFlag()}">${att.getExamFlag()==0 ? "非考察课" : "考察课"} </option>
												<option value="0">非考察课</option>
												<option value="1">考察课</option>
										</select></td> --%>
										<td style="font-size: 15px">
										<input
											name="examFlag1" type=text size="7"  style="text-align:center"
											value="${att.getExamFlag()}"></td>
										</td>

										<td style="font-size: 15px"><select name="year1">
												<option value="${att.getYear()}">${att.getYear()}</option>
												<%@ include file="publicpage/year_option.jsp"%>
										</select></td>
										<td align="center" style="font-size: 15px"><input
											name="ordinarygrade" type=text size="5" style="text-align:center"
											value="${att.getOrdinaryGrade() }"></td>
										<td align="center" style="font-size: 15px"><input
											name="papergrade" type=text size="5" style="text-align:center"
											value="${att.getPaperGrade()}"></td>
										<td align="center" style="font-size: 15px"><input
											name="finalgrade" type=text size="7" style="text-align:center"
											value="${att.getFinalGrade()}"><%-- ${att.getFinalGrade().matches("^[0.0-9.0]+$")?"1":"2"} --%></td>

										<td align="center" style="font-size: 15px"><input
											name="resetgrade1" type=text size="5" style="text-align:center"
											value="${att.getResetGrade1()}"></td>
										<td align="center" style="font-size: 15px"><input
											name="resetgrade2" type=text size="5" style="text-align:center"
											value="${att.getResetGrade2() }"></td>
										<td align="center" style="font-size:15px"><input
											name="resetgrade3" type=text size="5" style="text-align:center"
											value="${att.getResetGrade3()}"></td>
										<td align="center" style="font-size: 15px"><select
											name="beizhu1">
												<option value="${att.getBeizhu() }">${att.getBeizhu() }</option>
												<option value="无">无</option>
												<option value="未选">未选</option>
												<option value="作弊">作弊</option>
												<option value="违纪">违纪</option>
												<option value="旷考">旷考</option>
												<option value="缓考">缓考</option>
												<option value="取消考试资格">取消考试资格</option>
										</select></td>
										<%-- <td width="40%" align="center"><a
												href="Source_query?page=coursegradefinal&year=2016-2017/2&course=${att.getCourseName() }&className=${att.getClassName()}"><input
													type="submit" value='最终成绩单打印'></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<a
												href='Source_query?page=courseandattendancegradefinal&year=2016-2017/2&course=${att.getCourseName() }&className=${att.getClassName()}'><input
													type="submit" value='平时成绩单打印'></a></td> --%>
									</tr>

								</c:forEach>

							</table>
							<div class="modal-footer">
								<button class="btn btn-default"><a href="scorefind_manager.jsp">返&nbsp;&nbsp;回</a></button>&nbsp;&nbsp;<button class="btn btn-default" type="submit">提交修改</button>
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
