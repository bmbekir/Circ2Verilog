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
public class CircuitTableModel extends CustomTableModel{
    private Circuit circuit;

    public CircuitTableModel(Circuit circuit) {
        this.circuit = circuit;
    }

    public CircuitTableModel(Circuit circuit, Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        this.circuit = circuit;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }
    
}
