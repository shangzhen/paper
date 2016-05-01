-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.14


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema paper
--

CREATE DATABASE IF NOT EXISTS paper;
USE paper;

--
-- Definition of table `t_announcement`
--

DROP TABLE IF EXISTS `t_announcement`;
CREATE TABLE `t_announcement` (
  `fSerialNo` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `fTitle` varchar(50) NOT NULL COMMENT '标题',
  `fPublisher` varchar(20) NOT NULL COMMENT '发布人',
  `fPublishMessage` varchar(5000) NOT NULL COMMENT '发布信息',
  `fType` varchar(20) NOT NULL COMMENT '类型(导师/学生可见)',
  `fContent` varchar(5000) DEFAULT NULL COMMENT '内容',
  `fBrowseTime` int(10) unsigned DEFAULT NULL COMMENT '浏览次数',
  `fAdjunct` varchar(100) DEFAULT NULL COMMENT '附件',
  PRIMARY KEY (`fSerialNo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='公告表';

--
-- Dumping data for table `t_announcement`
--

/*!40000 ALTER TABLE `t_announcement` DISABLE KEYS */;
INSERT INTO `t_announcement` (`fSerialNo`,`fTitle`,`fPublisher`,`fPublishMessage`,`fType`,`fContent`,`fBrowseTime`,`fAdjunct`) VALUES 
 (2,'title','publisher','message','教师','123325',1,NULL),
 (3,'title','publisher','message','教师','123325',1,NULL),
 (4,'title','publisher','message','教师','123325',1,NULL),
 (5,'title','publisher','message','教师','123325',1,NULL),
 (6,'title','publisher','message','教师','123325',1,NULL),
 (7,'title','publisher','message','教师','123325',1,NULL),
 (8,'title','publisher','message','教师','123325',1,NULL),
 (9,'title','publisher','message','教师','123325',1,NULL),
 (10,'title','publisher','message','教师','123325',1,NULL),
 (11,'title','publisher','message','教师','123325',1,NULL);
/*!40000 ALTER TABLE `t_announcement` ENABLE KEYS */;


--
-- Definition of table `t_check`
--

DROP TABLE IF EXISTS `t_check`;
CREATE TABLE `t_check` (
  `fNo` varchar(20) NOT NULL COMMENT '学号',
  `fTitle` varchar(100) DEFAULT NULL COMMENT '题目名称',
  `fCollege` varchar(50) DEFAULT NULL COMMENT '学院',
  `fName` varchar(20) DEFAULT NULL COMMENT '学生姓名',
  `fMajor` varchar(100) DEFAULT NULL COMMENT '所学专业',
  `fFare` varchar(1000) DEFAULT NULL COMMENT '进展情况',
  `fProblem` varchar(1000) DEFAULT NULL COMMENT '问题',
  `fSelfEvaluation` varchar(500) DEFAULT NULL COMMENT '自我评价',
  `fTutorEvaluation` varchar(500) DEFAULT NULL COMMENT '导师评价',
  `fTutorTime` varchar(45) DEFAULT NULL COMMENT '导师评价时间',
  `fCheck` varchar(50) DEFAULT NULL COMMENT '中期检查表',
  `fAdjunct` varchar(100) DEFAULT NULL COMMENT '附件',
  `fMemo` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中期检查表';

--
-- Dumping data for table `t_check`
--

/*!40000 ALTER TABLE `t_check` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_check` ENABLE KEYS */;


--
-- Definition of table `t_distribution`
--

DROP TABLE IF EXISTS `t_distribution`;
CREATE TABLE `t_distribution` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fNo` varchar(20) NOT NULL COMMENT '学号',
  `fTId` varchar(20) NOT NULL COMMENT '工号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评阅教师分配表';

--
-- Dumping data for table `t_distribution`
--

/*!40000 ALTER TABLE `t_distribution` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_distribution` ENABLE KEYS */;


--
-- Definition of table `t_file`
--

DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `fId` int(20) unsigned NOT NULL COMMENT '编号',
  `fTitle` varchar(100) NOT NULL COMMENT '标题',
  `fPublisher` varchar(20) DEFAULT NULL COMMENT '上传人',
  `fUpTime` varchar(45) DEFAULT NULL COMMENT '上传时间',
  `fFilePath` varchar(100) DEFAULT NULL COMMENT '上传路径',
  `fRemark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';

--
-- Dumping data for table `t_file`
--

/*!40000 ALTER TABLE `t_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_file` ENABLE KEYS */;


--
-- Definition of table `t_notice`
--

DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `fId` int(15) unsigned NOT NULL COMMENT '主键',
  `fDefenceTime` varchar(100) DEFAULT NULL COMMENT '答辩时间',
  `fDefencePlace` varchar(100) DEFAULT NULL COMMENT '答辩地点',
  `fRoute` varchar(500) DEFAULT NULL COMMENT '路线',
  `fReleaseTime` varchar(45) DEFAULT NULL COMMENT '发布时间',
  `fReleasePerson` varchar(20) DEFAULT NULL COMMENT '发布人',
  `fMemo` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='答辩公告表';

--
-- Dumping data for table `t_notice`
--

/*!40000 ALTER TABLE `t_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_notice` ENABLE KEYS */;


--
-- Definition of table `t_online`
--

DROP TABLE IF EXISTS `t_online`;
CREATE TABLE `t_online` (
  `fId` int(50) unsigned NOT NULL COMMENT '编号',
  `fTitle` varchar(50) DEFAULT NULL COMMENT '标题',
  `fContent` varchar(5000) DEFAULT NULL COMMENT '内容',
  `fIsTop` varchar(10) DEFAULT NULL COMMENT '是否置顶(1：置顶  0：不置顶)',
  `fAnswer` varchar(20) DEFAULT NULL COMMENT '回复人',
  `fReply` varchar(500) DEFAULT NULL COMMENT '回复内容',
  `fQueryTime` varchar(45) DEFAULT NULL COMMENT '咨询时间',
  `fStudentName` varchar(20) DEFAULT NULL COMMENT '咨询学生姓名',
  `fReplyTime` varchar(45) DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线咨询表';

--
-- Dumping data for table `t_online`
--

/*!40000 ALTER TABLE `t_online` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_online` ENABLE KEYS */;


--
-- Definition of table `t_paperdetails`
--

DROP TABLE IF EXISTS `t_paperdetails`;
CREATE TABLE `t_paperdetails` (
  `fId` int(20) unsigned NOT NULL COMMENT '主键',
  `fRevision` varchar(10) DEFAULT NULL COMMENT '版次',
  `fTitle` varchar(100) DEFAULT NULL COMMENT '标题',
  `fModifyContent` varchar(1000) DEFAULT NULL COMMENT '修改内容',
  `fThesisAdjunct` varchar(100) DEFAULT NULL COMMENT '论文附件',
  `fPptAdjunct` varchar(100) DEFAULT NULL COMMENT 'PPT附件',
  `fSourceCodeAdjunct` varchar(100) DEFAULT NULL COMMENT '源程序附件',
  `fCheckAdjunct` varchar(100) DEFAULT NULL COMMENT '查重附件',
  `fUploadTime` varchar(45) DEFAULT NULL COMMENT '上传时间',
  `fReviewComment` varchar(500) DEFAULT NULL COMMENT '评阅意见',
  `fReviewTime` varchar(45) DEFAULT NULL COMMENT '评阅时间',
  `fReviewAdjunct` varchar(500) DEFAULT NULL COMMENT '评阅附件',
  `fReviewTeacher` varchar(20) DEFAULT NULL COMMENT '评阅教师',
  `fIdentification` varchar(100) DEFAULT NULL COMMENT '标识',
  `fRepetitionRate` varchar(10) DEFAULT NULL COMMENT '重复率',
  `fMemo` varchar(500) DEFAULT NULL COMMENT '备注',
  `fNo` varchar(20) NOT NULL COMMENT '学号',
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论文明细表';

--
-- Dumping data for table `t_paperdetails`
--

/*!40000 ALTER TABLE `t_paperdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_paperdetails` ENABLE KEYS */;


--
-- Definition of table `t_registration`
--

DROP TABLE IF EXISTS `t_registration`;
CREATE TABLE `t_registration` (
  `fId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fName` varchar(20) NOT NULL COMMENT '姓名',
  `fDefencePlace` varchar(100) DEFAULT NULL COMMENT '答辩地点',
  `fThesisTopic` varchar(1000) DEFAULT NULL COMMENT '论文题目',
  `fReleaseTime` varchar(45) DEFAULT NULL COMMENT '答辩时间',
  `fGuideTeacher` varchar(20) DEFAULT NULL COMMENT '指导老师',
  `fNo` varchar(20) DEFAULT NULL COMMENT '学号',
  `fNoticeId` int(10) unsigned DEFAULT NULL COMMENT '答辩公告编号',
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='答辩报名表';

--
-- Dumping data for table `t_registration`
--

/*!40000 ALTER TABLE `t_registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_registration` ENABLE KEYS */;


--
-- Definition of table `t_report`
--

DROP TABLE IF EXISTS `t_report`;
CREATE TABLE `t_report` (
  `fNo` varchar(20) NOT NULL COMMENT '学号',
  `fOpeningTime` varchar(45) DEFAULT NULL COMMENT '开题时间',
  `fTopicTitle` varchar(100) DEFAULT NULL COMMENT '课题题目',
  `fTopicSource` varchar(100) DEFAULT NULL COMMENT '课题来源',
  `fSubjectPurpose` varchar(2000) DEFAULT NULL COMMENT '课题目的',
  `fResearchObject` varchar(2000) DEFAULT NULL COMMENT '研究方法',
  `fUseWay` varchar(2000) DEFAULT NULL COMMENT '采取的方法',
  `fExpectedResults` varchar(1000) DEFAULT NULL COMMENT '预期成果',
  `fProgressPlan` varchar(1000) DEFAULT NULL COMMENT '进度计划',
  `fReference` varchar(1000) DEFAULT NULL COMMENT '参考文献',
  `fMentorOpinion` varchar(500) DEFAULT NULL COMMENT '导师意见',
  `fAdjunct` varchar(100) DEFAULT NULL COMMENT '附件',
  `fMemo` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开题报告表';

--
-- Dumping data for table `t_report`
--

/*!40000 ALTER TABLE `t_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_report` ENABLE KEYS */;


--
-- Definition of table `t_review`
--

DROP TABLE IF EXISTS `t_review`;
CREATE TABLE `t_review` (
  `fId` int(15) unsigned NOT NULL COMMENT '主键',
  `fComment` varchar(500) DEFAULT NULL COMMENT '答委评语',
  `fPersonnel` varchar(100) DEFAULT NULL COMMENT '答委人员',
  `fDirector` varchar(20) DEFAULT NULL COMMENT '答委主任',
  `fContentScore` decimal(4,1) DEFAULT NULL COMMENT '内容表达分值',
  `fScoreDefense` decimal(4,0) DEFAULT NULL COMMENT '答辩情况分值',
  `fWordScore` decimal(4,1) DEFAULT NULL COMMENT '文字表达分值',
  `fQualityScore` decimal(4,1) DEFAULT NULL COMMENT '论文质量分值',
  `fComprehensiveScore` decimal(4,1) DEFAULT NULL COMMENT '综合成绩',
  `fRating` varchar(20) DEFAULT NULL COMMENT '评定等级',
  `fDefenceTime` varchar(45) DEFAULT NULL COMMENT '答辩时间',
  `fAdjunct` varchar(100) DEFAULT NULL COMMENT '附件',
  `fMemo` varchar(500) DEFAULT NULL COMMENT '备注',
  `fNo` varchar(10) NOT NULL COMMENT '学号',
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='答辩评阅表';

--
-- Dumping data for table `t_review`
--

/*!40000 ALTER TABLE `t_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_review` ENABLE KEYS */;


--
-- Definition of table `t_score`
--

DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `fId` int(15) unsigned NOT NULL COMMENT '主键',
  `fNo` varchar(20) DEFAULT NULL COMMENT '学号',
  `fName` varchar(20) DEFAULT NULL COMMENT '姓名',
  `fMajor` varchar(100) DEFAULT NULL COMMENT '专业',
  `fTutorName` varchar(20) DEFAULT NULL COMMENT '导师姓名',
  `fAverage` decimal(4,1) DEFAULT NULL COMMENT '评阅平均得分',
  `fTitle` varchar(100) DEFAULT NULL COMMENT '论文题目',
  `fCoach` varchar(500) DEFAULT NULL COMMENT '指导老师评语',
  `fOpenReportScore` decimal(4,1) DEFAULT NULL COMMENT '开题报告分值',
  `fVarcharScore` decimal(4,1) DEFAULT NULL COMMENT '整理资料分值',
  `fShowScore` decimal(4,1) DEFAULT NULL COMMENT '文字表达分值',
  `fQualityScore` decimal(4,1) DEFAULT NULL COMMENT '论文质量分值',
  `fReviewTime` varchar(45) DEFAULT NULL COMMENT '导师评阅时间',
  `fCommentTeacher` varchar(500) DEFAULT NULL COMMENT '评阅教师评语',
  `fCommentReportScore` decimal(4,1) DEFAULT NULL COMMENT '评阅教师开题报名分值',
  `fCommentVarcharScore` decimal(4,1) DEFAULT NULL COMMENT '评阅教师整理资料分值',
  `fCommentShowScore` decimal(4,1) DEFAULT NULL COMMENT '评阅教师文字表达分值',
  `fCommentQualityScore` decimal(4,1) DEFAULT NULL COMMENT '评阅教师论文质量分值',
  `fCommentTime` varchar(45) DEFAULT NULL COMMENT '评阅教师评阅时间',
  `fAdjunct` varchar(200) DEFAULT NULL COMMENT '附录',
  `fMemo` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师成绩评阅表';

--
-- Dumping data for table `t_score`
--

/*!40000 ALTER TABLE `t_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_score` ENABLE KEYS */;


--
-- Definition of table `t_task`
--

DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `fNo` varchar(10) NOT NULL COMMENT '学号',
  `fTitle` varchar(100) DEFAULT NULL COMMENT '题目名称',
  `fCollege` varchar(50) DEFAULT NULL COMMENT '学院',
  `fName` varchar(20) DEFAULT NULL COMMENT '学生姓名',
  `fMajor` varchar(100) DEFAULT NULL COMMENT '所学专业',
  `fRequire` varchar(3000) DEFAULT NULL COMMENT '要求',
  `fTime` varchar(45) DEFAULT NULL COMMENT '时间',
  `fTutorName` varchar(50) DEFAULT NULL COMMENT '导师姓名',
  `fAdjunct` varchar(100) DEFAULT NULL COMMENT '附件',
  `fMemo` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务表';

--
-- Dumping data for table `t_task`
--

/*!40000 ALTER TABLE `t_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_task` ENABLE KEYS */;


--
-- Definition of table `t_teacher`
--

DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `fTid` varchar(20) NOT NULL COMMENT '主键，教工号',
  `fName` varchar(20) DEFAULT NULL COMMENT '姓名',
  `fDepartment` varchar(50) DEFAULT NULL COMMENT '系别',
  `fPosition` varchar(20) DEFAULT NULL COMMENT '职称',
  `fPhone` varchar(13) DEFAULT NULL COMMENT '电话',
  `fEmail` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `fQQ` varchar(15) DEFAULT NULL COMMENT 'QQ号',
  `fQGNo` varchar(15) DEFAULT NULL COMMENT 'QQ群',
  `fPsw` varchar(100) DEFAULT NULL COMMENT '密码',
  `fType` varchar(10) DEFAULT NULL COMMENT '用户类型',
  `fMemo` varchar(500) DEFAULT NULL COMMENT '备注',
  `fCollege` varchar(50) DEFAULT NULL COMMENT '学院',
  PRIMARY KEY (`fTid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';

--
-- Dumping data for table `t_teacher`
--

/*!40000 ALTER TABLE `t_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_teacher` ENABLE KEYS */;


--
-- Definition of table `t_thesis`
--

DROP TABLE IF EXISTS `t_thesis`;
CREATE TABLE `t_thesis` (
  `fNo` varchar(20) NOT NULL COMMENT '学号',
  `fThePro` varchar(50) DEFAULT NULL COMMENT '开题报告',
  `fTask` varchar(50) DEFAULT NULL COMMENT '任务表',
  `fMidCheck` varchar(50) DEFAULT NULL COMMENT '中期检查',
  `fFinalDraft` varchar(50) DEFAULT NULL COMMENT '终稿',
  `fScore` varchar(50) DEFAULT NULL COMMENT '成绩判定',
  `fSenceRep` varchar(50) DEFAULT NULL COMMENT '现场答辩',
  `fEvaluate` varchar(50) DEFAULT NULL COMMENT '答辩评阅',
  `fRepeat` varchar(50) DEFAULT NULL COMMENT '查重',
  `FMemo` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论文状态表';

--
-- Dumping data for table `t_thesis`
--

/*!40000 ALTER TABLE `t_thesis` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_thesis` ENABLE KEYS */;


--
-- Definition of table `t_thesislist`
--

DROP TABLE IF EXISTS `t_thesislist`;
CREATE TABLE `t_thesislist` (
  `fNo` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '学号',
  `fSName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `fProfessional` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '专业',
  `fTNo` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '指导老师工号',
  `fTName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '指导老师姓名',
  `fState` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '学生状态（在校/毕业）',
  `fPrimaryWork` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '初次工作单位',
  `fPrimaryPay` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '初次月薪',
  `fLeaveSchoolWork` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '离校工作单位',
  `fPay` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '月薪',
  `fPsw` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `fDepartment` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '系别',
  `fMemo` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`fNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='论文分配表';

--
-- Dumping data for table `t_thesislist`
--

/*!40000 ALTER TABLE `t_thesislist` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_thesislist` ENABLE KEYS */;


--
-- Definition of table `t_timelimit`
--

DROP TABLE IF EXISTS `t_timelimit`;
CREATE TABLE `t_timelimit` (
  `fId` int(10) unsigned NOT NULL COMMENT '主键',
  `fJobTasks` varchar(500) DEFAULT NULL COMMENT '工作任务',
  `fTimeRequirement` varchar(45) DEFAULT NULL COMMENT '时间要求',
  `fRemindContent` varchar(200) DEFAULT NULL COMMENT '提醒内容',
  `fRemindTime` int(10) unsigned DEFAULT NULL COMMENT '提前提醒天数',
  `fTid` varchar(20) DEFAULT NULL COMMENT '教师工号',
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时间限制表';

--
-- Dumping data for table `t_timelimit`
--

/*!40000 ALTER TABLE `t_timelimit` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_timelimit` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
