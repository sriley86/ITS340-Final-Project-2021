 ************DEMOGRAPHICS CLASS************
 ******************************************
 
 
 *Calls Forms - through Buttons 

DEMOGRAPHICS GUI FORM:
    1. Open form - data displays in Table
    2. Add button - moves data from the fields into the fields within the fields class. 
    3. Edit button - edits field data
    4. Save button - writes the data to the fields in the class 

DATABASE:
1.When the GUI form opens a query is made into the Database and holds data in the fields 
    that mirror the Demographics Form. Including the PatientID - it is stored in a field t
    hat "moves" to each form.
2. When the Add button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
3.When the Update button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
4. When the Delete button is pressed in the GUI form the fields in the class are cleared and 
    a delete statement is made to the database that deletes ALL tables in the Database with that PatientID 

AUTOMATED INTERVIEW:
    1. run the interview - called from GenMedHis Class 

************GENMEDHIS CLASS**************
******************************************


 *Calls Forms - through Buttons 

GENERAL MEDICAL HISTORY GUI FORM:
    1. Open form - data displays in Table
    2. Add button - moves data from the fields into the fields within the fields class. 
    3. Edit button - edits field data
    4. Save button - writes the data to the fields in the class 

DATABASE:
1.When the GUI form opens a query is made into the Database and holds data in the fields 
    that mirror the Demographics Form. Including the PatientID - it is stored in a field t
    hat "moves" to each form.
2. When the Add button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
3.When the Update button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
4. When the Delete button is pressed in the GUI form the fields in the class are cleared and 
    a delete statement is made to the database that deletes ALL tables in the Database with that PatientID 

AUTOMATED INTERVIEW:
1. run the interview - called from GenMedHis Class 
2. capture the data and store in appropriate fields in the GenMedHis Class 
3. Query the Database to add the data

************ALLERGY CLASS*****************
******************************************
 *Calls Forms - through Buttons 

ALLERGY GUI FORM:
    1. Open form - data displays in Table
    2. Add button - moves data from the fields into the fields within the fields class. 
    3. Edit button - edits field data
    4. Save button - writes the data to the fields in the class 

DATABASE:
1.When the GUI form opens a query is made into the Database and holds data in the fields 
    that mirror the Demographics Form. Including the PatientID - it is stored in a field t
    hat "moves" to each form.
2. When the Add button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
3.When the Update button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
4. When the Delete button is pressed in the GUI form the fields in the class are cleared and 
    a delete statement is made to the database that deletes ALL tables in the Database with that PatientID 

AUTOMATED INTERVIEW:
1. run the interview - called from GenMedHis Class 
2.capture the data and store in appropriate fields in the GenMedHis Class 
3. Query the Database to add the data

************FAMILY CLASS*****************
******************************************
 *Calls Forms - through Buttons 

FAMILY GUI FORM:
1. Open form - data displays in Table
    2. Add button - moves data from the fields into the fields within the fields class. 
    3. Edit button - edits field data
    4. Save button - writes the data to the fields in the class 

DATABASE:
1.When the GUI form opens a query is made into the Database and holds data in the fields 
    that mirror the Demographics Form. Including the PatientID - it is stored in a field t
    hat "moves" to each form.
2. When the Add button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
3.When the Update button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
4. When the Delete button is pressed in the GUI form the fields in the class are cleared and 
    a delete statement is made to the database that deletes ALL tables in the Database with that PatientID 

************IMMUNIZATION CLASS************
******************************************
 *Calls Forms - through Buttons 

IMMUNIZATION GUI FORM:
1. Open form - data displays in Table
    2. Add button - moves data from the fields into the fields within the fields class. 
    3. Edit button - edits field data
    4. Save button - writes the data to the fields in the class 

DATABASE:
1.When the GUI form opens a query is made into the Database and holds data in the fields 
    that mirror the Demographics Form. Including the PatientID - it is stored in a field t
    hat "moves" to each form.
2. When the Add button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
3.When the Update button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
4. When the Delete button is pressed in the GUI form the fields in the class are cleared and 
    a delete statement is made to the database that deletes ALL tables in the Database with that PatientID 


************MEDICATION CLASS*****************
******************************************
 *Calls Forms - through Buttons 

MEDICATION GUI FORM:
1. Open form - data displays in Table
    2. Add button - moves data from the fields into the fields within the fields class. 
    3. Edit button - edits field data
    4. Save button - writes the data to the fields in the class 

DATABASE:
1.When the GUI form opens a query is made into the Database and holds data in the fields 
    that mirror the Demographics Form. Including the PatientID - it is stored in a field t
    hat "moves" to each form.
2. When the Add button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
3.When the Update button is pressed in the GUI form the fields in the class are populated 
    with new data, an update is made into the Database
4. When the Delete button is pressed in the GUI form the fields in the class are cleared and 
    a delete statement is made to the database that deletes ALL tables in the Database with that PatientID 

************DECISION CLASS*****************
******************************************

called from the Automated Button
Need three methods: 1 for each form 

create a separate automation for General Medical History

create a separate automation for Allergy 


1. Ask questions from jOptionPane in Yes or No format

2. Record the patientID, datestamp, question and yes/no answer for each question in an file I/O

3. Store each answer in a field - interpret YES as an appropriate Blood Type, Married, rH, 

4. Store data in appropriate fields