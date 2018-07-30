<%@ page language="java" import="java.util.*"
    contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>山东科技大学济南校区学生上课考勤表</title>
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
</head>
<body>
<table id="tblMsg" width="750" cellspacing="0" cellpadding="0" border="0" align="center">
    <tbody><tr>
        <td>
            <table class="Font12" width="100%" border="0" align="center">
                <tbody>
                <tr>
                	<td nowrap="nowrap"> <font color="#FF0000"><strong>&nbsp;&nbsp;&nbsp;&nbsp;</strong></font></td>
                </tr>
                <tr valign="top">   
                    <td nowrap="nowrap"> <font color="#FF0000"><strong>声&nbsp;&nbsp;&nbsp;&nbsp;明：</strong></font></td>
                    <td><font color="#FF0000">本网站提供的成绩信息仅供您参考，所有信息以记录在<strong>教务科公布数据为准</strong></font></td>
                </tr>
                </tbody>
             </table>
        </td>
    </tr>
    <tr>
        <td>
            <table class="Font12" width="100%" border="0" align="center">
                <tbody><tr valign="top">
                    <td nowrap="nowrap"><font color="#FF0000"><strong>&nbsp;</strong></font></td>
                    <td>&nbsp;</td>
                </tr>
                </tbody></table>
        </td>
    </tr>
    <tr><td><hr  width="90%" size="1"></td></tr>
    </tbody></table>
    <!--startprint1-->
<table width="750px" cellspacing="0" cellpadding="0" border="0" align="center" >
    <tbody><tr>
        <td class="Font18" width="50%" valign="middle" align="center"><font size="5" face="黑体">山东科技大学学生考勤表</font><br><br></td>
    </tr>
    <tr>
        <td> <table class="Font11PtX120" width="100%" cellspacing="0" cellpadding="0" border="0" align="center">
            <tbody><tr valign="middle" align="left">
                <td height="18" width="40%" nowrap="nowrap" align="left">Class：${list.get(0).getClassEnglish() } </td>
                <td height="18" nowrap="nowrap" align="left">Class Number：${list.get(0).getClassId() } &nbsp&nbsp</td>
                <td height="18" width="40%" nowrap="nowrap" align="left">Academic year/Semester：${list.get(0).getYears() }</td>
            </tr>
            <tr valign="middle" align="left">
                <td height="18" nowrap="nowrap" align="left" >Course：${list.get(0).getCourseName() } &nbsp&nbsp</td>
                <td height="18" nowrap="nowrap" align="left">Credit：${list.get(0).getCredits() }</td>
                <td height="18" nowrap="nowrap" align="left">Course Type：${list.get(0).getCategory() } </td>
            </tr>
            </tbody></table>
        </td>
    </tr>
    <tr>
        <td valign="top"><table width="100%" cellspacing="0" cellpadding="0" border="0">
            <tbody ><tr valign="top" align="left">
                <td width="100%"> 
                <table class="LUpLines" width="100%"
										cellspacing="0" cellpadding="0" border="1" align="center">
									
											<tr class="Font11PtX120" valign="middle" align="center">
												<td class="RULine" width="7%" nowrap rowspan="2">No</td>
												<td class="RULine" width="16%" nowrap rowspan="2">Student ID</td>
												<td class="RULine" width="7%" nowrap rowspan="2">Name</td>
												<td class="RULine" width="7%" nowrap>1th</td>
												<td class="RULine" width="7%" nowrap>2th</td>
												<td class="RULine" width="7%" nowrap>3th</td>
												<td class="RULine" width="7%" nowrap>4th</td>
												<td class="RULine" width="7%" nowrap>5th</td>
												<td class="RULine" width="7%" nowrap>6th</td>
												<td class="RULine" width="7%" nowrap>7th</td>
												<td class="RULine" width="7%" nowrap>8th</td>
												<td class="RULine" width="7%" nowrap>9th</td>
												<td class="RULine" width="7%" nowrap rowspan="2">Remarks</td>
											</tr>

											<tr class="Font8Pt" valign="top">
												<td>Date: &nbsp&nbsp&nbsp&nbsp</td>
												<td>Date: &nbsp</td>
												<td>Date: &nbsp</td>
												<td>Date: &nbsp</td>
												<td>Date: &nbsp</td>
												<td>Date: &nbsp</td>
												<td>Date: &nbsp</td>
												<td>Date: &nbsp</td>
												<td>Date:</td>
											</tr>
										
							
                      					<c:forEach items="${list}" var="att" varStatus="varstatus">
                                          <tr >
                                          		<td height="18" noWrap style="text-align:center"><font size="2">${varstatus.count }</font></td>
												<td height="18" noWrap style="text-align:center"><font size="2">${att.getSid() }</font></td>
												<td height="18" noWrap style="text-align:center"><font size="2">${att.getEnglishName() }</font></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</c:forEach>
										
            </tbody></table>
        </td>
    </tr>
    </tbody>

</table>

<table id="tblMsg2" width="750" cellspacing="0" cellpadding="0" border="0" align="center">
    <tbody><tr>
        <td>
        </td>
    </tr>
    <tr>
        <td>
            <table class="Font12" width="100%" border="0" align="center">
                <tbody><tr valign="top">
                    <td nowrap="nowrap"><font color="#FF0000"><strong>&nbsp;</strong></font></td>
                    <td>&nbsp;</td>
                </tr>
                </tbody></table>
        </td>
    </tr>


    <tr>
        <td>
            <br>
        </td>
    </tr>
    <tr>
        <td>
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        Signature of teacher：
                    </td>
                    <td>
                        Date：
                    </td>
                </tr>
            </table>
        </td>


<!--endprint1-->
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <br>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="queryinfo.jsp" style='text-decoration:none;'>
                        <center><button type="button" class="btn btn-primary" >Return</button></center>
                    </a>
                </td>
                <td>
                    <center><button type="button" class="btn btn-danger" onclick="preview(1)" >Print</button></center>
                </td>
            </tr>
            <tr>
              <td>&nbsp;&nbsp;&nbsp;&nbsp; </td>
            </tr>
            <tr>
              <td>&nbsp;&nbsp;&nbsp;&nbsp; </td>
            </tr>
            <tr>
              <td>&nbsp;&nbsp;&nbsp;&nbsp; </td>
            </tr>
        </table>
    </tr>
    </tbody></table>
</body></html>