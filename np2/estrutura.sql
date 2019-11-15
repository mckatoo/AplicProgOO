use teste;
CREATE TABLE `clientes` (
  `codCli` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  PRIMARY KEY (`codCli`)
);

CREATE TABLE `pneus` (
  `codPneu` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  `medidas` varchar(15) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  `ativo` char(1) NOT NULL,
  PRIMARY KEY (`codPneu`)
);

CREATE TABLE `notaFiscal` (
  `numero` char(9) NOT NULL,
  `serie` char(3) NOT NULL,
  `codCli` int(11) NOT NULL,
  `data` date NOT NULL,
  `cancelada` char(1) NOT NULL,
  PRIMARY KEY (`numero`,`serie`),
  KEY `FK_CLIENTES` (`codCli`),
  CONSTRAINT `fk_notaFiscal_clientes` FOREIGN KEY (`codCli`) REFERENCES `clientes` (`codCli`)
);

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
);