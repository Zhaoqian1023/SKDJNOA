<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


 <html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>山东科技大学济南校区教务信息管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FREEHTML5" />

    <!-- Animate.css -->
    <link rel="stylesheet" href="<%=basePath %>admin/css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="<%=basePath %>admin/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="<%=basePath %>admin/css/bootstrap.css">
    <!-- Superfish -->
    <link rel="stylesheet" href="<%=basePath %>admin/css/superfish.css">

    <link rel="stylesheet" href="<%=basePath %>admin/css/stylefont.css">


    <!-- Modernizr JS -->
    <script src="<%=basePath %>admin/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="<%=basePath %>admin/js/respondfont.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="fh5co-wrapper">
    <div id="fh5co-page">
        <div id="fh5co-header">
            <header id="fh5co-header-section">
                <div class="container">
                    <div class="nav-header">
                        <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
                        <h1 id="fh5co-logo"><a href="<%=basePath %>home.jsp"><span>山东科技大学</span></a></h1>
                    </div>
                </div>
            </header>

        </div>


        <div class="fh5co-hero">
            <div class="fh5co-overlay"></div>
            <div class="fh5co-cover text-center" data-stellar-background-ratio="0.5" style="background-image: url(<%=basePath %>admin/images/skdheng01.jpg);">
                <div class="desc animate-box">
                    <h2>教务信息管理系统</h2>
                    <h2 style="font-size: 28px;text-transform: capitalize">Academic Information Management System</h2>
                    <span>济南校区<br> Jinan Campus</span>
                    <span style="font-size: medium"><a class="btn btn-primary" href="<%=basePath %>admin/index.jsp">开始办公/start</a></span>
                    <span style="font-size: medium"><a class="btn btn-primary" href="<%=basePath %>student/StudentLogin.jsp">学生入口/Student Login</a></span>
                </div>
            </div>
        </div>

        <div id="fh5co-services-section" class="fh5co-section-gray">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
                        <h3>Welcome</h3>
                        <p>欢迎使用山东科技大学济南校区教务信息管理系统。本系统提供六大功能模块，为教师提供优质办公资源，提高教学效率。</p>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row text-center">
                    <div class="col-md-4 col-sm-4">
                        <div class="services animate-box">
                            <span><i class="icon-browser"></i></span>
                            <h3>多级用户登录</h3>
                            <p>A master can tell you what he expects of you. A teacher, though, awakens your own expectations.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <div class="services animate-box">
                            <span><i class="icon-mobile"></i></span>
                            <h3>课程成绩录入</h3>
                            <p>Successful teachers are effective in spite of the psychological theories they suffer under</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <div class="services animate-box">
                            <span><i class="icon-tools"></i></span>
                            <h3>打印预览</h3>
                            <p>While we try to teach our children all about life, our children teach us what life is all about.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <div class="services animate-box">
                            <span><i class="icon-video"></i></span>
                            <h3>空成绩单打印</h3>
                            <p>There are three things to remember when teaching: know your stuff; know whom you are stuffing; and then stuff them elegantly</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <div class="services animate-box">
                            <span><i class="icon-search"></i></span>
                            <h3>动态统计</h3>
                            <p>The secret of teaching is to appear to have known all your life what you learned this afternoon</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <div class="services animate-box">
                            <span><i class="icon-cloud"></i></span>
                            <h3>智能提交</h3>
                            <p>Teachers are expected to reach unattainable goals with inadequate tools. The miracle is that at times they accomplish this impossible task.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div id="fh5co-content-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
                        <h3>宗旨</h3>
                        <p>惟真求新，尽职尽责，服务师生，高效办学</p>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="fh5co-testimonial text-center animate-box">
                            <figure>
                                <img src="<%=basePath %>admin/img/spaceship.gif" alt="user">
                            </figure>
                            <blockquote>
                                <p>“Histories make men wise;poems witty;the mathematics subtle;natural philosophy deep;moral grave;logic and rhetoric able to contend.”</p>
                            </blockquote>
                            <span>Francis Bacon, British philosopher.</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <footer>
            <div id="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 text-center">
                            <p class="fh5co-social-icons">
                                <a href="#"><i class="icon-twitter2"></i></a>
                                <a href="#"><i class="icon-facebook2"></i></a>
                                <a href="#"><i class="icon-instagram"></i></a>
                                <a href="#"><i class="icon-dribbble2"></i></a>
                                <a href="#"><i class="icon-youtube"></i></a>
                            </p>
                            <p>Copyright &copy; 2016-2018 <a href="http://www.ustsd.edu.cn">山东科技大学济南校区</a>教科部版权所有</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

    </div>
    <!-- END fh5co-page -->

</div>
<!-- END fh5co-wrapper -->

<!-- jQuery -->


<script src="<%=basePath %>admin/js/jquery.js"></script>
<!-- jQuery Easing -->
<script src="<%=basePath %>admin/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="<%=basePath %>admin/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="<%=basePath %>admin/js/jquery.waypoints.min.js"></script>
<!-- Stellar -->
<script src="<%=basePath %>admin/js/jquery.stellar.min.js"></script>
<!-- Superfish -->
<script src="<%=basePath %>admin/js/hoverIntent.js"></script>
<script src="<%=basePath %>admin/js/superfish.js"></script>

<!-- Main JS (Do not remove) -->
<script src="<%=basePath %>admin/js/mainfont.js"></script>

</body>
</html>

