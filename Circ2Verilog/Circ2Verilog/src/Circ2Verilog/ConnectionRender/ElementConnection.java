/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.ConnectionRender;

/**
 *
 * @author Ebubekir
 */
public class ElementConnection {
    private Elementable OutElement;
    private Elementable InElement;
    private Connectorable InConnector;
    private Connectorable OutConnector;

    public ElementConnection(Elementable OutElement, Elementable InElement, Connectorable InConnector, Connectorable OutConnector) {
        this.OutElement = OutElement;
        this.InElement = InElement;
        this.InConnector = InConnector;
        this.OutConnector = OutConnector;
    }

    public Elementable getOutElement() {
        return OutElement;
    }

    public void setOutElement(Elementable OutElement) {
        this.OutElement = OutElement;
    }

    public Elementable getInElement() {
        return InElement;
    }

    public void setInElement(Elementable InElement) {
        this.InElement = InElement;
    }

    public Connectorable getInConnector() {
        return InConnector;
    }

    public void setInConnector(Connectorable InConnector) {
        this.InConnector = InConnector;
    }

    public Connectorable getOutConnector() {
        return OutConnector;
    }

    public void setOutConnector(Connectorable OutConnector) {
        this.OutConnector = OutConnector;
    }
    
    
}
