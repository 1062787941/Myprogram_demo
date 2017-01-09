/*
SQLyog v10.2 
MySQL - 5.0.87-community-nt : Database - books
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `books`;

/*Table structure for table `authorisbn` */

DROP TABLE IF EXISTS `authorisbn`;

CREATE TABLE `authorisbn` (
  `authorID` int(11) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  KEY `fk_authorISBN_1` (`authorID`),
  KEY `fk_authorISBN_2` (`isbn`),
  CONSTRAINT `fk_authorISBN_1` FOREIGN KEY (`authorID`) REFERENCES `authors` (`authorID`),
  CONSTRAINT `fk_authorISBN_2` FOREIGN KEY (`isbn`) REFERENCES `titles` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `authorisbn` */

insert  into `authorisbn`(`authorID`,`isbn`) values (1,'0130895725'),(1,'0132261197'),(1,'0130895717'),(1,'0135289106'),(1,'0139163050'),(1,'013028419x'),(1,'0130161438'),(1,'0130856118'),(1,'0130125075'),(1,'0138993947'),(1,'0130852473'),(1,'0130829277'),(1,'0134569555'),(1,'0130829293'),(1,'0130284173'),(1,'0130284181'),(1,'0130895601'),(2,'0130895725'),(2,'0132261197'),(2,'0130895717'),(2,'0135289106'),(2,'0139163050'),(2,'013028419x'),(2,'0130161438'),(2,'0130856118'),(2,'0130125075'),(2,'0138993947'),(2,'0130852473'),(2,'0130829277'),(2,'0134569555'),(2,'0130829293'),(2,'0130284173'),(2,'0130284181'),(2,'0130895601'),(3,'013028419x'),(3,'0130161438'),(3,'0130856118'),(3,'0134569555'),(3,'0130829293'),(3,'0130284173'),(3,'0130284181'),(4,'0130895601');

/*Table structure for table `authors` */

DROP TABLE IF EXISTS `authors`;

CREATE TABLE `authors` (
  `authorID` int(11) NOT NULL auto_increment,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  PRIMARY KEY  (`authorID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `authors` */

insert  into `authors`(`authorID`,`firstName`,`lastName`) values (1,'Harvey','Deitel'),(2,'Paul','Deitel'),(3,'Tem','Nieto'),(4,'Sean','Sant'),(5,'adsa','asfd'),(6,'werwer','erwtre'),(7,'wqtqrt','retyer'),(8,'wqerweqt','retyer'),(9,'wqetret','wtert'),(10,'awert','wqerw'),(13,'werte','twye');

/*Table structure for table `bookusers` */

DROP TABLE IF EXISTS `bookusers`;

CREATE TABLE `bookusers` (
  `userId` int(10) NOT NULL auto_increment,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=115202 DEFAULT CHARSET=utf8;

/*Data for the table `bookusers` */

insert  into `bookusers`(`userId`,`account`,`password`,`name`,`createTime`) values (115200,'admin','admin','administrator','2015-09-16 00:35:45');

/*Table structure for table `publishers` */

DROP TABLE IF EXISTS `publishers`;

CREATE TABLE `publishers` (
  `publisherID` int(11) NOT NULL auto_increment,
  `publisherName` varchar(30) NOT NULL,
  PRIMARY KEY  (`publisherID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `publishers` */

insert  into `publishers`(`publisherID`,`publisherName`) values (1,'Prentice'),(2,'Prentice Hall PTG'),(3,'xiaoming'),(5,'明天'),(6,'sadfgsd'),(7,'sdagsda'),(8,'sadfggsag'),(14,'fsadgfdsg');

/*Table structure for table `titles` */

DROP TABLE IF EXISTS `titles`;

CREATE TABLE `titles` (
  `isbn` varchar(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `editionNumber` int(11) NOT NULL,
  `copyright` varchar(4) NOT NULL,
  `publisherID` int(11) NOT NULL,
  `imageFile` varchar(20) default '""',
  `price` float NOT NULL,
  PRIMARY KEY  (`isbn`),
  KEY `fk_titles` (`publisherID`),
  CONSTRAINT `fk_titles` FOREIGN KEY (`publisherID`) REFERENCES `publishers` (`publisherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `titles` */

insert  into `titles`(`isbn`,`title`,`editionNumber`,`copyright`,`publisherID`,`imageFile`,`price`) values ('0130125075','Java How to Program (Java 2)',3,'2000',1,'jhtp3.jpg',69.95),('0130161438','Internet and World Wide Web How to Program',1,'2000',1,'iw3htp1.jpg',69.95),('0130284173','XML How to Program',1,'2001',1,'xmlhtp1.jpg',69.95),('0130284181','Perl How to Program',1,'2001',1,'perlhtp1.jpg',69.95),('013028419x','e-Business and e-Commerce How to Program',1,'2001',1,'ebechtp1.jpg',69.95),('0130829277','The Complete Java Training Course (Java 1.1)',2,'1998',2,'javactc2.jpg',99.95),('0130829293','The Complete Visual Basic 6 Training Course',1,'1999',2,'vbctc1.jpg',109.95),('0130852473','The Complete Java 2 Training Course',3,'2000',2,'javactc3.jpg',109.95),('0130856118','The Complete Internet and World Wide Web Programming Training Course',1,'2000',2,'iw3ctc1.jpg',109.95),('0130895601','Advanced Java 2 Platform How to Program',1,'2002',1,'advjhtp1.jpg',69.95),('0130895717','C++ How to Program',3,'2001',1,'cpphtp3.jpg',69.95),('0130895725','C How to Program',3,'2001',1,'chtp3.jpg',69.95),('0132261197','C How to Program',2,'1994',1,'chtp2.jpg',49.95),('0134569555','Visual Basic 6 How to Program',1,'1999',1,'vbhtp1.jpg',69.95),('0135289106','C++ How to Program',2,'1998',1,'cpphtp2.jpg',49.95),('0138993947','Java How to Program (Java 1.1)',2,'1998',1,'jhtp2.jpg',49.95),('0139163050','The Complete C++ Training Course',3,'2001',2,'cppctc3.jpg',109.95);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
