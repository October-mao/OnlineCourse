-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.17 - MySQL Community Server - GPL
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_select_course
CREATE DATABASE IF NOT EXISTS `db_select_course` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_select_course`;

-- Dumping structure for table db_select_course.course
CREATE TABLE IF NOT EXISTS `course` (
  `CNo` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(30) NOT NULL,
  `Ccredit` float(5,1) DEFAULT '0.0',
  PRIMARY KEY (`CNo`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Dumping data for table db_select_course.course: ~14 rows (大约)
DELETE FROM `course`;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`CNo`, `Cname`, `Ccredit`) VALUES
	(1, '数学', 3.0),
	(2, '大学英语', 3.0),
	(3, 'JAVA程序设计', 5.0),
	(4, '计算机网络', 2.5),
	(5, '数据结构', 4.0),
	(6, '大学物理', 3.5),
	(7, 'PHP程序设计', 4.0),
	(8, '网页设计', 3.5),
	(9, 'Android程序设计', 5.0),
	(10, '生物制药', 2.0),
	(11, '诗歌鉴赏', 1.5),
	(12, 'MySQL数据库', 3.0),
	(13, '牛猛在线教育', 3.0),
	(32, '12124', 1241.0);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for table db_select_course.sc
CREATE TABLE IF NOT EXISTS `sc` (
  `SNo` int(11) NOT NULL,
  `CNo` int(11) NOT NULL,
  `classroom` varchar(11) DEFAULT '0.0',
  KEY `FK_sc_course` (`CNo`),
  KEY `FK_sc_student` (`SNo`),
  CONSTRAINT `FK_sc_course` FOREIGN KEY (`CNo`) REFERENCES `course` (`CNo`) ON UPDATE CASCADE,
  CONSTRAINT `FK_sc_student` FOREIGN KEY (`SNo`) REFERENCES `student` (`SNo`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table db_select_course.sc: ~19 rows (大约)
DELETE FROM `sc`;
/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
INSERT INTO `sc` (`SNo`, `CNo`, `classroom`) VALUES
	(1, 3, '401'),
	(1514010919, 4, '505'),
	(1514010922, 2, '206'),
	(1514010922, 8, '205'),
	(1514010924, 1, '208'),
	(1514010924, 4, '107'),
	(1514010924, 5, '506'),
	(1514010924, 6, '402'),
	(1514010926, 2, '108'),
	(1514010927, 1, '211'),
	(1514010927, 4, '301'),
	(1514010928, 5, '406'),
	(1514010928, 8, '101'),
	(2222, 3, '203'),
	(2222, 4, '205'),
	(2222, 5, '208'),
	(1514010948, 1, '209'),
	(1514010948, 2, '205'),
	(1514010948, 3, '207');
/*!40000 ALTER TABLE `sc` ENABLE KEYS */;

-- Dumping structure for table db_select_course.student
CREATE TABLE IF NOT EXISTS `student` (
  `SNo` int(11) NOT NULL AUTO_INCREMENT,
  `Sname` varchar(30) NOT NULL,
  `Spassword` varchar(30) NOT NULL,
  `Sclass` varchar(30) DEFAULT '',
  `Ssex` varchar(10) DEFAULT '',
  `PublishTime` varchar(30) DEFAULT NULL,
  `Photo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1514010979 DEFAULT CHARSET=utf8;

-- Dumping data for table db_select_course.student: ~14 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`SNo`, `Sname`, `Spassword`, `Sclass`, `Ssex`, `PublishTime`, `Photo`) VALUES
	(1, '呆呆', '0', 'class1', '男', '2019-12-3', 'photo1.jpg'),
	(2222, '小二', '222222', 'class3', '女', '2019-12-11', 'touxiang.png'),
	(1514010919, '刘琪', '123456', 'class3', '女', '2019-12-11', 'touxiang.png'),
	(1514010922, '二狗子', '888999', 'class3', '男', '2019-12-11', 'photo4.jpg'),
	(1514010924, '于强', '456789', 'class1', '男', '2019-12-11', 'touxiang.png'),
	(1514010926, '张三', '111222', 'class3', '男', '2019-12-11', 'photo4.jpg'),
	(1514010927, '李欧思', '222666', 'class1', '女', '2019-12-11', 'touxiang.png'),
	(1514010928, '安慕希', '166166', 'class2', '女', '2019-12-11', 'photo4.jpg'),
	(1514010929, '无芯', '166520', 'class2', '女', '2019-12-11', 'touxiang.png'),
	(1514010930, '卡娜', 'kana', 'class1', '女', '2019-12-11', 'photo4.jpg'),
	(1514010945, '牛猛', '1234', 'class3', '男', '2019-12-11', 'touxiang.png'),
	(1514010946, 'asds', '1234', '124', '12', '2019-12-11', 'photo4.jpg'),
	(1514010948, '阿航', '1234', '1', '女', '2019-12-12', 'photo1.jpg'),
	(1514010974, '阿萨法', '1234', '1', '男', '2019-12-19', 'photo2.jpg');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table db_select_course.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `TNo` int(11) NOT NULL AUTO_INCREMENT,
  `Tname` varchar(30) DEFAULT NULL,
  `Tpassword` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TNo`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

-- Dumping data for table db_select_course.teacher: ~3 rows (大约)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`TNo`, `Tname`, `Tpassword`) VALUES
	(111, 'tom', '123'),
	(112, 'Lisa', '456'),
	(113, 'admin', 'admin');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
