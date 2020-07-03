/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import java.awt.Color;
import javax.swing.JFrame;
import services.EmployeServices;

/**
 *
 * @author eddy.parisi
 */
public class ForgotPassword extends javax.swing.JFrame {

    private int idUser;

    /**
     * Creates new form ForgotPassword
     */
    public ForgotPassword() {
        initComponents();
    }

    public ForgotPassword(int idUser) {
        initComponents();
        this.idUser = idUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        erreurDialog = new javax.swing.JDialog();
        errorDialogText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textfieldNewPassword = new javax.swing.JPasswordField();
        textfieldConfirmationPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        erreurDialog.setTitle("Erreur");
        erreurDialog.setPreferredSize(new java.awt.Dimension(581, 77));
        erreurDialog.setSize(new java.awt.Dimension(581, 77));

        javax.swing.GroupLayout erreurDialogLayout = new javax.swing.GroupLayout(erreurDialog.getContentPane());
        erreurDialog.getContentPane().setLayout(erreurDialogLayout);
        erreurDialogLayout.setHorizontalGroup(
            erreurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(erreurDialogLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(errorDialogText, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        erreurDialogLayout.setVerticalGroup(
            erreurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(erreurDialogLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(errorDialogText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nouveau mot de passe");

        jLabel2.setText("Confirmer");

        textfieldNewPassword.setPreferredSize(new java.awt.Dimension(110, 20));

        textfieldConfirmationPassword.setPreferredSize(new java.awt.Dimension(110, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Changer son mot de passe");

        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldConfirmationPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textfieldNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textfieldConfirmationPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // changer le mot de passe avec l'id qu'on a en var global : idUser
        //reset default parameter
        errorDialogText.setText("");
        textfieldNewPassword.setBackground(Color.WHITE);
        textfieldConfirmationPassword.setBackground(Color.WHITE);
        //check error
        if (textfieldNewPassword.getText().equals("")) {
            textfieldNewPassword.setBackground(Color.red);
        }
        if (textfieldConfirmationPassword.getText().equals("")) {
            textfieldConfirmationPassword.setBackground(Color.red);
        }
        if (!textfieldNewPassword.getText().equals(textfieldConfirmationPassword.getText())) {
            textfieldNewPassword.setBackground(Color.red);
            textfieldConfirmationPassword.setBackground(Color.red);
            errorDialogText.setText("Les mots de passe ne sont pas identique.");
        } else {
            Boolean isSaved = new EmployeServices().save(this.idUser, textfieldNewPassword.getText());
            if (isSaved) {
                errorDialogText.setText("");
                textfieldNewPassword.setText("");
                textfieldConfirmationPassword.setText("");
                this.setVisible(false);
            } else {
                errorDialogText.setText("Erreur veuillez contacter l'administrateur.");
            }
        }
        if (!errorDialogText.getText().equals("")){
            erreurDialog.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog erreurDialog;
    private javax.swing.JLabel errorDialogText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField textfieldConfirmationPassword;
    private javax.swing.JPasswordField textfieldNewPassword;
    // End of variables declaration//GEN-END:variables
}
