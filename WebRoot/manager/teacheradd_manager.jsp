<%@ page language="java" import="java.util.* ,com.po.Student" pageEncoding="UTF-8"%>
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
<title>山东科技大学济南校区教师添加</title>

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
							请输入教师信息 </span>
					</header>
					<div class="panel-body">
						<form method="post" action="Teacher_addTeacher">
						<div class="modal-dialog">
							<div class="modal-content">

								<div class="modal-body" style="padding: 100px 100px 10px;">
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 教师工号&nbsp;:
											</label> <input name="tid"   type="text" >
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 教师姓名&nbsp;:
											</label> <input name="tname"   type="text">
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 所在教研室:
											</label> <!--<input name="position"   type="text">-->
											
											<select
												name="position">
												<option value="">无</option>
												<option value="专业基础教研室">专业基础教研室</option>
												<option value="中兴企业">中兴企业</option>
												<option value="主任">主任</option>
												<option value="主席">主席</option>
												<option value="书记">书记</option>
												<option value="人力资源部">人力资源部</option>
												<option value="会计教研室">会计教研室</option>
												<option value="体育教研室">体育教研室</option>
												<option value="信息咨询部">信息咨询部</option>
												<option value="党总支书记">党总支书记</option>
												<option value="党政办公室">党政办公室</option>
												<option value="副主任">副主任</option>
												<option value="副书记">副书记</option>
												<option value="合作办学科">合作办学科</option>
												<option value="商贸教研室">商贸教研室</option>
												<option value="团委书记">团委书记</option>
												<option value="团总支">团总支</option>
												<option value="团总支书记">团总支书记</option>
												<option value="处长">处长</option>
												<option value="外教管理科">外教管理科</option>
												<option value="宿舍管理中心">宿舍管理中心</option>
												<option value="就业指导中心">就业指导中心</option>
												<option value="教务科">教务科</option>
												<option value="教学科">教学科</option>
												<option value="数学教研室">数学教研室</option>
												<option value="校区党委常务副书记">校区党委常务副书记</option>
												<option value="校区管委副主任">校区管委副主任</option>
												<option value="校区管委常务副主任">校区管委常务副主任</option>
												<option value="澳教">澳教</option>
												<option value="物理实验室">物理实验室</option>
												<option value="物理教研室">物理教研室</option>
												<option value="电子、期刊阅览室">电子、期刊阅览室</option>
												<option value="电工电子技术教研室">电工电子技术教研室</option>
												<option value="电气技术教研室">电气技术教研室</option>
												<option value="社科教研室">社科教研室</option>
												<option value="科研科">科研科</option>
												<option value="组织员">组织员</option>
												<option value="网融企业">网融企业</option>
												<option value="英语教研室">英语教研室</option>
												<option value="计算机软件技术教研室">计算机软件技术教研室</option>
												<option value="通信工程教研室">通信工程教研室</option>
												<option value="金融教研室">金融教研室</option>
											</select>
											
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 职&nbsp;&nbsp;&nbsp;称:
											</label> <!--  <input name="title"   type="text">-->
											<select
												name="title">
												<option value="">无</option>
												<option value="讲师">讲师</option>
												<option value="助教">助教</option>
												<option value="副教授">副教授</option>
												<option value="教授">教授</option>
											</select>
											
											
											
										</div>
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 所属单位&nbsp;:
											</label> <!--  <input name="dname"  type="text">-->
											<select
												name="dname">
												<option value="">无</option>
												<option value="党委办公室">党委办公室</option>
												<option value="行政办公室">行政办公室</option>
												<option value="教科部">教科部</option>
												<option value="学生工作处">学生工作处</option>
												<option value="工会">工会</option>
												<option value="团委">团委</option>
												<option value="图书馆">图书馆</option>
												<option value="后勤管理处">后勤管理处</option>
												<option value="审计办公室">审计办公室</option>
												<option value="资产部">资产部</option>
												<option value="外事办公室">外事办公室</option>
												<option value="公共课部">公共课部</option>
												<option value="财经系">财经系</option>
												<option value="电气信息系">电气信息系</option>
													
											</select>
											
											
										</div>
										
										
									<div class="modal-footer">
									<button class="btn btn-default" type="submit">确认添加</button>
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
