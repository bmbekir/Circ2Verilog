/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.Components.Gates;

import Circ2Verilog.Logisim.CircuitElement;
import Circ2Verilog.Logisim.Direction;
import Circ2Verilog.Logisim.ElementLabel;
import Circ2Verilog.Logisim.MultiBitable;

/**
 *
 * @author Ebubekir
 */
public class GateAnd extends MultiInputGate{

    public GateAnd(int bitLength,int posX, int posY, ElementLabel label,Direction direction,int size,int inputLength) {
        super(bitLength, posX, posY, label,direction, "AND GATE",size,inputLength);
    }
    
    
   
    
}
