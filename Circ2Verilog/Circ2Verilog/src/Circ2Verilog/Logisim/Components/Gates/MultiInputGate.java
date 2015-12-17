/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.Components.Gates;

import Circ2Verilog.Logisim.CircuitFactory;
import Circ2Verilog.Logisim.Connector;
import Circ2Verilog.Logisim.Direction;
import Circ2Verilog.Logisim.ElementLabel;
import Circ2Verilog.Logisim.InputConnector;
import Circ2Verilog.Logisim.MultiInputable;
import Circ2Verilog.Logisim.OutputConnector;
import Circ2Verilog.Logisim.PositionFactory;

/**
 *
 * @author Ebubekir
 */
public abstract class MultiInputGate extends BaseGate implements MultiInputable{

    public MultiInputGate(int bitLength, int posX, int posY, ElementLabel label,Direction direction, String elementType, int size,int inputLength) {
        super(bitLength, posX, posY, label,direction, elementType, size);
        this.inputLength=inputLength;
        createConnectors();
    }
    
    
    protected int inputLength;
    
    @Override
    public int getInputLength() {
      return inputLength;
    }
    
    protected final void createConnectors()
    {
        connectors= new Connector[inputLength+1];
        connectors[0]= new OutputConnector(this, bitLength, position);
        for (int i = 0; i < inputLength; i++) {
            connectors[i+1]= new InputConnector(this, this.bitLength, PositionFactory.StandardConnectorPositionFactory(i,size, inputLength, this.getDirection(), position));
        }
    }
        
    
}
