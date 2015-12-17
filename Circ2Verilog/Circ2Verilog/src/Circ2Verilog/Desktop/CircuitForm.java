 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Desktop;

import Circ2Verilog.Logisim.Components.Wiring.Wire;
import Circ2Verilog.Logisim.Components.Wiring.OutputPin;
import Circ2Verilog.Logisim.Components.Wiring.InputPin;
import Circ2Verilog.Logisim.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ebubekir
 */
public class CircuitForm extends javax.swing.JInternalFrame {
    Circuit circ;
    public CircuitForm(Circuit circ) {
        this.circ=circ;
        
        initComponents();
        
        
             try {
                        lblCircName.setText(circ.getCircuitName());
                        lblSharedLabelFacing.setText(circ.getSharedLabel().getFacing().toString());
                        lblSharedLabel.setText(circ.getSharedLabel().getText());
                        LblSharedLabelFont.setText(circ.getSharedLabel().getFont());

                        DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("Label");
                        model.addColumn("Bit Length");
                        model.addColumn("PosX");
                        model.addColumn("PosY");

                        OutputPin[] outputs = circ.getOutputs();
                        for (OutputPin output : outputs) {
                            model.addRow(new Object[]{output.getLabel().getText(), output.getBitLength(), output.getPosX(), output.getPosY()});
                        }

                        tblOutputs.setModel(model);

                        model = new DefaultTableModel();
                        model.addColumn("Label");
                        model.addColumn("Bit Length");
                        model.addColumn("PosX");
                        model.addColumn("PosY");

                        InputPin[] inputs = circ.getInputs();
                        for (InputPin input : inputs) {
                            model.addRow(new Object[]{input.getLabel().getText(), input.getBitLength(), input.getPosX(), input.getPosY()});
                        }
                        tblInputs.setModel(model);

                        CircuitElement[] elements = circ.getElements();
                        model = (DefaultTableModel) tblAllElements.getModel();
                        for (int i = model.getRowCount() - 1; i >= 0; i--) {
                            model.removeRow(i);
                        }
                        Object bitLength;
                        for (CircuitElement element : elements) {
                            if (element instanceof MultiBitable) {
                                bitLength = ((MultiBitable) element).getBitLength();
                            } else {
                                bitLength = "-";
                            }
                            String conn=null;
                            if(element.getConnectors()!=null&&element.getConnectors().length>0)
                                conn=element.getConnectors()[0].getPosition().toString();
                            model.addRow(new Object[]{element.getElementType(), element.getLabel().getText(), bitLength, element.getPosX(), element.getPosY(),conn});
                        }
                        tblAllElements.setModel(model);
                        
                        
                        model = new DefaultTableModel();
                        model.addColumn("From");
                        model.addColumn("To");
                        model.addColumn("Length");

                        Wire[] wires = circ.getWires();
                        for (Wire wire : wires) {
                            model.addRow(new Object[]{wire.getFrom(), wire.getTo(), wire.getLength()});
                        }
                        tblWires.setModel(model);
                        
                        
                        Connector[] connectors= circ.getConnectors();
                        model = new DefaultTableModel();
                        model.addColumn("Element");
                        model.addColumn("I/O");
                        model.addColumn("Position");
                        for (Connector con : connectors) {
                            model.addRow(new Object[]{con.getParent().getLabel().getText(), con.getConnectorType(), con.getPosition()});
                        }
                        tblConnectors.setModel(model);
                        
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex);
                        Logger.getLogger(CircuitForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCircName = new javax.swing.JLabel();
        lblSharedLabel = new javax.swing.JLabel();
        lblSharedLabelFacing = new javax.swing.JLabel();
        LblSharedLabelFont = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInputs = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOutputs = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblWires = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblAllElements = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConnectors = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setMinimumSize(new java.awt.Dimension(256, 256));
        setVisible(true);

        jToolBar1.setRollover(true);

        jLabel1.setText("Circuit Name");

        jLabel2.setText("Shared Label");

        jLabel3.setText("Shared Label Facing");

        jLabel4.setText("Shared Label Font");

        lblCircName.setText("...");

        lblSharedLabel.setText("...");

        lblSharedLabelFacing.setText("...");

        LblSharedLabelFont.setText("...");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(103, 103, 103)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblSharedLabelFont)
                    .addComponent(lblSharedLabelFacing)
                    .addComponent(lblSharedLabel)
                    .addComponent(lblCircName))
                .addContainerGap(517, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCircName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSharedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSharedLabelFacing))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(LblSharedLabelFont))
                .addContainerGap(386, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Properties", jPanel4);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblInputs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Bit Length", "Default Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInputs);
        if (tblInputs.getColumnModel().getColumnCount() > 0) {
            tblInputs.getColumnModel().getColumn(0).setResizable(false);
            tblInputs.getColumnModel().getColumn(0).setHeaderValue("Name");
            tblInputs.getColumnModel().getColumn(1).setResizable(false);
            tblInputs.getColumnModel().getColumn(1).setHeaderValue("Bit Length");
            tblInputs.getColumnModel().getColumn(2).setResizable(false);
            tblInputs.getColumnModel().getColumn(2).setHeaderValue("Default Value");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inputs", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblOutputs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Bit Length", "Default Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblOutputs);
        if (tblOutputs.getColumnModel().getColumnCount() > 0) {
            tblOutputs.getColumnModel().getColumn(0).setResizable(false);
            tblOutputs.getColumnModel().getColumn(1).setResizable(false);
            tblOutputs.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Outputs", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblWires.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Bit Length", "Wire Input", "WireOutput"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblWires);
        if (tblWires.getColumnModel().getColumnCount() > 0) {
            tblWires.getColumnModel().getColumn(0).setResizable(false);
            tblWires.getColumnModel().getColumn(1).setResizable(false);
            tblWires.getColumnModel().getColumn(2).setResizable(false);
            tblWires.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Wires", jPanel3);

        tblAllElements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Label", "Bit Length", "PosX", "PosY", "Connector"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblAllElements);
        if (tblAllElements.getColumnModel().getColumnCount() > 0) {
            tblAllElements.getColumnModel().getColumn(5).setResizable(false);
        }

        jTabbedPane1.addTab("Elements", jScrollPane5);

        tblConnectors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Element", "I/O", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblConnectors);
        if (tblConnectors.getColumnModel().getColumnCount() > 0) {
            tblConnectors.getColumnModel().getColumn(0).setResizable(false);
            tblConnectors.getColumnModel().getColumn(1).setResizable(false);
            tblConnectors.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Connectors", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblSharedLabelFont;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCircName;
    private javax.swing.JLabel lblSharedLabel;
    private javax.swing.JLabel lblSharedLabelFacing;
    private javax.swing.JTable tblAllElements;
    private javax.swing.JTable tblConnectors;
    private javax.swing.JTable tblInputs;
    private javax.swing.JTable tblOutputs;
    private javax.swing.JTable tblWires;
    // End of variables declaration//GEN-END:variables
}
