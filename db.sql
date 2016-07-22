-- MySQL dump 10.13  Distrib 5.5.40, for Win64 (x86)
--
-- Host: localhost    Database: web_j_db
-- ------------------------------------------------------
-- Server version       5.5.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `userid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(258) NOT NULL,
  `profileid` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'user','04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb',NULL),(2,'admin','8c6976e5b5410415bde908bd4
ee15dfb167a9c873fc4bb8a81f6f2ab448a918',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activefeed`
--

DROP TABLE IF EXISTS `activefeed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activefeed` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `imgUrl` varchar(200) DEFAULT NULL,
  `profileID` varchar(150) DEFAULT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activefeed`
--

LOCK TABLES `activefeed` WRITE;
/*!40000 ALTER TABLE `activefeed` DISABLE KEYS */;
INSERT INTO `activefeed` VALUES (1,'Amit',24,'https://placehold.it/40x40','04f8996da763b7a969b1028ee3007569eaf3a635486==','Rameshwarm',NULL),(2,'Moha
',25,'https://placehold.it/40x40','04f8996da763b7a969b1028ee3007569eaf3a635486==','neha',NULL),(3,'Laxman',16,'https://placehold.it/40x40','04f8996da
63b7a969b1028ee3007569eaf3a635486==','Rameshwarm',NULL),(4,'Sunil',26,'https://placehold.it/40x40','04f8996da763b7a969b1028ee3007569eaf3a635486==','L
tika',NULL),(5,'raghav',78,'https://placehold.it/40x40','04f8996da763b7a969b1028ee3007569eaf3a635486==','Lekhak',NULL),(6,'nitish Kumar Yadeve',45,'h
tps://placehold.it/40x40','04f8996da763b7a969b1028ee3007569eaf3a635486==','Laxaman',NULL),(7,'Latika Joshi',19,'https://placehold.it/40x40','04f8996d
763b7a969b1028ee3007569eaf3a635486==','Yogendra',NULL),(8,'Mahima Chaudhary',21,'https://placehold.it/40x40','04f8996da763b7a969b1028ee3007569eaf3a63
486==','Jeewan',NULL),(9,'raghav',78,'https://placehold.it/40x40','04f8996da763b7a969b1028ee3007569eaf3a635486==',NULL,NULL),(10,'nitish Kumar Yadeve
,45,'https://placehold.it/40x40','04f8996da763b7a969b1028ee3007569eaf3a635486==','Jogendra',NULL),(11,'Latika Joshi',19,'https://placehold.it/40x40',
04f8996da763b7a969b1028ee3007569eaf3a635486==','Komal',NULL),(12,'Mahima Chaudhary',21,'https://placehold.it/40x40','04f8996da763b7a969b1028ee3007569
af3a635486==','Kishor',NULL);
/*!40000 ALTER TABLE `activefeed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userappointdetail`
--

DROP TABLE IF EXISTS `userappointdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userappointdetail` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT,
  `userid` bigint(18) DEFAULT NULL,
  `appdate` date DEFAULT NULL,
  `attachement` varchar(1000) DEFAULT NULL,
  `notes` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `userappointdetail_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `userprofile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userappointdetail`
--

LOCK TABLES `userappointdetail` WRITE;
/*!40000 ALTER TABLE `userappointdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `userappointdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userprofile`
--

DROP TABLE IF EXISTS `userprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userprofile` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `age` int(3) NOT NULL,
  `imgUrl` varchar(300) DEFAULT NULL,
  `profileid` varchar(300) DEFAULT NULL,
  `lvisitdate` date DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `zip` int(10) unsigned DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `countrycode` int(10) unsigned DEFAULT NULL,
  `msisdn` bigint(10) unsigned DEFAULT NULL,
  `statecode` int(4) unsigned DEFAULT NULL,
  `town` varchar(400) DEFAULT NULL,
  `nextvisitdate` date DEFAULT NULL,
  `status` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userprofile`
--

LOCK TABLES `userprofile` WRITE;
/*!40000 ALTER TABLE `userprofile` DISABLE KEYS */;
INSERT INTO `userprofile` VALUES (1,'sunil','singh',27,'sirsa',NULL,'2016-08-20','madhya pradesh','gwalier',30001,'india',91,9000000000,NULL,'014',NU
L,NULL);
/*!40000 ALTER TABLE `userprofile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-22  9:37:52