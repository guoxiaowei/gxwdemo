CREATE TABLE `gxw_user` (
  `ID` decimal(10,0) NOT NULL DEFAULT '0',
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE gxw_user ADD COLUMN birthday DATE;