
package v1porject_mc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static v1porject_mc.PatientDemographics.Address1;
import static v1porject_mc.PatientDemographics.Address2;
import static v1porject_mc.PatientDemographics.Citizenship;
import static v1porject_mc.PatientDemographics.City;
import static v1porject_mc.PatientDemographics.Comments;
import static v1porject_mc.PatientDemographics.Country;
import static v1porject_mc.PatientDemographics.CurrentPrimaryHCPId;
import static v1porject_mc.PatientDemographics.DOB;
import static v1porject_mc.PatientDemographics.EmailAddress;
import static v1porject_mc.PatientDemographics.EmergencyPhoneNumber;
import static v1porject_mc.PatientDemographics.EthnicAssociation;
import static v1porject_mc.PatientDemographics.FirstName;
import static v1porject_mc.PatientDemographics.Gender;
import static v1porject_mc.PatientDemographics.LastName;
import static v1porject_mc.PatientDemographics.MaritalStatus;
import static v1porject_mc.PatientDemographics.MiddleInitial;
import static v1porject_mc.PatientDemographics.NextOfKin;
import static v1porject_mc.PatientDemographics.NextOfKinRelationshipToPatient;
import static v1porject_mc.PatientDemographics.Phone;
import static v1porject_mc.PatientDemographics.PreviousLastName;
import static v1porject_mc.PatientDemographics.State;
import static v1porject_mc.PatientDemographics.SubscriberRelationship;
import static v1porject_mc.PatientDemographics.Zip;
import static v1porject_mc.PatientDemographics.ssNumber;

/**
 *
 * @author rodri737
 */
public class PatientDemClass extends PatientDemographics{
    
    public static void PatientDem(){
        
        String first = FirstName.getText();
        String middleinitial = MiddleInitial.getText();
        String last = LastName.getText();
        String address1 = Address1.getText();
        String address2 = Address2.getText();
        String city = City.getText();
        String state = State.getText();
        String zip = Zip.getText();
        String country = Country.getText();
        String citizen = Citizenship.getText();
        String phone = Phone.getText();
        String emergencyphonenumber = EmergencyPhoneNumber.getText();
        String emailaddress = EmailAddress.getText();
        String ss = ssNumber.getText();
        String dob =DOB.getText();
        String gender = Gender.getText();
        String ethnicassoc = EthnicAssociation.getText();
        String martialstat = MaritalStatus.getText(); 
        String previouslastname = PreviousLastName.getText();
        String curprihcp = CurrentPrimaryHCPId.getText(); 
        String comments = Comments.getText(); 
        String subscribrelat = SubscriberRelationship.getText();
        String nextofkin = NextOfKin.getText();
        String nextkinrel = NextOfKinRelationshipToPatient.getText();
    
        String dburl = "jdbc:mysql://localhost:3306/genmedhis?autoconnect=true&useSSL=false"; //connection string of the database
        String InsertSQL = "INSERT INTO patienttable " //prepared statement
                + "(FirstName, MiddleInitial, LastName, Address1, Address2, City, State, Zip, Country, Citizenship, Phone, EmergencyPhoneNumber, EmailAddress, SSNumber, DOB, Gender, EthnicAssociation, MaritalStatus, PreviousLastName, CurrentPrimaryHCPId, Comments, SubscriberRelationship, NextOfKin, NextOfKinRelationshipToPatient ) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; //? are placeholders
        // Zip, Country, Citizenship, Phone, EmergencyPhoneNumber, EmailAddress, SSNumber, DOB, Gender, EthinicAssociation, MaritalStatus, PreviousLastName, CurrentPrimaryHCPId, Comments, SubscriberRelationship, NextOfKin, NextOfKinRelationshipToPatient
        try
        {
        //register the driver class
        //initialize
            Class.forName("com.mysql.cj.jdbc.Driver");
            //actual connect with login
            Connection con = DriverManager.getConnection(dburl, "root", "P@ssw0rd");
            PreparedStatement ps = con.prepareStatement(InsertSQL); //insert statement from above
            
             //1 = first ? from above
            ps.setString(1, first);
            ps.setString(2, middleinitial);
            ps.setString(3, last); 
            ps.setString(4, address1);
            ps.setString(5, address2);
            ps.setString(6, city);
            ps.setString(7, state);
            ps.setString(8, zip);
            ps.setString(9, country);
            ps.setString(10, citizen);
            ps.setString(11, phone);
            ps.setString(12, emergencyphonenumber);
            ps.setString(13, emailaddress);
            ps.setString(14, ss);
            ps.setString(15, dob);
            ps.setString(16, gender);
            ps.setString(17, ethnicassoc); 
            ps.setString(18, martialstat); 
            ps.setString(19, previouslastname); 
            ps.setString(20, curprihcp); 
            ps.setString(21, comments); 
            ps.setString(22, subscribrelat);
            ps.setString(23, nextofkin);
            ps.setString(24, nextkinrel); 
            
            int rowCount = ps.executeUpdate();
//            JOptionPane.showMessageDialog(this, "Record inserted successfully");
//            table_update();
            
          
            
            FirstName.setText("");
            MiddleInitial.setText("");
            LastName.setText("");
            Address1.setText("");
            Address2.setText("");
            City.setText("");
            State.setText("");
            Zip.setText("");
            Country.setText("");
            Citizenship.setText("");
            Phone.setText("");
            EmergencyPhoneNumber.setText("");
            EmailAddress.setText("");
            ssNumber.setText("");
            DOB.setText("");
            Gender.setText("");
            EthnicAssociation.setText("");
            MaritalStatus.setText(""); 
            PreviousLastName.setText(""); 
            CurrentPrimaryHCPId.setText(""); 
            Comments.setText(""); 
            SubscriberRelationship.setText("");
            NextOfKin.setText("");
            NextOfKinRelationshipToPatient.setText(""); 
            
            con.close(); //close connection
        }
        
        catch(SQLException e)
        {
            System.out.println("Error exceuting INSERT Operation!");
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
    }

    
    public static void UpdateButton(){
        DefaultTableModel Df = (DefaultTableModel) tabledemographics.getModel();
        
        int selectedRowIndex = tabledemographics.getSelectedRow();

        
        
        String dburl = "jdbc:mysql://localhost:3306/genmedhis?autoconnect=true&useSSL=false"; //connection string of the database
        String InsertSQL = "UPDATE patienttable SET FirstName=?, MiddleInitial =?, LastName=?, Address1=?, Address2=?, City=?, State=?, Zip=?, Country=?, "
                + "Citizenship=?, Phone=?, EmergencyPhoneNumber=?, EmailAddress=?, SSNumber=?, DOB=?, Gender=?, EthnicAssociation=?, MaritalStatus=?, "
                + "PreviousLastName=?, CurrentPrimaryHCPId=?, Comments=?, SubscriberRelationship=?, NextOfKin=?, NextOfKinRelationshipToPatient=? where PatientID=?"; 
        try
        {
            int id = Integer.parseInt(Df.getValueAt(selectedRowIndex,0).toString());
        //register the driver class
        //initialize
            Class.forName("com.mysql.cj.jdbc.Driver");
            //actual connect with login
            Connection con = DriverManager.getConnection(dburl, "root", "P@ssw0rd");
            PreparedStatement ps = con.prepareStatement(InsertSQL); //insert statement from above
            String first = FirstName.getText();
            String middleinitial = MiddleInitial.getText();
            String last = LastName.getText();
            String address1 = Address1.getText();
            String address2 = Address2.getText();
            String city = City.getText();
            String state = State.getText();
            String zip = Zip.getText();
            String country = Country.getText();
            String citizen = Citizenship.getText();
            String phone = Phone.getText();
            String emergencyphonenumber = EmergencyPhoneNumber.getText();
            String emailaddress = EmailAddress.getText();
            String ss = ssNumber.getText();
            String dob =DOB.getText();
            String gender = Gender.getText();
            String ethnicassoc = EthnicAssociation.getText();
            String martialstat = MaritalStatus.getText(); 
            String previouslastname = PreviousLastName.getText();
            String curprihcp = CurrentPrimaryHCPId.getText(); 
            String comments = Comments.getText(); 
            String subscribrelat = SubscriberRelationship.getText();
            String nextofkin = NextOfKin.getText();
            String nextkinrel = NextOfKinRelationshipToPatient.getText();
//            String patientID = PatientID.getText();
             //1 = first ? from above
//             ps.setString(0, patientID);
            ps.setString(1, first);
            ps.setString(2, middleinitial);
            ps.setString(3, last); 
            ps.setString(4, address1);
            ps.setString(5, address2);
            ps.setString(6, city);
            ps.setString(7, state);
            ps.setString(8, zip);
            ps.setString(9, country);
            ps.setString(10, citizen);
            ps.setString(11, phone);
            ps.setString(12, emergencyphonenumber);
            ps.setString(13, emailaddress);
            ps.setString(14, ss);
            ps.setString(15, dob);
            ps.setString(16, gender);
            ps.setString(17, ethnicassoc); 
            ps.setString(18, martialstat); 
            ps.setString(19, previouslastname); 
            ps.setString(20, curprihcp); 
            ps.setString(21, comments); 
            ps.setString(22, subscribrelat);
            ps.setString(23, nextofkin);
            ps.setString(24, nextkinrel); 
            ps.setInt (25, id);
            
            ps.executeUpdate();
            
            con.close(); //close connection
        }
        
        catch(SQLException e)
        {
            System.out.println("Error exceuting UPDATING Operation!");
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
}
}   
    
    
    
    
    
    
    
//    public static void PatientDemClass(){

        
//    private int PatientID;
//    private String FirstName;
//    private String MiddleInitial;
//    private String LastName; 
//    private String Address1;
//    private String Address2;
//    private String City;
//    private String State;
//    private String Zip;
//    private String Country;
//    private String Citizenship;
//    private String Phone;
//    private String EmergencyPhoneNumber;
//    private String EmailAddress;
//    private String SSNumber;
//    private String DOB;
//    private String Gender;
//    private String EthnicAssociation; 
//    private String MaritalStatus; 
//    private String PreviousLastName;
//    private String CurrentPrimaryHCPId;
//    //private boolean Active
//    private String Comments; 
//    private String SubscriberRelationship;
//    private String NextOfKin;
//    private String NextOfKinRelationshipToPatient; 
//    
//    
//
//    public void setPatient(int PatientID, String FirstName, String MiddleInitial, String LastName, String Address1,
//         String Address2, String City, String State, String Zip, String Country, String Citizenship,
//         String Phone, String EmergencyPhoneNumber, String EmailAddress, String SSNumber, String DOB, String Gender,
//         String EthnicAssociation, String MartialStatus, String PreviousLastName, String CurrentPrimaryHCPId, String Comments,
//         String SubscriberRelationship, String NextOfKin, String NextOfKinRelationshipToPatient) 
//    {
//        
//        this.PatientID = PatientID;
//        this.FirstName = FirstName;
//        this.MiddleInitial = MiddleInitial;
//        this.LastName = PreviousLastName;
//        this.Address1 = Address1;
//        this.Address2 = Address2;
//        this.City = City;
//        this.State = State;
//        this.Zip = Zip;
//        this.Country = Country;
//        this.Citizenship = Citizenship;
//        this.Phone = Phone;
//        this.EmergencyPhoneNumber = EmergencyPhoneNumber;
//        this.EmailAddress = EmailAddress;
//        this.SSNumber = SSNumber;
//        this.DOB = DOB;
//        this.Gender = Gender;
//        this.EthnicAssociation = EthnicAssociation;
//        this.MaritalStatus = MartialStatus;
//        this.PreviousLastName = PreviousLastName;
//        this.CurrentPrimaryHCPId = CurrentPrimaryHCPId;
//        //this.active = active;
//        this.Comments = Comments;
//        this.SubscriberRelationship = SubscriberRelationship;
//        this.NextOfKin = NextOfKin;
//        this.NextOfKinRelationshipToPatient =NextOfKinRelationshipToPatient;
//
//
//
//   }
//    public  static void PatientDemClass(int PatientID, String FirstName, String MiddleInitial, String LastName, String Address1,
//         String Address2, String City, String State, String Zip, String Country, String Citizenship,
//         String Phone, String EmergencyPhoneNumber, String EmailAddress, String SSNumber, String DOB, String Gender,
//         String EthnicAssociation, String MartialStatus, String PreviousLastName, String CurrentPrimaryHCPId, String Comments,
//         String SubscriberRelationship, String NextOfKin, String NextOfKinRelationshipToPatient)
//    {
////        setPatient( PatientID, FirstName,  MiddleInitial, LastName,  Address1,
////          Address2, City,  State, Zip, Country, Citizenship,
////          Phone,  EmergencyPhoneNumber,  EmailAddress,  SSNumber,  DOB,  Gender,
////          EthnicAssociation,  MartialStatus,  PreviousLastName,  CurrentPrimaryHCPId, Comments,
////          SubscriberRelationship, NextOfKin, NextOfKinRelationshipToPatient);
//             
//    }
//    
//    public int getPatientID()
//    {
//        return PatientID;
//    }
//   
//    public String getFirstName() 
//    {
//        return FirstName;
//    }
//
//    public String getLastName()
//    {
//        return LastName;
//    }
//    
//    public String getMiddleInitial()
//    {
//        return MiddleInitial;
//    }
//    public String getAddress1() 
//    {
//        return Address1;
//    }
//
//    public String getAddress2()
//    {
//        return Address2;
//    }
//
//    public String getCity() 
//    {
//        return City;
//    }
//    
//    /**
//     *
//     * @return
//     */
//    public String getState()
//    {
//        return State;
//    }
//
//    public String getHomeZip()
//    {
//        return Zip;
//    }
//
//    public String getCountry() 
//    {
//      return Country;
//    }
//
//    public String getCitizenship()
//    {
//        return Citizenship;
//    }
//
//    public String getPhone() 
//    {
//        return Phone;
//    }
//
//    public String getEmergencyPhoneNumber() 
//    {
//        return EmergencyPhoneNumber;
//    }
//
//    public String getEmailAddress()
//    {
//        return EmailAddress;
//    }
//
//    public String getSSNumber() 
//    {
//        return SSNumber;
//    }
//
//    public String getDOB()       
//    {
//        return DOB;
//    }
//
//    public String getGender() 
//    {
//        return Gender;
//    }
//
//    public String getEthnicAssociation() 
//    {
//        return EthnicAssociation;
//    }
//
//    public String getMartialStatus()
//    {
//        return MaritalStatus;
//    }
//    public String getPreviousLastName()
//    {
//        return PreviousLastName;
//    }
//    public String getCurrentPrimaryHCPId() 
//    {
//        return CurrentPrimaryHCPId;
//    }
//
////   public boolean isActive() {
////      return active;
////   }
//
//    public String getComments()
//    {
//        return Comments;
//    }
//
//    public String getSubscriberRelationship()
//    {
//        return SubscriberRelationship;
//    }
//
//    public String getNextOfKin() 
//    {
//        return NextOfKin;
//    }
//
//    public String getNextOfKinRelationshipToPatient()
//    {
//      return NextOfKinRelationshipToPatient;
//    }
//    
//    //SET METHODS
//
//    public void setId(int PatientID) 
//    {
//       this.PatientID = PatientID;
//    }
//
//    public void setFirstName(String FirstName)
//    {
//       this.FirstName = FirstName;
//    }
//
//    public void setLastName(String LastName)
//    {
//       this.LastName = LastName;
//    }
//
//    public void setMiddleInital(String MiddleInitial)
//    {
//       this.MiddleInitial = MiddleInitial;
//    }
//
//    public void setAddress1(String Address1)
//    {
//       this.Address1 = Address1;
//    }
//
//    public void setAddress2(String Address2) 
//    {
//       this.Address2 = Address2;
//    }
//
//    public void setHomeCity(String City)
//    {
//       this.City = City;
//    }
//
//    public void setState(String State)
//    {
//       this.State = State;
//    }
//
//    public void setZip(String Zip) 
//    {
//       this.Zip = Zip;
//    }
//
//    public void setCountry(String Country)
//    {
//       this.Country = Country;
//    }
//
//    public void setCitizenship(String Citizenship) 
//    {
//       this.Citizenship = Citizenship;
//    }
//
//    public void setPhone(String Phone)
//    {
//       this.Phone = Phone;
//    }
//
//    public void setEmergencyPhoneNumber(String EmergencyPhoneNumber) 
//    {
//       this.EmergencyPhoneNumber = EmergencyPhoneNumber;
//    }
//
//    public void setEmailAddress(String EmailAddress) 
//    {
//       this.EmailAddress = EmailAddress;
//    }
//
//    public void setSSNumber(String SSNumber)
//    {
//       this.SSNumber = SSNumber;
//    }
//
//    public void setDOB(String DOB) 
//    {
//       this.DOB = DOB;
//    }
//
//    public void setGender(String Gender)
//    {
//       this.Gender = Gender;
//    }
//
//    public void setEthnicAssociation(String EthnicAssociation)
//    {
//       this.EthnicAssociation = EthnicAssociation;
//    }
//
//    public void setMaritalStatus(String MartialStatus) 
//    {
//       this.MaritalStatus = MaritalStatus;
//    }
//    public void setPreviousLastName(String PreviousLastName)
//    {
//        this.PreviousLastName = PreviousLastName;
//    }
//
//    public void setCurrentPrimaryHCPId(String CurrentPrimaryHCPId) {
//       this.CurrentPrimaryHCPId = CurrentPrimaryHCPId;
//       
//    }
//
////    public void setActive(boolean active) {
////       this.active = active;
////    }
//
//    public void setComments(String Comments) {
//       this.Comments = Comments;
//    }
//
//    public void setSubscriberRelationship(String SubscriberRelationship) 
//    {
//       this.SubscriberRelationship = SubscriberRelationship;
//    }
//
//    public void setNextOfKin(String NextOfKin) {
//       this.NextOfKin = NextOfKin;
//    }
//
//
//    public void setNextOfKinRelationshipToPatient(String nextOfKinRelationshipToPatient) {
//       this.NextOfKinRelationshipToPatient = NextOfKinRelationshipToPatient;
//    }
//
//
//   
//}
//        
//
//
//    