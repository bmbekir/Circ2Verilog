/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

import Circ2Verilog.ConnectionRender.ConnectorType;

/**
 *
 * @author Ebubekir
 */
public class OutputConnector extends Connector{

    public OutputConnector(CircuitElement parent, int bitLength, Position position) {
        super(parent, bitLength, position);
    }

    @Override
    public ConnectorType getConnectorType() {
        return ConnectorType.ElementOutput;
    }
    
}
