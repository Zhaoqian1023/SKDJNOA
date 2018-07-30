<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
    <head>
        <meta charset="UTF-8">
        <title>山东科技大学成绩查询界面</title>
        <meta name="description" content="Demo Theme">
        <meta name="author" content="BusinessMobile">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Style CSS -->  
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="css/new-style.css">
        <script src="js/jquery.js"></script>
        <script type="text/javascript">
	
		function URLencode(str){
			return escape(str).replace('+', '%2B');
		}
	
	</script>
        <script type="text/javascript">
        function checkAction(n){
    		if(n == 0){
    			document.formName.action="Student_getScore?page=reportcard";
    			document.formName.submit();
    		}
    	}
        function showMessage(n){
        	if(n ==0){
	        	$("#errorInfo").html("信息输入有误！");
        	}
        	if(n == 1){
        		$("#errorInfo").html("系统异常，请稍后！");
        		
        	}
        	if(n == 3){
        		$("#errorInfo").html("输入信息为空，请重新输入！");
        	}
        	setTimeout("$('#errorInfo').html('')", 3000 );
        	$("#tijiao").html("确认登录");
        }
        function temp() {
			var v1=$("#bsm_section_7_name").val();
			var v2=$("#bsm_section_7_sid").val();
			var v3=$("#bsm_section_7_password").val();
			var temp = URLencode(v3);
			var loginInfo = "sid=" + v2 + "&sname=" + v1 + "&stuPassWord=" + temp;
			if (v1 == "" || v2 == ""|| temp == "") {
				showMessage(3);
			} else {
				$.ajax({
					type : "post",
					url : "Student_login.action",
					data : loginInfo,
					async : false,
					success : function(result) {
						
						eval("var data=" + result);
						if (data.name == "login"
								&& data.descript == "success") {
							$("#tijiao").html("登录成功");
							checkAction(0);
						} else {
							showMessage(0);
						}
					},
					error : function() {
						showMessage(1);
					},
					beforeSend : function(XMLHttpRequest) {
						$("#tijiao").html("登录中...");
					},
					complete : function(XMLHttpRequest, textStatus) {
					}
				});
			}
		}
	</script>
    </head>

    <body class="bsm_page_contact_class bsm_page_static_class" style="max-height: 100%">
        
        <!-- BEGIN HEADER -->
        <header>
            <div id="bsm_navigation_open_mobile_content_nav"></div>
            <div id="bsm_navigation_open_mobile_content">
                <span id="bsm_navigation_open_mobile">
                    <img src="img/sk.jpg" style="height: 33px;width: 169px">
                </span>
                <span id="bsm_navigation_close_mobile">
                    <i class="fa fa-times" aria-hidden="true"></i>
                </span>
            </div>
            <div class="container-fluid bsm_top_bar">
                <div class="row">
                    <div class="container">
                        <div class="col-md-6 col-sm-6 bsm_align_left" >
                            <p class="bsm_color_white bsm_museo_font bsm_font_size_14 bsm_767_display_none"></p>

                        </div>
                        <div id="bsm_shop_data" class="col-md-6 col-sm-6  bsm_align_right" style="margin-top: -5px;margin-left: -100px">
                            <a href="../home.jsp" class="bsm_color_white bsm_museo_font bsm_font_size_14 bsm_991_font_size_12 bsm_767_js_move_to_cart">
                                <!--<svg height="17px"><path fill-rule="evenodd" d="M15.164,8.969 L1.977,8.937 C0.941,8.937 1.008,7.906 1.008,7.906 C1.008,7.016 1.992,7.000 1.992,7.000 L3.023,7.000 C3.023,7.000 2.816,8.000 3.977,8.000 L5.997,8.000 C7.091,7.953 7.039,7.000 7.039,7.000 L9.914,7.000 C9.914,7.000 9.868,8.000 11.070,8.000 L12.952,8.000 C14.015,8.000 14.039,7.015 14.039,7.015 L15.195,7.015 C15.727,7.015 15.977,7.969 15.977,7.969 C15.977,8.802 15.164,8.969 15.164,8.969 ZM12.476,7.000 L11.226,7.000 C11.138,6.985 10.711,6.823 10.633,6.500 L8.695,1.469 C8.695,1.192 8.732,0.969 9.195,0.969 L10.695,0.969 C10.695,0.969 11.195,1.192 11.195,1.469 L12.977,6.500 C12.977,6.776 12.971,7.000 12.476,7.000 ZM6.320,6.500 C6.242,6.823 5.909,6.985 5.820,7.000 L4.508,7.000 C4.013,7.000 4.008,6.776 4.008,6.500 L5.664,1.469 C5.914,1.130 6.164,0.969 6.164,0.969 L7.539,0.969 C8.128,0.969 8.039,1.192 8.039,1.469 L6.320,6.500 ZM13.966,15.870 C13.825,16.433 12.997,16.964 12.997,16.964 L4.029,16.979 C3.622,16.979 3.013,15.901 3.013,15.901 L2.017,10.004 L15.028,10.022 L13.966,15.870 Z"></svg>-->
                                <span>
                                    <img src="img/skcom.png">
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- END HEADER -->
        
        <!-- BEGIN CONTACT -->
        <div style="position: static">
        <div id="bsm_section_7" class="container-fluid" >
            <div class="row" style="height: 80%">
                <div class="container">
                        <div class="row bsm_767_padding_15 bsm_767_margin_top_50" style="text-align: center">
                            <h1 class="bsm_color_red bsm_uppercase bsm_amatic_font bsm_font_size_36 bsm_section_7_title bsm_1199_font_size_30" style="color: #23527c;font-family: 'KaiTi'">登录</h1>
                            <div class="work-progress">
                                <center>
                                <form name="formName" action="" method="post">
                                    <div class="bsm_section_7_form_content" style="text-align: center">
                                        <input id="bsm_section_7_name" class="bsm_section_7_input bsm_font_size_14" type="text" name="bsm_section_7_name" placeholder="姓名">
                                        <label for="bsm_section_7_name">
                                            <img src="img/bsm_border_input.png" alt="">
                                        </label>
                                    </div>
                                    <div class="bsm_section_7_form_content" style="text-align: center">
                                        <input id="bsm_section_7_sid" class="bsm_section_7_input bsm_font_size_14" type="text" name="bsm_section_7_sid" placeholder="学号">
                                        <label for="bsm_section_7_sid">
                                            <img src="img/bsm_border_input.png" alt="">
                                        </label>
                                    </div>
                                    <div class="bsm_section_7_form_content" style="text-align: center">
                                        <input id="bsm_section_7_password" class="bsm_section_7_input bsm_font_size_14" type="password" name="bsm_section_7_password" placeholder="密码">
                                        <label for="bsm_section_7_password">
                                            <img src="img/bsm_border_input.png" alt="" >
                                        </label>
                                    </div>
                                    <span id="errorInfo"  style="color: red;font-family: 'KaiTi'"></span>
                                    <br>
                                    <a href ="changepwd.jsp" style="font-family: 'kaiti';font-size: large;" >修改密码</a>
                                    <button type="button" class="bsm_effect_slide_left bsm_section_7_submit bsm_font_size_14 bsm_uppercase" type="submit" name="bsm_section_7_submit_button" onclick="temp()" style="background-color: #23527c">
                                        <span id="tijiao" style="color: white;font-family: 'kaiti'">确认登录</span>
                                    </button>
                                </form>
                                </center>
                            </div>
                        </div>

                </div>
            </div>
        </div>
        </div>
        <!-- END CONTACT -->
        
        <!-- BEGIN FOOTER -->
        <footer class=".site-footer" id="site-footer">
            <div class="container-fluid">
                <div class="row" style="position: fixed ;width: 100%;bottom: -10px;width:100%">
                    <div class="bsm_bottom_bar" style="background-color: #005da3">
                            <div style="text-align: center">
                            <div id="bsm_footer_all_center" class="bsm_color_white bsm_font_size_18 ">
                                <p>Copyright &copy; 2016-2018 山东科技大学济南校区教科部版权所有</p>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- END FOOTER -->
        
        <div id="bsm_mobile_border_footer_waves"></div>
        
        <script src="js/bootstrap.js"></script>
        <script src="js/slider.js"></script>
        <script src="js/staller.js"></script>
        <script src="js/range_price.js"></script>
        <script src="js/custom.js"></script>
        
    </body>
</html>