CREATE DATABASE  IF NOT EXISTS `airline` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `airline`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: airline
-- ------------------------------------------------------
-- Server version	5.7.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `crew` (
  `crew_id` int(11) NOT NULL AUTO_INCREMENT,
  `crew_employee` int(11) NOT NULL,
  `crew_flight` int(11) NOT NULL,
  PRIMARY KEY (`crew_id`),
  KEY `fk_crew_employee_idx` (`crew_employee`),
  KEY `fk_crew_flight_idx` (`crew_flight`),
  CONSTRAINT `fk_crew_employee` FOREIGN KEY (`crew_employee`) REFERENCES `employees` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_crew_flight` FOREIGN KEY (`crew_flight`) REFERENCES `flights` (`flight_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew`
--

LOCK TABLES `crew` WRITE;
/*!40000 ALTER TABLE `crew` DISABLE KEYS */;
INSERT INTO `crew` VALUES (8,1,1),(38,2,1),(39,5,1),(40,6,1),(41,7,1),(42,4,1),(43,5,2),(44,8,2),(46,6,2),(47,4,2),(48,10,2);
/*!40000 ALTER TABLE `crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_surname` varchar(45) NOT NULL,
  `employee_firstname` varchar(45) NOT NULL,
  `employee_occupation` set('pilot','navigator','radio_operator','stewardess') NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Pertseva','Veronika','pilot'),(2,'Гредасов','Максим','pilot'),(4,'Застоева','Ольга','stewardess'),(5,'Malinin','Oleg','pilot'),(6,'Kindra','Mickey','radio_operator'),(7,'Labodeva','Anastasiya','navigator'),(8,'Gredasov','Ignat','pilot'),(10,'Tunic','Roman','navigator'),(11,'Morgun','Ilya','radio_operator'),(13,'Levicheva','Arina','stewardess'),(14,'Grigoreva','Svetlana','stewardess');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flights` (
  `flight_id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_number` varchar(20) NOT NULL,
  `flight_name` varchar(45) NOT NULL,
  `flight_city_from` varchar(45) NOT NULL,
  `flight_city_to` varchar(45) NOT NULL,
  `flight_date_departure` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flight_date_arrival` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flight_status` set('boarding','cancelled','check_in','scheduled','delayed','departed','gate_open','gate_closing','gate_closed','without_status') NOT NULL,
  PRIMARY KEY (`flight_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,'PS2458','To summer','Kiev','Sharm','2018-11-11 21:57:56','2018-11-11 21:57:56','scheduled'),(2,'SA3610','Fast flight','Sharm','Ankara','2018-11-11 21:58:08','2018-11-11 21:58:08','delayed'),(3,'AK7825','Home','Ankara','Kiev','2018-11-15 09:27:23','2018-11-15 16:12:00','without_status'),(5,'MD2512','Веселый полет','Berlin','London','2018-11-25 14:00:00','2018-11-25 16:00:00','without_status'),(6,'GT5863','Good tour','Paris','Kiev','2018-11-30 14:00:00','2018-11-30 16:00:00','without_status');
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requests` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `request_user` int(11) NOT NULL,
  `request_flight` int(11) NOT NULL,
  `request_topic` varchar(100) NOT NULL,
  `request_message` varchar(300) DEFAULT NULL,
  `request_date` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `request_status` set('awaiting','done','rejected') NOT NULL,
  PRIMARY KEY (`request_id`),
  KEY `fk_application_flight_idx` (`request_flight`),
  KEY `fk_application_user_idx` (`request_user`),
  CONSTRAINT `fk_request_flight` FOREIGN KEY (`request_flight`) REFERENCES `flights` (`flight_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_request_user` FOREIGN KEY (`request_user`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES (1,1,3,'Problem with pilots','There are not available pilots for the flight','2018-11-08 17:57:08.169','rejected'),(2,1,1,'Stewardesses','I need two stewardesses for the flight.','2018-11-11 21:32:46.319','done'),(4,1,3,'Problem with pilots','There are not available pilots for the flight','2018-11-11 21:32:46.341','awaiting'),(5,1,2,'Flight','I can\'t form the crew.','2018-11-11 21:32:46.341','awaiting');
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_role` set('dispatcher','administrator') NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2507950@gmail.com','35e7b2a3d597628359b08fb7e2806c2b','dispatcher'),(2,'123@gmail.com','35e7b2a3d597628359b08fb7e2806c2b','administrator');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12  0:22:00
