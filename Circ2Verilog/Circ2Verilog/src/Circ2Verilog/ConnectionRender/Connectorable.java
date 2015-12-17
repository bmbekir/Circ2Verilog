/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.ConnectionRender;

/**
 *
 * @author Ebubekir
 */
public interface Connectorable {
    int getPosX();
    int getPosY();
    ConnectorType getConnectorType();
}
