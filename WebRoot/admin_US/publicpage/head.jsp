<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

  <header class="header white-bg">
		 <!-- SIDEBAR TOGGLE BUTTON -->
            <div class="sidebar-toggle-box">
               <div  data-placement="right" class="fa fa-bars tooltips"></div>
            </div>
			<!-- SIDEBAR TOGGLE BUTTON  END-->
            <a href="../home.jsp" class="logo">
			<img src="img/logo04.png">
			</a>
			        
        <!-- START HEADER  NAV -->
        
           
			   <!-- START NOTIFY TASK BAR -->
               
			<!-- END HEADER NAV -->
        
			<!-- START USER LOGIN DROPDOWN  -->
            <div class="top-nav ">
               <ul class="nav pull-right top-menu">
                  <li>
                     <input type="text" class="form-control search" placeholder="Enter">
                  </li>
                  <li class="dropdown">
                     <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                     <img alt="" src="img/user.png">
                     <span class="username">Welcome</span>
                     <b class="caret"></b>
                     </a>
                     <ul class="dropdown-menu extended logout">
                        <li class="log-arrow-up"></li>
                       
                        
                        <li><a href="login.jsp"><i class="fa fa-key"></i> Login</a></li>
                        <li><a href="changepwd.jsp"><i class="fa fa-key"></i>Change Password</a></li>
                         <li><a href="Users_quit.action"><i class="fa fa-key"></i>Exit</a></li>
                     </ul>
                  </li>
               </ul>
            </div>
            <!-- END USER LOGIN DROPDOWN  -->
		 </header>