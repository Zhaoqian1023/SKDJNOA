<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Victor Rock">
    <title>成绩录入之课程选择</title>
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
		   $("#mymodal").modal({
             show:true
         });
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
							Please select the class and course you want to enter the grade </span>
                </header>
                    <br>
                    &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp; 


                    <br><br>
                    &nbsp;     &nbsp; &nbsp; &nbsp; &nbsp;    
                    
                   <div id='course'>
                   <table align="center">
                   	<tr>
                   		
                   		<th width="40%"  style="text-align:center;font-size: 25px">Course</th>
                   		<th width="30%"  style="text-align:center;font-size: 25px">Class</th>
                   		<th width="30%"  style="text-align:center;font-size: 25px">Entry Method</th>
                   	</tr>
                   	<c:forEach items="${VOList}" var="att">
                       <tr>
                        <td width="40%" align="center" style="font-size: 20px">${att.getCourseName() }</td>
                    	<td width="30%" align="center" style="font-size: 20px">${att.getEnglishName() }</td>
                    	<td width="30%" align="center" >
	                    	<a href="Print_printFunctionasinput?page=scoreinput&status=在校&fangshi=百分制&kcdm=${att.getCourseId() }&bjdm=${att.getClassId()}"><input type="submit" value='Percentage' ></a>&nbsp;&nbsp;&nbsp;	                    	
	                    	<%-- <a href='Print_printFunctionasinput?page=scorekccinput&status=在校&fangshi=五级记分制&kcm=${att.getCourseName() }&bjm=${att.getClassName()}'><input type="submit" value='Others' ></a> --%>
						</td>
                        </tr>
                        <tr><td><br></td></tr>
                    </c:forEach>
                   </table>
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
                                                    <td >This page shows your teaching task in this semester, including course name and the classes.</td>
                                                </tr>
                                                
                                                <tr>
                                                <td><br></td>
                                                    <%-- <td ><span>二、录入成绩时，可根据对应课程班级后的录入按钮选择成绩录入方式。</span></td> --%>
                                                </tr> 
                                                <tr>
                                                    <td><span style="font-weight:bold;">Note: If this page doesn't correspond to the teaching task you take in this semester, 
                                                    please contact Academic Affairs office and provide your name, course names and the classes.</span></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
