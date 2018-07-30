<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Victor Rock">
    <title>山东科技大学济南校区教务信息系统</title>
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
	   function showTime(){
				var d = new Date();
				var year = d.getFullYear();
				var month = d.getMonth()+1;
				var day = d.getDate();
				var week = d.getDay();
				switch(week){
					case 0 : week="Sunday";break;
					case 1 : week="Monday";break;
					case 2 : week="Tuesday";break;
					case 3 : week="Wednesday";break;
					case 4 : week="Thursday";break;
					case 5 : week="Friday";break;
					case 6 : week="Saturday";break;
				}
				switch(month){
					case 1: month="January";break;
					case 2: month="February";break;
					case 3: month="March";break;
					case 4: month="April";break;
					case 5: month="May";break;
					case 6: month="June";break;
					case 7: month="July";break;
					case 8: month="August";break;
					case 9: month="September";break;
					case 10: month="October";break;
					case 11: month="November";break;
					case 12: month="December";break;
				}
				
				var mytime = document.getElementById("time");
				mytime.innerHTML = week+", "+month+"&nbsp"+day+", "+year;
				/* mytime.innerHTML = year+"年"+month+"月"+day+"日"+week; */
				setTimeout(showTime,1000);
			}
	   function active(){
		   $("#index").attr("class","active");
	   }
	
	</script>
	
  </head>
  
  <body onload="showTime(),active()">
    
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
                <section class="panel" width="100%" >
                <header class="panel-heading">
                  <i class="fa fa-smile-o">
                  </i>
                  <span class="label label-primary" style="font-size: medium">
                  Welcome to SDUST (Jinan) Academic Information System            </span>

                </header>
                    <br>
                    &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp; 


                    <br><br>
                    &nbsp;     &nbsp; &nbsp; &nbsp; &nbsp;    
                    <span class="label label-default"  style="font-size:medium">
                    Pro.${users.getUname()}
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                  </span>
                    <br><br>
                    &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp;   <span class="label label-default"  style="font-size:medium">
              Enjoy your work!！ &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

                  </span>
                    <br><br>
                    <span id="time" class="label label-default"  style="font-size:medium">当前时间日期</span>
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