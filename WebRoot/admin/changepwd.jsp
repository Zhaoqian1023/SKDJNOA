<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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
<meta name="author" content="Olive Enterprise">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<title>山东科技大学济南校区教师管理系统</title>
<!-- BEGIN STYLESHEET-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- FONT AWESOME ICON CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/clndr.css" rel="stylesheet">
<script type="text/javascript">
	function active() {
		$("#changepwd").attr("class", "active");
	}
</script>
</head>
<body onload="active(),setup()">
	<section id="container" class="">
		<!-- BEGIN HEADER -->
		<%@ include file="publicpage/head.jsp"%>
		<!-- END HEADER -->

		<!-- BEGIN SIDEBAR -->
		<%@ include file="publicpage/leftaside.jsp"%>
		<!-- END SIDEBAR -->
		<section id="main-content">
			<!-- START WRAPPER -->
			<section class="wrapper">

				<!-- START ROW -->
				<section class="panel">
					<header class="panel-heading">
						<i class="fa fa-smile-o"> </i> <span class="label label-primary"
							style="font-size: medium"> 修改密码 </span>

					</header>
					<br>
				<!-- 	<form class="cmxform" id="commentForm" method="post" action="Users_update">-->
					<form method="post" action="Users_update?page=changepwd">
						<div class="modal-dialog">
							<div class="modal-content">

								<div class="modal-body" style="padding: 100px 100px 10px;">
							<!--		<form class="form-horizontal" role="form">-->
										<div width="100px" height="20px">
											<label for="name" style="font-size: medium"> 输入修改密码:
											</label> <input id="pwd1" name="name" minlength="6" type="password"
												required>
										</div>
										<div width="100px" height="20px" style="margin-top: 20px">
											<label for="name" style="font-size: medium">确认修改密码: </label>
											<input id="pwd2" name="newpassword" minlength="6" type="password"
												onkeyup="validate()" required><span id="tishi"></span>
										</div>
									<div class="modal-footer">
									<button class="btn btn-default" type="submit">确认修改</button>
									<a href="login.jsp"><button class="btn btn-success" type="button">取消修改</button></a>
								</div>
								<!-- 	 </form>-->
								</div>
								
							</div>
						</div>
					</form>

					<!-- END ROW -->
				</section>
				<!-- START WRAPPER -->
			</section>
			<!-- END MAIN CONTENT -->
			<!-- START FOOTER -->
			<%@ include file="publicpage/footer.jsp"%>
			<!-- END FOOTER -->
		</section>
		<!-- END SECTION -->
		<!-- BEGIN JS -->
		<!--<script src="../SKDOA前台1115/js/jquery-1.8.3.min.js"></script>&lt;!&ndash; BASIC JQUERY 1.8.3 LIB. JS &ndash;&gt;-->
		<script src="js/jquery.js"></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/message_zn.js"></script>
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
		
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/message_zn.js"></script>

		<script>
			$.validator.setDefaults({
				submitHandler : function() {
					//alert("提交事件!");
				}
			});

			$().ready(function() {
				$("#commentForm").validate();
			});
			function validate() {
				var pwd1 = document.getElementById("pwd1").value;
				var pwd2 = document.getElementById("pwd2").value;

				// 对比两次输入的密码 
				if (pwd1 == pwd2) {
					document.getElementById("tishi").innerHTML = "<font color='green'>两次密码相同</font>";
					document.getElementById("submit").disabled = false;
					return true;
				} else {
					document.getElementById("tishi").innerHTML = "<font color='red'>两次密码不相同</font>";
					document.getElementById("submit").disabled = true;
					return false;
				}
			}
		</script>
		<!-- END JS -->
	</section>

</body>
</html>


