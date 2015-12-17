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
import Circ2Verilog.Logisim.SizeableElement;

/**
 *
 * @author Ebubekir
 */
public abstract class BaseGate extends CircuitElement implements MultiBitable,SizeableElement {
    protected final int bitLength;
    protected int size;
    public BaseGate(int bitLength,int posX, int posY, ElementLabel label,Direction direction,String elementType,int size) {
        super(posX, posY, label,direction, elementType);
        this.bitLength=bitLength;
        this.size=size;
    }
    
    @Override
    public int getBitLength() {
        return bitLength;
    }
    
    @Override
    public int getSize()
    {
        return size;
    }
}
