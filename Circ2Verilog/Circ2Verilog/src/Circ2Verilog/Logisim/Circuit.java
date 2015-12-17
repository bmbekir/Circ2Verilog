/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

import Circ2Verilog.Logisim.Components.Wiring.Wire;
import Circ2Verilog.Logisim.Components.Wiring.OutputPin;
import Circ2Verilog.Logisim.Components.Wiring.InputPin;
import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Ebubekir
 */
public class Circuit {
    
    private final Vector<CircuitElement> elements;
    private final Vector<InputPin> inputs;
    private final Vector<OutputPin> outputs;
    private final Vector<Connector> connectors;
    private final Vector<Wire> wires;
    
    public Circuit()
    {
        this.elements= new Vector<CircuitElement>();        
        this.inputs= new Vector<InputPin>();
        this.outputs= new Vector<OutputPin>();
        this.wires= new Vector<Wire>();
        this.connectors= new Vector<Connector>();
    }

    public Connector[] getConnectors() {
         Connector[] a= new Connector[connectors.size()];
        for (int i = 0; i < connectors.size(); i++) {
            a[i]=connectors.get(i);
        }
        return a;
    }

    public ElementLabel getSharedLabel() {
        return sharedLabel;
    }

    public void setSharedLabel(ElementLabel sharedLabel) {
        this.sharedLabel = sharedLabel;
    }
    
    

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public void addComponent(CircuitElement element) {
        if(element instanceof InputPin)
            inputs.add((InputPin)element);
        
        if(element instanceof OutputPin)
            outputs.add((OutputPin)element);
        
        elements.add(element);
    }
    
    public void addConnector(Connector c)
    {
        this.connectors.add(c);
    }
    
    public void addConnectors(Connector[] c)
    {
        this.connectors.addAll(Arrays.asList(c));
    }
    
    
    public boolean addWire(Wire w)
    {
        for (Wire wire : wires) {
            if (w.equals(wire)) {
                return false;
            }
        }
        wires.add(w);
        return true;
    }
    
    public Wire[] getWires() {
         Wire[] a= new Wire[wires.size()];
        for (int i = 0; i < wires.size(); i++) {
            a[i]=wires.get(i);
        }
        return a;
    }

    public CircuitElement[] getElements() {
         CircuitElement[] a= new CircuitElement[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            a[i]=elements.get(i);
        }
        return a;
    }

    public InputPin[] getInputs() {
        InputPin[] a= new InputPin[inputs.size()];
        for (int i = 0; i < inputs.size(); i++) {
            a[i]=inputs.get(i);
        }
        return a;
    }

    public OutputPin[] getOutputs() {
        OutputPin[] a= new OutputPin[outputs.size()];
        for (int i = 0; i < outputs.size(); i++) {
            a[i]=outputs.get(i);
        }
        return a;
    }
    
    private String circuitName;
    private ElementLabel sharedLabel;
}
