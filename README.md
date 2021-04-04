# ITS340-Final-Project-2021
Statement of Work Final Project ITS 340

Develop an application that interviews a patient for some general medical history data using a binary tree to drive the process, implemented using the Java language and using the Java Swing graphical user interface, and the MySQL database to store data. Think of the interview as a digital physician that asks the user questions regarding their medical history.

1. The scope of the interview will be limited to the following:
    a. Interview for Allergies
        i. Allergen
        ii. Start Date (people may not remember a specific date, but only a year)
        iii. End Date
        iv. Allergy Description

    b. Interview for General Medical History
        i. Blood Type ii. Rh Factor
        iii. Marital Status
        iv. Alcohol Use – Type and Quantity, and Duration (e.g., wine twice a week)
        v. Tobacco Use – Type and Quantity, and Duration (e.g., cigar once a week) vi. Drug Usage – Type and Duration

2. The following tables need to be built in the MySQL database: 
    a. AllergyHistoryTable
    b. GeneralMedicalHistoryTable c. PatientTable

3. Create a graphical user-interface that includes forms for: 
    1) Patient Selection, 
    2) Patient Demographics, 
    3) General Medical History, and 
    4) Allergy History using Java Swing.

    a. The Patient Demographics, General Medical History and Allergy History forms must comply with the following:

        i. The frame (form) must have fields to display all the data from each associated table (allergy history, 
            general  history, etc.) 
            The General Medical History frame will show one record from the associated table for a specific patient. 
            The Allergy history frame must be able to show many records per patient in a list.
        
        ii. The frame must have buttons for Edit, New, Save, Delete, and Close.
        
        iii. The screen should open in “View” mode where the text fields cannot be initially
            edited (the fields are locked). The background of the text fields should be a light gray color. 
            When you click the Edit or New buttons, then the form changes to “Edit” mode where the fields can be editable. Change the text field background to white while in “Edit” mode.

        iv. When the Save button is clicked, save changes to an existing record or insert a new record into the 
            General History table.
        
        v. The screen should go back to “View” mode upon the click of the Save button. The Close button should 
            close the screen and go back to the patient selection screen.

    b. The following specific frames must also have a button to start the automated interview:
        i. General Medical History form as a button to start the automated interview for
            specific general medical history data (see General Medical History table).

        ii. Allergy History form has a button to start the automated interview for allergy
            history data (see Allergy table).

    c. The GUI must be structured to include:
        i. A patient selection form which upon selection of a patient takes you to a patient
            demographics form.

        ii. The patient demographics form must have buttons to go to a:
            1. General Medical History form.
            2. Allergy History form.

4. Use a graph or binary tree structure to implement the interview. 
    Each node must include a question and depending on a YES/NO or TRUE/FALSE answer navigate to either the right or left branch of the tree to ask the next question. 
    
    Suggestion: You may want to create many binary trees for specific interview subsets rather than one extremely large tree. For example, a tree specific to getting general medical history data or specific trees for asking questions regarding specific general medical history data such as blood type, another for specifically for questions on alcohol consumption, etc. You will have a lot of flexibility on how to implement this tree(s) but must show that the interview is driven by a binary tree(s).

5. Save the interview results to the respective database tables.

6. Record the interview in a log file both the question and answer. The log file must be a text file. Use Java File I/O,

7. Database Table Fields

    Patient Table (patient demographics)
    CREATE TABLE `patienttable` (
    `PatientID` int(11) NOT NULL AUTO_INCREMENT,
    `FirstName` varchar(128) DEFAULT NULL, 
    `MiddleInitial` varchar(4) DEFAULT NULL, 
    `LastName` varchar(128) DEFAULT NULL, 
    `HomeAddress1` varchar(128) DEFAULT NULL, 
    `HomeAddress2` varchar(128) DEFAULT NULL,
    `HomeCity` varchar(128) DEFAULT NULL, 
    `HomeState/Province/Region` varchar(50) DEFAULT NULL,
    `HomeZip` varchar(15) DEFAULT NULL,
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
    KEY `I_HomePhone` (`HomePhone`),
    KEY `I_SSN` (`SS#`)
    );

    Allergy History
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

    General Medical History
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

Extra Forms and Database Tables for Teams of 3 People and Extra Credit ITS 340

Teams of three must implement Family History and Immunization History

    Family History  

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
    Immunization History

    CREATE TABLE `immunizationshistorytable` ( 
    `ImmunizationsID` int(11) NOT NULL AUTO_INCREMENT, 
    `PatientID` int(11) DEFAULT NULL,
    `Vaccine` varchar(128) DEFAULT NULL, 
    `ImmunizationDate` date DEFAULT NULL, 
    `ExperationDate` date DEFAULT NULL,
    `Delivery` varchar(128) DEFAULT NULL,
    `Comments` varchar(254) DEFAULT NULL,
    `HCPId` int(11) DEFAULT NULL,
    `deleted` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`ImmunizationsID`),
    KEY `I_PatientID` (`PatientID`)
    );

Project Extra Credit 15 pts: Medication/Prescription table and Forms

    (Includes form to display all prescriptions and enter/edit/discontinue medications. 
    Include buttons to show ALL medications both current and past and button (the default view) 
    to show only current medications. 
    Check the medication end date to see if a medication has been discontinued.)

    CREATE TABLE `patientmedicationstable` ( 
    `MedicationID` int(11) NOT NULL AUTO_INCREMENT, 
    `CurrentMedicationID` int(11) DEFAULT NULL, 
    `PatientID` int(11) DEFAULT NULL,
    `Medication` varchar(254) DEFAULT NULL, 
    `PrescriptionQuantity` varchar(50) DEFAULT NULL, 
    `PrescriptionQuantityUnits` varchar(50) DEFAULT NULL,
    `Refills` int(11) DEFAULT NULL,
    `RefillPeriod` varchar(50) DEFAULT NULL,
    `Generic` tinyint(1) DEFAULT '0',
    `PrescriptionHCP` int(11) DEFAULT NULL, 
    `PrescriptionDate` datetime DEFAULT NULL, 
    `PharmacyID` int(11) DEFAULT NULL,
    `deleted` tinyint(1) DEFAULT '0',
    `Instructions` varchar(1024) DEFAULT NULL, 
    `PrescriptionMedsAmt` varchar(50) DEFAULT NULL, 
    `PrescriptionMedsUnit` varchar(50) DEFAULT NULL, 
    'MedicationStartDate' date DEFAULT NULL, 
    'MedicationEndDate' date DEFAULT NULL, 
    PRIMARY KEY (`PrescriptionID`),
    KEY `I_PatientID` (`PatientID`)
    );
