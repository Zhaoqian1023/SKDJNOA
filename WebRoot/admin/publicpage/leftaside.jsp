<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a href="index.jsp" id="index" class="">
					<i class="fa fa-dashboard"> </i> <span style="font-size: medium">
						<h4>主页</h4>
				</span></a>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						必修课程</span></a>
				<ul class="sub">
				    <li><a href="queryinfo.jsp" id="attendance"
						class=""> 必修课信息打印 </a></li>
					<li><a href="Course_byTeacher?page=inScoreSelectOrdinary&years=2018-2019/1">必修课成绩录入</a></li>
					<li><a href="Course_alreadyByTeacher?page=onScoreSelectOrdinary&years=2017-2018/2">必修课成绩单打印</a></li>
					
					<!-- <li><a href="attendance.jsp" id="attendance"
						class=""> 上课考勤表打印 </a></li>
					<li><a href="regulargrade.jsp"
						id="regulargrade" class=""> 平时成绩单打印 </a></li>
					<li><a href="coursegrade.jsp"
						id="coursegrade" class=""> 最终成绩单打印 </a></li> -->
					
				</ul>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-pencil"> </i> <span style="font-size: medium">
						系选修课程 </span></a>

				<ul class="sub">
					<li><a href="queryinfo_select.jsp" id="attendance"
						class=""> 系选修课信息打印 </a></li>
					<li><a href="PublicCourse_getSelectCourseByTeacher?page=inScoreSelect&tempCategory=select&years=2018-2019/1">系选课成绩录入</a></li>
					<li><a href="PublicCourse_alreadyByTeacher?page=onScoreSelect&tempCategory=select&years=2017-2018/2">选修课成绩单打印</a></li>
					<!-- <li><a href="#">补考成绩录入</a></li>
					<li><a href="#">重修成绩录入</a></li> -->
					
				</ul>
			</li>
			
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						公共选修课 </span></a>
				<ul class="sub">
					<li><a href="PublicCourse_getCourseName?page=publiccourseatt&tempCategory=public&years=2018-2019/1">考勤单打印</a></li>
					<li><a href="PublicCourse_getCourseByTeacher?page=inScoreSelectPublic&tempCategory=public&years=2018-2019/1" > 成绩录入 </a></li>
					<li><a href="PublicCourse_alreadyByTeacher?page=onScoreSelectPublic&tempCategory=public&years=2017-2018/2">最终成绩单打印</a></li>
					<li><a href="PublicCourse_alreadyByTeacherAll?page=onScoreSelectPublicAll&tempCategory=public&years=2017-2018/2">最终成绩单批量打印</a></li>
					
				</ul>
			</li>
			<!-- <li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-search"> </i> <span style="font-size: medium">
						信息查询 </span></a>
				<ul class="sub">
					<li><a href="#"> 基本信息查询 </a></li>
					<li><a href="#"> 考勤信息查询 </a></li>
					<li><a href="#"> 成绩信息查询 </a></li>
				</ul>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-edit"> </i> <span style="font-size: medium">
						信息修改 </span></a>
				<ul class="sub">
					<li><a href="#"> 基本信息修改 </a></li>
					<li><a href="#"> 考勤信息修改 </a></li>
					<li><a href="#"> 成绩信息修改 </a></li>
				</ul>
			</li> -->
		</ul>
	</div>
</aside>

