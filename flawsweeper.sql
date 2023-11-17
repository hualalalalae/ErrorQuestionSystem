/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.37 : Database - flawsweeper
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flawsweeper` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `flawsweeper`;

/*Table structure for table `b_user` */

DROP TABLE IF EXISTS `b_user`;

CREATE TABLE `b_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `b_user` */

insert  into `b_user`(`uid`,`username`,`password`,`nickname`) values (1,'1234','1234','张三'),(2,'12345','12345','张三'),(3,'zss','1234','李思思'),(4,'111','222','name'),(5,'ls1','1234','李四'),(6,'123','1234','w5'),(7,'w5','11','w5'),(8,'12345677','1234','??'),(9,'123asd','123','李逵'),(20,'zzrr','1234','朱正'),(22,'5678','5678','5678');

/*Table structure for table `classify` */

DROP TABLE IF EXISTS `classify`;

CREATE TABLE `classify` (
  `classifyid` int(11) NOT NULL AUTO_INCREMENT,
  `classifyname` varchar(50) NOT NULL,
  PRIMARY KEY (`classifyid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `classify` */

insert  into `classify`(`classifyid`,`classifyname`) values (1,'数学'),(2,'英语'),(3,'政治'),(4,'专业课');

/*Table structure for table `errorquestion` */

DROP TABLE IF EXISTS `errorquestion`;

CREATE TABLE `errorquestion` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT,
  `title1` longtext NOT NULL,
  `title2` longtext,
  `titletype` int(11) NOT NULL DEFAULT '0',
  `answer` longtext,
  `analysis` longtext,
  `classifyid` int(11) NOT NULL DEFAULT '1',
  `questiontime` datetime DEFAULT NULL,
  `notes` longtext,
  `imagesrc` longtext,
  `inrecycle` int(11) DEFAULT '0',
  `incollect` int(11) DEFAULT '0',
  `uid` int(11) NOT NULL,
  `proficiency` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`questionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

/*Data for the table `errorquestion` */

insert  into `errorquestion`(`questionid`,`title1`,`title2`,`titletype`,`answer`,`analysis`,`classifyid`,`questiontime`,`notes`,`imagesrc`,`inrecycle`,`incollect`,`uid`,`proficiency`) values (20,'下列不属于操作系统目标的是（ ）','A、方便性♞B、有效性♞C、可扩充性♞D、开放性♞E、通用性',1,'E','无',4,'2023-04-03 13:45:18','操作系统','',0,1,2,1),(21,'下列关于操作系统的作用错误的是（ ）','A、作为用户与计算机硬件系统之间的接口♞B、作为计算机系统资源的管理者♞C、实现对计算机资源的抽象♞D、管理和控制用户的日常生活',1,'D','无',4,'2023-04-03 13:46:07','数据库','',0,0,1,1),(22,'在网络边缘的端系统之间的通信方式通常可划分为两大类： 和 。',NULL,0,'客户/服务器方式;C/S方式、        对等方式;P2P方式','这是分析',4,'2023-11-05 13:46:08','计算机网络','',0,1,3,1),(25,'在早期无操作系统时代，下面关于人工操作方式的说法错误的是（ ）','A、用户独占全机，资源利用率低♞B、主机等待人工操作，cpu和内存利用率低♞C、人工速度慢，但智能化程度高♞D、脱机输入输出技术提高了cpu和I/O速度',1,'这是答案','这是分析',4,'2023-04-03 13:47:57','嘛/数','',0,0,1,1),(26,'马克思和恩格斯首次系统阐述历史唯物主义基本观点的著作?','A、用户独占全机，资源利用率低B、主机等待人工操作，cpu和内存利用率低',1,'A','A 选项，《德意志意识形态》是马克思、恩格斯对费尔巴哈为代表的各式各样唯心史观的思想进行批判的著作，该著作首次系统阐述了唯物史观的基本内容，标志着唯物史观的创立。\nB 选项，《神圣家族》是马克思和恩格斯第一次合写的批判青年黑格尔派主观唯心主义和论述历史唯物主义的著作。\nC 选项，《哲学的贫困》是为批判蒲鲁东的《贫困的哲学》而写的著作。该著作是马克思主义学说最早发表的文本。\nD 选项，《共产党宣言》发表于 1848 年，标志着马克思主义的公开问世。',3,'2023-11-07 17:49:30','马克思','',0,0,1,1),(27,'下列不属于操作系统目标的是（ ）','A、方便性♞B、有效性♞C、可扩充性♞D、开放性♞E、通用性',1,'E','无',4,'2023-04-03 21:01:46','马克期','',0,1,1,1),(28,'计算机网络是以能够相互共享资源的方式互联起来的 计算机系统的集合','',0,'自治','这是分析',4,'2023-11-03 21:02:18','','',0,1,2,1),(31,'The Impact of Artificial Intelligence on the Job Market','',0,'N/A (Open-ended question)','Artificial Intelligence (AI) is reshaping the job market by automating tasks and processes previously performed by humans. While AI brings efficiency and innovation, it also raises concerns about job displacement and the need for upskilling. The workforce of the future will require adaptability and new skill sets to thrive in an AI-driven economy.',2,'2023-10-26 23:55:49','期末','',0,0,2,1),(32,'The Process of Cellular Respiration','',0,'N/A (Open-ended question)','Cellular respiration is the process through which cells convert glucose and oxygen into energy',2,'2023-11-04 20:15:10',' and water. It occurs in three main stages: glycolysis','',0,1,3,1),(34,'The Influence of Art Movements on Modern Architecture','',0,'N/A (Open-ended question)','Various art movements',2,'2023-08-30 20:15:15',' Surrealism',' ',0,1,4,2),(36,'The Impact of Artificial Intelligence on the Job Market','',0,'N/A (Open-ended question)','Artificial Intelligence (AI) is reshaping the job market by automating tasks and processes previously performed by humans. While AI brings efficiency and innovation, it also raises concerns about job displacement and the need for upskilling. The workforce of the future will require adaptability and new skill sets to thrive in an AI-driven economy.',2,'2023-04-14 13:55:01','期末','',0,1,1,1),(37,'人们能从历史中汲取经验教训是因为','A.历史规律和自然规律有惊人的相似B.人类历史发展存在着不以人的意志为转移的规律C.历史总是在循环往复中不断向前发展D.人类已经完全掌握了历史发展的内在替身',1,'B','A 选项说法有误，历史规律与自然规律是不同的。自然规律起作用是自发的，离开了人的活动也同样起作用，而历史规律起作用离不开人的有有目的， 有意识的活动的参与。\nB 选项说法正确，人们之所以能从历史中汲取经验教训正是由于历史的发展有着不以人的意志为转移的规律，发挥能动性就能认识和把握这些规律。\nC 选项说法有误，事物的发展是波浪式前进和螺旋式上升的，是前进性与曲折性的统一，历史的发展同样如此，并不是循环往复的。\nD 选项说法有误，认识发展具有无限性和反复性，人类还没有完全掌握历史发展的内在规律。',3,'2023-11-05 01:24:49','历史','',0,0,2,1),(38,'从社会意识和社会存在的关系看，法律法规','A.总是阻碍新技术的健康发展♞B. 只能落后于新技术发展♞C. 与新技术发展具有不平衡性♞D. 归根到底是新技术发展的内在动力',1,'C','A 选项有误，法律法规作为并不总是阻碍新技术发展的，当法律法规适应了技术进步的要求就会对技术进步产生促进作用。\nB 选项有误，社会意识与社会存在的发展具有不平衡性，法律法规作为社会意识的一种特定类型，有时会早于技术发展的变迁而变化，有时会晚于技术发展而变化，并不总是落后于新技术发展。\nD 选项有误，法律法规的变化发展归根到底是受到生产力发展水平制约的。\n',3,'2023-11-02 11:08:37','法律法规','',0,0,2,1),(39,'What is the capital of Canada?','A.Ottawa♞B.Toronto♞C.Vancouver♞D.Montreal',1,'A','The capital of Canada is Ottawa, which is located in the province of Ontario.',2,'2023-04-17 11:08:59','','',0,1,2,1),(42,'若x+3=7x+3=7，则xx的值是多少？','A. 2♞B. 4♞C. 5♞D. 10',1,'B','将方程x+3=7x+3=7两边同时减去3，得到x=4x=4。',1,'2023-04-18 22:11:49','一次方程','',0,1,2,1),(43,'如果一个三角形的两边长分别为3和4，那么第三边的长可以是多少？','A. 2♞B. 5♞C. 6♞D. 7',1,'B',' 根据三角形两边之和大于第三边的性质，第三边的长度必须小于3+4=7，大于4-3=1。因此第三边的长度可以是任何大于1小于7的实数，所以选项B是正确答案。',1,'2023-04-18 22:12:37','几何','',0,1,1,1),(44,'马克思指出：资本主义在发展“社会劳动的生产力”的同时进而不自觉的创造着一种更高级的生产形式的物质条件，这表明：','A. 资本主义生产方式能够无限制解放和发展社会生产力♞B.资本越发展越有利于巩固资本主义♞C. 资本越扩张越不利于创造更多的物质财富♞D. 资本主义生产是一种历史的、过渡性生产形式',1,'D','A 选项有误，资本主义生产方式极大提高了生产力的水平，但不能由此就说，资本主义生产方式能够无限制解放发展生产力，随着生产力不断提高， 资本主义内生性矛盾会不断凸显，最终推动资本主义走向灭亡。\nB 选项有误，资本主义不断发展，资本主义内生性矛盾也不断凸显，最终会推动资本主义走向灭亡。\nC 选项有误，资本主义生产方式下，生产力得到极大释放，有利于创造更多的物质财富，但也会带来负面效应，如贫富两极分化等社会问题。\nD 选项正确，资本主义生产方式极大提高了生产力水平，随着生产力不断得到解放，资本主义的生产关系会越来越不适应生产力的发展，最终生产力与生产关系的矛盾运动会推动资本主义走向解体，人类社会会进入到更高级的社会形态——共产主义，因此说资本主义是一种过渡性的生产形式。\n',3,'2023-11-04 10:23:08','','',0,0,1,3),(45,'Who is the author of the novel \"Pride and Prejudice\"?','A. Jane Austen♞B. Charles Dickens♞C. Emily Brontë♞D. F. Scott Fitzgerald',1,'A','\"Pride and Prejudice\" was written by Jane Austen, a renowned English novelist.',2,'2023-04-19 00:25:38','','',0,1,2,1),(46,'What is the capital of Canada?','A. Ottawa♞B. Toronto♞C. Vancouver♞D. Montreal',1,'A','The capital of Canada is Ottawa, which is located in the province of Ontario.',2,'2023-04-28 16:58:51','','',0,1,1,1),(47,'TCP/IP协议包括网络接口层、网际层、运输层和（）。','A、 物理层♞B、表示层♞C、 会话层♞D、 应用层',1,'D','分析',4,'2023-04-19 16:59:24','计算机网络','',0,0,2,1),(48,'毛泽东思想作为马克思主义中国化的第一个重大理论成果，是由一系列相互联系的重要理论观点所构成的科学思想体系这一科学体系所围绕的主题是','A.中国革命和建设♞B.中国命运和前途♞C.中国社会性质和阶段状况♞D.中国改革和发展',1,'A','没有中国革命和建设的丰富实践，没有对中国革命和建设经验的深刻总结，就不可能有毛泽东思想。正是经过长期实践的反复比较，党和人民选择了毛泽东作为自己的领袖，选择了毛泽东思想作为自己的指导思想。中国共产党领导人民进行革命和建设的成功实践是毛泽东思想形成和发展的实践基础。毛泽东思想是被实践证明了的关于中国革命和建设的正确的理论原则和经验总结。故正确答案为 A。',3,'2023-11-04 17:37:49','毛泽东思想','',0,1,3,1),(49,'The Ethical Implications of Genetic Engineering','',0,'答案','Genetic engineering raises ethical questions concerning the alteration of genes in humans',2,'2023-10-30 20:18:31',' and plants. While it holds promise for medical advancements and agricultural improvements','',1,0,1,1),(51,'如图，正方体ABCD-EFGH的棱长为2，在正方形ABEF的内切圆上任取一点P1，在正方形BCGF的内切圆上任取一点P2，在正方形EFGH的内切圆上任取一点P3，求|P1 P2 |+|P2 P3 |+|P3 P1 |的最小值与最大值.','',0,'最小值为3√2-3，最大值为3√6.','无',1,'2023-04-28 12:01:14','立体几何','http://s38t0buqe.hn-bkt.clouddn.com/Screenshot%202023-10-29%20210247.png',0,0,1,1),(53,'题目','',0,'N/A (Open-ended question)','分析',2,'2023-10-27 00:41:37','','',0,0,1,2),(54,'asdfas','A.sdaf♞B.sdfa♞C.sdaf♞D.asdfa',1,'asdfasd','asdfasdf',2,'2023-05-07 15:46:33','标签1♞标签2','',0,0,1,1),(55,'sdfa','',0,'N/A (Open-ended question)','sadfsdf',2,'2023-05-07 15:48:35','标签1♞标签2','',0,0,1,1),(56,'牢固树立和认真落实科学发展观的重大意义是什么?','',0,'（1）科学发展观是我们党指导社会主义现代化建设的基本理论、基本路线、基本纲领和基本经验，是我们党执政理念的一个飞跃。\n\n（2）科学发展观对于我国建成完善的社会主义市场经济体制，实现全面建设小康社会进而实现现代化的宏伟目标，具有重大而深远的意义、基本路线、基本纲领和基本经验，是我们党执政理念的一个飞跃。','',3,'2023-11-04 15:51:42','科学发展观','',0,0,1,1),(57,'设有理数r=p/q∈(0,1)，其中p,q为互素的正整数，且pq整除3600.这样的有理数r的个数为________.','',0,'112','',1,'2023-11-04 15:52:15','标签1♞标签2','',0,0,1,1),(58,'Who is the author of the novel \"Pride and Prejudice\"?','A. Jane Austen♞B. Charles Dickens♞C. Emily Brontë♞D. F. Scott Fitzgerald',1,'A','\"Pride and Prejudice\" was written by Jane Austen, a renowned English novelist.',2,'2023-05-07 15:54:26','标签1♞标签2','',0,0,1,1),(59,'一颗质地均匀的正方体骰子，六个面上分别标有点数1,2,3,4,5,6.随机抛掷该骰子三次（各次抛掷结果相互独立），所得的点数依次为a1,a2,a3，则事件|a1-a2 |+|a2-a3 |+|a3-a1 |=6发生的概率为__________.','',0,'1/4','',1,'2023-11-03 16:00:29','标签1♞标签2','',0,0,1,1),(60,'1234','A.♞B.♞C.♞D.',1,'123','123',2,'2023-11-06 16:00:52','标签1♞标签2','',0,0,1,1),(61,'What is the capital of Canada?','A. Ottawa♞B. Toronto♞C. Vancouver♞D. Montreal',1,'A','The capital of Canada is Ottawa, which is located in the province of Ontario.',2,'2023-11-06 16:23:34','标签1♞标签2','',0,0,1,1),(62,'asdf','',0,'撒旦法','士大夫',2,'2023-05-07 21:45:44','标签1♞标签2','',0,0,1,1),(63,'撒旦法','',0,'撒旦法','是打法',2,'2023-05-07 22:13:17','标签1♞标签2','',0,1,1,1),(65,'asdfas','A.sdaf♞B.sdfa♞C.sdaf♞D.asdfa',1,'asdfasd','asdfasdf',2,'2023-10-27 15:46:33','标签1♞标签2','',0,1,1,1),(66,'sdfa','',0,'N/A (Open-ended question)','sadfsdf',2,'2023-05-07 15:48:35','标签1♞标签2','',0,1,1,1),(67,'简述邓小平理论形成的社会历史条件。','',0,'（1）邓小平理论是在时期主题转换和新技术革命浪潮兴起的历史条件下形成的。\n\n（2）邓小平理论是在总结中国和其他社会主义国家建设经验教训的基础上形成和发展起来的。\n\n（3）邓小平理论是在改革开放和社会主义现代化建设的实践过程中形成和发展起来的。','无',3,'2023-05-07 15:51:42','邓小平理论♞简答','',0,1,1,1),(68,'已知三角形ABC中，a=5,b=7,∠C=60∘a=5,b=7,∠C=60∘，求角B的大小。','',0,'角B的大小为60∘60∘.','利用正弦定理，asin⁡A=bsin⁡B=csin⁡CsinAa​=sinBb​=sinCc​，代入已知值，解得sin⁡B=7sin⁡60∘5=7310sinB=57sin60∘​=1073\n​​，所以B=arcsin⁡(7310)≈60∘B=arcsin(1073\n​​)≈60∘.',1,'2023-05-07 15:52:15','','',0,1,1,1),(69,'1','A.♞B.♞C.♞D.',1,'1','1',2,'2023-05-07 15:54:26','标签1♞标签2','',0,1,1,1),(70,'某地2019年底的人口为500万，按年均增长2%计算。请问到2025年底，该地的人口预计会达到多少？','',0,'2025年底预计人口为500×(1+0.02)6500×(1+0.02)6 ≈ 563.47563.47 万人。','利用复利公式，年均增长2%，六年后的人口为初始人口乘以1+0.021+0.02的6次方。',1,'2023-05-07 16:00:29','复利公式♞人口增长','',0,1,1,1),(71,'Who is the author of the novel \"Pride and Prejudice\"?','A. Jane Austen♞B. Charles Dickens♞C. Emily Brontë♞D. F. Scott Fitzgerald',1,'A','\"Pride and Prejudice\" was written by Jane Austen, a renowned English novelist.',2,'2023-05-07 16:00:52','标签1♞标签2','',0,1,1,1),(73,'asdf','',0,'撒旦法','士大夫',2,'2023-10-26 21:45:44','标签1♞标签2','',0,0,1,1),(74,'撒旦法（0分修改）水电费多少分水电费','',0,'撒旦法2水电费','是打法2',2,'2023-05-22 00:33:46','标签1♞标签2','',0,1,1,1),(75,'已知函数f(x)=x3−6x2+11x−6f(x)=x3−6x2+11x−6，求其在区间[1,5][1,5]上的最大值和最小值。','',0,'最大值为f(1)=0f(1)=0，最小值为f(3)=−6f(3)=−6。','求函数在区间端点和驻点处的函数值，比较得出最大值和最小值。',1,'2023-05-07 22:23:49','最大值♞最小值','',1,0,1,1),(76,'','',0,'','',2,'2023-05-21 01:22:55','撒旦法♞打法','',1,0,1,4),(77,'某班级有40人，其中男生占总人数的60%。如果女生的平均身高是165厘米，男生的平均身高是175厘米，求该班级的平均身高。','',0,'该班级的平均身高为(0.6×175+0.4×165)(0.6×175+0.4×165) cm = 171171 cm。',' 分别计算男生和女生的身高总和，然后按比例加权平均得到班级的平均身高。',1,'2023-05-22 00:38:14','平均数','',1,0,1,1),(78,'题目描述（修改2次）','A.选项1（改1）♞B.选项2（改2）♞C.选项3（改3）♞D.选项4（改4）',1,'题目解析2','个人理解2',2,'2023-05-21 01:22:02','水电费♞手动阀','',0,1,1,3),(79,'水电费','',0,'水电费','水电费',2,'2023-05-20 16:49:09','','',0,0,1,1),(80,'打法','',0,'是',' 是',2,'2023-05-20 17:13:12','手动阀','',0,0,1,4),(81,'已知无向图G 如下所示，使用克鲁斯卡尔(Kruskal) 算法求图G 的最小生成树，加入到最小生成树中的边依次是:','A.(b, f) (b, d) (a, e) (c, e) (b, e)♞B.(b,f)(b,d)(b,e)(a,e)(e,c)♞C.(a,e)(b,e)(c,e)(b,d) (b,f)♞D.(a,e)(c,e)(b,e)(b,f) (b,d)',1,'答案是A','暂无',4,'2023-05-22 10:54:58','数据结构','',0,0,1,5),(82,'计算机网络向用户提供的最重要的功能有两个，即数据通信和 ','',0,'资源共享',' 啥的',4,'2023-05-21 22:41:28','地方','',0,0,1,1),(83,'计算机网络是由负责信息传递的 子网和负责信息处理的 子网组成','',0,' 通信、资源','是 ',4,'2023-05-22 00:28:53','计网','',0,0,22,3),(84,'为什么说实事求是是马克思主义中国化各个理论成果的精髓？','',0,'所谓精髓，对于某一理论而言，指的是能使这一理论得以形成和发展并贯穿其始终，同时又体现在这一理论体系各个基本观点中的最本质的东西。马克思主义中国化的各个理论成果，其精髓都是实事求是。一方面，正是由于把握和运用了这个精髓，才有毛泽东思想、邓小平理论和“三个代表”重要思想的创立和发展，才有十六大以来的理论创新；另一方面，这个精髓，又体现在马克思主义中国化各个理论成果基本内容的各个方面。',' 无',3,'2023-05-22 10:22:02','实事求是♞马克思主义中国化','',0,0,1,1),(85,'新民主主义基本纲领的主要内容是什么？','',0,'新民主主义的政治纲领是建立一个无产阶级领导的，工农联盟为基础的，一切反帝反封建的人们联合专政的新民主主义共和国。\n\n新民主主义三大经济纲领： 没收封建阶级的土地归农民所有；没收官僚资产阶级的垄断资本归新民主主义国家所有，保护民族工商业。\n\n新民主主义的文化纲领：无产阶级领导的人民大众的反帝反封建的文化，民族的、科学的、大众的文化。',' 无',3,'2023-05-22 10:22:24','新民主主义♞基本纲领','',0,0,1,1),(86,'计算机网络向用户提供的最重要的功能有两个，即数据通信和 ','',0,'资源共享','是的',4,'2023-05-22 10:53:50','计算机网络','',0,1,22,4),(87,'Who is the author of the novel \"Pride and Prejudice\"?','A. Jane Austen♞B. Charles Dickens♞C. Emily Brontë♞D. F. Scott Fitzgerald',1,'A','\"Pride and Prejudice\" was written by Jane Austen, a renowned English novelist.',2,'2023-10-29 12:06:54','软件工程♞经济学','',0,1,1,1),(88,'下列关于操作系统的作用错误的是（ ）','A、作为用户与计算机硬件系统之间的接口♞B、作为计算机系统资源的管理者♞C、实现对计算机资源的抽象♞D、管理和控制用户的日常生活',1,'D','无',4,'2023-10-29 12:09:12','操作系统','',0,1,1,1),(89,'下列不属于操作系统目标的是（ ）','A、方便性♞B、有效性♞C、可扩充性♞D、开放性♞E、通用性',1,'E','无',4,'2023-10-29 12:09:13','操作系统','',0,1,1,1),(90,'构建新发展格局，是以习近平同志为核心的党中央积极应对国际国内形势变化，与时俱进提升我国经济发展水平，塑造国际经济全球和竞争新优势提出的战略决策，这一发展格局是','A.以体制机制创新为主体，利用好国际国内两个市场♞B.以维护和平稳定为主体，促进国际国内经济复苏♞C.以国内大循环为主体，国内国际双循环相互促进♞D.以发展先进制造业为主体，促进产业结构优化升级',1,'C','新发展格局是以国内大循环为主体、国内国际双循环相互促进的发展格局，绝不是封闭的国内循环，而是更加开放的国内国际双循环。故正确答案为 C。',3,'2023-10-29 12:09:14','发展格局','',0,1,1,1),(91,'改革开放初期，确立了公有制为主体的市场经济，多种所有制公共发展，按劳分配为主体，多种分配制度并存，社会市场经济制度等社会主义基本经济制度，这一基本经济制度中，坚持公有制的主体地位是因为','A.公有制是社会主义市场经济的重要组成部分♞B.公有制是我国经济社会发展的重要基础♞C. 生产资料所有制决定社会的基本性质和发展方向♞D. 由生产资料所有制决定的分配方式能使一切社会成员实现全面发展',1,'C','之所以要坚持公有制的主体地位，是因为生产资料社会主义公有制是社会主义经济制度的基础，是社会主义经济制度的根本标志，它决定了我国社会主义的基本性质和发展方向，只有建立起社会主义公有制并使其在多种所有制经济中居于主体地位，才标志着社会主义经济制度真正建立起来。要坚持社会主义， 必须坚持生产资料公有制;在社会主义初级阶段，必须坚持公有制的主体地位。故正确答案为 C。',3,'2023-10-29 12:09:15','公有制','',0,1,1,1),(92,'','A. Ottawa♞B. Toronto♞C. Vancouver♞D. Montreal',1,'A','The capital of Canada is Ottawa, which is located in the province of Ontario.',2,'2023-11-02 00:01:08','数学♞经济学','',0,1,1,3),(93,'What is the capital of Canada?','A.Ottawa♞B.Toronto♞C.Vancouver♞D.Montreal',1,'A','The capital of Canada is Ottawa, which is located in the province of Ontario.',2,'2023-10-29 12:09:23','数学♞经济学','',0,1,1,1),(94,'如果一个长方形的长度是3x3x，宽度是2x2x，那么它的面积是多少？','A. 6x26x2♞B. 5x25x2♞C. x2x2♞D. 12x12x',1,'A','长方形的面积等于长度乘以宽度，所以面积为(3x)(2x)=6x2(3x)(2x)=6x2。',1,'2023-10-29 12:56:33','面积','',0,0,1,1),(95,'如果aa、bb和cc是正整数，且a2+b2=c2a2+b2=c2，那么这组整数aa、bb、cc是否可以构成一个直角三角形？','A. 可以♞B. 不可以',1,'A','这组整数满足勾股定理，所以可以构成一个直角三角形。',1,'2023-10-29 12:56:34','勾股定理','',0,1,1,1),(96,'已知一个等差数列的前nn项和为Sn=2n2+3nSn​=2n2+3n，则该数列的第nn项是：','A. 2n+32n+3♞B. 3n2+2n3n2+2n♞C. 2n2+3n2n2+3n♞D. n2+3nn2+3n',1,'D',' 使用等差数列的前nn项和公式n2[2a+(n−1)d]2n​[2a+(n−1)d]，将SnSn​与等差数列的前nn项和公式进行比较，解出aa和dd，然后求第nn项。',1,'2023-10-29 12:56:55','数列','',0,1,1,1),(97,'创新是引领发展的第一动力，必须把创新摆在现代化建设全面的核心地位。2020 年 9 月 11 日，习近平在《科学家座谈上讲话》中指出我国经济发展及改善民生比以往任何时候都需要加强创新这个第一动力，创造更多从“0” 到“1”的突破，需要摆在更加突出位置的是','A. 提升原始创新能力♞B. 加快推进消化吸收再创新♞C.加强了企业创新主体地位♞D.改善科技创新',1,'A','无',3,'2023-10-30 11:13:22','创新','',0,1,1,1),(99,'English','A.♞B.♞C.♞D.',1,'','',2,'2023-10-30 20:17:25','','',0,1,1,3),(100,'网卡实现的主要功能是？','A.物理层与数据链路层的功能♞B.数据链路层与网络层的功能♞C.网络层与传输层的功能♞D.传输层与应用层的功能',1,'A\n网卡实现数据的封装与解封，链路管理，编码与译码功能。 \n网卡工作在数据链路层， 但也可以向下兼容物理层。','',1,'2023-10-30 20:50:34','','http://s38t0buqe.hn-bkt.clouddn.com/code/duck/2023-10-30-ba244d954dc9463da4d1933340d9b089.png',0,1,1,1),(101,'模式串的长度是m，主串的长度是n（m<n），使用KMP算法匹配的时间复杂度是（）？','A.O(m+n)♞B.O(m∙n)♞C.O(m∙log2n)♞D.O(n∙log2m)',1,'A','',4,'2023-10-31 21:42:05','','',0,0,1,1),(102,'地图','',0,'','',4,'2023-10-31 22:13:35','','http://s38t0buqe.hn-bkt.clouddn.com/code/duck/2023-10-31-fe93c2c9bf9c473f9111865c9d156f0e.png',0,0,1,1),(103,'','',0,'','',3,'2023-10-31 22:21:29','','http://s38t0buqe.hn-bkt.clouddn.com/code/duck/2023-10-31-3772aa91adc24ed7adab4a981c5ef099.png',0,0,1,1),(104,'321','A.♞B.♞C.♞D.',1,'','',2,'2023-11-03 09:28:24','','',0,0,1,1),(105,'111','A.♞B.♞C.♞D.',1,'','',2,'2023-11-08 10:56:21','','',0,0,1,1);

/*Table structure for table `question_note` */

DROP TABLE IF EXISTS `question_note`;

CREATE TABLE `question_note` (
  `questionid` int(11) NOT NULL,
  `notename` varchar(50) NOT NULL,
  `inrecycle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `question_note` */

insert  into `question_note`(`questionid`,`notename`,`inrecycle`) values (97,'数据库',0),(97,'数据结构',0),(98,'数据库',0),(98,'软件工程',0),(99,'数据库',0),(99,'软件工程',0),(102,'1',0),(103,'1',0),(104,'1',0),(105,'1',0),(107,'1',0),(109,'1',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
