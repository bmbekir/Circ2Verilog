/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.Components.Wiring;

import Circ2Verilog.ConnectionRender.ConnectorType;
import Circ2Verilog.Logisim.Direction;
import Circ2Verilog.Logisim.ElementLabel;

/**
 *
 * @author Ebubekir
 */
public class InputPin extends Pin {

    public InputPin(int bitLength, int posX, int posY,ElementLabel label,Direction direction) {
        super(bitLength, posX, posY,label, direction,"Input Pin");
    }

    @Override
    public ConnectorType getConnectorType() {
        return ConnectorType.Input;
    }

}
