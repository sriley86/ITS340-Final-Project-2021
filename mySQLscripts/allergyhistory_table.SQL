/* its 340 - Spring 2021*/
CREATE SCHEMA IF NOT EXISTS genmedhis;
use genmedhis;
drop table if exists allergyhistorytable;
CREATE TABLE `allergyhistorytable` (
`AllergyID` int(11) NOT NULL AUTO_INCREMENT, 
`PatientID` int(11) DEFAULT NULL,
`Allergen` varchar(254) DEFAULT NULL, 
`AllergyStartDate` varchar(25) DEFAULT NULL, 
`AllergyEndDate` varchar(25) DEFAULT NULL, 
`AllergyDescription` varchar(254) DEFAULT NULL, 
`deleted` tinyint(1) DEFAULT '0',
PRIMARY KEY (`AllergyID`)
);