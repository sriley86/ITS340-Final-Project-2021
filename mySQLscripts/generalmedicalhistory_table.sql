CREATE SCHEMA IF NOT EXISTS genmedhis;
use genmedhis;
drop table if exists generalmedicalhistorytable;
CREATE TABLE `generalmedicalhistorytable` ( 
`GeneralMedicalHistoryID` int(11) NOT NULL AUTO_INCREMENT, 
`PatientID` int(11) DEFAULT NULL,
`Tobacco` varchar(50) DEFAULT NULL,
`TobaccoQuantity` varchar(75) DEFAULT NULL, 
`Tobaccoduraton` varchar(75) DEFAULT NULL,
`Alcohol` varchar(50) DEFAULT NULL,
`AlcoholQuantity` varchar(75) DEFAULT NULL,
`Alcoholduration` varchar(75) DEFAULT NULL,
`Drug` varchar(25) DEFAULT NULL,
`DrugType` varchar(254) DEFAULT NULL, 
`Drugduration` varchar(75) DEFAULT NULL, 
`BloodType` varchar(10) DEFAULT NULL,
`Rh` varchar(10) DEFAULT NULL,
`deleted` tinyint(1) DEFAULT '0',
PRIMARY KEY (`GeneralMedicalHistoryID`),
KEY `GeneralMedHxPatientIDIndex` (`PatientID`)
);