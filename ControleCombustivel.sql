CREATE DATABASE  IF NOT EXISTS `controlecombustivel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `controlecombustivel`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: controlecombustivel
-- ------------------------------------------------------
-- Server version	5.5.24

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
-- Table structure for table `oleos`
--

DROP TABLE IF EXISTS `oleos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oleos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(20) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `classificacao` varchar(20) NOT NULL,
  `duracaoKm` int(11) NOT NULL,
  `litragem` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oleos`
--

LOCK TABLES `oleos` WRITE;
/*!40000 ALTER TABLE `oleos` DISABLE KEYS */;
INSERT INTO `oleos` VALUES (1,'shell','A','sintetico',10000,10);
/*!40000 ALTER TABLE `oleos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controleoleo`
--

DROP TABLE IF EXISTS `controleoleo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controleoleo` (
  `sequencia` int(11) NOT NULL AUTO_INCREMENT,
  `idVeiculo` int(11) NOT NULL,
  `idOleo` int(11) NOT NULL,
  `data` date NOT NULL,
  `kmInicial` int(11) NOT NULL,
  `valorLitro` int(11) NOT NULL,
  `quant` int(11) NOT NULL,
  `localTroca` int(11) NOT NULL,
  `proximaTroca` int(11) NOT NULL,
  `filtro` int(11) NOT NULL,
  PRIMARY KEY (`sequencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controleoleo`
--

LOCK TABLES `controleoleo` WRITE;
/*!40000 ALTER TABLE `controleoleo` DISABLE KEYS */;
/*!40000 ALTER TABLE `controleoleo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controle_comb`
--

DROP TABLE IF EXISTS `controle_comb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controle_comb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idVeiculo` int(11) NOT NULL,
  `idPosto` int(11) NOT NULL,
  `litros` double NOT NULL,
  `data` date NOT NULL,
  `kmInicial` double NOT NULL,
  `kmFinal` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_p` (`idPosto`),
  KEY `id_v` (`idVeiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controle_comb`
--

LOCK TABLES `controle_comb` WRITE;
/*!40000 ALTER TABLE `controle_comb` DISABLE KEYS */;
INSERT INTO `controle_comb` VALUES (1,1,1,25,'2015-05-18',25000,25600),(2,1,1,28,'2015-05-18',25000,25600),(3,2,2,33,'2015-05-18',25000,25600),(4,2,2,33,'2015-05-30',25000,25600),(5,3,3,33,'2015-05-18',25000,25600),(6,1,2,25,'2015-05-18',25000,25600);
/*!40000 ALTER TABLE `controle_comb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculos`
--

DROP TABLE IF EXISTS `veiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(8) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `montadora` varchar(20) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `km` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculos`
--

LOCK TABLES `veiculos` WRITE;
/*!40000 ALTER TABLE `veiculos` DISABLE KEYS */;
INSERT INTO `veiculos` VALUES (1,'ddd-2222','kadet','chevrolet','preto',20000),(2,'gggg','gol','gggg','gggg',111);
/*!40000 ALTER TABLE `veiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `usuario` varchar(30) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('gustavo','gustavo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postos`
--

DROP TABLE IF EXISTS `postos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `bandeira` varchar(20) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postos`
--

LOCK TABLES `postos` WRITE;
/*!40000 ALTER TABLE `postos` DISABLE KEYS */;
INSERT INTO `postos` VALUES (1,'gasolina','ipiranga','mutinga'),(2,'mais um','outra','outra'),(4,'dddd','qqqq','valentino cardoso'),(5,'Ipiranga Turística','Ipiranga','Estrada turistica do jaragua'),(6,'Texaco','Ipiranga','mutinga'),(7,'Gustavo','Ipiranga','gustavo');
/*!40000 ALTER TABLE `postos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-07 23:18:40
