/* its 340 - Spring 2021*/
CREATE SCHEMA IF NOT EXISTS genmedhis;
use genmedhis;
drop table if exists familyhistorytable;
CREATE TABLE `familyhistorytable` (
`FamilyID` int(11) NOT NULL AUTO_INCREMENT, 
`PatientID` int(11) DEFAULT NULL,
`Name` varchar(50) DEFAULT NULL,
`Relation` varchar(50) DEFAULT NULL,
`Alive` tinyint(1) DEFAULT '0',
`Lives with patient` tinyint(1) DEFAULT '0', 
`MajorDisorder` varchar(254) DEFAULT NULL, 
`SpecificTypeDisorder` varchar(254) DEFAULT NULL, 
`DisorderHRF` tinyint(1) DEFAULT '0',
`deleted` tinyint(1) DEFAULT '0',
PRIMARY KEY (`FamilyID`),
KEY `I_PatientID` (`PatientID`)
)