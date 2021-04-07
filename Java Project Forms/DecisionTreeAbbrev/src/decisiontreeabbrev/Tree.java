
package decisiontreeabbrev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree {

    Node root = null;

    public Tree() {
        root = null;
    }  
    // Setup keyboard input
    static BufferedReader keyboardInput = 
            new BufferedReader(new InputStreamReader(System.in)); 
    
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

        if (currentNode.yesBranch==null) {
            if (currentNode.noBranch==null) 
            {
                System.out.println(currentNode.question);
            }
            else 
            {
                System.out.println("Error: Missing \"Yes\" branch at \"" +
            		currentNode.question + "\" question");
            }
            return;
        }
        if (currentNode.noBranch==null) {
            System.out.println("Error: Missing \"No\" branch at \"" +
            		currentNode.question + "\" question");
            return;
        }

        // Question

        askQuestion(currentNode);
        }

    private void askQuestion(Node currentNode) {
        try 
        {
            System.out.println(currentNode.question + 
                    " (enter \"Yes\" or \"No\")");
            String answer = keyboardInput.readLine();
            if (answer.equals("Yes")) {
                queryBinTree(currentNode.yesBranch);
            }
            else {
                if (answer.equals("No")) {
                    queryBinTree(currentNode.noBranch);
                }
                else {
                    System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                    askQuestion(currentNode);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Keyboard input error");
        }
    }
}
