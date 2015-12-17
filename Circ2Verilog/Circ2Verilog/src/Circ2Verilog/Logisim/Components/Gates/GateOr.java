/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.Components.Gates;

import Circ2Verilog.Logisim.Direction;
import Circ2Verilog.Logisim.ElementLabel;

/**
 *
 * @author Ebubekir
 */
public class GateOr extends MultiInputGate{

    public GateOr(int bitLength, int posX, int posY, ElementLabel label,Direction direction,int size,int inputLength) {
        super(bitLength, posX, posY, label,direction, "OR GATE",size,inputLength);
    }
    
}
