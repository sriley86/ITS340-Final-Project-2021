/*its 340 - Spring 2021*/
CREATE SCHEMA IF NOT EXISTS genmedhis;
use genmedhis;
drop table if exists immunizationshistorytable;
CREATE TABLE `immunizationshistorytable` ( 
`ImmunizationsID` int(11) NOT NULL AUTO_INCREMENT, 
`PatientID` int(11) DEFAULT NULL,
`Vaccine` varchar(128) DEFAULT NULL, 
`ImmunizationDate` varchar(15) DEFAULT NULL, 
`ExperationDate` varchar(15) DEFAULT NULL,
`Delivery` varchar(128) DEFAULT NULL,
`Comments` varchar(254) DEFAULT NULL,
`HCPId` int(11) DEFAULT NULL,
`deleted` tinyint(1) DEFAULT '0',
PRIMARY KEY (`ImmunizationsID`),
KEY `I_PatientID` (`PatientID`)
);