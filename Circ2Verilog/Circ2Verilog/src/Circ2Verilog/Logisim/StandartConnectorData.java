/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Logisim;

import java.util.Hashtable;

/**
 *
 * @author Ebubekir
 */
class StandartConnectorData {

    private final Hashtable<Integer, Integer> ConnectorDiffs30;
    private final Hashtable<Integer, Integer> ConnectorDiffs50;
    private final Hashtable<Integer, Integer> ConnectorDiffs70;
    public StandartConnectorData() {
        ConnectorDiffs30= new Hashtable<Integer,Integer>();        
        ConnectorDiffs50= new Hashtable<Integer,Integer>();
        ConnectorDiffs70= new Hashtable<Integer,Integer>();
        
        for (int i = -15; i < 16; i++) {
           ConnectorDiffs30.put(i, i*10);           
           ConnectorDiffs30.put(i, i*10);
           ConnectorDiffs30.put(i, i*10);
        }
        
        

    }
    
    
}
