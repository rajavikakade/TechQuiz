CREATE DATABASE  IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `project`;
-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `College` varchar(45) NOT NULL,
  `Year` varchar(3) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'harveyspectre@pearsonhardman.com','mikeross69','Harvey Spectre','Harvard Law School','FE'),(2,'mikeross@gmail.com','harvey123','Mike Ross','Harvard Law School','TE'),(3,'shishir.rcj@gmail.com','1monomial///','Shishir Jha','Pune Institute of Computer Technology','BE'),(4,'tamhankarpriyanka9@gmail.com','pritam99','Priyanka Tamhankar','Pune Institute of Computer Technology','TE'),(6,'kakaderajavi22@gmail.com','123456','Rajavi Kakade','Pune Institute of Computer Technology','TE');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marks` (
  `TestID` int(11) NOT NULL AUTO_INCREMENT,
  `Marks` varchar(45) DEFAULT NULL,
  `Date_Time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Student_ID` int(11) NOT NULL,
  PRIMARY KEY (`TestID`),
  KEY `Student_ID_idx` (`Student_ID`),
  CONSTRAINT `Student_ID` FOREIGN KEY (`Student_ID`) REFERENCES `login` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,'12','2020-08-24 10:04:48',3),(4,'14','2020-08-24 10:05:45',3),(5,'10','2020-08-24 10:45:01',3),(6,'10','2020-08-24 10:46:47',3),(7,'14','2020-08-25 11:34:58',3),(8,'4','2020-08-26 09:27:26',3),(9,'14','2020-08-26 09:28:59',3),(10,'14','2020-08-27 10:58:52',3),(11,'12','2020-08-27 11:46:36',6);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionbank`
--

DROP TABLE IF EXISTS `questionbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `questionbank` (
  `QNO` int(11) NOT NULL,
  `QUESTION` varchar(500) DEFAULT NULL,
  `OP1` varchar(200) DEFAULT NULL,
  `OP2` varchar(200) DEFAULT NULL,
  `OP3` varchar(200) DEFAULT NULL,
  `OP4` varchar(200) DEFAULT NULL,
  `ANS` varchar(200) DEFAULT NULL,
  `TOPIC` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`QNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionbank`
--

LOCK TABLES `questionbank` WRITE;
/*!40000 ALTER TABLE `questionbank` DISABLE KEYS */;
INSERT INTO `questionbank` VALUES (1,'In C language, if a function return type is not explicitly defined then it defaults to what data type?',' void',' int',' Double',' No return type','int','OOP'),(2,'What is the worst case time complexity of linear search algorithm?','Ο(1)','Ο(n)','Ο(logn)','Ο(n2)','Ο(n2)','DSA'),(3,'What data structure is used for breadth first traversal of a graph?','queue','stack','list','none of these','queue','DSA'),(4,'Which of the following is an example of dynamic programming approach?','Fibonacci Series','Tower of Hanoi','Dijkstra Shortest Path',' All of the above',' All of the above','DSA'),(5,'Maximum degree of any vertex in a simple graph of vertices n is','-2n-1','-n','-n+1','-n-1','-n-1','DSA'),(6,'Apriory algorithm analysis does not include −','Time Complexity','Space Complexity','Program Complexity','none of these','Program Complexity','DSA'),(7,'Which of the below mentioned sorting algorithms are not stable?','Selection Sort','Bubble Sort','Merge Sort','Insertion Sort','Selection Sort','DSA'),(8,'Which of these alogrithmic approach tries to achieve localized optimum solution −','Greedy approach',' Divide and conquer approach',' Dynamic approach','All of the above','Greedy approach','DSA'),(9,' In C programming, when we remove an item from bottom of the stack, then −','The stack will fall down.','Stack will rearranged items.','It will convert to LIFO','This operation is not allowed.','Stack will rearranged items.','DSA'),(10,'The following sorting algorithms maintain two sub-lists, one sorted and one to be sorted −','Selection Sort','Insertion Sort','Merge Sort','both A & B','both A & B','DSA'),(11,'Aposterior analysis are more accurate than apriori analysis because −','it contains the real data.',' it assumes all other factors to be dynamic.','it assumes all other factors to be constant.',' it is a result of reverse-engineering.',' it assumes all other factors to be dynamic.','DSA'),(12,'A relational database consists of a collection of','Tables','Fields','Records','Keys','Tables','DBMS'),(13,'A ________ in a table represents a relationship among a set of values.',' Column','Key','Row','Entry','Row','DBMS'),(14,'The term _______ is used to refer to a row.','Attribute','Tuple','Field',' Instance','Tuple','DBMS'),(15,' The term attribute refers to a ___________ of a table.',' Record','Column','Tuple','Key','Column','DBMS'),(16,'For each attribute of a relation, there is a set of permitted values, called the ________ of that attribute.',' Domain','Relation',' Set','Schema',' Domain','DBMS'),(17,'Database __________ which is the logical design of the database, and the database _______ which is a snapshot of the data in the database at a given instant in time.','Instance, Schema','Relation, Schema',' Relation, Domain','Schema, Instance','Schema, Instance','DBMS'),(18,'A domain is atomic if elements of the domain are considered to be ____________ units.','Different',' Indivisbile','Constant','Divisible',' Indivisbile','DBMS'),(19,'The tuples of the relations can be of ________ order.',' Any',' Same','Sorted','Constant',' Any','DBMS'),(20,'Which one of the following is used to define the structure of the relation, deleting relations and relating schemas?','DML(Data Manipulation Langauge)','DDL(Data Definition Langauge)','Query','Relational Schema','DDL(Data Definition Langauge)','DBMS'),(21,' The basic data type char(n) is a _____ length character string and varchar(n) is _____ length character.','Fixed, equal','Equal, variable','Fixed, variable','Variable, equal','Fixed, variable','DBMS'),(22,'An attribute A of datatype varchar(20) has the value “Avi”. The attribute B of datatype char(20) has value ”Reed”. Here attribute A has ____ spaces and attribute B has ____ spaces.',' 3, 20','20, 4','20, 20','3,4',' 3, 20','DBMS'),(23,'To remove a relation from an SQL database, we use the ______ command.','Delete','Purge',' Remove','Drop table','Drop table','DBMS'),(24,'Updates that violate __________ are disallowed.',' Integrity constraints','Transaction control','Authorization','DDL constraints',' Integrity constraints','DBMS'),(25,'Which of the following is a fundamental operation in relational algebra?','Set intersection','Natural join',' Assignment','None of the mentioned','None of the mentioned','DBMS'),(26,' For select operation the ________ appear in the subscript and the ___________ argument appears in the paranthesis after the sigma.',' Pi (Greek)',' Sigma (Greek)','Lambda (Greek)','Omega (Greek)',' Sigma (Greek)','DBMS'),(27,NULL,NULL,NULL,NULL,NULL,NULL,''),(28,NULL,NULL,NULL,NULL,NULL,NULL,''),(29,NULL,NULL,NULL,NULL,NULL,NULL,''),(30,NULL,NULL,NULL,NULL,NULL,NULL,''),(31,NULL,NULL,NULL,NULL,NULL,NULL,''),(32,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(48,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(49,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `questionbank` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-27 17:43:11
