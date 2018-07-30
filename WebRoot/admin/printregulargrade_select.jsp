<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>山东科技大学学生课程平时成绩</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
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
<!--<style>-->
<!--.hengxian {-->
<!--width: 100%;-->
<!--height: 0.5px;-->
<!--border-top: 0.5px solid #000;-->
<!--}-->
<!--</style>-->
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
			                	<td nowrap="nowrap"> <font color="#FF0000"><strong>&nbsp;&nbsp;&nbsp;&nbsp;</strong></font></td>
			                </tr>
							<tr valign="top">
								<td nowrap="nowrap"><font color="#FF0000"><strong>声&nbsp;&nbsp;&nbsp;&nbsp;明：</strong></font></td>
								<td><font color="#FF0000">本网站提供的成绩信息仅供您参考，所有信息以记录在<strong>教务科公布数据为准</strong>。
								</font></td>
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
					size="5" face="黑体">山东科技大学学生课程平时成绩</font><br>
				<br></td>
			</tr>
			<tr>
				<td>
					<table class="Font11PtX120" width="100%" cellspacing="0"
						cellpadding="0" border="0" align="center">
						<tbody>
							<tr valign="middle" align="left">
								 <td height="18" width="40%" nowrap="nowrap" align="left">班级：${list.get(0).getClassName() } </td>
				                <td height="18" nowrap="nowrap" align="left" style="width: 200px">班号：${list.get(0).getClassId() } </td>
				                <td height="18" width="40%" nowrap="nowrap" align="left">学年学期：${list.get(0).getYears() }</td>
							</tr>
							<tr valign="middle" align="left">
								<td height="18" nowrap="nowrap" align="left" style="width: 410px">课程名称：${list.get(0).getCourseName() }</td>
				                <td height="18" nowrap="nowrap" align="left">学分：${list.get(0).getCredits() }</td>
				                <td height="18" nowrap="nowrap" align="left">课程类别：${list.get(0).getCategory() } </td>
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
								<td width="100%">
									<table class="LUpLines" width="100%" cellspacing="0"
										cellpadding="0" border="1" align="left">
										<tbody>
											<tr class="Font11PtX120" valign="middle" align="center">
												<td height="24" class="RULine" width="3.5%" nowrap="nowrap"><font size="2">序号</font></td>
												<td height="24" class="RULine" width="17.5%" nowrap="nowrap"><font size="2">学号</font></td>
												<td height="24" class="RULine" width="14%" nowrap="nowrap"><font size="2">姓名</font></td>
												<td height="24" class="RULine" width="52%" nowrap="nowrap" colspan="5"
													valign="middle" align="center"><font size="2">平时成绩</font></td>

											</tr>
											<c:forEach items="${list}" var="att" varStatus="varstatus">
											<tr>
												<td height="18" noWrap style="text-align:center"><font size="3">${varstatus.count }</font></td>
												<td height="18" noWrap style="text-align:center"><font size="3">${att.getSid() }</font></td>
												<td height="18" noWrap style="text-align:center"><font size="3">${att.getSname() }</font></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>
											</c:forEach>
											
										</tbody>
									</table>
								</td>


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
				<td><br></td>
			</tr>

			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td>
					<table width="80%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>任课教师签字：</td>
							<td>日期：</td>
						</tr>
					</table>
				</td>


				<!--endprint1-->
				<table width="60%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td><br></td>
					</tr>
					<tr>
						<td><a href="queryinfo_select.jsp" style='text-decoration:none;'>
								<center>
									<button type="button" class="btn btn-primary">返回查询</button>
								</center>
						</a></td>
						<td>
							<center>
								<button type="button" class="btn btn-danger"
									onclick="preview(1)">打印成绩</button>
							</center> <!--<input style="font-size: medium;color: #FF6C60" type=button title='打印1' onclick=preview(1) value=打印成绩>-->
						</td>
					</tr>
<tr>
						<td><br><br><br><br><br></td>
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