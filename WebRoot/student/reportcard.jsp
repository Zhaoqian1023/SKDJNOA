<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
    <head>
        <meta charset="UTF-8">
        <title>成绩单</title>
        <meta name="description" content="Demo Theme">
        <meta name="author" content="BusinessMobile">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Style CSS -->  
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="css/new-style.css">
    </head>

    <body class="bsm_page_contact_class bsm_page_static_class" style="hight:'auto'">
        
        <!-- BEGIN HEADER -->
        <header>
            <div id="bsm_navigation_open_mobile_content_nav"></div>
            <div id="bsm_navigation_open_mobile_content">
                <span id="bsm_navigation_open_mobile">
                    <i aria-hidden="true">
                        <img src="img/sk.jpg" style="height: 33px;width: 169px">
                    </i>
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
                            <a href="_self" class="bsm_color_white bsm_museo_font bsm_font_size_14 bsm_991_font_size_12 bsm_767_js_move_to_cart">
                                <span>
                                    <img src="img/skcom.png" >
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- END HEADER -->
        
        <!-- BEGIN CONTACT -->
        <div style="position: static;height: auto" >
        <div id="bsm_section_7" class="container-fluid" >
            <div class="row" style="height: 80%">
                <div class="container">
                        <div class="row bsm_767_padding_15 bsm_767_margin_top_50">
                            <h2 class="bsm_color_red bsm_uppercase bsm_amatic_font bsm_font_size_36 bsm_section_7_title bsm_1199_font_size_30" style="font-size: 25px;font-family: ''kaiti'">声明：此成绩仅供参考，最终成绩以教务科纸质成绩为准。</h2>
                            <h5 style="text-align: center;font-family:kaiti">提醒：若对课程成绩有疑议，请联系任课教师核对</h5>
                            <h2 class="bsm_color_red bsm_uppercase bsm_amatic_font bsm_font_size_36 bsm_section_7_title bsm_1199_font_size_30" style="font-size: 30px;color: #23527c;text-align: center;font-family: ''kaiti'">山东科技大学学生成绩单</h2>
                            <br/>
                            <div class="work-progress">
                                <center>
                                    <table id="table-responsive">
                                        <tr>
                                        	<td>姓名：${dataMap.get("info").get(0).getStudentName() }</td>
                                            <td></td>
                                            <td>学号：${dataMap.get("info").get(0).getStudentId() }</td>
                                            
                                        </tr>
                                        <tr>
                                            <td>班级代码：${dataMap.get("info").get(0).getClassId() }</td>
                                            <td width="10%"></td>
                                            <!-- <td width="90px"></td> -->
                                            <td>专业班级：${dataMap.get("info").get(0).getClassName() }</td>
                                        </tr>
                                    </table>
                                </center>
                                <br/>
                                    <div class="course-style">
                                        <b><p>必修课与系选修课</p></b>
                                    </div>
                                <center>
                                    <table class="table-score" border="1px" frame="below" rules="rows">
                                        <thead>
                                        <tr>
                                            <th>课程名</th>
                                            <th>类别</th>
                                            <th>学分</th>
                                            <th>成绩</th>
                                            <th>学期</th>
                                        </tr>
                                        </thead>
                                        <c:forEach items='${dataMap.get("bx")}' var="att">
                                        <tr>
                                            <td width="400px">${att.getCourse() }</td>
                                            <td width="100px">${att.getCategory() }</td>
                                            <td width="100px">${att.getCredits() }</td>
                                            <td width="100px">${att.getFinalGrade() }</td>
                                            <td width="100px">${att.getYear()}</td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                </center>
                                <br/>
                                <hr style="border-color: grey">
                                
                                <div class="course-style">
                                    <b><p>公共选修课</p></b>
                                </div>
                                <center>
                                    <table class="table-score" border="1px" frame="below" rules="rows">
                                        <thead>
                                        <tr>
                                            <th width="400px">课程名</th>
                                            <th width="100px">类别</th>
                                            <th width="100px">学分</th>
                                            <th width="100px">成绩</th>
                                            <th width="100px">学期</th>
                                        </tr>
                                        </thead>
                                        <c:forEach items='${dataMap.get("xx")}' var="att1">
                                        <tr>
                                            <td width="400px">${att1.getCourse() }</td>
                                            <td width="100px">${att1.getCategory() }</td>
                                            <td width="100px">${att1.getCredits() }</td>
                                            <td width="100px">${att1.getFinalGrade() }</td>
                                            <td width="100px">${att1.getYear()}</td>
                                        </tr>
                                        </c:forEach>
                                       
                                    </table>
                                </center>
                                <br/><br/><br/><br/>
                            </div>
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
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/slider.js"></script>
        <script src="js/staller.js"></script>
        <script src="js/range_price.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
