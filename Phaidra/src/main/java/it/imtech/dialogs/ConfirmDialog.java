/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.imtech.dialogs;

import it.imtech.globals.Globals;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import org.apache.log4j.Logger;

/**
 *
 * @author mauro
 */
public class ConfirmDialog extends javax.swing.JDialog {
    
    private static final Logger logger = Logger.getLogger(ConfirmDialog.class);
    
    private boolean next;
    
    public boolean getChoice(){
        return next;
    }
    
    /**
     * Creates new form ConfirmDialog
     * @param parent
     * @param modal
     * @param text
     * @param title
     * @param type
     */
    public ConfirmDialog(java.awt.Frame parent, boolean modal,  String title, String text, String buttonok, String buttonko) {
        super(parent, modal);
        setModal(true);
        ResourceBundle bundle = ResourceBundle.getBundle(Globals.RESOURCES, Globals.CURRENT_LOCALE, Globals.loader);
        
        initComponents();
        this.setTitle(title);
        
        MigLayout main = new MigLayout();
        MigLayout nord = new MigLayout();
        MigLayout sud = new MigLayout("fillx,insets 5 5 5 5");
        
        //getContentPane().setBackground(Color.white);
        getContentPane().setLayout(main);
        
        Icon ico = UIManager.getIcon("OptionPane.questionIcon");
       
        JLabel picture = new JLabel();
        JLabel sentence = new JLabel(text);
        picture.setIcon(ico);

        JPanel north = new JPanel(nord);
        //north.setBackground(Color.WHITE);
        north.add(picture);
        north.add(sentence, "wrap");
        
        JPanel south = new JPanel(sud);
        //south.setBackground(Color.WHITE);
  
        JButton nextButton = new JButton(buttonok);//Utility.getBundleString("confirm", bundle));
        nextButton.setMinimumSize(new Dimension(120,10));
        nextButton.setName("next_button");
        
        nextButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                next = true;
                setVisible(false);
            }
        });
                
        JButton  prevButton = new JButton(buttonko);//Utility.getBundleString("annulla", bundle));
        prevButton.setMinimumSize(new Dimension(120,10));
        prevButton.setName("prev_button");
        
        prevButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                next = false;
                setVisible(false);
            }
        });
                
        south.add(new JSeparator(), "growx, wrap");
        south.add(prevButton, "split, right");
        south.add(nextButton);
        
        this.add(north, "wrap, growx");
        this.add(south, "wrap, growx");
        this.pack();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getSize().width) / 2;
        int y = (dim.height - getSize().height) / 2;
        setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            logger.error(ex.getMessage());
        } catch (InstantiationException ex) {
            logger.error(ex.getMessage());
        } catch (IllegalAccessException ex) {
            logger.error(ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            logger.error(ex.getMessage());
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfirmDialog dialog = new ConfirmDialog(new javax.swing.JFrame(), true, "", "","","");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
