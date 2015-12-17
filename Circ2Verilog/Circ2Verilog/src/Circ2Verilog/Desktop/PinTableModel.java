/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Desktop;

import Circ2Verilog.Logisim.Circuit;

/**
 *
 * @author Ebubekir
 */
public class PinTableModel extends CircuitTableModel {

    public PinTableModel(Circuit circuit,boolean output) {
        super(circuit,new Object [][] {

            },
            new String [] {
                "Label", "BitLength", "PosX", "PosY"
            });

    }
    Class[] types = new Class[]{
        java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
    };
    boolean[] canEdit = new boolean[]{
        false, false, false, false, false
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

}
