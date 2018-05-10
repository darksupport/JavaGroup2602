CREATE DATABASE  IF NOT EXISTS `sockdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sockdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sockdb
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `sock_types`
--

DROP TABLE IF EXISTS `sock_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sock_types` (
  `id_sock_types` int(11) NOT NULL AUTO_INCREMENT,
  `type_sock_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id_sock_types`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sock_types`
--

LOCK TABLES `sock_types` WRITE;
/*!40000 ALTER TABLE `sock_types` DISABLE KEYS */;
INSERT INTO `sock_types` VALUES (1,'Warm'),(2,'Sport'),(3,'Casual'),(4,'Summer'),(5,'Light');
/*!40000 ALTER TABLE `sock_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socks`
--

DROP TABLE IF EXISTS `socks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socks` (
  `id_socks` int(11) NOT NULL AUTO_INCREMENT,
  `color_socks` varchar(45) NOT NULL,
  `size_socks` int(10) unsigned NOT NULL,
  `type_socks` int(11) NOT NULL,
  PRIMARY KEY (`id_socks`),
  KEY `sock_types_idx` (`type_socks`),
  CONSTRAINT `sock_types` FOREIGN KEY (`type_socks`) REFERENCES `sock_types` (`id_sock_types`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Sock data.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socks`
--

LOCK TABLES `socks` WRITE;
/*!40000 ALTER TABLE `socks` DISABLE KEYS */;
INSERT INTO `socks` VALUES (1,'White',10,1),(2,'Black',20,2),(3,'Black',10,1),(4,'Green',20,3),(6,'Gray',33,1);
/*!40000 ALTER TABLE `socks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-10 17:37:23
