/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Desktop;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ebubekir
 */
public class CustomTableModel extends DefaultTableModel{
    public CustomTableModel()
    {
        
    }
    
    public CustomTableModel(Object[][] data, Object[] columnNames)
    {
        super( data,columnNames);
    }
}
