/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1porject_mc;

/**
 * @author sharylriley
 * April 17, 2021
 */
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import javax.swing.JOptionPane;

public class DecisionTreeClass {

    static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
    static BloodType_Tree newBloodTypleTree;
    static rh_Tree newrhTree;
    static MaritalStatus_Tree newMsTree;
    static Alcohol_Tree newAlcoholTree;
    static Tobacco_Tree newTobaccoTree;
    static Drug_Tree newDrugTree;
    static Allergy_Tree newAllergyTree;

    
        //called by the patient demographics form 
        // automated interview button
    public static void runFullAutomatedInterview() {

        startBloodTypeTree();
        startRhTree();
        startMaritalStatusTree();
        startAlcoholTree();
        startTobaccoTree();
        startDrugTree();
        startAllergyTree();
        
        printHeaderToFile();
        queryTree();
        optionToExit();

    }
    
    public static void runGenMedAutomatedInterview(){
       
        startAlcoholTree();
        startTobaccoTree();
        startDrugTree();
        
        
        printHeaderToFile();
        queryTreeGenMed();
        optionToExit();  
        
    }
    
    public static void runAllergyAutomatedInterview(){
        
        startAllergyTree();
        
        printHeaderToFile();
        queryTreeAllergy();
        optionToExit();
    }

    private static void startBloodTypeTree() {

        newBloodTypleTree = new BloodType_Tree();
        newBloodTypleTree.createRoot(1, "I would like to ask you about your general medical history?"); //if no exit program
        newBloodTypleTree.addYesNode(1, 2, "Do you know your Blood Type?"); //if no, goes to rH_Tree
        newBloodTypleTree.addNoNode(1, 3, "We Understand, Thank you for your time."); // no, exit program
        newBloodTypleTree.addYesNode(2, 4, "Is your Blood Type O?");
        newBloodTypleTree.addNoNode(2, 5, "Thank you, your answer has been received as Blood Type Unknown");
        newBloodTypleTree.addYesNode(4, 6, "Thank you, your answer has been received as Blood Type 0");
        newBloodTypleTree.addNoNode(4, 7, "Is your Blood Type A?");
        newBloodTypleTree.addYesNode(7, 6, "Thank you, your answer has been received as Blood Type A");
        newBloodTypleTree.addNoNode(7, 9, "Is your Blood Type B?");
        newBloodTypleTree.addYesNode(9, 6, "Thank you, your answer has been received as Blood Type B");
        newBloodTypleTree.addNoNode(9, 10, "Is your Blood Type AB?");
        newBloodTypleTree.addYesNode(10, 6, "Thank you, your answer has been received as Blood Type AB");
        newBloodTypleTree.addNoNode(10, 5, "The rH Facotor is next");
    }

    private static void startRhTree() {
        // rH Factor_Tree
        newrhTree = new rh_Tree();
        newrhTree.createRoot(30, "Do you know your rH Factor?");
        newrhTree.addYesNode(30, 31, "Are you rH Positive?");
        newrhTree.addNoNode(30, 32, "Thank you, your answer has been received as rH Factor Unknown.");
        newrhTree.addYesNode(31, 33, "Thank you, your answer has been received as rH Positive.");
        newrhTree.addNoNode(31, 34, "Are you rH Negative? ");
        newrhTree.addYesNode(34, 35, "Thank you, your answer has been received as rH Negative.");
        newrhTree.addNoNode(34, 36, "The Marrial Status is next.");
    }

    private static void startMaritalStatusTree() {
        // MarritalStatus_Tree
        newMsTree = new MaritalStatus_Tree();
        newMsTree.createRoot(11, "Are you Married?");
        newMsTree.addYesNode(11, 12, "Thank you, your answer has been received as Married.");
        newMsTree.addNoNode(11, 13, "Thank you, your answer has been received as  NOT Married.");
    }

    private static void startAlcoholTree() {
        //Alcohol_Tree
        newAlcoholTree = new Alcohol_Tree();
        newAlcoholTree.createRoot(14, "Do you consume Alcohol?");
        newAlcoholTree.addYesNode(14, 15, "Do you consume Beer/Wine?");
        newAlcoholTree.addNoNode(14, 16, "Thank you, your answer has been received as DOES NOT Consume Alcohol.");
        newAlcoholTree.addYesNode(15, 17, "Do you comsume Beer/Wine Weekly?");
        newAlcoholTree.addNoNode(15, 18, "Do you consume Hard Liquor?");
        newAlcoholTree.addYesNode(17, 19, "Thank you, your answer has been received as Consumes Beer/Wine Weekly.");
        newAlcoholTree.addNoNode(17, 20, "Do You consume Beer/Wine Monthly?");
        newAlcoholTree.addYesNode(18, 21, "Do you comsume Hard Liquor Weekly?");
        newAlcoholTree.addNoNode(18, 22, "Thank you, your answer has been received as DOES NOT Consume Hard Liquor.");
        newAlcoholTree.addYesNode(20, 25, "Thank you, your answer has been received as Consumes Beer/Wine Monthly.");
        newAlcoholTree.addNoNode(20, 26, "beer/wine monthly end");
        newAlcoholTree.addYesNode(21, 27, "Thank you, your answer has been received as Consumes Hard Liquor Weekly.");
        newAlcoholTree.addNoNode(21, 28, "Do you comsume Hard Liquor Monthly?");
        newAlcoholTree.addYesNode(28, 31, "Thank you, your answer has been received as Consumes Hard Liquor Monthly.");
        newAlcoholTree.addNoNode(28, 32, "The Tobacco is next");
    }

    private static void startTobaccoTree() {
        //Tobacco_Tree
        newTobaccoTree = new Tobacco_Tree();
        newTobaccoTree.createRoot(40, "Do you use Tobacco?");
        newTobaccoTree.addYesNode(40, 41, "Do you Smoke Tobacco?");
        newTobaccoTree.addNoNode(40, 42, "Thank you, your answer has been received as DOESNOT Use Tobacco.");
        newTobaccoTree.addYesNode(41, 43, "Do you Smoke Tobacco Weekly?");
        newTobaccoTree.addNoNode(41, 44, "Do you Chew Tobacco?");
        newTobaccoTree.addYesNode(43, 45, "Thank you, your answer has been received as Smokes Tobacco Weekly.");
        newTobaccoTree.addNoNode(43, 46, "Do You Smoke Tobacco Monthly?");
        newTobaccoTree.addYesNode(44, 47, "Do you Chew Tobacco Weekly?");
        newTobaccoTree.addNoNode(44, 48, "Thank you, your answer has been received as DOESNOT Chew Tabacco.");
        newTobaccoTree.addYesNode(46, 51, "Thank you, your answer has been received as Smokes Tobacco Monthly.");
        newTobaccoTree.addNoNode(46, 52, "smokes tobacco monthly end");
        newTobaccoTree.addYesNode(47, 53, "Thank you, your answer has been received as Chews Tobacco Weekly.");
        newTobaccoTree.addNoNode(47, 54, "Do you Chew Tobacco Monthly?");
        newTobaccoTree.addYesNode(54, 57, "Thank you, your answer has been received as Chews Tobacco Monthly.");
        newTobaccoTree.addNoNode(54, 58, "The Drugs is next");
    }

    private static void startDrugTree() {
        //Drug_Tree
        newDrugTree = new Drug_Tree();
        newDrugTree.createRoot(60, "Do you use Drugs?");
        newDrugTree.addYesNode(60, 61, "Do you use Stimulants - Cocaine, Meth, Ecstasy, etc.?");
        newDrugTree.addNoNode(60, 62, "Thank you, your answer has been received as DOESNOT Use Drugs.");
        newDrugTree.addYesNode(61, 63, "Do you use Stimulants - Cocaine, Meth, Ecstasy, etc Weekly?");
        newDrugTree.addNoNode(61, 64, "Do you use Depressants - Cannabis, Heroin, Opioids, etc.?");
        newDrugTree.addYesNode(63, 65, "Thank you, your answer has been received as use Depressants - Cannabis, Heroin, Opioids, etc. Weekly.");
        newDrugTree.addNoNode(63, 66, "Do You use Stimulants - Cocaine, Meth, Ecstasy, etco Monthly?");
        newDrugTree.addYesNode(64, 67, "Do you use Depressants - Cannabis, Heroin, Opioids, etc. Weekly?");
        newDrugTree.addNoNode(64, 68, "Thank you, your answer has been received as DOES NOT use Depressants - Cannabis, Heroin, Opioids, etc..");
        newDrugTree.addYesNode(66, 71, "Thank you, your answer has been received as uses Stimulants - Cocaine, Meth, Ecstasy, etc Monthly");
        newDrugTree.addNoNode(66, 72, "Uses Stimulants - Cocaine, Meth, ecstasy, etc monthly end");
        newDrugTree.addYesNode(67, 73, "Thank you, your answer has been received as use Depressants - Cannabis, Heroin, Opioids, etc. Weekly.");
        newDrugTree.addNoNode(67, 74, "Do you use Depressants - Cannabis, Heroin, Opioids, etc. Monthly Monthly?");
        newDrugTree.addYesNode(74, 77, "Thank you, your answer has been received as use Depressants - Cannabis, Heroin, Opioids, etc. Monthly.");
        newDrugTree.addNoNode(74, 78, "The Allergy is next");
    }

    private static void startAllergyTree() {
        //Allergy_Tree
        newAllergyTree = new Allergy_Tree();
        newAllergyTree.createRoot(80, "Do you have Allergies?");
        newAllergyTree.addYesNode(80, 81, "Are your allergies Environmental - Dust Mites, Pollen, Pet Dander, Mold, etc.?");
        newAllergyTree.addNoNode(80, 82, "Thank you, your answer has been received as DOESNOT have Allergies.");
        newAllergyTree.addYesNode(81, 83, "Did your Allergies start while an Adolescent?");
        newAllergyTree.addNoNode(81, 84, "Are your allergies Food - Dairy, Glutten, Tree Nuts, Soy, etc.?");
        newAllergyTree.addYesNode(83, 85, "Are your Food Allergies Adolescence Severe?");
        newAllergyTree.addNoNode(83, 86, "Did your Environmental Allergies start in Adulthood?");
        newAllergyTree.addYesNode(84, 87, "Did your Food Allergies start in Adolescence?");
        newAllergyTree.addNoNode(84, 88, "Thank you, your answer has been received as DOESNOT have Food Allergies.");
        newAllergyTree.addYesNode(85, 89, "Thank you, your answer has been received as Allergies Environmental Adolescence are Severe. ");
        newAllergyTree.addNoNode(85, 90, "Are your Environmental  Adolescence Allergies Mild? ");
        newAllergyTree.addYesNode(86, 91, "Are your Environmental Adulthood Allergies Severe?");
        newAllergyTree.addNoNode(86, 92, "Thank you, Environmental Adulthood end");
        newAllergyTree.addYesNode(87, 93, "Are your Food Adolescence Allergies Severe?");
        newAllergyTree.addNoNode(87, 94, "Did your Food Allergies start in Adulthood?");
        newAllergyTree.addYesNode(90, 95, "Thank you, your answer has been received as Allergies Environmental Adolescence Mild.");
        newAllergyTree.addNoNode(90, 96, "Environmental Allergy Adolescence Mild end ");
        newAllergyTree.addYesNode(91, 97, "Thank you, your answer has been received as Allergies Environmental Adulthood Severe. ");
        newAllergyTree.addNoNode(91, 98, "Are your Invironmental Adulthood Allergies Mild? ");
        newAllergyTree.addYesNode(93, 99, "Thank you, your answer has been received as Allergies Food Adolescence Severe. ");
        newAllergyTree.addNoNode(93, 100, "Are your Food Adolescence Allergies Mild? ");
        newAllergyTree.addYesNode(94, 101, "Are your Food Adulthood Allergies Severe? ");
        newAllergyTree.addNoNode(94, 102, "Thank you, Food Allergy Adulthood end.");
        newAllergyTree.addYesNode(98, 103, "Thank you, your answer has been received as Environmental Adolescence Allergies Mild. ");
        newAllergyTree.addNoNode(98, 104, "Invironmental Allergy Adulthood Mild end ");
        newAllergyTree.addYesNode(100, 105, "Thank you, your answer has been received as Food Adolescence Allergies Mild. ");
        newAllergyTree.addNoNode(100, 106, "Food Allergy Adolescence Mild end ");
        newAllergyTree.addYesNode(101, 107, "Thank you, your answer has been received Allergies Food Adulthood Severe.");
        newAllergyTree.addNoNode(101, 108, "Thank you, your answer has been received as Allergies Food Adulthood Mild.");
    }

    //Query Tree Method
    static void queryTree() {

        newBloodTypleTree.queryBinTree();
        newrhTree.queryBinTree();
        newMsTree.queryBinTree();
        newAlcoholTree.queryBinTree();
        newTobaccoTree.queryBinTree();
        newDrugTree.queryBinTree();
        newAllergyTree.queryBinTree();

    }
    
    static void queryTreeGenMed(){
        
        newAlcoholTree.queryBinTree();
        newTobaccoTree.queryBinTree();
        newDrugTree.queryBinTree();
    }
    
    static void queryTreeAllergy(){
        newAllergyTree.queryBinTree();
    }

    // Exit Tree
    static void optionToExit() {
        try {

            int res = JOptionPane.showOptionDialog(null, "Exit?", "Exit Option",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    new Object[]{"Yes", "No"}, JOptionPane.YES_OPTION);

            if (res == JOptionPane.YES_OPTION) {
                return;
            } else if (res == JOptionPane.NO_OPTION) {
                queryTree();
            }

        } catch (Exception e) {
            System.out.println("Keyboard input error!");
        }
    }

    // Print Timestamp into File
    private static void printHeaderToFile() {
        Path file = Paths.get("C:\\test\\AutomatedInterview.txt"); //holds the date stamp, patient id and tree responses

        try {
            //open up channel to file
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.APPEND));
            //create writer object to write data to file
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            Instant instant = Instant.now(); //timestamp

            {
                //instant = timestamp
                writer.write(instant + "\n");
            }

            writer.close();
            output.close();
        } catch (Exception e) {
            System.out.println("Error Message: " + e);
        }

    }
}
