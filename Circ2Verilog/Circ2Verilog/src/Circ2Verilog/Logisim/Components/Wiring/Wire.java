/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim.Components.Wiring;

import Circ2Verilog.ConnectionRender.Wireable;
import Circ2Verilog.Logisim.AbstractConnector;
import Circ2Verilog.Logisim.Position;
import java.util.Objects;

/**
 *
 * @author Ebubekir
 */
public class Wire extends AbstractConnector implements Wireable{
    
    private Position from;
    private Position to;

    public Wire(int toX,int toY,int fromX,int fromY) {
        from= new Position(fromX, fromY);
        to= new Position(toX, toY);
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Wire))
            return false;
        Wire w=(Wire)obj;
        
        return w.from.getX()==this.from.getX()
             &&w.from.getY()==this.from.getY()
             &&w.to.getX()==this.to.getX()
             &&w.to.getY()==this.to.getY();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.from);
        hash = 83 * hash + Objects.hashCode(this.to);
        return hash;
    }
    
    

    @Override
    public int getLength() {
        return (int)Math.sqrt(Math.pow((double)from.getX()-(double)to.getX(), 2)+Math.pow((double)from.getY()-(double)to.getY(),2));
    }

    @Override
    public int getToX() {
        return getTo().getX();
    }

    @Override
    public int getToY() {
        return getTo().getY();
    }

    @Override
    public int getFromX() {
        return getFrom().getX();
    }

    @Override
    public int getFromY() {
        return getFrom().getY();
    }
    
    
    
}
