/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import ModelDTO.CamionDto;
import ModelDTO.EmployeDto;
import ModelDTO.EntrepriseDto;
import ModelDTO.TypeDechetDto;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import services.CamionServices;
import services.EmployeServices;
import services.EntrepriseService;
import services.TypeDechetService;

/**
 *
 * @author eddy.parisi
 */
public class AgentWindow extends javax.swing.JFrame {

    private List<TypeDechetDto> listTypesDechet;
    private List<EmployeDto> listEmployesLibre;
    private List<CamionDto> listCamions;

    /**
     * Creates new form AgentWindow
     */
    public AgentWindow() {
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

        dialogEntreprise = new javax.swing.JDialog();
        textfieldSiret = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textfieldRaisonSocial = new javax.swing.JTextField();
        textfieldNumero = new javax.swing.JTextField();
        textfieldRue = new javax.swing.JTextField();
        textfieldVille = new javax.swing.JTextField();
        textfieldCP = new javax.swing.JTextField();
        textfieldTel = new javax.swing.JTextField();
        textfieldContact = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        buttonValider = new javax.swing.JButton();
        ButtonRetour = new javax.swing.JButton();
        erreurDialog = new javax.swing.JDialog();
        errorDialogText = new javax.swing.JLabel();
        dialogTournee = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboboxTypesDechet = new javax.swing.JComboBox<>();
        comboboxCamions = new javax.swing.JComboBox<>();
        comboboxEmployes = new javax.swing.JComboBox<>();
        buttonValiderTournee = new javax.swing.JButton();
        buttonRetourTournee = new javax.swing.JButton();
        butonAddTournee = new javax.swing.JButton();
        buttonAddEntreprise = new javax.swing.JButton();

        dialogEntreprise.setSize(new java.awt.Dimension(406, 368));

        jLabel1.setText("Siret :");

        jLabel2.setText("Raison sociale :");

        jLabel3.setText("Numéro :");

        jLabel4.setText("Rue :");

        jLabel5.setText("Ville :");

        jLabel6.setText("Code postal :");

        jLabel7.setText("Téléphone :");

        jLabel8.setText("Contact :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Ajouter une entreprise");

        buttonValider.setText("Valider");
        buttonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderActionPerformed(evt);
            }
        });

        ButtonRetour.setText("Retour");
        ButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogEntrepriseLayout = new javax.swing.GroupLayout(dialogEntreprise.getContentPane());
        dialogEntreprise.getContentPane().setLayout(dialogEntrepriseLayout);
        dialogEntrepriseLayout.setHorizontalGroup(
            dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogEntrepriseLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogEntrepriseLayout.createSequentialGroup()
                        .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldRaisonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldRue, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldVille, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldContact, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldSiret, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogEntrepriseLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogEntrepriseLayout.createSequentialGroup()
                        .addComponent(buttonValider)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonRetour)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        dialogEntrepriseLayout.setVerticalGroup(
            dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogEntrepriseLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addGap(27, 27, 27)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldSiret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textfieldRaisonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textfieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textfieldRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textfieldVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textfieldCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textfieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textfieldContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(dialogEntrepriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonValider)
                    .addComponent(ButtonRetour))
                .addGap(25, 25, 25))
        );

        erreurDialog.setTitle("Erreur");
        erreurDialog.setPreferredSize(new java.awt.Dimension(567, 140));
        erreurDialog.setSize(new java.awt.Dimension(581, 140));

        javax.swing.GroupLayout erreurDialogLayout = new javax.swing.GroupLayout(erreurDialog.getContentPane());
        erreurDialog.getContentPane().setLayout(erreurDialogLayout);
        erreurDialogLayout.setHorizontalGroup(
            erreurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, erreurDialogLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(errorDialogText, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        erreurDialogLayout.setVerticalGroup(
            erreurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(erreurDialogLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(errorDialogText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        dialogTournee.setSize(new java.awt.Dimension(406, 368));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Ajouter une tournée");

        jLabel11.setText("Type de déchet :");

        jLabel12.setText("Camion :");
        jLabel12.setToolTipText("");

        jLabel13.setText("Employé :");

        comboboxTypesDechet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboboxTypesDechetItemStateChanged(evt);
            }
        });

        buttonValiderTournee.setText("Valider");
        buttonValiderTournee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderTourneeActionPerformed(evt);
            }
        });

        buttonRetourTournee.setText("Retour");
        buttonRetourTournee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetourTourneeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogTourneeLayout = new javax.swing.GroupLayout(dialogTournee.getContentPane());
        dialogTournee.getContentPane().setLayout(dialogTourneeLayout);
        dialogTourneeLayout.setHorizontalGroup(
            dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTourneeLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogTourneeLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboboxTypesDechet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboboxCamions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboboxEmployes, 0, 161, Short.MAX_VALUE))
                    .addGroup(dialogTourneeLayout.createSequentialGroup()
                        .addComponent(buttonValiderTournee)
                        .addGap(18, 18, 18)
                        .addComponent(buttonRetourTournee)))
                .addGap(80, 80, 80))
        );
        dialogTourneeLayout.setVerticalGroup(
            dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTourneeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addGap(30, 30, 30)
                .addGroup(dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboboxTypesDechet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboboxCamions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboboxEmployes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(dialogTourneeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonValiderTournee)
                    .addComponent(buttonRetourTournee))
                .addGap(75, 75, 75))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        butonAddTournee.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        butonAddTournee.setText("Ajouter une tournée");
        butonAddTournee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddTourneeActionPerformed(evt);
            }
        });

        buttonAddEntreprise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonAddEntreprise.setText("Ajouter une entreprise");
        buttonAddEntreprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddEntrepriseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonAddEntreprise, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(butonAddTournee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(butonAddTournee, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAddEntreprise, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddEntrepriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEntrepriseActionPerformed
        dialogEntreprise.setVisible(true);
    }//GEN-LAST:event_buttonAddEntrepriseActionPerformed

    private void buttonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderActionPerformed
        // Check errors
        if (isError()) {
            errorDialogText.setText("Tous les champs doivent être renseignés");
        } else {
            //add si pas d'erreur
            EntrepriseDto newEntreprise = getEntreprise();
            reset();
            if (new EntrepriseService().create(newEntreprise)) {
                dialogEntreprise.setVisible(false);
            } else {
                errorDialogText.setText("Erreur veuillez contacter l'administrateur.");
            }
        }
        if (!errorDialogText.getText().equals("")) {
            erreurDialog.setVisible(true);
        }
    }//GEN-LAST:event_buttonValiderActionPerformed

    private void ButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRetourActionPerformed
        //reset
        reset();
        dialogEntreprise.setVisible(false);
    }//GEN-LAST:event_ButtonRetourActionPerformed

    private void butonAddTourneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddTourneeActionPerformed
        errorDialogText.setText("");
        // Les types de dechet
        listTypesDechet = new TypeDechetService().getAll();
        Stream<String> streamType = listTypesDechet.stream().map(type -> type.getLibelle());
        comboboxTypesDechet.setModel(new DefaultComboBoxModel(streamType.toArray()));
        // Les employes libres
        listEmployesLibre = new EmployeServices().getAllChauffeursLibres();
        Stream<String> streamEmp = listEmployesLibre.stream().map(type -> type.toString());
        if (streamEmp.count() == 0) {
            errorDialogText.setText("Il n'y a pas d'employé de libre. Vous ne pourrez pas créer de tournée.");
        } else {
            comboboxEmployes.setModel(new DefaultComboBoxModel(streamEmp.toArray()));
        }
        // Les camions adéquat au type de déchets
        listCamions = getCamionFromLibelleTypeDechet(comboboxTypesDechet.getItemAt(0));
        Stream<String> streamCamion = listCamions.stream().map(camion -> camion.toString());
        comboboxCamions.setModel(new DefaultComboBoxModel(streamCamion.toArray()));
        
        dialogTournee.setVisible(true);
        if (!errorDialogText.getText().equals("")) {
            erreurDialog.setVisible(true);
        }
    }//GEN-LAST:event_butonAddTourneeActionPerformed

    private void buttonRetourTourneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetourTourneeActionPerformed
        dialogTournee.setVisible(false);
    }//GEN-LAST:event_buttonRetourTourneeActionPerformed

    private void buttonValiderTourneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderTourneeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonValiderTourneeActionPerformed

    private void comboboxTypesDechetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxTypesDechetItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String libelleTypeDechet = evt.getItem().toString();

            listCamions = getCamionFromLibelleTypeDechet(libelleTypeDechet);
            Stream<String> streamCamion = listCamions.stream().map(camion -> camion.toString());
            comboboxCamions.setModel(new DefaultComboBoxModel(streamCamion.toArray()));
        }
    }//GEN-LAST:event_comboboxTypesDechetItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgentWindow().setVisible(true);
            }
        });
    }

    private Boolean isError() {
        Boolean _isError = false;

        if (textfieldCP.getText().equals("")) {
            textfieldCP.setBackground(Color.red);
            _isError = true;
        }
        if (textfieldContact.getText().equals("")) {
            textfieldContact.setBackground(Color.red);
            _isError = true;
        }
        if (textfieldNumero.getText().equals("")) {
            textfieldNumero.setBackground(Color.red);
            _isError = true;
        }
        if (textfieldRaisonSocial.getText().equals("")) {
            textfieldRaisonSocial.setBackground(Color.red);
            _isError = true;
        }
        if (textfieldRue.getText().equals("")) {
            textfieldRue.setBackground(Color.red);
            _isError = true;
        }
        if (textfieldSiret.getText().equals("")) {
            textfieldSiret.setBackground(Color.red);
            _isError = true;
        }
        if (textfieldTel.getText().equals("")) {
            textfieldTel.setBackground(Color.red);
            _isError = true;
        }
        if (textfieldVille.getText().equals("")) {
            textfieldVille.setBackground(Color.red);
            _isError = true;
        }

        return _isError;
    }

    private void reset() {
        textfieldCP.setText("");
        textfieldContact.setText("");
        textfieldNumero.setText("");
        textfieldRaisonSocial.setText("");
        textfieldRue.setText("");
        textfieldSiret.setText("");
        textfieldTel.setText("");
        textfieldVille.setText("");
        textfieldCP.setBackground(Color.WHITE);
        textfieldContact.setBackground(Color.WHITE);
        textfieldNumero.setBackground(Color.WHITE);
        textfieldRaisonSocial.setBackground(Color.WHITE);
        textfieldRue.setBackground(Color.WHITE);
        textfieldSiret.setBackground(Color.WHITE);
        textfieldTel.setBackground(Color.WHITE);
        textfieldVille.setBackground(Color.WHITE);
        errorDialogText.setText("");
    }

    private EntrepriseDto getEntreprise() {
        return new EntrepriseDto(
                Long.parseLong(textfieldSiret.getText()),
                textfieldRaisonSocial.getText(),
                Integer.parseInt(textfieldNumero.getText()),
                textfieldRue.getText(),
                textfieldVille.getText(),
                Integer.parseInt(textfieldCP.getText()),
                Integer.parseInt(textfieldTel.getText()),
                textfieldContact.getText()
        );
    }

    private List<CamionDto> getCamionFromLibelleTypeDechet(String libelle) {
        List<TypeDechetDto> typesDechet = listTypesDechet.stream().filter(
                type -> type.getLibelle().equals(libelle)).collect(Collectors.toList());
        TypeDechetDto typeDechet = typesDechet.get(0);

        return new CamionServices().getAllFromIdTypeDechet(typeDechet.getId());
    }

    public List<TypeDechetDto> getListTypesDechet() {
        return listTypesDechet;
    }

    public void setListTypesDechet(List<TypeDechetDto> listTypesDechet) {
        this.listTypesDechet = listTypesDechet;
    }

    public List<EmployeDto> getListEmployesLibre() {
        return listEmployesLibre;
    }

    public void setListEmployesLibre(List<EmployeDto> listEmployesLibre) {
        this.listEmployesLibre = listEmployesLibre;
    }

    public List<CamionDto> getListCamions() {
        return listCamions;
    }

    public void setListCamions(List<CamionDto> listCamions) {
        this.listCamions = listCamions;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonRetour;
    private javax.swing.JButton butonAddTournee;
    private javax.swing.JButton buttonAddEntreprise;
    private javax.swing.JButton buttonRetourTournee;
    private javax.swing.JButton buttonValider;
    private javax.swing.JButton buttonValiderTournee;
    private javax.swing.JComboBox<String> comboboxCamions;
    private javax.swing.JComboBox<String> comboboxEmployes;
    private javax.swing.JComboBox<String> comboboxTypesDechet;
    private javax.swing.JDialog dialogEntreprise;
    private javax.swing.JDialog dialogTournee;
    private javax.swing.JDialog erreurDialog;
    private javax.swing.JLabel errorDialogText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textfieldCP;
    private javax.swing.JTextField textfieldContact;
    private javax.swing.JTextField textfieldNumero;
    private javax.swing.JTextField textfieldRaisonSocial;
    private javax.swing.JTextField textfieldRue;
    private javax.swing.JTextField textfieldSiret;
    private javax.swing.JTextField textfieldTel;
    private javax.swing.JTextField textfieldVille;
    // End of variables declaration//GEN-END:variables
}
