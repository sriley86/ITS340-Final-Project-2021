/*its 340 - Spring 2021*/
CREATE SCHEMA IF NOT EXISTS genmedhis;
use genmedhis;
drop table if exists patientmedicationstable;
CREATE TABLE `patientmedicationstable` ( 
`MedicationID` int(11) NOT NULL AUTO_INCREMENT, 
`CurrentMedicationID` int(11) DEFAULT NULL, 
`PatientID` DEFAULT NULL,
`Medication` varchar(254) DEFAULT NULL, 
`PrescriptionQuantity` varchar(50) DEFAULT NULL, 
`PrescriptionQuantityUnits` varchar(50) DEFAULT NULL,
`Refills` int(11) DEFAULT NULL,
`RefillPeriod` varchar(50) DEFAULT NULL,
`Generic` tinyint(1) DEFAULT '0',
`PrescriptionHCP` int(11) DEFAULT NULL, 
`PrescriptionDate` varchar(15) DEFAULT NULL, 
`PharmacyID` int(11) DEFAULT NULL,
`deleted` tinyint(1) DEFAULT '0',
`Instructions` varchar(1024) DEFAULT NULL, 
`PrescriptionMedsAmt` varchar(50) DEFAULT NULL, 
`PrescriptionMedsUnit` varchar(50) DEFAULT NULL, 
`MedicationStartDate` varchar(15) DEFAULT NULL, 
`MedicationEndDate` varchar(15) DEFAULT NULL, 
PRIMARY KEY (`MedicationID`),
KEY `I_PatientID` (`PatientID`)
);