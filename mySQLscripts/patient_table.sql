/*its 340 - Spring 2021*/
CREATE SCHEMA IF NOT EXISTS genmedhis;
use genmedhis;
drop table if exists patienttable;
CREATE TABLE `patienttable` (
`PatientID` int(11) NOT NULL AUTO_INCREMENT,
`FirstName` varchar(128) DEFAULT NULL, 
`MiddleInitial` varchar(4) DEFAULT NULL, 
`LastName` varchar(128) DEFAULT NULL, 
`Address1` varchar(128) DEFAULT NULL, 
`Address2` varchar(128) DEFAULT NULL,
`City` varchar(128) DEFAULT NULL, 
`State/Province/Region` varchar(50) DEFAULT NULL,
`Zip` varchar(15) DEFAULT NULL,
`Country` varchar(75) DEFAULT NULL,
`Citizenship` varchar(75) DEFAULT NULL, 
`HomePhone` varchar(14) DEFAULT NULL, 
`EmergencyPhoneNumber` varchar(14) DEFAULT NULL, 
`EmailAddress` varchar(128) DEFAULT NULL,
`SS#` varchar(12) DEFAULT NULL,
`DOB` datetime DEFAULT NULL,
`Gender` varchar(50) DEFAULT NULL, 
`EthnicAssociation` varchar(75) DEFAULT NULL, 
`MaritalStatus` varchar(25) DEFAULT NULL, 
`PreviousLastName` varchar(128) DEFAULT NULL, 
`CurrentPrimaryHCPId` varchar(128) DEFAULT NULL, 
`Active` tinyint(1) DEFAULT '1',
`Comments` varchar(254) DEFAULT NULL, 
`SubscriberRelationship` varchar(10) DEFAULT NULL,
`NextOfKin` varchar(128) DEFAULT NULL,
`NextOfKinRelationshipToPatient` varchar(50) DEFAULT NULL, 
PRIMARY KEY (`PatientID`),
KEY `I_LastFirstName` (`LastName`,`FirstName`),
KEY `I_Phone` (`Phone`),
KEY `I_SSN` (`SS#`)
);