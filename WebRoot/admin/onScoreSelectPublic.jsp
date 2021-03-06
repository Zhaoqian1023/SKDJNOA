<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Victor Rock">
    <title>最终成绩单打印选择</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.min.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
	<link href="css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON CSS -->
	<link href="css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
	<link href="css/style-responsive.css" rel="stylesheet"><!-- THEME RESPONSIVE CSS -->
	<link href="assets/morris.js-0.4.3/morris.css" rel="stylesheet"><!-- MORRIS CHART CSS -->
    <link href="css/clndr.css" rel="stylesheet">
    <script src="js/html5shiv.js">
	</script>
	<script src="js/respond.min.js">
	</script>
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
          
			<!-- START ROW -->
                <section class="panel">
                <header class="panel-heading">
                 <i class="fa fa-hand-o-down"> </i> <span
							class="label label-primary" style="font-size:medium">
							请选择需要打印成绩的班级及课程 </span>
                </header>
                    <br>
                    &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp; 


                    <br><br>
                    &nbsp;     &nbsp; &nbsp; &nbsp; &nbsp;    
                    
                   <div id='course'>
                   <table align="center">
                   	<tr>
                   		
                   		<th width="40%"  style="text-align:center;font-size: 25px">课程名</th>
                   		<th width="40%"  style="text-align:center;font-size: 25px">班级</th>
                   		<th width="20%"  style="text-align:center;font-size: 25px">打印方式</th>
                   	</tr>
                   	<tr><td><br></td></tr>
                   	<tr><td><br></td></tr>
                   	<c:forEach items="${VOList}" var="att">
                       <tr>
                        <td width="40%" align="center" style="font-size: 20px">${att.getCourseName() }</td>
                    	<td width="40%" align="center" style="font-size: 20px">${att.getClassName() }</td>
                    	<td width="20%" align="center" >
	                    	<a href="Source_query?page=coursegradefinal&year=2017-2018/2&courseId=${att.getCourseId() }&classId=${att.getClassId()}"><input type="submit" value='最终成绩单打印' ></a>&nbsp;&nbsp;&nbsp;                    	
						</td>
                        </tr>
                        <tr><td><br></td></tr>
                    </c:forEach>
                   	
                   </table>
                    
                   
                   </div>
                   
                   
                   
             <!-- END ROW -->
			</section>
			<!-- START WRAPPER -->
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


    <!-- END JS -->
 </section>

  </body>
</html>
