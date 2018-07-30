<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <!-- END META -->
    <title>山东科技大学学生教务信息管理系统</title>

    <!-- BEGIN STYLESHEET -->
    <link rel="stylesheet" href="css/main.css">
    <link href="css/bootstrap.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
    <link href="css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON STYLESHEET -->
    <link href="assets/jquery-ui/jquery-ui-1.10.1.custom.min.css" rel="stylesheet"><!-- JQUERY STYLESHEET -->
    <link href="css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
    <link href="css/style-responsive.css" rel="stylesheet">
	<script type="text/javascript">
	   
	   function active(){
		   $("#index").attr("class","active");
	   }
	
	</script>
	
  </head>
  
  <body onload="active()">
    
    <section id="container" class="">
    <!--header-->
     <%@ include file="publicpage/head.jsp" %>
    <!---->
        
      <!-- aside -->
      <%@ include file="publicpage/leftaside.jsp" %>
      <!---->
       <section id="main-content">
            <!-- START WRAPPER -->
			<section class="wrapper">
            <!-- BEGIN ROW  -->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <i class="fa fa-hand-o-down">
                            </i>
                            <span class="label label-success" style="font-size: medium">
                 必修课教学计划文件下载
                  </span>
                        </header>

                        <div class="form-group has-success" align="center">
                                <table border="0">

                                    <tr>
                                        <td><br></td>
                                    </tr>
                                    <div id="f3" align="center" style="float-left:100px;margin-left: 100px">
                                        <tr >
                                            <th width="20%"  align="center" style="font-size: medium">
                                                   学年学期
                                            </th>
                                            <th width="20%" align="center" style="font-size: medium">文件名</th>
                                            <th width="20%" align="center">操作功能

                                        </th>
                                        </tr>
                                        <tr>
                                        <td><br></td>
                                        </tr>
                                        <tr>
                                        	<td  width="20%"  style="font-size: medium">2016-2017学年第1学期</td>
                                        	<td width="20%"  style="font-size: medium"><a href="courseplandownload/2016-2017-1.xls">2016-2017-1.xls</a></td>
                                        	<td  width="20%" style="font-size: medium"><a href="Manager_downloadCoursePlan?years=2016-2017/1" class="btn btn-success" style="font-size: medium" id="fileBtn" >重新生成文件</a></td>
                                        </tr>
                                        <tr>
                                        <td><br></td>
                                        </tr>
                                        <tr>
                                        	<td  width="20%"  style="font-size: medium">2016-2017学年第2学期</td>
                                        	<td width="20%"  style="font-size: medium"><a href="courseplandownload/2016-2017-2.xls">2016-2017-2.xls</a></td>
                                        	<td  width="20%" style="font-size: medium"><a href="Manager_downloadCoursePlan?years=2016-2017/2" class="btn btn-success" style="font-size: medium" id="fileBtn" >重新生成文件</a></td>
                                        </tr>
                                        <tr>
                                        <td><br></td>
                                        </tr>
                                        <tr>
                                        	<td  width="20%"  style="font-size: medium">2017-2018学年第1学期</td>
                                        	<td width="20%"  style="font-size: medium"><a href="courseplandownload/2017-2018-1.xls">2017-2018-1.xls</a></td>
                                        	<td  width="20%" style="font-size: medium"><a href="Manager_downloadCoursePlan?years=2017-2018/1" class="btn btn-success" style="font-size: medium" id="fileBtn" >重新生成文件</a></td>
                                        </tr>
                                        <tr>
                                        <td><br></td>
                                        </tr>
                                        <tr>
                                        	<td  width="20%"  style="font-size: medium">2017-2018学年第2学期</td>
                                        	<td width="20%"  style="font-size: medium"><a href="courseplandownload/2017-2018-2.xls">2017-2018-2.xls</a></td>
                                        	<td  width="20%" style="font-size: medium"><a href="Manager_downloadCoursePlan?years=2017-2018/2" class="btn btn-success" style="font-size: medium" id="fileBtn" >重新生成文件</a></td>
                                        </tr>
                                        <tr>
                                        <td><br></td>
                                        </tr>
                                        <tr>
                                        	<td  width="20%"  style="font-size: medium">2018-2019学年第1学期</td>
                                        	<td width="20%"  style="font-size: medium"><a href="courseplandownload/2018-2019-1.xls">2018-2019-1.xls</a></td>
                                        	<td  width="20%" style="font-size: medium"><a href="Manager_downloadCoursePlan?years=2018-2019/1" class="btn btn-success" style="font-size: medium" id="fileBtn" >重新生成文件</a></td>
                                        </tr>
                                       </div>
                                </table>
                        </div>
                        
                        
                    </section>
                </div>
            </div>
            <!-- END ROW  -->

        </section>
		 
	<!-- footer -->
     <%@ include file="publicpage/footer.jsp" %>
     <!--  -->
     
    </section>
    <!-- END SECTION -->
    <!-- BEGIN JS -->
    <script src="js/jquery.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/message_zn.js"></script>
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
	<script type="text/javascript">
		$("#fileBtn").click(
				function() {
					$.ajax({
						type : "post",
						url : "Manager_fileDownLoad.action",
						data : "page=filedownload_manager",
						async : false,
						success : function(result) {
							eval("var data=" + result);
							if (data.descript == "success") {
								/* window.location.href = "filedownload_manager.jsp"; */
								window.location.href = "Manager_initFile?page=filedownload_manager";
							} 
						}
					});
					
				}
		);
	</script>

    <!-- END JS -->
 </section>

  </body>
</html>
