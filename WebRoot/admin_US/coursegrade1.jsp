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
	  <title>山东科技大学济南校区学生课程成绩单查询</title>
	  
	  <!-- BEGIN STYLESHEET -->
      
      <link href="css/bootstrap.min.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
    <link href="css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON STYLESHEET -->
      <link href="assets/jquery-ui/jquery-ui-1.10.1.custom.min.css" rel="stylesheet"><!-- JQUERY STYLESHEET -->
      <link href="css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
	<link href="css/style-responsive.css" rel="stylesheet"><!-- THEME BASIC RESPONSIVE  CSS -->
	  <script type="text/javascript">
	  function active(){
		   $("#coursegrade").attr("class","active");
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
                  Please select the form to be printed
                  </span>
                    </header>
                    <div class="panel-body">
           <form action="Print_printFunction?page=coursegrade&status=在校" method="post">
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
			<button type="submit" class="btn btn-primary">Print preview</button>
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
	 <script type="text/javascript">
	  function getKCM(){
		    var dept=document.getElementById("s1").value;
		    var grade=document.getElementById("s2").value;
		    var professional=document.getElementById("s3").value;
		    var msg = "professional=" + professional +"&years=2017-2018/1" + "&category=非公选" ;
		   /*  sendAjax("post","Course_byProfessional.action",msg,true,function(req){
		        
		        var result = req.responseText;
		        eval("var info="+result);//函数转化形式
		        var x=document.getElementById("s4");
		        for(i=0;i<x.options.length;i++){
		          x.removeChild(x.options[i]);
		        }
		        for(i=0;i<info.length;i++){
		          var option=document.createElement("option");
		            option.text=info[i].value;
		            x.add(option,x.options[i]);
		        }
		        }  
		   )  ;*/
		    
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
      <script src="js/jquery.js" ></script><!-- BASIC JS LIABRARY -->
    <script src="js/bootstrap.min.js" ></script><!-- BOOTSTRAP JS  -->
    <script src="js/jquery.dcjqaccordion.2.7.js"></script><!-- ACCORDING JS -->
    <script src="js/jquery.scrollTo.min.js" ></script><!-- SCROLLTO JS  -->
    <script src="js/jquery.nicescroll.js" > </script><!-- NICESCROLL JS  -->
      <script src="assets/jquery-ui/jquery-ui-1.10.1.custom.min.js" ></script><!-- BASIC JS LIABRARY -->
      <script src="js/jquery.ui.touch-punch.min.js" ></script><!-- TOUCH PUNCH JS -->
       <script src="js/respond.min.js" ></script><!-- RESPOND JS  -->
      <script src="js/common-scripts.js" ></script><!-- BASIC COMMON JS  -->
      <script src="js/sliders.js" ></script><!-- SLIDER JS  -->
	  <!-- END JS -->
   </section>
   </body>
</html>
