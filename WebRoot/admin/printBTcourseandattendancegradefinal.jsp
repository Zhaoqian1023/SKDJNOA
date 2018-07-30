<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>山东科技大学学生课程平时成绩单</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/normalize.css">
<script language="javascript">
	function preview(oper) {
		if (oper < 10) {
			bdhtml = window.document.body.innerHTML;
			sprnstr = "<!--startprint" + oper + "-->";
			eprnstr = "<!--endprint" + oper + "-->";
			prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 18);
			prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));
			window.document.body.innerHTML = prnhtml;
			window.print();
			window.document.body.innerHTML = bdhtml;
		} else {
			window.print();
		}
	}
</script>
<style>
.hengxian {
	width: 100%;
	height: 2px;
	border-top: 1px solid #000;
	border-bottom: 1px solid #000;
}
</style>
</head>
<body>
	<table id="tblMsg" width="750" cellspacing="0" cellpadding="0"
		border="0" align="center">
		<tbody>
			<tr>
				<td>
					<table class="Font12" width="100%" border="0" align="center">
						<tbody>
							<tr>
								<td nowrap="nowrap"><font color="#FF0000"><strong>&nbsp;&nbsp;&nbsp;&nbsp;</strong></font></td>
							</tr>
							<tr valign="top">
								<td nowrap="nowrap"><font color="#FF0000"><strong>声&nbsp;&nbsp;&nbsp;&nbsp;明：</strong></font></td>
								<td><font color="#FF0000">本网站提供的成绩信息仅供您参考，所有信息以记录在<strong>教务科公布数据为准</strong></font></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table class="Font12" width="100%" border="0" align="center">
						<tbody>
							<tr valign="top">
								<td nowrap="nowrap"><font color="#FF0000"><strong>&nbsp;</strong></font></td>
								<td>&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td><hr width="90%" size="1"></td>
			</tr>
		</tbody>
	</table>
	<!--startprint1-->
	<table width="750" cellspacing="0" cellpadding="0" border="0"
		align="center">
		<tbody>
			<tr>
				<td class="Font18" width="50%" valign="middle" align="center"><font
					size="5" face="黑体">山东科技大学学生平时成绩单</font> <br><br></td>
			</tr>
			<tr>
				<td>
					<table class="Font11PtX120" width="100%" cellspacing="0"
						cellpadding="0" border="0" align="center">
						<tbody>
							<tr valign="middle" align="left">
								<td height="18" width="40%" nowrap="nowrap" align="left">班级：${list.get(0).getClassName() }
								</td>
								<td height="18" nowrap="nowrap" align="left">班号：${list.get(0).getClassId() }
								</td>
								<td height="18" width="40%" nowrap="nowrap" align="left">学年学期：${list.get(0).getYear() }</td>
							</tr>
							<tr valign="middle" align="left">
								<td height="18" nowrap="nowrap" align="left">课程名称：${list.get(0).getCourse() }</td>
								<td height="18" nowrap="nowrap" align="left">学分：${list.get(0).getCredits() }</td>
								<td height="18" nowrap="nowrap" align="left">课程类别：${list.get(0).getCategory() }
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top"><table width="100%" cellspacing="0"
						cellpadding="0" border="0">
						<tbody>
							<tr valign="top" align="left">
								<td width="356">
									<table class="LUpLines" width="100%" cellspacing="0"
										cellpadding="0" border="1" align="left"
										style="border-right:none;border-left:none;border-bottom:none">
										<tbody>
											<tr class="Font11PtX120" valign="middle" align="center">
												<td height="18" class="RULine" width="5%" nowrap="nowrap"
													style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">序号</td>
												<td height="18" class="RULine" width="30%" nowrap="nowrap"
													style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"">学号</td>
												<td height="18" class="RULine" width="25%" nowrap="nowrap"
													style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"">姓名</td>
												<td height="18" class="RULine" width="20%" nowrap="nowrap"
													style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"">平时成绩</td>
												<td height="18" class="RULine" width="20%" nowrap="nowrap"
													style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"">卷面成绩</td>
											</tr>
											<c:choose>
												<c:when test="${list.size()<=35}">
													<c:forEach items="${list}" var="att" varStatus="status">
														<tr class="Font8Pt" valign="top">
															<td height="21" class="RULine" align="center"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																size="2">${status.count}</font></td>
															<td height="21" class="RULine" nowrap="nowrap"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																size="2">${att.getStudentId() }</font></td>
															<td height="21" class="RULine" nowrap="nowrap"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																size="2">${att.getStudentName() }</font></td>

															<td height="21" class="RULine" nowrap="nowrap"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">

																<center>
																	<font size="2">${att.getOrdinaryGrade() }</font>
																</center>

															</td>

															<td height="21" class="RULine" nowrap="nowrap"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><center>
																	<font size="2">${att.getPaperGrade() }</font>
																</center></td>
														</tr>
													</c:forEach>
													<c:choose>
														<c:when test="${list.size()<35}">
															<c:forEach begin="${list.size()+1}" end="35" var="att1"
																varStatus="status">
																<tr class="Font8Pt" valign="top">
																	<td height="21" class="RULine" align="center"
																		valign="middle" colspan="5"
																		style="border-right:none;border-left:none;border-top:none;border-bottom:none;">
																	</td>
																</tr>
															</c:forEach>
														</c:when>
													</c:choose>

												</c:when>
												<c:otherwise>
													<c:forEach items="${list}" var="att" begin="0" end="34"
														varStatus="status">
														<tr class="Font8Pt" valign="top">
															<td height="21" class="RULine" align="center"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																size="2">${status.count}</font></td>
															<td height="21" class="RULine" nowrap="nowrap"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																size="2">${att.getStudentId() }</font></td>
															<td height="21" class="RULine" nowrap="nowrap"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																size="2">${att.getStudentName() }</font></td>
															<td height="21" class="RULine" nowrap="nowrap"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">

																<center>
																	<font size="2">${att.getOrdinaryGrade() }</font>
																</center>

															</td>

															<td height="21" class="RULine" nowrap="nowrap"
																valign="middle"
																style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><center>
																	<font size="2">${att.getPaperGrade() }</font>
																</center></td>
														</tr>
													</c:forEach>
												</c:otherwise>

											</c:choose>

										</tbody>
									</table>
								</td>
								<td valign="top"><table width="100%" cellspacing="0"
										cellpadding="0" border="0">
										<tbody>
											<tr valign="top" align="left">
												<td width="36">
													<table class="LUpLines" width="100%" cellspacing="0"
														cellpadding="0" border="0" align="left">
														<tbody>
															<tr class="Font11PtX120" valign="middle" align="center">
																<td class="RULine" width="6%" nowrap="nowrap">&nbsp;</td>

															</tr>
														</tbody>
													</table>
												</td>
												<td width="356">
													<table class="LUpLines" width="100%" cellspacing="0"
														cellpadding="0" border="1" align="right">
														<tbody>
															<tr class="Font11PtX120" valign="middle" align="center">
																<td height="18" class="RULine" width="5%"
																	nowrap="nowrap"
																	style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">序号</td>
																<td height="18" class="RULine" width="30%"
																	nowrap="nowrap"
																	style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">学号</td>
																<td height="18" class="RULine" width="25%"
																	nowrap="nowrap"
																	style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">姓名</td>
																<td height="18" class="RULine" width="25%"
																	nowrap="nowrap"
																	style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">卷面成绩</td>
																<td height="18" class="RULine" width="15%"
																	nowrap="nowrap"
																	style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">平时成绩</td>
															</tr>

															<s:if test="%{list.size()>35}">
																<c:forEach items="${list}" var="att" begin="35"
																	end="${list.size()-1}" varStatus="status">
																	<tr class="Font8Pt" valign="top">
																		<td height="21" class="RULine" nowrap="nowrap"
																			valign="middle"
																			style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																			size="2">${status.count+35}</font></td>
																		<td height="21" class="RULine" nowrap="nowrap"
																			valign="middle"
																			style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																			size="2">${att.getStudentId() }</font></td>
																		<td height="21" class="RULine" nowrap="nowrap"
																			valign="middle"
																			style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><font
																			size="2">${att.getStudentName() }</font></td>
																		<td height="21" class="RULine" nowrap="nowrap"
																			valign="middle"
																			style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid">

																			<center>
																				<font size="2">${att.getOrdinaryGrade() }</font>
																			</center>

																		</td>

																		<td height="21" class="RULine" nowrap="nowrap"
																			valign="middle"
																			style="border-right:1px solid;border-left:1px solid;border-bottom:1px solid"><center>
																				<font size="2">${att.getPaperGrade() }</font>
																			</center></td>
																	</tr>
																</c:forEach>
															</s:if>

														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table></td>
							</tr>

						</tbody>
					</table></td>
			</tr>
		</tbody>

	</table>

	<table id="tblMsg2" width="750" cellspacing="0" cellpadding="0"
		border="0" align="center">
		<tbody>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>
					<table class="Font12" width="100%" border="0" align="center">
						<tbody>
							<tr valign="top">
								<td nowrap="nowrap"><font color="#FF0000"><strong>&nbsp;</strong></font></td>
								<td>&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td class="hengxian"></td>
				<!--<td > <div class="hengxian"></div>-->
				<!--<div class="hengxian"></div></td>-->
				<!--<hr width="90%"  height="1">-->
				<!--<hr width="90%" height="1">-->
				<!--<td>═════════════════════════════════════════════════════════════════════</td>-->
			</tr>
			<table class="Font12" width="750" border="0" align="center">
				<tr>
					<td width="5%">注：</td>
					<td><font size="2">1、不及格成绩请用红笔登记，无成绩者应在“备注”栏中注明原因；成绩填写不能使用复写纸;</font></td>
				</tr>
				<tr>
					<td></td>
					<td><font size="2">2、成绩如有涂改，或无任课教师签字，则此单无效;</font></td>
				</tr>
				<tr>
					<td></td>
					<td><font size="2">3、此单由任课教师填写，一式两份，考试后四天内分别送教务科和学生所在院（系、部）办公室。</font></td>
				</tr>

			</table>

			<!--注：<p class="text-left"> 1、不及格成绩请用红笔登记，无成绩者应在“备注”栏中注明原因；成绩填写不能使用复写纸；-->
			<!--<br>2、成绩如有涂改，或无任课教师签字，则此单无效；-->
			<!--<br>3、此单由任课教师填写，一式两份，考试后四天内分别送教务科和学生所在院（系、部）办公室。</p>-->


			<tr>
				<td>
					<table width="750" border="1" align="center" cellpadding="0"
						cellspacing="0">

						<tr>
							<td nowrap="nowrap"><font size="2">成绩统计</font></td>
							<td nowrap="nowrap"><font size="2">90～100(优)</font></td>
							<td nowrap="nowrap"><font size="2">80～89(良)</font></td>
							<td nowrap="nowrap"><font size="2">70～79(中)</font></td>
							<td nowrap="nowrap"><font size="2">60～69(及格)</font></td>
							<td nowrap="nowrap"><font size="2">小于60(不及格)</font></td>
							<td nowrap="nowrap"><font size="2">平时成绩比例</font></td>
							<td nowrap="nowrap"><font size="2">卷面成绩比例</font></td>
							<td nowrap="nowrap"><font size="2">平均成绩</font></td>
						</tr>
						<tr>
							<td nowrap="nowrap"><font size="2">人数</font></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap" rowspan="2"><center><font size="2"></font></center></td>
							<td nowrap="nowrap" rowspan="2"><center><font size="2"></font></center></td>
							<td nowrap="nowrap" rowspan="2"><center><font size="2"></font></center></td>
						</tr>
						<!--!!!!请看这里!!!!td中的空格不能去除，ie中td无内容就不显示下框线-->
						<tr>
							<td nowrap="nowrap"><font size="2">百分数</font></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<td nowrap="nowrap"><center><font size="2"></font></center></td>
							<!--<td nowrap="nowrap">&nbsp;</td>-->

						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td>
					<table width="750" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>任课教师签字：</td>
							<td>日期：</td>
						</tr>
					</table>
				</td>

				<!--endprint1-->

				<table width="40%" border="0" align="center" valign="middle"
					cellpadding="0" cellspacing="0">
					<tr>
						<td><br></td>
					</tr>
					<tr>

						<td><a href="index.jsp" style='text-decoration:none;'>
								<button type="button" class="btn btn-primary">返回查询</button>
						</a></td>
						<td>
							<button type="button" class="btn btn-danger" onclick="preview(1)">打印成绩</button>
							<!--<input style="font-size: medium;color: #FF6C60" type=button title='打印1' onclick=preview(1) value=打印成绩>-->
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>
				<!--<TD width="100%" align=left><a href="index.jsp" style='text-decoration:none;'><button style="color:#3f5765;font-size:medium">返回查询</button></a></TD>-->
				<!--<TD width="100%" align=left><input style="font-size: medium;color: #3f5765" type=button  title='打印1' onclick=preview(1)-->
				<!--value=打印成绩></TD>-->
			</tr>
		</tbody>
	</table>
</body>
</html>