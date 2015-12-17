/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

/**
 *
 * @author Ebubekir
 */
public class PositionFactory {
    private PositionFactory()
    {
        
    }
    
     public static Position SingleConnectorPositionFactory(int size, Direction direction,Position elementPosition)
    {
        switch(direction)
        {
            case West:
                return new Position(elementPosition.getX()+size, elementPosition.getY());
            case East:
                return new Position(elementPosition.getX()-size, elementPosition.getY());
            case North:
                return new Position(elementPosition.getX(),elementPosition.getY()+size);
            case South:
                return new Position(elementPosition.getX(),elementPosition.getY()-size);
            default:
                return null;
        }
        
        
    }
    
    public static Position StandardConnectorPositionFactory(int inputIndex,int size,int inputLength, Direction direction,Position elementPosition,boolean isNot)
    {
        int x=size+(isNot?10:0);
        int y=0;
        if(inputIndex==0)
            y=10;
        if(inputIndex==1)
            y=-10;
        
        switch(direction)
        {
            case West:
                return new Position(elementPosition.getX()+x, elementPosition.getY()-y);
            case East:
                return new Position(elementPosition.getX()-x, elementPosition.getY()-y);
            case North:
                return new Position(elementPosition.getX()-y,elementPosition.getY()+x);
            case South:
                return new Position(elementPosition.getX()-y,elementPosition.getY()-x);
            default:
                return null;
        }
        
        
    }
    
    public static Position StandardConnectorPositionFactory(int inputIndex,int size,int inputLength, Direction direction,Position elementPosition)
    {
        return StandardConnectorPositionFactory(inputIndex,size, inputLength, direction, elementPosition,false);
    }
}
