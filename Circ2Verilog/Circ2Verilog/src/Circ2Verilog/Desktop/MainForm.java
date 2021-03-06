/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circ2Verilog.Desktop;

import Circ2Verilog.Logisim.CircParser;
import Circ2Verilog.Logisim.Circuit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Ebubekir
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     * @param args
     */
    public MainForm(String[] args) {
        initComponents();
            Hashtable<Circuit,CircuitForm> openedCircs= new Hashtable<Circuit,CircuitForm>();
            this.treeProject.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int selRow = treeProject.getRowForLocation(e.getX(), e.getY());
                    TreePath selPath = treeProject.getPathForLocation(e.getX(), e.getY());
                    if (selRow != -1) {
                         if (e.getClickCount() == 2) {
                             if(selPath.getLastPathComponent() instanceof CustomMutableTreeNode)
                             {
                                 Circuit circ=((CustomMutableTreeNode)selPath.getLastPathComponent()).getCircuit();
                                 CircuitForm p;
                                 p = openedCircs.get(circ);
                                 if(p!=null)
                                 {
                                     p.setVisible(true);
                                     return;
                                 }
                                                                  
                                 p= new CircuitForm(circ);
                                openedCircs.put(circ, p);
                                 jMainDesktop.add(p);
                                 p.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                 try { 
                                     p.setMaximum(true);
                                 } catch (PropertyVetoException ex) {
                                     Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                                 }
                                 p.setVisible(true);
                             }
                        }
                    }
                    super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                }

            });
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        for (String arg : args) {
            OpenFile(arg);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private CircParser project;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jMainDesktop = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treeProject = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuFileOpen = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));

        jMainDesktop.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jMainDesktopLayout = new javax.swing.GroupLayout(jMainDesktop);
        jMainDesktop.setLayout(jMainDesktopLayout);
        jMainDesktopLayout.setHorizontalGroup(
            jMainDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        jMainDesktopLayout.setVerticalGroup(
            jMainDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainDesktop)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainDesktop)
        );

        jSplitPane2.setRightComponent(jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(150, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(150, 422));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeProject.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeProject.setToolTipText("Project Detail");
        jScrollPane2.setViewportView(treeProject);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(jPanel2);

        jMenu1.setText("File");

        jMenuFileOpen.setText("Open");
        jMenuFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuFileOpen);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void OpenFile(String fileName) {
        CircParser cParser;
        try {
            cParser = new CircParser(fileName);
            //ProjectForm f = new ProjectForm(cParser);
            //jMainDesktop.add(f);
            
            
            this.project = cParser;
            String[] circs = project.GetCircuitNames();
            String mainCirc = project.GetMainCircuitName();
            TreeModel m1 = treeProject.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) m1.getRoot();
            root.setUserObject(project.GetCircNames());
            int index = 0;
            int selelectedIndex = 0;
            String nodeName="";
            for (String circ : circs) {
                index++;
                nodeName=circ;
                if (circ.equals(mainCirc)) {
                   nodeName+="*";
                    selelectedIndex = index;
                }
                try {
                    root.add(new CustomMutableTreeNode(project.GetCircuitWithName(circ),nodeName));
                } catch (Exception ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            treeProject.expandRow(0);
            treeProject.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            treeProject.setSelectionRow(selelectedIndex);
            
        } catch (JAXBException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            JOptionPane.showMessageDialog(null, "Dosya okunurken hata oluştu!", "Hatalı Dosya!", 0);
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    private void jMenuFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileOpenActionPerformed
        JFileChooser  fc= new JFileChooser("C:\\Users\\Ebubekir\\Desktop\\Test.circ");
        fc.showOpenDialog(null);
        OpenFile(fc.getSelectedFile().getPath());
        
    }//GEN-LAST:event_jMenuFileOpenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm(args).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jMainDesktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuFileOpen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTree treeProject;
    // End of variables declaration//GEN-END:variables
}
