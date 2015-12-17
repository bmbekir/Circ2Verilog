/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

import Circ2Verilog.ConnectionRender.Elementable;

/**
 *
 * @author Ebubekir
 */
public class CircuitElement implements Elementable{
    protected Position position;
    protected ElementLabel label;
    private final String elementType;
    protected Connector[] connectors;
    protected Direction direction;
    
    
    protected CircuitElement(int posX, int posY,ElementLabel label,Direction direction,String elementType) {
        this.position= new Position(posX, posY);
        this.label=label;
        this.elementType=elementType;
        connectors= new Connector[0];
        this.direction= direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }


    public Connector[] getConnectors() {
        return connectors;
    }
  
    public String getElementType()
    {
        return elementType;
    }

    public ElementLabel getLabel() {
        return label;
    }

    public int getPosX() {
        return position.getX();
    }

    public int getPosY() {
        return position.getY();
    }

    
    
}
