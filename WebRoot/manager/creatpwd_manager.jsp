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
            <!-- START WRAPPER -->
			<section id="main-content">
        <!-- BEGIN WRAPPER  -->
        <section class="wrapper">
            <!-- BEGIN ROW  -->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <i class="fa fa-hand-o-down">
                            </i>
                            <span class="label label-success" style="font-size: medium">
               		   生成密码
                  </span>
                        </header>

                        <div class="form-group has-success" align="center">
                            <form action="" class="form-horizontal" role="form">
                                <table border="0">
                                    <tr>
                                        <td width="50%"> <span class="btn-info" style="font-size: 25px"  >请输入教师工号：</span></td>
                                        <td width="50%"> <input type="text" class="form-control" name="teacherId" id="teacherId" size="10"></td>

                                    </tr>
                                    <tr>
                                        <td><br></td>
                                    </tr>
                                    <div id="f3" align="center" style="float-left:100px;margin-left: 100px">
                                        <tr align="center" style="display: block">
                                            <td>
                                               <button class="btn btn-primary"
													 id="modale" type="button" >生成初始密码</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><br></td>
                                        </tr>
                                    </div>
                                </table>
                            </form>
                        </div>


                       <div class="modal" id="mymodal" style="margin-bottom: 20px">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">生成随机密码</h4>
                                    </div>
                                    <div class="modal-body" style="padding: 100px 100px 10px;">
                                        <div class="text-danger" style="font-size: medium;margin: auto">
                                            <table align="center">
                                                <tr>
                                                    <td width="50%"><span>为您生成的密码为：</span></td>
                                                    <td width="50%"><span id="newpassword"></span></td>
                                                    <td width="50%"><br></td>
                                                    <td width="50%"><br></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                   <!--  <div class="modal-footer">
                                        <button class="btn btn-success" type="button">确认</button>
                                    </div> -->
                                </div>
                            </div>
                        </div>


                    </section>
                </div>
            </div>
            <!-- END ROW  -->

        </section>
			<!-- START WRAPPER -->
		 
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

 <script>
 $(function(){
     $("#modale").click(function(){
    	 	var teacherId=$("#teacherId").val();
			var loginInfo = "teacherId=" + teacherId;
			$("#loginBtn").attr("value", "登录中..");
			if (teacherId != "") {
				$.ajax({
					type : "post",
					url : "Manager_forgetPwd.action",
					data : loginInfo,
					async : false,
					success : function(result) {
						eval("var data=" + result);
						if (data[0].key == "0") {
							$("#newpassword").html(data[0].value);
						} else {
							$("#newpassword").html("生成密码错误，请重新生成！！");
						}
					},
					error : function() {
						$("#newpassword").html("生成密码错误，请重新生成！！");
					}
					
				});
				 $("#mymodal").modal({
		             show:true
		         });
			} 

     });
 });

 </script>
    <!-- END JS -->
 </section>

  </body>
</html>
