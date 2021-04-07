/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeabbrev;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DecisionTreeAbbrev {

    static BufferedReader keyboardInput = new
                           BufferedReader(new InputStreamReader(System.in));
    static Tree newTree;
    
    public static void main(String[] args) {
        
       newTree = new Tree();     
       
       System.out.println("\nGENERATE DECISION TREE");
       System.out.println("======================");
       newTree.createRoot(1,"Does animal eat meat?");
       newTree.addYesNode(1,2,"Does animal have stripes?");
       newTree.addNoNode(1,3,"Does animal have stripes?");
       newTree.addYesNode(2,4,"Animal is a Tiger");
       newTree.addNoNode(2,5,"Animal is a Leopard");
       newTree.addYesNode(3,6,"Animal is a Zebra");
       newTree.addNoNode(3,7,"Animal is a Horse");       
       System.out.println("\nQUERY DECISION TREE");
       System.out.println("===================");
       
       queryTree();
       optionToExit();       
    }
    
    /* QUERY TREE */
	
    static void queryTree() {
        System.out.println("\nQUERY DECISION TREE");
        System.out.println("===================");
        newTree.queryBinTree();

        optionToExit();
    } 
    static void optionToExit() {
        try {
            System.out.println("Exit? (enter \"Yes\" or \"No\")");
            String answer = keyboardInput.readLine();
            if (answer.equals("Yes")) return;
            else {
                if (answer.equals("No")) {
                    queryTree();
                }
                else {
                    System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                    optionToExit();
                }
            }
        }
        catch (Exception e) {
            System.out.println("Keyboard input error!");
        }
    }
}
