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
    <title>导入新选课名单</title>

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
                 导入学生选课名单（公选）
                  </span>
                        </header>

                        <div class="form-group has-success" align="center">
                            <!-- <form  class="form-horizontal" role="form"> -->
                                <form action="electivestudentuploads.action" method="post" enctype="multipart/form-data">
                                <table border="0">

                                    <tr>
                                        <td><br></td>
                                    </tr>
                                    <div id="f3" align="center" style="float-left:100px;margin-left: 100px">
                                        <tr >
                                            <td width="20%" align="left" style="font-size: medium">
                                                   选择导入学期：
                                            </td>
                                            <td width="60%" style="font-size: medium">
                                            
											    <select name="years"  id="s1" style="width:100%; height:30px;">
													<%@ include file="publicpage/year_option.jsp" %>
												</select>
                                            </td>
                                            
                                        </tr>
                                        <tr>
                                        <td></br></br></td>
                                        </tr>
                                        <tr>
                                        	<td width="20%" align="left" style="font-size: medium">
                                                   选择导入文件（.xls）：
                                            </td>
                                            <td width="60%" style="font-size: medium">
											    <input type="file" name="uploadImage" />
                                            </td>
                                        
                                        </tr>
                                        <tr>
                                        	<td></br></br></td>
                                        </tr>
                                        <tr>
                                        <td width="20%" align="left" style="font-size: medium">导入教学计划帮助:</td>
                                        <td><a href="modelfile/学生选课信息录入模板（公选课）.xls">学生选课信息录入模板（公选课）（请按照模板格式导入文件）</a></td>
                                        </tr>
                                        <tr>
                                        	<td></br></br></td>
                                        </tr>
                                        <tr>
                                        	<td colspan="2" style="text-align: center;"><font color="red"><em>注意：请确保每次导入的文件中仅能包含1门课程的选课学生信息</em></font></td>
                                        </tr>
                                        <tr>
                                        	<td></br></br></td>
                                        </tr>
                                        <tr>
                                        	<td width="20%" align="left" style="font-size: medium">
                                                   
                                            </td>
                                            <td width="60%" style="font-size: medium">
											    <input class="btn btn-primary"	 type="submit" value="导入文件" />
                                            </td>
                                        
                                        </tr>
                                        
                                    </div>
                                </table>
                            </form>
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
