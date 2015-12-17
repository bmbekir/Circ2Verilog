/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Desktop;

import Circ2Verilog.Logisim.Circuit;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Ebubekir
 */
public class CustomMutableTreeNode extends DefaultMutableTreeNode{
    private Circuit circuit;

    public CustomMutableTreeNode(Circuit circuit) {
        this.circuit = circuit;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public CustomMutableTreeNode(Circuit circuit, Object userObject) {
        super(userObject);
        this.circuit = circuit;
    }

    public CustomMutableTreeNode(Circuit circuit, Object userObject, boolean allowsChildren) {
        super(userObject, allowsChildren);
        this.circuit = circuit;
    }
    
    
    
    
}
