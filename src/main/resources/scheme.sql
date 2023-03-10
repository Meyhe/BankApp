DROP schema IF EXISTS `bankApp`;
CREATE schema IF NOT EXISTS `bankApp`;
use `bankApp`;

DROP TABLE IF EXISTS `CUSTOMER`;
CREATE TABLE `CUSTOMER` (
    `ID_CUSTOMER` int NOT NULL AUTO_INCREMENT,
    `FIRST_NAME` varchar(35),
    `LAST_NAME` varchar (35),
    `MIDDLE_NAME` varchar(35),
    `STATUS_CUSTOMER` varchar(15),

    PRIMARY KEY (`ID_CUSTOMER`)
);

DROP TABLE IF EXISTS `ACCOUNT`;
CREATE TABLE `ACCOUNT` (
    `ID_ACCOUNT` int NOT NULL AUTO_INCREMENT,
    `ID_CUSTOMER` int,
    `STATUS_ACCOUNT` varchar(15),
    `TYPE_ACCOUNT` varchar(15),
    `BALANCE_ACCOUNT` decimal(8,2)

    PRIMARY KEY (`ID_ACCOUNT`)
);

DROP TABLE IF EXISTS `TRANSACTION`;
CREATE TABLE `TRANSACTION` (
    `ID_TRANSACTION` int NOT NULL AUTO_INCREMENT,
    `ID_ACCOUNT` int,
    `DATE_TRANSACTION` date,
    `STATUS_TRANSACTION` varchar(15),
    `TYPE_TRANSACTION` varchar(15),
    `AMOUNT_TRANSACTION` decimal(8, 2),

    PRIMARY KEY (`ID_TRANSACTION`)
);

INSERT INTO `ACCOUNT` VALUES
    (1, NULL, 'VDFFD', 'SDFSF', 136.00),
    (2, NULL, 'FDGBDFFD', 'FGBSG', 6.15);