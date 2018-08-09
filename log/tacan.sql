# Host: LOCALHOST  (Version: 5.5.15)
# Date: 2018-08-09 18:15:32
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "category"
#

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (7,'财经'),(17,'军事'),(22,'招聘'),(26,'博客');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

#
# Structure for table "hibernate_sequence"
#

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "hibernate_sequence"
#

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (27),(27),(27);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

#
# Structure for table "role_permission"
#

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `r_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  KEY `FKti38e958bdjlf6gn1dhw62hd7` (`p_id`),
  KEY `FKr84nsavm9txr6cnobstm2hu1l` (`r_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "role_permission"
#

/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES (5,6);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;

#
# Structure for table "t_permission"
#

DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "t_permission"
#

/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` VALUES (6,'admin:*','/**');
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;

#
# Structure for table "t_role"
#

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "t_role"
#

/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (5,'超级管理员','admin');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;

#
# Structure for table "t_user"
#

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "t_user"
#

/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (4,'498336692@qq.com','327daeaa239056e74ce48cc347fb327a','admin');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

#
# Structure for table "urlsite"
#

DROP TABLE IF EXISTS `urlsite`;
CREATE TABLE `urlsite` (
  `id` int(11) NOT NULL,
  `sitename` varchar(255) DEFAULT NULL,
  `siteurl` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqplbgkyv3twxf75i26tiq9kng` (`c_id`),
  KEY `FKlx7qv30ed6jtvp2gr06e0mkei` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "urlsite"
#

/*!40000 ALTER TABLE `urlsite` DISABLE KEYS */;
INSERT INTO `urlsite` VALUES (9,'编程否','http://www.bcfou.com',1,7,7);
/*!40000 ALTER TABLE `urlsite` ENABLE KEYS */;

#
# Structure for table "user_role"
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `u_id` int(11) NOT NULL,
  `r_id` int(11) NOT NULL,
  KEY `FKkdimolbxhgalocs1k1jg9to6v` (`r_id`),
  KEY `FK90k2unqj313clpg00nb77ci52` (`u_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "user_role"
#

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (4,5);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

#
# Structure for table "visitor"
#

DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `id` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj4jqe6v3ucm3812ivmfiybn05` (`u_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "visitor"
#

/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
INSERT INTO `visitor` VALUES (20,100004,9);
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;

#
# Structure for table "website"
#

DROP TABLE IF EXISTS `website`;
CREATE TABLE `website` (
  `id` int(11) NOT NULL,
  `webdescribe` varchar(255) DEFAULT NULL,
  `webname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

#
# Data for table "website"
#

/*!40000 ALTER TABLE `website` DISABLE KEYS */;
INSERT INTO `website` VALUES (8,'专注精准导航系统','hao123网址导航');
/*!40000 ALTER TABLE `website` ENABLE KEYS */;
