/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kekworld;

import static kekworld.Main.yourID;
import static kekworld.Main.playerChatReturnValue;

/**
 *
 * @author Sean
 */
public class GameContainer extends javax.swing.JFrame {

    PlayerHandler playerHandler = new PlayerHandler();
    public String playerInputValue;
    
    /**
     * Creates new form GameContainer
     */
    public GameContainer() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextMain = new javax.swing.JTextArea();
        txtGameInput = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextMain.setEditable(false);
        jTextMain.setColumns(20);
        jTextMain.setRows(5);
        jTextMain.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextMainCaretUpdate(evt);
            }
        });
        jTextMain.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextMainInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTextMain);

        txtGameInput.setAutoscrolls(false);
        txtGameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGameInputKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGameInputKeyTyped(evt);
            }
        });

        btnEnter.setText("Enter");
        btnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnterMouseClicked(evt);
            }
        });
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtGameInput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnter)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnter)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseClicked
        // TODO add your handling code here:
        enterText();
    }//GEN-LAST:event_btnEnterMouseClicked

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnterActionPerformed

    private void txtGameInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGameInputKeyTyped
        // TODO add your handling code here:
        //Main.gMsg(Integer.toString(evt.getKeyCode()));
    }//GEN-LAST:event_txtGameInputKeyTyped

    private void txtGameInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGameInputKeyPressed
        // TODO add your handling code here:
        //returns key pressed
        //Main.gMsg(Integer.toString(evt.getKeyCode()));
        
        //pressed enter
        if(evt.getKeyCode() == 10) {
           enterText();
        }
    }//GEN-LAST:event_txtGameInputKeyPressed

    private void jTextMainInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextMainInputMethodTextChanged
        // TODO add your handling code here:
       
        //jTextMain.setCaretPosition(jTextMain.getDocument().getLength());

    }//GEN-LAST:event_jTextMainInputMethodTextChanged

    private void jTextMainCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextMainCaretUpdate
        // TODO add your handling code here:
        //jTextMain.setCaretPosition(jTextMain.getDocument().getLength());
    }//GEN-LAST:event_jTextMainCaretUpdate

   
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
            java.util.logging.Logger.getLogger(GameContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameContainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameContainer().setVisible(true);
                
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextMain;
    private javax.swing.JTextField txtGameInput;
    // End of variables declaration//GEN-END:variables

    public void updateGameInterface(String gameInputText){
        jTextMain.append(gameInputText);
        jTextMain.setCaretPosition(jTextMain.getDocument().getLength()); //puts cursor to bottom, automatically scrolls each now event
    }
    
    public void enterText(){
       Main.gMsg("player return value b4 " + getPlayerInput());
       setPlayerInput(txtGameInput.getText());
       Main.gMsg("player return value after " + getPlayerInput());
       Main.playerCommandPending = true;
       Main.gMsg(txtGameInput.getText());
       txtGameInput.setText("");
        //Main.
    }
    
    public String getPlayerInput() {
        return playerInputValue;
    }
    
    public void setPlayerInput(String input){
        this.playerInputValue = input;
    }

}

