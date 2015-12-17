/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.Components.Wiring;

import Circ2Verilog.ConnectionRender.ConnectorType;
import Circ2Verilog.ConnectionRender.Connectorable;
import Circ2Verilog.Logisim.CircuitElement;
import Circ2Verilog.Logisim.Direction;
import Circ2Verilog.Logisim.ElementLabel;
import Circ2Verilog.Logisim.MultiBitable;
import Circ2Verilog.Logisim.PullBehavior;

/**
 *
 * @author Ebubekir
 */
public abstract class Pin extends CircuitElement implements MultiBitable,Connectorable {

    protected int bitLength;
    protected Direction Facing;
    protected PullBehavior pullBehavior;
    protected boolean treeState;

    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }

    @Override
    public int getBitLength() {
        return bitLength;
    }

    public Direction getFacing() {
        return Facing;
    }

    public void setFacing(Direction Facing) {
        this.Facing = Facing;
    }

    protected Pin(int bitLength, int posX, int posY,ElementLabel label,Direction direction,String type) {
        super(posX, posY,label,direction,type);
        this.bitLength = bitLength;
    }

}
