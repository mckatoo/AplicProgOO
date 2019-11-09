CREATE DATABASE  IF NOT EXISTS `loja` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `loja`;
-- MySQL dump 10.16  Distrib 10.1.41-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: loja
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `codCli` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  PRIMARY KEY (`codCli`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Gumercindo','Rua 15, 2150','SP'),(2,'Joaquim Jose','Rua Tiradentes, 50','SP'),(3,'Joana Darc','Rua dos Martires, 1500','RJ'),(4,'Maria Beatriz endereço','Rua Ipanema, 230','RJ'),(5,'Milton Carlos Katoo','Rua Dr Miguel Couto, 81','SP'),(32,'fgdfgdfg fdfdfd','dfgdfgd 5656','yy'),(33,'sdfsdfsdf 545','sdfsdfsdf','ew');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens`
--

DROP TABLE IF EXISTS `itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itens` (
  `numero` char(9) NOT NULL,
  `serie` char(3) NOT NULL,
  `item` smallint(6) NOT NULL,
  `codPneu` int(11) NOT NULL,
  `qtde` smallint(6) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  PRIMARY KEY (`item`,`numero`,`serie`),
  KEY `FK_PNEUS` (`codPneu`),
  KEY `FK_NOTAS` (`numero`,`serie`),
  CONSTRAINT `FK_NOTAS` FOREIGN KEY (`numero`, `serie`) REFERENCES `notaFiscal` (`numero`, `serie`),
  CONSTRAINT `FK_PNEUS` FOREIGN KEY (`codPneu`) REFERENCES `pneus` (`codPneu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens`
--

LOCK TABLES `itens` WRITE;
/*!40000 ALTER TABLE `itens` DISABLE KEYS */;
INSERT INTO `itens` VALUES ('1','001',1,3,2,1200.00),('2','001',1,1,4,135.00),('3','001',1,1,4,135.00),('4','001',1,2,8,240.00),('1','001',2,4,2,3500.00),('2','001',2,2,4,240.00);
/*!40000 ALTER TABLE `itens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notaFiscal`
--

DROP TABLE IF EXISTS `notaFiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notaFiscal` (
  `numero` char(9) NOT NULL,
  `serie` char(3) NOT NULL,
  `codCli` int(11) NOT NULL,
  `data` date NOT NULL,
  `cancelada` char(1) NOT NULL,
  PRIMARY KEY (`numero`,`serie`),
  KEY `FK_CLIENTES` (`codCli`),
  CONSTRAINT `fk_notaFiscal_clientes` FOREIGN KEY (`codCli`) REFERENCES `clientes` (`codCli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notaFiscal`
--

LOCK TABLES `notaFiscal` WRITE;
/*!40000 ALTER TABLE `notaFiscal` DISABLE KEYS */;
INSERT INTO `notaFiscal` VALUES ('1','001',2,'2018-07-15','N'),('2','001',4,'2018-03-16','N'),('3','001',1,'2018-06-20','N'),('4','001',4,'2018-08-25','N');
/*!40000 ALTER TABLE `notaFiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pneus`
--

DROP TABLE IF EXISTS `pneus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pneus` (
  `codPneu` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  `medidas` varchar(15) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  `ativo` char(1) NOT NULL,
  PRIMARY KEY (`codPneu`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pneus`
--

LOCK TABLES `pneus` WRITE;
/*!40000 ALTER TABLE `pneus` DISABLE KEYS */;
INSERT INTO `pneus` VALUES (1,'pneu comum','aro 13',135.00,'S'),(2,'pneu comum','aro 14',240.00,'S'),(3,'pneu trator dianteiro',NULL,1200.00,'S'),(4,'pneu trator traseiro',NULL,3500.00,'S'),(5,'pneu comum','aro 15',314.00,'S'),(6,'pneu comum','aro 13',135.00,'S'),(7,'pneu comum','aro 14',240.00,'S'),(8,'pneu trator dianteiro',NULL,1200.00,'S'),(9,'pneu trator traseiro',NULL,3500.00,'S'),(10,'pneu comum','aro 15',314.00,'S');
/*!40000 ALTER TABLE `pneus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-08 22:08:10
