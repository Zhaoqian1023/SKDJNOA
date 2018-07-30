# Host: localhost  (Version 5.5.27)
# Date: 2018-07-30 20:09:56
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "allstudent1706"
#

DROP TABLE IF EXISTS `allstudent1706`;
CREATE TABLE `allstudent1706` (
  `xh` varchar(255) DEFAULT NULL,
  `xm` varchar(255) DEFAULT NULL,
  `bh` varchar(255) DEFAULT NULL,
  `bbh` varchar(255) DEFAULT NULL,
  `在校情况` varchar(255) DEFAULT NULL,
  `xb` varchar(255) DEFAULT NULL,
  `xym` varchar(255) DEFAULT NULL,
  `pinyin` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "jxjh20172"
#

DROP TABLE IF EXISTS `jxjh20172`;
CREATE TABLE `jxjh20172` (
  `biaoji` double DEFAULT NULL,
  `jid` double DEFAULT NULL,
  `bjdm` varchar(255) DEFAULT NULL,
  `bjm` varchar(255) DEFAULT NULL,
  `rkjsdm` varchar(255) DEFAULT NULL,
  `kcdm` varchar(255) DEFAULT NULL,
  `kcm` varchar(255) DEFAULT NULL,
  `kclb` varchar(255) DEFAULT NULL,
  `xf` varchar(255) DEFAULT NULL,
  `zxs` varchar(255) DEFAULT NULL,
  `ykxs` varchar(255) DEFAULT NULL,
  `xkxs` varchar(255) DEFAULT NULL,
  `rkjs` varchar(255) DEFAULT NULL,
  `jys` varchar(255) DEFAULT NULL,
  `ksz1` varchar(255) DEFAULT NULL,
  `jsz1` varchar(255) DEFAULT NULL,
  `zxs1` varchar(255) DEFAULT NULL,
  `ksz2` varchar(255) DEFAULT NULL,
  `jsz2` varchar(255) DEFAULT NULL,
  `zxs2` varchar(255) DEFAULT NULL,
  `ksz3` varchar(255) DEFAULT NULL,
  `jsz3` varchar(255) DEFAULT NULL,
  `zxs3` varchar(255) DEFAULT NULL,
  `ksz4` varchar(255) DEFAULT NULL,
  `jsz4` varchar(255) DEFAULT NULL,
  `zxs4` varchar(255) DEFAULT NULL,
  `ks` varchar(255) DEFAULT NULL,
  `bz` varchar(255) DEFAULT NULL,
  `hb` varchar(255) DEFAULT NULL,
  `rs` double DEFAULT NULL,
  `zrs` double DEFAULT NULL,
  `apxs` varchar(255) DEFAULT NULL,
  `xstj` varchar(255) DEFAULT NULL,
  `hbcheck` varchar(255) DEFAULT NULL,
  `dyindex` double DEFAULT NULL,
  `request` varchar(255) DEFAULT NULL,
  `syxs` double DEFAULT NULL,
  `sjxs` double DEFAULT NULL,
  `hdxf` varchar(255) DEFAULT NULL,
  `lb` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "jxjh20181"
#

DROP TABLE IF EXISTS `jxjh20181`;
CREATE TABLE `jxjh20181` (
  `bjdm` varchar(255) DEFAULT NULL,
  `bjm` varchar(255) DEFAULT NULL,
  `rkjsdm` varchar(255) DEFAULT NULL,
  `kcdm` varchar(255) DEFAULT NULL,
  `kcm` varchar(255) DEFAULT NULL,
  `kclb` varchar(255) DEFAULT NULL,
  `xf` varchar(255) DEFAULT NULL,
  `zxs` varchar(255) DEFAULT NULL,
  `ykxs` varchar(255) DEFAULT NULL,
  `xkxs` varchar(255) DEFAULT NULL,
  `rkjs` varchar(255) DEFAULT NULL,
  `jys` varchar(255) DEFAULT NULL,
  `ksz1` varchar(255) DEFAULT NULL,
  `jsz1` varchar(255) DEFAULT NULL,
  `zxs1` varchar(255) DEFAULT NULL,
  `ksz2` varchar(255) DEFAULT NULL,
  `jsz2` varchar(255) DEFAULT NULL,
  `zxs2` varchar(255) DEFAULT NULL,
  `ksz3` varchar(255) DEFAULT NULL,
  `jsz3` varchar(255) DEFAULT NULL,
  `zxs3` varchar(255) DEFAULT NULL,
  `ksz4` varchar(255) DEFAULT NULL,
  `jsz4` varchar(255) DEFAULT NULL,
  `zxs4` varchar(255) DEFAULT NULL,
  `ks` varchar(255) DEFAULT NULL,
  `bz` varchar(255) DEFAULT NULL,
  `hb` varchar(255) DEFAULT NULL,
  `rs` double DEFAULT NULL,
  `zrs` double DEFAULT NULL,
  `apxs` varchar(255) DEFAULT NULL,
  `xstj` varchar(255) DEFAULT NULL,
  `hbcheck` varchar(255) DEFAULT NULL,
  `dyindex` double DEFAULT NULL,
  `request` varchar(255) DEFAULT NULL,
  `syxs` double DEFAULT NULL,
  `sjxs` double DEFAULT NULL,
  `hdxf` varchar(255) DEFAULT NULL,
  `lb` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "t_colleage"
#

DROP TABLE IF EXISTS `t_colleage`;
CREATE TABLE `t_colleage` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院系部id',
  `cname` varchar(255) NOT NULL DEFAULT '' COMMENT '系部名称',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='学院系部表';

#
# Structure for table "t_department"
#

DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `did` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `dname` varchar(255) NOT NULL DEFAULT '' COMMENT '部门名称',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='学校部门信息表';

#
# Structure for table "t_logs"
#

DROP TABLE IF EXISTS `t_logs`;
CREATE TABLE `t_logs` (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `ltime` varchar(255) DEFAULT NULL COMMENT '操作时间',
  `luid` int(11) DEFAULT NULL COMMENT '操作者ID',
  `luser` varchar(255) DEFAULT NULL COMMENT '操作者姓名',
  `lclass` varchar(255) DEFAULT NULL COMMENT '班级名',
  `lcourse` varchar(255) DEFAULT NULL COMMENT '课程名',
  `lcontrol` varchar(255) DEFAULT NULL COMMENT '操作名称',
  `lgenre` varchar(255) DEFAULT NULL COMMENT '操作者类别',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=3063 DEFAULT CHARSET=utf8 COMMENT='操作日志信息表';

#
# Structure for table "t_management"
#

DROP TABLE IF EXISTS `t_management`;
CREATE TABLE `t_management` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `mname` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员姓名',
  `passWord` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员密码',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=2297 DEFAULT CHARSET=utf8 COMMENT='管理员信息表';

#
# Structure for table "t_professional"
#

DROP TABLE IF EXISTS `t_professional`;
CREATE TABLE `t_professional` (
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '专业ID',
  `pname` varchar(255) NOT NULL DEFAULT '' COMMENT '专业名称',
  `cid` int(11) DEFAULT NULL COMMENT '学院系部ID',
  PRIMARY KEY (`pid`),
  KEY `FK_b57ka8d87yr46xtbtvguucidh` (`cid`),
  CONSTRAINT `FK_b57ka8d87yr46xtbtvguucidh` FOREIGN KEY (`cid`) REFERENCES `t_colleage` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业信息表';

#
# Structure for table "t_classname"
#

DROP TABLE IF EXISTS `t_classname`;
CREATE TABLE `t_classname` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级代码',
  `cname` varchar(255) DEFAULT NULL COMMENT '班级名',
  `englishname` varchar(255) DEFAULT NULL COMMENT '班级英文名称',
  `pid` int(11) DEFAULT NULL COMMENT 'FK对应专业代码',
  PRIMARY KEY (`cid`),
  KEY `FK_nbfbo7elpyvp1ksd2pm3vn21c` (`pid`),
  CONSTRAINT `FK_nbfbo7elpyvp1ksd2pm3vn21c` FOREIGN KEY (`pid`) REFERENCES `t_professional` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=172045 DEFAULT CHARSET=utf8 COMMENT='班级信息表';

#
# Structure for table "t_savetemp"
#

DROP TABLE IF EXISTS `t_savetemp`;
CREATE TABLE `t_savetemp` (
  `stid` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(45) DEFAULT NULL,
  `classid` varchar(45) DEFAULT NULL,
  `years` varchar(45) DEFAULT NULL,
  `coursename` varchar(45) DEFAULT NULL,
  `studentid` varchar(45) DEFAULT NULL,
  `studentname` varchar(45) DEFAULT NULL,
  `ordinaryscore` varchar(45) DEFAULT NULL,
  `paperscore` varchar(45) DEFAULT NULL,
  `remark` varchar(45) DEFAULT NULL,
  `ordinaryproportion` varchar(45) DEFAULT NULL,
  `paperproportion` varchar(45) DEFAULT NULL,
  `credit` varchar(45) DEFAULT NULL,
  `coursecategory` varchar(45) DEFAULT NULL,
  `flag` varchar(45) DEFAULT NULL,
  `finalscore` varchar(45) DEFAULT NULL,
  `courseid` varchar(45) DEFAULT NULL,
  `examflag` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB AUTO_INCREMENT=35980 DEFAULT CHARSET=utf8;

#
# Structure for table "t_scoremanagement"
#

DROP TABLE IF EXISTS `t_scoremanagement`;
CREATE TABLE `t_scoremanagement` (
  `smid` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号ID',
  `studentId` varchar(255) NOT NULL DEFAULT '' COMMENT '学号',
  `studentName` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `classId` int(11) DEFAULT NULL COMMENT '班级ID',
  `className` varchar(255) DEFAULT NULL COMMENT '班级名称',
  `year` varchar(255) DEFAULT NULL COMMENT '学期学年',
  `category` varchar(255) DEFAULT NULL COMMENT '课程类别',
  `coursename` varchar(255) DEFAULT NULL COMMENT '课程名',
  `courseId` int(11) DEFAULT NULL COMMENT '课程ID',
  `credits` float DEFAULT NULL COMMENT '学分',
  `paperProportion` float DEFAULT NULL COMMENT '纸质成绩比例',
  `ordinaryProportion` float DEFAULT NULL COMMENT '平时成绩比例',
  `paperGrade` varchar(255) DEFAULT NULL COMMENT '纸质成绩',
  `ordinaryGrade` varchar(255) DEFAULT NULL COMMENT '平时成绩',
  `finalGrade` varchar(255) DEFAULT NULL COMMENT '最终成绩',
  `resetGrade1` varchar(255) DEFAULT NULL COMMENT '重修1',
  `resetGrade2` varchar(255) DEFAULT NULL COMMENT '重修2',
  `resetGrade3` varchar(255) DEFAULT NULL COMMENT '重修3',
  `beizhu` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `examFlag` int(11) NOT NULL DEFAULT '0' COMMENT '课程是否为考察课，1为考试课程，0为非考试课程',
  `teacherName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`smid`)
) ENGINE=InnoDB AUTO_INCREMENT=56376 DEFAULT CHARSET=utf8 COMMENT='学生成绩库';

#
# Structure for table "t_student"
#

DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `sid` varchar(255) NOT NULL DEFAULT '' COMMENT '学号',
  `sname` varchar(255) NOT NULL DEFAULT '' COMMENT '学生姓名',
  `englishname` varchar(255) NOT NULL DEFAULT '' COMMENT '学生英文名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `number` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `political` varchar(255) DEFAULT NULL COMMENT '政治面貌',
  `national` varchar(255) DEFAULT NULL COMMENT '民族',
  `amissionTime` varchar(255) DEFAULT NULL COMMENT '入学时间',
  `graduationTime` varchar(255) DEFAULT NULL COMMENT '毕业时间',
  `classnameid` int(11) DEFAULT NULL COMMENT '班级id',
  `professionsid` int(11) DEFAULT NULL COMMENT '专业id',
  `colleagesid` int(11) DEFAULT NULL COMMENT '学院id',
  `note` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `status` varchar(255) NOT NULL DEFAULT '在校' COMMENT '学生状态',
  `password` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`sid`),
  KEY `FK_jy4vvfynyt86mywkexbebyfo` (`classnameid`),
  KEY `FK_9pab3ddosldt6kv9qosucwmhy` (`professionsid`),
  KEY `FK_fi9rwxbi1k7g1genhvfb8q06u` (`colleagesid`),
  CONSTRAINT `FK_9pab3ddosldt6kv9qosucwmhy` FOREIGN KEY (`professionsid`) REFERENCES `t_professional` (`pid`),
  CONSTRAINT `FK_fi9rwxbi1k7g1genhvfb8q06u` FOREIGN KEY (`colleagesid`) REFERENCES `t_colleage` (`cid`),
  CONSTRAINT `FK_jy4vvfynyt86mywkexbebyfo` FOREIGN KEY (`classnameid`) REFERENCES `t_classname` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生信息表';

#
# Structure for table "t_teacher"
#

DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `tid` int(11) NOT NULL DEFAULT '0' COMMENT '教师id',
  `tname` varchar(255) DEFAULT NULL COMMENT '教师姓名',
  `position` varchar(255) DEFAULT NULL COMMENT '所在单位部门名称',
  `title` varchar(255) DEFAULT NULL COMMENT '职称',
  `did` int(11) NOT NULL DEFAULT '15' COMMENT '部门ID',
  PRIMARY KEY (`tid`),
  KEY `FK_c7cs1n3qqpqyok63rsq6ut4h3` (`did`),
  CONSTRAINT `FK_c7cs1n3qqpqyok63rsq6ut4h3` FOREIGN KEY (`did`) REFERENCES `t_department` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师信息表';

#
# Structure for table "t_publiccourse"
#

DROP TABLE IF EXISTS `t_publiccourse`;
CREATE TABLE `t_publiccourse` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '公选课ID',
  `pname` varchar(255) NOT NULL DEFAULT '' COMMENT '公选课名称',
  `category` varchar(255) DEFAULT NULL COMMENT '课程类别',
  `credits` float DEFAULT NULL COMMENT '学分',
  `time` varchar(255) DEFAULT NULL COMMENT '总学时',
  `year` varchar(255) DEFAULT NULL COMMENT '学期',
  `beginTime` int(11) DEFAULT NULL COMMENT '开始周数',
  `endTime` int(11) DEFAULT NULL COMMENT '结束周数',
  `tid` int(11) DEFAULT NULL COMMENT '任课教师ID',
  `examFlag` int(2) DEFAULT '0',
  `courseNum` varchar(255) DEFAULT NULL COMMENT '课程编码',
  PRIMARY KEY (`pid`),
  KEY `FK_69kha4fvt83o950l2138yx1hh` (`tid`),
  CONSTRAINT `FK_69kha4fvt83o950l2138yx1hh` FOREIGN KEY (`tid`) REFERENCES `t_teacher` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=5001197 DEFAULT CHARSET=utf8 COMMENT='公选课信息表';

#
# Structure for table "t_publicelective"
#

DROP TABLE IF EXISTS `t_publicelective`;
CREATE TABLE `t_publicelective` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '序列id',
  `sid` varchar(255) DEFAULT NULL COMMENT '学号',
  `pcid` int(11) DEFAULT NULL COMMENT '公选课ID',
  `year` varchar(255) DEFAULT NULL COMMENT '学期',
  PRIMARY KEY (`pid`),
  KEY `FK_n8t03q6jtmrciy42a9kkpa83a` (`sid`),
  KEY `FK_gc14et0lf63u0uj37rudph08h` (`pcid`),
  CONSTRAINT `FK_gc14et0lf63u0uj37rudph08h` FOREIGN KEY (`pcid`) REFERENCES `t_publiccourse` (`pid`),
  CONSTRAINT `FK_n8t03q6jtmrciy42a9kkpa83a` FOREIGN KEY (`sid`) REFERENCES `t_student` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=13534 DEFAULT CHARSET=utf8 COMMENT='公选课选课信息表';

#
# Structure for table "t_course"
#

DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `cname` varchar(255) NOT NULL DEFAULT '' COMMENT '课程名称',
  `category` varchar(255) DEFAULT NULL COMMENT '课程类别',
  `credits` float DEFAULT NULL COMMENT '课程学分',
  `time` varchar(255) DEFAULT NULL COMMENT '总学时',
  `year` varchar(255) DEFAULT NULL COMMENT '学年',
  `beginTime` int(11) DEFAULT NULL COMMENT '开始周数',
  `endTime` int(11) DEFAULT NULL COMMENT '结束周数',
  `tid` int(11) DEFAULT NULL COMMENT '任课教师id',
  `examFlag` int(11) DEFAULT NULL COMMENT '是否为考察课，1需要考试，0不需考试',
  `courseNum` varchar(255) DEFAULT NULL COMMENT '课程编码',
  PRIMARY KEY (`cid`),
  KEY `FK_3dmfligdhhy5xu9pwnb6vxaor` (`tid`),
  CONSTRAINT `FK_3dmfligdhhy5xu9pwnb6vxaor` FOREIGN KEY (`tid`) REFERENCES `t_teacher` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=5002086 DEFAULT CHARSET=utf8 COMMENT='课程信息表';

#
# Structure for table "t_courseclass"
#

DROP TABLE IF EXISTS `t_courseclass`;
CREATE TABLE `t_courseclass` (
  `classid` int(11) NOT NULL DEFAULT '0' COMMENT '班级ID',
  `cid` int(11) NOT NULL DEFAULT '0' COMMENT '课程id',
  PRIMARY KEY (`cid`,`classid`),
  KEY `FK_8idgahfu9uen4t6emmes3epqi` (`classid`),
  CONSTRAINT `FK_8idgahfu9uen4t6emmes3epqi` FOREIGN KEY (`classid`) REFERENCES `t_classname` (`cid`),
  CONSTRAINT `FK_qrkp99vowopm5ejsxajfv9avf` FOREIGN KEY (`cid`) REFERENCES `t_course` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程对应班级信息表';

#
# Structure for table "t_users"
#

DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `uname` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
