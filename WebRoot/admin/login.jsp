<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">

<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>山东科技大学教务管理系统登录页面</TITLE>
<SCRIPT src="js/jquery.js" type="text/javascript"></SCRIPT>
<STYLE>
body {
    background: #ebebeb;
    font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
        "\9ED1\4F53", Arial, sans-serif;
    color: #222;
    font-size: 12px;
}

* {
    padding: 0px;
    margin: 0px;
}

.top_div {
    background: #3f5765;
    background-image: url('img/bg02.png');
    background-repeat: no-repeat;
    /*background-position: 70px 50px;*/
    width: 100%;
    height: 400px;
}

.ipt {
    border: 1px solid #d3d3d3;
    padding: 10px 10px;
    width: 290px;
    border-radius: 4px;
    padding-left: 35px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
        ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
        .15s;
    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.ipt:focus {
    border-color: #66afe9;
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
        rgba(102, 175, 233, .6);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
        rgba(102, 175, 233, .6)
}

.u_logo {
    background: url("images/username.png") no-repeat;
    padding: 10px 10px;
    position: absolute;
    top: 30px;
    left: 40px;
}

.p_logo {
    background: url("images/password.png") no-repeat;
    padding: 10px 10px;
    position: absolute;
    top: 12px;
    left: 40px;
}

a {
    text-decoration: none;
}

.tou {
    background: url("images/tou.png") no-repeat;
    width: 97px;
    height: 92px;
    position: absolute;
    top: -87px;
    left: 140px;
}

.left_hand {
    background: url("images/left_hand.png") no-repeat;
    width: 32px;
    height: 37px;
    position: absolute;
    top: -38px;
    left: 150px;
}

.right_hand {
    background: url("images/right_hand.png") no-repeat;
    width: 32px;
    height: 37px;
    position: absolute;
    top: -38px;
    right: -64px;
}

.initial_left_hand {
    background: url("images/hand.png") no-repeat;
    width: 30px;
    height: 20px;
    position: absolute;
    top: -12px;
    left: 100px;
}

.initial_right_hand {
    background: url("images/hand.png") no-repeat;
    width: 30px;
    height: 20px;
    position: absolute;
    top: -12px;
    right: -112px;
}

.left_handing {
    background: url("images/left-handing.png") no-repeat;
    width: 30px;
    height: 20px;
    position: absolute;
    top: -24px;
    left: 139px;
}

.right_handinging {
    background: url("images/right_handing.png") no-repeat;
    width: 30px;
    height: 20px;
    position: absolute;
    top: -21px;
    left: 210px;
}
</STYLE>

<SCRIPT type="text/javascript">
    $(function() {
        //得到焦点
        $("#password").focus(function() {
            $("#left_hand").animate({
                left : "150",
                top : " -38"
            }, {
                step : function() {
                    if (parseInt($("#left_hand").css("left")) > 140) {
                        $("#left_hand").attr("class", "left_hand");
                    }
                }
            }, 2000);
            $("#right_hand").animate({
                right : "-64",
                top : "-38px"
            }, {
                step : function() {
                    if (parseInt($("#right_hand").css("right")) > -70) {
                        $("#right_hand").attr("class", "right_hand");
                    }
                }
            }, 2000);
        });
        //失去焦点
        $("#password").blur(function() {
            $("#left_hand").attr("class", "initial_left_hand");
            $("#left_hand").attr("style", "left:100px;top:-12px;");
            $("#right_hand").attr("class", "initial_right_hand");
            $("#right_hand").attr("style", "right:-112px;top:-12px");
        });
    });
    function showMessage(n){
    	if(n ==0){
        	$("#errorMessage").html("信息输入有误！");
    	}
    	if(n == 1){
    		$("#errorMessage").html("系统异常，请稍后！");
    	}
    	if(n == 3){
    		$("#errorMessage").html("输入信息为空！");
    	}
    	if(n == 4){
    		$("#errorMessage").html("信息包含非法字符！");
    	}
    	setTimeout("$('#errorMessage').html('')", 3000 );
    	$("#loginBtn").attr("value", "登录");
    }
    

</SCRIPT>


<META name="GENERATOR" content="MSHTML 11.00.9600.17496">
</HEAD>
<BODY >
    <DIV class="top_div"></DIV>
    
    <DIV
        style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 260px; text-align: center;">
        <DIV style="width: 165px; height: 96px; position: absolute;">
            <DIV class="tou"></DIV>
            <DIV class="initial_left_hand" id="left_hand"></DIV>
            <DIV class="initial_right_hand" id="right_hand"></DIV>
        </DIV>
<p style="padding: 25px 0px 10px; position: relative;" ><h2>教师登录</h2></p>
        <P style="padding: 20px 0px 10px; position: relative;">
            <SPAN class="u_logo"></SPAN> <INPUT class="ipt" id="uname"
                name="uname" type="text" value=""  placeholder="请输入教师账号">
        <P style="position: relative;">
            <SPAN class="p_logo"></SPAN> <INPUT class="ipt" name="upwd"
                id="password" type="password" value=""  placeholder="请输入密码">
        </P>

        <DIV
            style="height: 44px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
            <span id="errorMessage"
                style="color: red;float: left;margin-left: 20px;margin-right: 0px"></span> 
            <span  id="tiaozhuan"
                style="display:block; float: left;margin-left: 10px;"><a href="../manager/login_manager.jsp"><strong>点此进入管理员登录页面</strong></a></span>
             
                
                <span
                style="margin-left: 50px;margin-top:-5px"> <input id="loginBtn" type="submit"
                value="登录"
                style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;">
            </span>
        </DIV>
        <span style="margin-left:-290px"><a href="../admin_US/login.jsp"><strong>Click here to become the English version</strong></a></span>



    </DIV>
	<script type="text/javascript">
	$("#loginBtn").click(
			function() {
				var v1=$("#uname").val();
				var v2=$("#password").val();
				var uid = URLencode(v1);
				$("#loginBtn").attr("value", "登录中..");
				var passWord = URLencode(v2);
				var loginInfo = "uid=" + uid + "&passWord=" + passWord;
				if (uid == "" || passWord == "") {
					showMessage(3);
				}else {
					$.ajax({
						type : "post",
						url : "Users_login.action",
						data : loginInfo,
						async : false,
						success : function(result) {
							eval("var data=" + result);
							if (data.name == "login"
									&& data.descript == "success") {
								$("#loginBtn").attr("value", "成功");
								window.location.href = "index.jsp";
							} else {
								showMessage(0);
							}
						},
						error : function() {
							showMessage(1);
						},
						beforeSend : function(XMLHttpRequest) {
							$("#loginBtn").attr("value", "登录中..");
						},
						complete : function(XMLHttpRequest, textStatus) {
						}

					});
				}
			});
	</script>
	<script type="text/javascript">
	
		function URLencode(str){
			return escape(str).replace('+', '%2B');
		}
	
	</script>
	
	
</BODY>
</HTML>
