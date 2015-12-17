/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.ConnectionRender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *
 * @author Ebubekir
 */
public class RenderMachine {
    
    private Connectorable[] Connectors;    
    private Wireable[] Wires;
    private Connectorable[] Inputs;
    private Connectorable[] Outputs;
    private Connectorable[] ElementInputs;
    private Connectorable[] ElementOutputs;
    private Connectorable[] ElementInouts;



    public RenderMachine(Connectorable[] Connectors,Wireable[] wires) {
        this.Connectors = Connectors;
        ArrayList<Connectorable> v= new ArrayList<Connectorable>();
        v.addAll(Arrays.asList(Connectors));
        Stream<Connectorable> s=v.stream();
        Object[] toArray = s.filter(b->b.getConnectorType()==ConnectorType.Input).toArray();
        for (int i = 0; i < toArray.length; i++) {
            Inputs[i]=(Connectorable) toArray[i];
        }
        
        toArray = s.filter(b -> b.getConnectorType() == ConnectorType.Output).toArray();
        for (int i = 0; i < toArray.length; i++) {
            Outputs[i] = (Connectorable) toArray[i];
        }
        
        toArray = s.filter(b -> b.getConnectorType() == ConnectorType.ElementInout).toArray();
        for (int i = 0; i < toArray.length; i++) {
            ElementInouts[i] = (Connectorable) toArray[i];
        }
        
        toArray = s.filter(b -> b.getConnectorType() == ConnectorType.ElementOutput).toArray();
        for (int i = 0; i < toArray.length; i++) {
            ElementOutputs[i] = (Connectorable) toArray[i];
        }
        toArray = s.filter(b -> b.getConnectorType() == ConnectorType.ElementInput).toArray();
        for (int i = 0; i < toArray.length; i++) {
            ElementInputs[i] = (Connectorable) toArray[i];
        }
    }
    
    
    
    public ElementConnection[] Render()
    {
        ArrayList<ElementConnection> v= new ArrayList<ElementConnection>();
       
       ElementConnection[] arr= new ElementConnection[v.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=v.get(i);
        }
       return arr;
    }
}
