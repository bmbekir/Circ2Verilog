/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

import Circ2Verilog.ConnectionRender.Connectorable;

/**
 *
 * @author Ebubekir
 */
public abstract class Connector implements Connectorable{
    private final int bitLength;
    private final Position position;
    private final CircuitElement parent;
    public int getBitLength() {
        return bitLength;
    }
    
    @Override
    public int getPosX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Position getPosition() {
        return position;
    }
    
    public CircuitElement getParent() {
        return parent;
    }

    protected Connector( CircuitElement parent,int bitLength,Position position) {
        this.bitLength = bitLength;
        this.parent = parent;
        this.position=position;
    }

    
    
    
}
