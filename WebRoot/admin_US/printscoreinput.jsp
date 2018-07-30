<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<!--xmlns="http://www.w3.org/1999/html"  -->
<html lang="en" >
<head>
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Olive Enterprise">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<!-- END META -->

<!-- BEGIN SHORTCUT ICON -->
<!--<link rel="shortcut icon" href="img/favicon.ico">-->
<!-- END SHORTCUT ICON -->
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
		$("#mymodal").modal({
            show:true
        });
	}
	function KeyP(v) {
		document.getElementById("txt").value = 100 - v.value;

	}
	function a() {
		var p1 = document
				.getElementById("p1").value;
		var j1 = document
				.getElementById("txt").value;
		document.getElementById("f1").style.display = "block";
		document.getElementById("f2").style.display = "block";
		 $("#mymodal").modal({
             show:true
         });
	}
	function checkAction(n){
		if(n == 0){
			document.formName.action="Source_save?page=save&flag=百分制";
		}else if(n == 1){
			document.formName.action="Source_add?page=input";
		}
		dbform.submit();
	}
</script>
<!-- END STYLESHEET-->
</head>
<body  onload="active()">
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
									Score Entry </span>
							</header>
							<div id="qzxs" style="display:none">
								<div align="center">

									<span class="label label-success" style="font-size: medium">
										<i class="fa fa-pencil"> </i>请输入权重
									</span>
								</div>
								<table align="center" border="0" style="border-spacing: 100px">
									<tr>
										<td><br></td>
									</tr>
									<tr>
										
										<td width="55%"><span class="btn-info"
											style="font-size: medium">平时成绩权重：</span></td>

										<td width="40%"><input type="text" name="ordinaryProportion" id="p1" size="5"
											placeholder="0" onkeyup="0" value ="0"><span>%</span></td>

									</tr>
									<tr>
										<td><span class="btn-info" style="font-size: medium">卷面成绩权重：</span></td>
										<td><input type="text" name="paperProportion" id="txt" size="5"
											placeholder="100"  onkeyup="100" value="100"><span>%</span></td>

									</tr>
									<tr>
										<td><br></td>
									</tr>
									<div id="f3" align="center"
										style="float-left:100px;margin-left: 100px">
										<tr align="center" style="display: block">
											<td>

												<span class="btn btn-primary"
													style="font-size: 15px;margin-left: 100px"  onclick="a()">
													<i class="fa fa-sort-up"> </i> 下一步
												</span>
											</td>
											<td>

												<input type="text" style="display: none" name="courseId" value="${list.get(0).getCourseId() }">
												<input type="text" style="display: none" name="examFlag" value="${list.get(0).getExamFlag() }">
											</td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
									</div>
								</table>

							</div>

							
							<div id="f1" class="f1" >
								<table width="750" cellspacing="0" cellpadding="0" border="0"
									align="center">
									<tbody>
										<tr>
											<td class="Font18" width="50%" valign="middle" align="center"><font
												size="5" face="黑体">山东科技大学学生课程成绩单</font><br>
											<br></td>
										</tr>
										<tr>
											<td>
												<table class="Font11PtX120" width="100%" cellspacing="0"
													cellpadding="0" border="0" align="center">
													<tbody>
														<tr valign="middle" align="left">
															<td height="24" width="40%" nowrap="nowrap" align="left">Class：<input type="text" readonly="readonly" style="border: 0px; width:280px" value="${list.get(0).getClassEnglish() }"><input type="text" name="className" readonly="readonly" style="border: 0px;display:none; width:280px" value="${list.get(0).getClassName() }"></td>
															<td height="24" nowrap="nowrap" align="left" name="a2">Class Number：<input type="text" name="classId" readonly="readonly" style="border: 0px" value="${list.get(0).getClassId() }"></td>
															<td height="24" width="40%" nowrap="nowrap" align="left">Academic year/Semester：<input type="text" name="year" readonly="readonly" style="border: 0px" value="${list.get(0).getYears() }"></td>
														</tr>
														<tr valign="middle" align="left">
															<td height="24" nowrap="nowrap" align="left">Course：<input type="text" name="course" readonly="readonly" style="border: 0px; width:330px" value="${list.get(0).getCourseName() }"></td>
															<td height="24" nowrap="nowrap" align="left">Credit：<input type="text" name="credits" readonly="readonly" style="border: 0px" value="${list.get(0).getCredits() }"></td>
															<td height="24" nowrap="nowrap" align="left">Course Type：<input type="text" name="category" readonly="readonly" style="border: 0px" value="${list.get(0).getCategory() }"></td>
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
																<table class="LUpLines" id="mm" onkeydown="keyDown(event)" width="100%" cellspacing="0"
																	cellpadding="0" border="1" align="left">
																	<tbody>
																		<tr class="Font11PtX120" valign="middle"
																			align="center">
																			<td class="RULine" width="13%" nowrap="nowrap">Student ID</td>
																			<td class="RULine" width="10%" nowrap="nowrap">Name</td>
																			<td class="RULine" width="18%" nowrap="nowrap" style="display:none">Regular Grade</td>
																			<td class="RULine" name="final" width="18%"
																				nowrap="nowrap">Grade</td>
																			<td style="display: none" class="RULine" id="xianshi2" class="xianshia"
																				width="22%" nowrap="nowrap" >Final Grade
																			</td>
																			<td class="RULine" width="18%" nowrap="nowrap">Remarks</td>
																		</tr>
																		
																		
																		<c:forEach items="${list}" var="att">
																		<tr class="Font8Pt" valign="top">
																			<td  class="RULine" ><center><input type="text"size="12" name="studentId" readonly="readonly" style="border: 0px" value="${att.getSid() }"></center></td>
																			<td class="RULine" nowrap="nowrap" >
																				<center>
																					<input type="text" size="15" readonly="readonly" style="border: 0px" value="${att.getEnglishName()}">
																					<input type="text" name="studentName" size="5" readonly="readonly" style="border: 0px;display: none" value="${att.getSname()}">
																				</center>
																					
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center"  style="display:none">
																				<center><input  name="ordinaryGrade" autocomplete="off" 
																				 id="p2" class="ping" type="text" size="5" 
																				placeholder="0"  value="0" readonly="readonly" style="border: 0px;text-align:center"/></center>
																			</td>
																			<td class="RULine" nowrap="nowrap" align="center">
																				<input  name="paperGrade" autocomplete="off"
																				 id="j2" class="juan" type="text"  size="8px"
																				placeholder="" style="text-align:center"/>
																			</td>
																			<td id="xianshi3" class="xianshia"
																				style="display: none" class="RULine" name="final1"
																				nowrap="nowrap" align="center">
																				<h5 name="finalGrade"  value="0"></h5>
																			</td>

																			<td class="RULine" nowrap="nowrap" align="center">
																				<select name="beizhu" id="mark"
																				style="text-align: center">
																					
																					<option value="1">nothing</option>
																					<option value="0">not taken</option>
																					<option value="2">cheating</option>
																					<option value="3">disciplinary violation</option>
																					<option value="4">absent for exam</option>
																					<option value="5">deferred exam</option>
																					<option value="6">ineligible of exam</option>
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

							<div id="f2">
								<table align="center">
										<td width="100px" >

											<button class="btn btn-primary" 
													data-toggle="modal" data-toggle="modal" data-target="#mymodaltwo" type="button">Save</button>
										
											<h5>
												<br>
											</h5>

										</td>
										<td style="margin-left: 100px">
										
												<button class="btn btn-primary"
													data-toggle="modal" data-toggle="modal" data-target="#mymodal-data" type="button">Confirm Entry (can not be changed)</button>
										
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
											<h4 class="modal-title">Confirm Save</h4>
										</div>
										<div class="modal-body" style="padding: 60px 100px 10px;">
											<div class="text-danger"
												style="font-size: medium;margin: auto">Welcome to use the save function, the next time you can continue to enter the results!</div>
										</div>
										<div class="modal-footer">
											<button class="btn btn-success" type="submit" onclick="checkAction(0);">Confirm Submission</button>

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
											<h4 class="modal-title">Confirm Entry</h4>
										</div>
										<div class="modal-body" style="padding: 60px 100px 10px;">
											<div class="text-danger"
												style="font-size: medium;margin: auto">Please confirm that the data is entered correctly before confirming the submission!</div>
										</div>
										<div class="modal-footer">
											<button class="btn btn-success" type="submit" onclick="checkAction(1);">Confirm Submission</button>

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
                                        <h4 class="modal-title">Notice</h4>
                                    </div>
                                    <div class="modal-body" style="padding: 30px 50px 50px;">
                                        <div class="text-danger" style="font-size: medium;margin: auto">
                                            <table align="center">
                                                <tr>
                                                    <td >1.	Make sure that every student has a score (including 0). Any space, Chinese characters, English letters or parentheses are NOT accepted.
</span></td>
                                                </tr>
                                                <tr>
                                                    <td ><span>2.	If student meets one of exceptional circumstances listed in the Remarks, just click it accordingly instead of entering any score.
</span></td>
                                                </tr>
                                                <tr>
                                                    <td ><span>3.	Please contact Academic Affairs Office if you meet any problems.
</span></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td ><br><br></td>
                                                </tr>
                                                <tr>
                                                    <td><span style="font-weight:bold;">Note: If the scores are not entered according to the requirements, they can’t be submitted. Please understand any inconvenience.
</span></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                   <!--  <div class="modal-footer">
                                        <button class="btn btn-success" type="button">确认</button>
                                    </div> -->
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


		<script>
			if (!document.getElementsByClassName) {
				document.getElementsByClassName = function(className, element) {
					var children = (element || document)
							.getElementsByTagName('*');
					var elements = new Array();
					for (var i = 0; i < children.length; i++) {
						var child = children[i];
						var classNames = child.className.split(' ');
						for (var j = 0; j < classNames.length; j++) {
							if (classNames[j] == className) {
								elements.push(child);
								break;
							}
						}
					}
					return elements;
				};
			}
			var h5s = document.getElementsByTagName("h5");
			var pings = document.getElementsByClassName("ping");
			var juans = document.getElementsByClassName("juan");
			var button = document.getElementsByName("boo")[0];
			var bs = document.getElementsByTagName("b");

			$(document)
					.ready(
							function() {
								button.onclick = function() {
									document.getElementById("xianshi").style.display = "block";
									document.getElementById("xianshi2").style.display = "block";
									$(".xianshia").show();
									var p1 = document.getElementById("p1").value / 100;
									var j1 = document.getElementById("txt").value / 100;

									var sums = new Array();
									for (var i = 0,d=pings.length; i < pings.length; i++) {
										sums[i] = parseFloat(pings[i].value)
												* p1
												+ parseFloat(juans[i].value)
												* j1;
										   sums[i] = Math.round(sums[i] * 100) / 100;
										   if((sums[i]<=60) && (sums[i] >=59.5)){
											   sums[i]=60;
										   }
										  // alert(sums[i]);
										  if(isNaN(sums[i])){
											  d--;
											  sums[i]=0;
										  }
										  if(isNaN(parseFloat(pings[i].value))||isNaN(parseFloat(juans[i].value))){
											  sums[i]=" ";
											 // alert(1);
										  }
										h5s[i].innerHTML = sums[i];
										
									}
									var you = 0;
									var liang = 0;
									var zhong = 0;
									var jige = 0;
									var notjige = 0;
									var avg = 0;
									var he = 0;
		//alert(d);
									for (var j = 0; j < sums.length; j++) {
										//he += parseFloat(sums[j]);
										if (parseFloat(sums[j]) >=60 & parseFloat(sums[j])<70 ) {
											jige++;
											he += parseFloat(sums[j]);
										} else if (parseFloat(sums[j]) >= 90) {
											you++;
											he += parseFloat(sums[j]);
										} else if (parseFloat(sums[j]) >= 80
												& parseFloat(sums[j]) < 90) {
											liang++;
											he += parseFloat(sums[j]);
										} else if (parseFloat(sums[j]) >= 70
												& parseFloat(sums[j]) < 80) {
											zhong++;
											he += parseFloat(sums[j]);
										} else if(parseFloat(sums[j]) < 60){
											notjige++;
											he += parseFloat(sums[j]);
										}
									}
								//alert(he);
									var you1 = 100 * you / d;
									var liang1 = 100 * liang / d;
									var zhong1 = 100 * zhong / d;
									var jige1 = 100 * jige / d;
									var notjige1 = 100 * notjige / d;
									 you1=Math.round(you1 * 100) / 100;
									 liang1=Math.round(liang1 * 100) / 100;
									 zhong1=Math.round(zhong1 * 100) / 100;
									 jige1=Math.round(jige1 * 100) / 100;
									 notjige1=Math.round(notjige1 * 100) / 100;
									var he1 = he/ d;
									document.getElementById("pjcj").value = Math.round(he1 * 100) / 100;
									document.getElementById("you").value = you;
									document.getElementById("liang").value = liang;
									document.getElementById("zhong").value = zhong;
									document.getElementById("jige").value = jige;
									document.getElementById("notjige").value = notjige;
									document.getElementById("you1").value = you1;
									document.getElementById("liang1").value = liang1;
									document.getElementById("zhong1").value = zhong1;
									document.getElementById("jige1").value = jige1;
									document.getElementById("notjige1").value = notjige1;

								}
							});
			function FormatAfterDotNumber(ValueString, nAfterDotNum) {
				var ValueString, nAfterDotNum;
				var resultStr, nTen;
				ValueString = "" + ValueString + "";
				strLen = ValueString.length;
				dotPos = ValueString.indexOf(".", 0);
				if (dotPos == -1) {
					resultStr = ValueString + ".";
					for (i = 0; i < nAfterDotNum; i++) {
						resultStr = resultStr + "0";
					}
					return resultStr;
				} else {
					if ((strLen - dotPos - 1) >= nAfterDotNum) {
						nAfter = dotPos + nAfterDotNum + 1;
						nTen = 1;
						for (j = 0; j < nAfterDotNum; j++) {
							nTen = nTen * 10;
						}
						resultStr = Math.round(parseFloat(ValueString) * nTen)
								/ nTen;
						return resultStr;
					} else {
						resultStr = ValueString;
						for (i = 0; i < (nAfterDotNum - strLen + dotPos + 1); i++) {
							resultStr = resultStr + "0";
						}
						return resultStr;
					}
				}
			}
		</script>

	</section>
</body>
</html>
