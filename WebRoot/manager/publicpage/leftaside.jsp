<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a href="index_manager.jsp" id="index" class=""> <i
					class="fa fa-dashboard"> </i> <span style="font-size: medium">
						<h4>主页</h4>
				</span>
			</a></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						教师管理 </span>
			</a>
				<ul class="sub">
					<li><a href="teacheradd_manager.jsp" id="attendance" class="">
							新增教师 </a></li>
					<li><a href="teacherfind_manager.jsp" id="attendance" class="">
							信息修改 </a></li>
					<li><a href="creatpwd_manager.jsp" id="attendance" class="">
							生成密码 </a></li>
					<li><a href="teacherdownload_manager.jsp" id="attendance" class="">
							下载教师库 </a></li>
				</ul></li>
			<!-- <li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						用户管理</span>
			</a>
				<ul class="sub">
					<li><a href="creatpwd_manager.jsp" id="attendance" class="">
							生成密码 </a></li>
					<li><a href="useradd_manager.jsp" id="attendance" class="">
							新增用户 </a></li>

					<li><a href="userdelete_manager.jsp" id="attendance" class="">
							删除用户 </a></li>
				</ul></li> -->
				
				
			<!-- <li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						课程管理</span>
			</a>
				<ul class="sub">

					<li><a href="courseadd_manager.jsp" id="attendance" class="">
							新增课程 </a></li>
					<li><a href="coursefind_manager.jsp" id="attendance" class="">
							修改课程 </a></li>
					<li><a href="#" id="attendance" class=""> 下载课程 </a></li>


				</ul></li> -->
				
				
				
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						教学计划(必修)</span>
			</a>
				<ul class="sub">
					<li><a href="addEduPlan_manager.jsp" id="attendance" class=""> 导入教学计划文件 </a></li>
					<li><a href="courseadd_manager.jsp" id="attendance" class=""> 新增课程 </a></li>
					<li><a href="coursefind_manager.jsp" id="attendance" class=""> 修改课程</a></li>
					<li><a href="deleteEduPlan_manager.jsp" id="attendance" class=""> 删除教学计划</a></li>
					<li><a href="courseplandownload_manager.jsp" id="attendance" class=""> 下载教学计划</a></li>
				</ul></li>
			
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						教学计划(选修)</span>
			</a>
				<ul class="sub">

					<li><a href="addEduSelectPlan_manager.jsp" id="attendance" class=""> 导入选修课程</a></li>
					<li><a href="selectcourseadd_manager.jsp" id="attendance" class=""> 新增选修课程</a></li>
					<li><a href="selectcoursefind_manager.jsp" id="attendance" class=""> 修改选修课程</a></li>
					<li><a href="selectcoursefindtodelete_manager.jsp" id="attendance" class=""> 删除选修课程</a></li>
					<li><a href="selectcourseplandownload_manager.jsp" id="attendance" class=""> 下载选修课程</a></li>
					<li><a href="selectstudentdelete_manager.jsp" id="attendance" class=""> 删除选课信息</a></li>
					<li><a href="addEduSelectStudent_manager.jsp" id="attendance" class=""> 导入选课信息</a></li>
					<li><a href="selectstudenttoexport_manager.jsp" id="attendance" class=""> 下载选课信息</a></li>
				</ul></li>
			
			
			
				
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						教学计划(公选)</span>
			</a>
				<ul class="sub">

					<li><a href="addEduPublicPlan_manager.jsp" id="attendance" class=""> 导入公选课程</a></li>
					<li><a href="publiccourseadd_manager.jsp" id="attendance" class=""> 新增选修课程</a></li>
					<li><a href="selectcoursefind_manager.jsp" id="attendance" class=""> 修改公选课程</a></li>
					<li><a href="publiccoursefindtodelete_manager.jsp" id="attendance" class=""> 删除公选课程</a></li>
					<li><a href="publiccourseplandownload_manager.jsp" id="attendance" class=""> 下载选修课程</a></li>
					<li><a href="publicstudentdelete_manager.jsp" id="attendance" class=""> 删除选课信息</a></li>
					<li><a href="addEduPublicStudent_manager.jsp" id="attendance" class=""> 导入选课信息</a></li>
					<li><a href="selectstudenttoexport_manager.jsp" id="attendance" class=""> 下载选课信息</a></li>
				</ul></li>
				
				
				
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						成绩管理</span>
			</a>
				<ul class="sub">
					<li><a href="scorefind_manager.jsp" id="attendance" class="">
							成绩修改</a></li>
					<li><a href="queryinfo_manager.jsp" id="attendance" class="">
							删除成绩</a></li>
					<li><a href="filedownload_manager.jsp"
						id="filedownload_manager" class=""> 下载成绩库</a></li>
				</ul></li>

			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						学生管理</span>
			</a>
				<ul class="sub">
					<li><a href="studentfind_manager.jsp" id="attendance" class="">
							信息修改</a></li>
					<li><a href="studentadd_manager.jsp" id="attendance" class="">学生添加</a></li>
					<!-- <li><a href="studentdelete_manager.jsp" id="attendance"
						class="">学生删除</a></li> -->
					<li><a href="creatstudentpwd_manager.jsp" id="attendance" class="">
							生成密码</a></li>
					<li><a href="Manager_initStudentFile?page=studentdownload_manager" id="attendance" class="">在校生库下载</a></li>
				</ul></li>


			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-print"> </i> <span style="font-size: medium">
						操作日志 </span>
			</a>
				<ul class="sub">
					<li><a href="Manager_showLogs?page=logs_manager"
						id="logs_manager" class=""> 日志查询</a></li>
					<li><a href="Manager_initLogsFile?page=logdownload_manager"
						id="logs_manager" class=""> 日志下载</a></li>

				</ul></li>

			


		</ul>
	</div>
</aside>

