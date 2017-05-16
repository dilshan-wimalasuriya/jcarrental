/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import ClassFiles.Customer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dilshan Wimalasuriya
 */
public class CustomerChangePassword extends javax.swing.JInternalFrame {

    /**
     * Creates new form AdminRegister
     */
    String uname;
    public CustomerChangePassword(String username) {
        initComponents();
        uname = username;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        conpassword = new javax.swing.JPasswordField();
        resetbutton = new javax.swing.JButton();

        setBorder(null);

        register.setText("Change Password");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        jLabel9.setText("Password");

        jLabel10.setText("Confirm Password");

        resetbutton.setText("Reset");
        resetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conpassword)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(621, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(register)
                        .addGap(18, 18, 18)
                        .addComponent(resetbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(conpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(449, Short.MAX_VALUE))
        );

        setBounds(-5, -35, 1188, 581);
    }// </editor-fold>//GEN-END:initComponents

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed

        String pass = String.valueOf(password.getPassword());
        String cpass = String.valueOf(conpassword.getPassword());
        int passcheck = pass.compareTo(cpass);
        

        if(pass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a Password");
        }
        else if(cpass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please confirm the Password");
        }
        else if(pass.length()<8)
        {
            JOptionPane.showMessageDialog(null, "Your Password must contain 8 or more charactors");
        }
        else if (passcheck !=0)
        {
            JOptionPane.showMessageDialog(null, "Entered Password and Confirm Password does not match");
        }    
        else
        {
            int x = JOptionPane.showConfirmDialog(null,"Do You Really Want To Change The Password?");
            if(x==0)
            {
                boolean status = false;
                Customer cm = new Customer();
                cm.setPassword(pass);
                cm.setUsername(uname);
                try {
                    status = cm.ChangeCustomerPassword();
                }
                catch (SQLException ex) {
                    Logger.getLogger(AdminsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(status)
                {
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error! Customer Password was not changed");
                }
            }
        }
    }//GEN-LAST:event_registerActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        password.setText("");
        conpassword.setText("");
    }//GEN-LAST:event_resetbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField conpassword;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton register;
    private javax.swing.JButton resetbutton;
    // End of variables declaration//GEN-END:variables
}
