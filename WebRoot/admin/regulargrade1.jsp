<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
   <head>
   <!-- BEGIN META -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="">
      <meta name="author" content="Olive Enterprise">
     <!-- END META -->
    
    <!-- BEGIN SHORTCUT ICON -->
      <!--<link rel="shortcut icon" href="img/favicon.ico">-->
	  <!-- END SHORTCUT ICON -->
	  <title>山东科技大学济南校区学生平时成绩单查询</title>
	  
	  <!-- BEGIN STYLESHEET -->
      
      <link href="css/bootstrap.min.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
    <link href="css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON STYLESHEET -->
      <link href="assets/jquery-ui/jquery-ui-1.10.1.custom.min.css" rel="stylesheet"><!-- JQUERY STYLESHEET -->
      <link href="css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
	<link href="css/style-responsive.css" rel="stylesheet"><!-- THEME BASIC RESPONSIVE  CSS -->
	 <script type="text/javascript">
	 function active(){
		   $("#regulargrade").attr("class","active");
	   }
	 </script>
  <script src="js/geo.js" ></script>
   </head>

  <body onload="active(),setup()">
       <section id="container" class="">
      <!-- BEGIN HEADER -->
          <%@ include file="publicpage/head.jsp" %>
		<!-- END HEADER -->
		
		<!-- BEGIN SIDEBAR -->
            <%@ include file="publicpage/leftaside.jsp" %>
          <!-- END SIDEBAR -->
          
       <!-- START MAIN CONTENT -->
      <section id="main-content">
            <!-- START WRAPPER -->
      <section class="wrapper">

      <!-- START ROW -->
                <section class="panel">
                    <header class="panel-heading">
                        <i class="fa fa-hand-o-down">
                        </i>
                  <span class="label label-primary"  style="font-size:medium">
                  请选择要打印的表格
                  </span>
                    </header>
                    <div class="panel-body">
         <form action="Print_printFunction?page=regulargrade&status=在校" method="post">
			<select name="zy" id="s1" style="width:20%; height:30px;">
				<option></option>
			</select> <select name="nj" id="s2" style="width:20%;height:30px;">
				<option></option>
			</select> <select name="bjm" id="s3" onmouseout="getKCM()"
				style="width:20%;height:30px;">
				<option></option>
			</select> <select name="kcm" id="s4" style="width:20%;height:30px;">
				<option></option>
			</select> <br> <br>
			<button type="submit" class="btn btn-primary">打印预览</button>
		</form>
		
                </section>
                <br><br><br>
                    </div>





      <!-- START WRAPPER -->
     </section>
     <!-- END MAIN CONTENT -->

		 <!-- START FOOTER -->
            <%@ include file="publicpage/footer.jsp" %>
		 <!-- END FOOTER -->
      </section>
	  <!-- START JS -->
       <script src="js/jquery-1.8.3.min.js" ></script><!-- BASIC JQUERY 1.8.3 LIB. JS -->
    <script src="js/bootstrap.min.js" ></script><!-- BOOTSTRAP JS -->
    <script src="js/jquery.dcjqaccordion.2.7.js"></script><!-- ACCORDIN JS -->
    <script src="js/jquery.scrollTo.min.js" ></script><!-- SCROLLTO JS -->
    <script src="js/jquery.nicescroll.js" ></script><!-- NICESCROLL JS -->
    <script src="js/respond.min.js" ></script><!-- RESPOND JS -->
    <script src="js/jquery.sparkline.js"></script><!-- SPARKLINE JS -->
    <script src="js/sparkline-chart.js"></script><!-- SPARKLINE CHART JS -->
    <script src="js/common-scripts.js"></script><!-- BASIC COMMON JS -->
    <script src="js/count.js"></script><!-- COUNT JS -->
    <!--Morris-->
    <script src="assets/morris.js-0.4.3/morris.min.js" ></script><!-- MORRIS JS -->
    <script src="assets/morris.js-0.4.3/raphael-min.js" ></script><!-- MORRIS  JS -->
    <script src="js/chart.js" ></script><!-- CHART JS -->
    <!--Calendar-->
    <script src="js/calendar/clndr.js"></script><!-- CALENDER JS -->
    <script src="js/calendar/evnt.calendar.init.js"></script><!-- CALENDER EVENT JS -->
    <script src="js/calendar/moment-2.2.1.js"></script><!-- CALENDER MOMENT JS -->
    <!--<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>&lt;!&ndash; UNDERSCORE JS &ndash;&gt;-->
    <script src="assets/jquery-knob/js/jquery.knob.js" ></script><!-- JQUERY KNOB JS -->
    <script >
      //knob
      $(".knob").knob();
      
    </script>
    <script type="text/javascript">
	  function getKCM(){
		    var dept=document.getElementById("s1").value;
		    var grade=document.getElementById("s2").value;
		    var professional=document.getElementById("s3").value;
		    var msg = "professional=" + professional +"&years=2017-2018/1" + "&category=非公选" ;
		    $.ajax({
				type:"post",
				url:"Course_byProfessional.action",
				data:msg,
				dataType:"text",
				async: false,
				success: function(result){
					 /* console.log(result); */
					 /* JSON.stringify(result); */
					 //JSON.parse(result);
					    eval("var info="+result);
					 	var x=document.getElementById("s4");
					    for(i=0;i<x.options.length;i++){
					    	x.removeChild(x.options[i]);
					    }
					    for(i=0;i<info.length;i++){
				        var option=document.createElement("option");
				        option.text=info[i].value;
					        x.add(option,x.options[i]);
					    }
				},
				
				
			});
	  
	  }
	  
	  
	  </script>
   
	  <!-- END JS -->
   </section>
   </body>
</html>
