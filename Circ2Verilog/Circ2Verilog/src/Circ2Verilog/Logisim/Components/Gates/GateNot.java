/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.Components.Gates;

import Circ2Verilog.Logisim.Position;
import Circ2Verilog.Logisim.Connector;
import Circ2Verilog.Logisim.Direction;
import Circ2Verilog.Logisim.ElementLabel;
import Circ2Verilog.Logisim.OutputConnector;
import Circ2Verilog.Logisim.PositionFactory;

/**
 *
 * @author Ebubekir
 */
public class GateNot extends BaseGate{
    public GateNot(int bitLength,int posX, int posY, ElementLabel label,Direction direction,int size) {
        super(bitLength, posX, posY, label,direction, "NOT GATE",size);
        Position conpos=PositionFactory.SingleConnectorPositionFactory(size,direction, position);
        Connector ocon=new OutputConnector(this, bitLength, new Position(posX, posY));        
        Connector icon=new OutputConnector(this, bitLength, conpos);
        this.connectors=new Connector[]{icon, ocon};
    }
}
