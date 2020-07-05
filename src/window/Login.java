/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import ModelDTO.EmployeDto;
import ModelDTO.FonctionDto;
import java.awt.Color;
import services.AuthServices;

/**
 *
 * @author eddy.parisi
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form loginPannel
     */
    public Login() {
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

        dialogError = new javax.swing.JDialog();
        errorDialogText = new javax.swing.JLabel();
        pannelLogin = new javax.swing.JPanel();
        textfieldLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textfieldPwd = new javax.swing.JTextField();
        buttonConnecter = new javax.swing.JButton();

        dialogError.setTitle("Error");
        dialogError.setSize(new java.awt.Dimension(581, 146));

        javax.swing.GroupLayout dialogErrorLayout = new javax.swing.GroupLayout(dialogError.getContentPane());
        dialogError.getContentPane().setLayout(dialogErrorLayout);
        dialogErrorLayout.setHorizontalGroup(
            dialogErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogErrorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(errorDialogText, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        dialogErrorLayout.setVerticalGroup(
            dialogErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(errorDialogText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(400, 300));

        pannelLogin.setBackground(new java.awt.Color(255, 255, 255));

        textfieldLogin.setToolTipText("");

        jLabel1.setText("Login");

        jLabel2.setText("Mot de passe");

        buttonConnecter.setText("Se connecter");
        buttonConnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnecterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelLoginLayout = new javax.swing.GroupLayout(pannelLogin);
        pannelLogin.setLayout(pannelLoginLayout);
        pannelLoginLayout.setHorizontalGroup(
            pannelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelLoginLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pannelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(pannelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfieldPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
            .addGroup(pannelLoginLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(buttonConnecter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pannelLoginLayout.setVerticalGroup(
            pannelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelLoginLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(pannelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(pannelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textfieldPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(buttonConnecter)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnecterActionPerformed
        //reset default parameter
        errorDialogText.setText("");
        textfieldLogin.setBackground(Color.WHITE);
        textfieldPwd.setBackground(Color.WHITE);
        //check error
        if (textfieldLogin.getText().equals("")) {
            textfieldLogin.setBackground(Color.red);
        }
        if (textfieldPwd.getText().equals("")) {
            textfieldPwd.setBackground(Color.red);
        }
        if (!textfieldLogin.getText().equals("") && !textfieldPwd.getText().equals("")) {
            AuthServices service = new AuthServices();
            EmployeDto employe = service.login(textfieldLogin.getText(), textfieldPwd.getText(), errorDialogText);
            if (employe != null && employe.getMotDePasse().equals(employe.getLogin()) && errorDialogText.getText().equals("")) {
                new ForgotPassword(employe.getId()).setVisible(true);
                textfieldLogin.setText("");
                textfieldPwd.setText("");
            } else if (employe != null && errorDialogText.getText().equals("")) {
                goToHomePage(employe);
            }
        }
        if (!errorDialogText.getText().equals("")) {
            dialogError.setVisible(true);
        }
    }//GEN-LAST:event_buttonConnecterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private void goToHomePage(EmployeDto employe) {
        FonctionDto _fonction = employe.getFonction();
        this.setVisible(false);
        switch (_fonction.getLibelle()) {
                    case "Employe":
                        new EmployeWimdow(employe.getId()).setVisible(true);
                        break;
                    case "Responsable":
                        //show Responsable
                        break;
                    case "Agent":
                        new AgentWindow().setVisible(true);
                        break;
                    case "Directeur":
                        //show Directeur
                        break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnecter;
    private javax.swing.JDialog dialogError;
    private javax.swing.JLabel errorDialogText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pannelLogin;
    private javax.swing.JTextField textfieldLogin;
    private javax.swing.JTextField textfieldPwd;
    // End of variables declaration//GEN-END:variables
}
