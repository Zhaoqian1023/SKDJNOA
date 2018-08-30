<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<ul class="sidebar-menu" id="nav-accordion" >
			<li ><a href="index.jsp" id="index" class="">
					<i class="fa fa-dashboard"> </i> <span style="font-size: 13px">
						Home
				</span></a>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: 13px">
						Print - Blank Transcript </span></a>
				<ul class="sub">
				    <li><a href="queryinfo.jsp" id="attendance"
						class=""> Print - Information </a></li>
					<!-- <li><a href="attendance.jsp" id="attendance"
						class=""> Print - Attendance Sheets </a></li>
					<li><a href="regulargrade.jsp"
						id="regulargrade" class=""> Print - Regular Grade </a></li> 
					<li><a href="coursegrade.jsp"
						id="coursegrade" class=""> Print-Final Transcript </a></li> -->
					
				</ul>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-pencil"> </i> <span style="font-size: 13px">
						Enter Scores </span></a>

				<ul class="sub">
					<li><a href="Course_byTeacher?page=inScoreSelectOrdinary&years=2018-2019/1">Enter Scores</a></li>
					<!-- <li><a href="#">补考成绩录入</a></li>
					<li><a href="#">重修成绩录入</a></li> -->
					
				</ul>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: 11.5px">
						Print-Complete Transcript </span></a>
				<ul class="sub">
					<li><a href="Course_alreadyByTeacher?page=onScoreSelectOrdinary&years=2017-2018/2">Print-Final Transcript</a></li>
					<!-- <li><a href="#">补考成绩单打印</a></li>
					<li><a href="#">重修成绩单打印</a></li> -->
				</ul>
			</li>
			<!-- <li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: 13px">
						Elective Courses </span></a>
				<ul class="sub">
					<li><a href="PublicCourse_getCourseName?page=publiccourseatt&years=2016-2017/2">Print - Attendance Sheets</a></li>
					<li><a href="PublicCourse_getCourseByTeacher?page=inScoreSelectPublic&years=2016-2017/2" > Enter Scores </a></li>
					<li><a href="PublicCourse_alreadyByTeacher?page=onScoreSelectPublic&years=2016-2017/2">Print-Final Transcript</a></li>
					
				</ul>
			</li> -->
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

