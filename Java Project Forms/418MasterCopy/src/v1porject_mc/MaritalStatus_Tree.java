// Author Sharyl Riley 
//April 3, 2021


package v1porject_mc;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JOptionPane;

public class MaritalStatus_Tree {

    Node root = null;

    public MaritalStatus_Tree() {
     root = null;
    }  
    // CREATE ROOT NODE
    public void createRoot(int newRootNodeID, String newQuestion) {
	root = new Node(newRootNodeID,newQuestion);	
	System.out.println("Created root node " + newRootNodeID);	
	}
			
    // ADD YES NODE
    public void addYesNode(int existingNodeID, int newNodeID, 
            String newQuestion) {
	// If no root node do nothing
	if (root == null) {
	    System.out.println("ERROR: No root node!  Use createRoot method to create a root node");
	    return;
	    }
	
	// Search tree
	if (searchTreeAndAddYesNode(root,existingNodeID,newNodeID, 
                newQuestion)) {
	    System.out.println("Added node " + newNodeID +
	    		" onto \"yes\" branch of node " + existingNodeID);
	    }
	else {
            System.out.println("Node " + existingNodeID + " not found");
        }
    }
    
    /* SEARCH TREE AND ADD YES NODE */

    private boolean searchTreeAndAddYesNode(Node currentNode,
    	int existingNodeID, int newNodeID, String question) {
    	if (currentNode.nodeID == existingNodeID) {
	    // Found node
	    if (currentNode.yesBranch == null) {
                currentNode.yesBranch = new Node(newNodeID, question);
            }
	    else {
	        System.out.println("WARNING: Overwriting previous node " +
			"(id = " + currentNode.yesBranch.nodeID +
			") linked to yes branch of node " +
			existingNodeID);
		currentNode.yesBranch = new Node(newNodeID,question);
		}		
    	    return(true);
	    }
	else {
	    // Try yes branch if it exists
	    if (currentNode.yesBranch != null) { 	
	        if (searchTreeAndAddYesNode(currentNode.yesBranch,
		        	existingNodeID,newNodeID,question)) {    	
	            return(true);
		}	
		else {
    	            // Try no branch if it exists
	    	    if (currentNode.noBranch != null) {
    	    		return(searchTreeAndAddYesNode(currentNode.noBranch,
				existingNodeID,newNodeID,question));
                    }
		    else {
                        return(false);  // Not found
                    }	
		}
            }
	    return(false);		// Not found
	}
    } 	

      /* ADD NO NODE */

    public void addNoNode(int existingNodeID, int newNodeID, String question) {
	// If no root node do nothing
	
	if (root == null) {
	    System.out.println("ERROR: No root node!");
	    return;
	    }
	
	// Search tree
	
	if (searchTreeAndAddNoNode(root,existingNodeID,newNodeID,question)) {
	    System.out.println("Added node " + newNodeID +
	    		" onto \"no\" branch of node " + existingNodeID);
	    }
	else System.out.println("Node " + existingNodeID + " not found");
	}
	
    /* SEARCH TREE AND ADD NO NODE */

    private boolean searchTreeAndAddNoNode(Node currentNode,
    			int existingNodeID, int newNodeID, String newQuestAns) {
    	if (currentNode.nodeID == existingNodeID) {
	    // Found node
	    if (currentNode.noBranch == null) {
                currentNode.noBranch = new Node(newNodeID,newQuestAns);
            }
	    else {
	        System.out.println("WARNING: Overwriting previous node " +
			"(id = " + currentNode.noBranch.nodeID +
			") linked to yes branch of node " +
			existingNodeID);
		currentNode.noBranch = new Node(newNodeID,newQuestAns);
            }		
    	    return(true);
	}
	else {
	    // Try yes branch if it exists
	    if (currentNode.yesBranch != null) { 	
	        if (searchTreeAndAddNoNode(currentNode.yesBranch,
		        	existingNodeID,newNodeID,newQuestAns)) {    	
	            return(true);
		}	
		else {
    	        // Try no branch if it exists
	    	    if (currentNode.noBranch != null) {
    	    		return(searchTreeAndAddNoNode(currentNode.noBranch,
				existingNodeID,newNodeID,newQuestAns));
                    }
		    else {
                        return(false);	// Not found here
		    }
		 }
            }
	    else {
                return(false);	// Not found here
	    }
   	} 
    }

    public void queryBinTree() {
        queryBinTree(root);
        }

   private void queryBinTree(Node currentNode) {
        
        // Test for leaf node (answer) and missing branches
       
            if (currentNode.yesBranch == null) {
                if (currentNode.noBranch == null) {
                    //System.out.println("Hello" + currentNode.question); //print in console
                    
                    printToFile(currentNode);
                    
                } else {
                    System.out.println("Error: Missing \"Yes\" branch at \""
                            + currentNode.question + "\" question");
                }
                 return;
            }
            if (currentNode.noBranch == null) {
                System.out.println("Error: Missing \"No\" branch at \""
                        + currentNode.question + "\" question");
                return;
            }

        // Question
        askQuestion(currentNode);
    }    

    private void askQuestion(Node currentNode) {
        try 
        {
            int res = JOptionPane.showOptionDialog(null, currentNode.question,"Marital Status Tree",
         JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
         new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
            
            if (res == JOptionPane.YES_OPTION) 
                {
                    queryBinTree(currentNode.yesBranch);
                }
            
                else if (res == JOptionPane.NO_OPTION) {
                    queryBinTree(currentNode.noBranch);
                    }
                else if (res == JOptionPane.CLOSED_OPTION) {
                     askQuestion(currentNode);
                }
            
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, ("Keyboard input error"), "AskQuestion", JOptionPane.ERROR_MESSAGE);
        }
    }
     private void printToFile(Node currentNode) {
        Path file = Paths.get("c:\\test\\AutomatedInterview.txt"); //holds the date stamp, patient id and tree responses
        
        try {
            //open up channel to file
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.APPEND));
            //create writer object to write data to file
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
            {
                 //write out record to file
                
                writer.write(currentNode.question + "\n");

            }

            writer.close();
            output.close();
        } catch (Exception e) {
            System.out.println("Error Message: " + e);
        }

    }
}
