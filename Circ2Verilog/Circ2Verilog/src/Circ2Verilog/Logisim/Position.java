/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

/**
 *
 * @author Ebubekir
 */
public class Position {
    private int x;    
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString()
    {
        return String.format("%1s %2s ", String.format("%03d", x),String.format("%03d", y));
    }
    
    
}
