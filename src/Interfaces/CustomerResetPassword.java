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
public class CustomerResetPassword extends javax.swing.JFrame {

    /**
     * Creates new form CustomerLogIn
     */
    public CustomerResetPassword() {
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

        register2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        conpassword = new javax.swing.JPasswordField();
        resetbutton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dlnum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reset Your Password");

        register2.setText("Change Password");
        register2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register2ActionPerformed(evt);
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

        jLabel11.setText("Driving Licence Number");

        jLabel12.setText("Customer Password Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(register2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(conpassword)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(dlnum))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel12)
                .addGap(0, 188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel12)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(conpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register2)
                    .addComponent(resetbutton))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void register2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register2ActionPerformed

        String pass = String.valueOf(password.getPassword());
        String cpass = String.valueOf(conpassword.getPassword());
        String dlnumber = dlnum.getText();
        int passcheck = pass.compareTo(cpass);
        
        boolean checklicence = false;

        for(int x = 1; x<dlnumber.length(); x++)
        {
            if(Character.isDigit(dlnumber.charAt(x)))
            {
                checklicence = true;
            }
            else
            {
                checklicence = false;
                break;
            }
        }
        
        if(dlnumber.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter A Valid Driving Licence Number");
        }
        else if(dlnumber.charAt(0) != 'B')
        {
            JOptionPane.showMessageDialog(null, "Invalid Driving Licence number. Must Start with letter 'B'");
        }
        else if(dlnumber.length() <6)
        {
            JOptionPane.showMessageDialog(null, "Invalid Driving Licence number. It should contain 6 or more numbers statring with 'B'");
        }
        else if(!checklicence)
        {
            JOptionPane.showMessageDialog(null, "Invalid Driving Licence number. Must contain only numbers after 'B'");
        }
        else if(pass.isEmpty()){
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
                cm.setDLnumber(dlnumber);
                try {
                    status = cm.ResetCustomerPassword();
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
                    JOptionPane.showMessageDialog(null, "Error! Your Password was not changed");
                }
            }
        }
    }//GEN-LAST:event_register2ActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        password.setText("");
        conpassword.setText("");
    }//GEN-LAST:event_resetbuttonActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerResetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField conpassword;
    private javax.swing.JTextField dlnum;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton register;
    private javax.swing.JButton register1;
    private javax.swing.JButton register2;
    private javax.swing.JButton resetbutton;
    // End of variables declaration//GEN-END:variables
}