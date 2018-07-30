<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Olive Enterprise">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />

<title>山东科技大学学生成绩单录入</title>

<!-- BEGIN STYLESHEET -->
<link rel="stylesheet" href="css/main.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- FONT AWESOME ICON STYLESHEET -->
<link href="assets/jquery-ui/jquery-ui-1.10.1.custom.min.css"
	rel="stylesheet">
<!-- JQUERY STYLESHEET -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/style-responsive.css" rel="stylesheet">
<!-- THEME BASIC RESPONSIVE  CSS -->
<script type="text/javascript">
	function active() {
		$("#printscoreinput").attr("class", "active");
	}
	function a() {
		 $("#mymodal").modal({
             show:true
         });
	}
	function checkAction(n){
		if(n == 0){
			document.formName.action="Source_saveGX?page=save&flag=百分制";
		}else if(n == 1){
			document.formName.action="Source_addGX?page=input";
		}
		dbform.submit();
	}
</script>
<!-- END STYLESHEET-->
</head>
<body  onload="a()">
	<section id="container" class="">
    <!--header-->
     <%@ include file="publicpage/head.jsp" %>
    <!---->
        
      <!-- aside -->
      <%@ include file="publicpage/leftaside.jsp" %>
      <!---->
		 <form  name="formName" action="" method="post">
		<section id="main-content">
			<!-- BEGIN WRAPPER  -->
			<section class="wrapper">
				<!-- BEGIN ROW  -->
				<div class="row">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading">
								<i class="fa fa-hand-o-down"> </i> <span
									class="label label-success" style="font-size: medium">
									成绩录入 </span>
							</header>
							
							<div id="f1" class="f1" style="display: block;">
								<table width="750" cellspacing="0" cellpadding="0" border="0"
									align="center">
									<tbody>
										<tr>
											<td class="Font18" width="50%" valign="middle" align="center"><font
												size="5" face="黑体">山东科技大学学生课程成绩单</font><br>
											<br>
												<input type="text" style="display: none" name="courseId" value="${listST.get(0).getCourseId() }">
												<input type="text" style="display: none" name="examFlag" value="${listST.get(0).getExamFlag()  }">
											
											</td>
										</tr>
										<tr>
											<td>
												<table class="Font11PtX120" width="100%" cellspacing="0"
													cellpadding="0" border="0" align="center">
													<tbody>
														<tr valign="middle" align="left">
															<td height="24" width="60%" nowrap="nowrap" align="left">课程名称：<input type="text" name="course" size="25" readonly="readonly" style="border: 0px" value="${listST.get(0).getCourseName() }"></td>
															<td height="24" width="40%" nowrap="nowrap" align="left">学年/学期：<input type="text" name="year" readonly="readonly" style="border: 0px" value="${listST.get(0).getYears() }"></td>
														</tr>
														<tr valign="middle" align="left">
															<td height="24" nowrap="nowrap" align="left">学分：<input type="text" name="credits" readonly="readonly" style="border: 0px" value="${listST.get(0).getCredit() }"></td>
															<td height="24" nowrap="nowrap" align="left">课程类别：<input type="text" name="category" readonly="readonly" style="border: 0px" value="${listST.get(0).getCourseCategory() }"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr>
											<td valign="top">
												<table width="100%" cellspacing="0" cellpadding="0"
													border="0">
													<tbody>
														<tr valign="top" align="left">
															<td width="356">
																<table class="LUpLines" id="mm" onkeydown="keyDown(event)"  width="100%" cellspacing="0"
																	cellpadding="0" border="1" align="left">
																	<tbody>
																		<tr class="Font11PtX120" valign="middle"
																			align="center">
																			<td class="RULine" width="18%" nowrap="nowrap">班级</td>
																			<td class="RULine" width="13%" nowrap="nowrap">学号</td>
																			<td class="RULine" width="10%" nowrap="nowrap">姓名</td>
																			<td class="RULine" name="final" width="18%" nowrap="nowrap">最终成绩</td>
																			<td class="RULine" width="18%" nowrap="nowrap">备注</td>
																		</tr>
																		
																		
																		<c:forEach items="${listST}" var="att">
																		<tr class="Font8Pt" valign="top">
																			<td class="RULine" nowrap="nowrap" align="center">
																				<input type="text" size="22" name="classNames" readonly="readonly" style="border: 0px" value="${att.getClassName() }">
																			</td>
																			<td  class="RULine" ><center><input type="text" size="12" name="studentId" readonly="readonly" style="border: 0px" value="${att.getStudentId() }"></center></td>
																			<td class="RULine" nowrap="nowrap" ><center>
																				<input type="text" name="studentName" size="5" readonly="readonly" style="border: 0px" value="${att.getStudentName() }"></center>
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<input  name="finalGrade"
																				 id="j2" class="juan" type="text" size="5" autocomplete="off" value="${att.getPaperScore() }"
																				placeholder="" />
																				<select name="classid" 
																				style="text-align: center;display: none">
																					<option value="${att.getClassId() }">${att.getClassId() }</option>
																			</select>
																			</td>

																			<td class="RULine" nowrap="nowrap" align="center">
																				<select name="beizhu" id="mark"
																				style="text-align: center">
																					<option value="${att.getRemarkNum() }">${att.getRemark() }</option>
																					<option value="1">无</option>
																					<option value="0">未选</option>
																					<option value="2">作弊</option>
																					<option value="3">违纪</option>
																					<option value="4">旷考</option>
																					<option value="5">缓考</option>
																					<option value="6">取消考试资格</option>
																			</select>
																			</td>
																		</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</td>

														</tr>

													</tbody>


												</table>
											</td>
										</tr>
									</tbody>
								</table>
							</div>

							<br> <br>

							<div id="f2" style="display: block">
								<table align="center">
									<tr>
										<td width="100px" >

											<button class="btn btn-primary" 
													data-toggle="modal" data-toggle="modal" data-target="#mymodaltwo" type="button">保存</button>
										
											<h5>
												<br>
											</h5>

										</td>
										<td style="margin-left: 100px">
										
												<button class="btn btn-primary"
													data-toggle="modal" data-toggle="modal" data-target="#mymodal-data" type="button">确认录入（不可修改）</button>
										
											<h5>
												<br>
											</h5></td>
									</tr>
								</table>
							</div>
							
							
							
							<div class="modal fade" id="mymodaltwo" style="margin-bottom: 20px">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">确定保存</h4>
										</div>
										<div class="modal-body" style="padding: 100px 100px 10px;">
											<div class="text-danger"
												style="font-size: medium;margin: auto">欢迎使用保存功能，下次可以继续录入成绩！</div>
										</div>
										<div class="modal-footer">
											<button class="btn btn-success" type="submit" onclick="checkAction(0);">确认提交</button>

										</div>
									</div>
								</div>
							</div>
							
							




							<div class="modal fade" id="mymodal-data" style="margin-bottom: 20px">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">确认录入</h4>
										</div>
										<div class="modal-body" style="padding: 100px 100px 10px;">
											<div class="text-danger"
												style="font-size: medium;margin: auto">请再次确认保存，并确认数据输入无误后，确认提交</div>
										</div>
										<div class="modal-footer">
											<button class="btn btn-success" type="submit" onclick="checkAction(1);">确认提交</button>

										</div>
									</div>
								</div>
							</div>
							
							
							<div class="modal" id="mymodal" style="margin-bottom: 20px">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">温馨提示</h4>
                                    </div>
                                    <div class="modal-body" style="padding: 30px 50px 50px;">
                                        <div class="text-danger" style="font-size: medium;margin: auto">
                                            <table align="center">
                                                <tr>
                                                    <td >一、最终成绩比例为必填项（范围为“0-100”，无平时成绩比例则输入“0”），在输入成绩时成绩范围为“0-100”，禁止出现空格、汉字、字母、符号等情况 。</span></td>
                                                </tr>
                                                <tr>
                                                    <td ><span>二、录入成绩时，应确保成绩单中每位学生都有成绩（包括0分），特殊情况也应在备注一栏中选择相应选项。</span></td>
                                                </tr>
                                                <tr>
                                                    <td ><br><br></td>
                                                </tr>
                                                <tr>
                                                    <td><span style="font-weight:bold;">声明：未按照要求录入的学生成绩，本系统将不予提交成绩，带来不便，敬请谅解！</span></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>







						</section>
					</div>
				</div>
				<!-- END ROW  -->

			</section>
			</form>
			<!-- END WRAPPER  -->

			<!-- END MAIN CONTENT -->
			<!-- START FOOTER -->
			<%@ include file="publicpage/footer.jsp"%>
			<!-- END FOOTER -->
		</section>
		<!-- START JS -->
		 <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script><!-- BOOTSTRAP JS -->
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/message_zn.js"></script>
    <script src="js/jquery.dcjqaccordion.2.7.js"></script><!-- ACCORDIN JS -->
    <script src="js/jquery.scrollTo.min.js"></script><!-- SCROLLTO JS -->
    <script src="js/jquery.nicescroll.js"></script><!-- NICESCROLL JS -->
    <script src="js/respond.min.js"></script><!-- RESPOND JS -->
    <script src="js/jquery.sparkline.js"></script><!-- SPARKLINE JS -->
    <script src="js/sparkline-chart.js"></script><!-- SPARKLINE CHART JS -->
    <script src="js/common-scripts.js"></script><!-- BASIC COMMON JS -->
    <script src="js/count.js"></script><!-- COUNT JS -->
    <script src="js/changeKey.js"></script>


	</section>
</body>
</html>
