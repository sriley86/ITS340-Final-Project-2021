// Author Sharyl Riley 
//April 3, 2021


package v1porject_mc;

import javax.swing.JOptionPane;

public class Node {
    public int nodeID;
    public String question = null;
    public Node yesBranch  = null;
    public Node noBranch   = null;

    /* CONSTRUCTOR */
    public Node(int newNodeID, String newQuestion) {
        nodeID     = newNodeID;
        question = newQuestion;
    }
    
    public void displayNode() {
        JOptionPane.showMessageDialog(null, ("NodeID = " + nodeID + ", " + question));
    }
}
