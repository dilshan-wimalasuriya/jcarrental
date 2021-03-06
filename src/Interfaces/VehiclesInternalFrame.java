/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ClassFiles.DBConnect;
import ClassFiles.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Vince Lance
 */
public class VehiclesInternalFrame extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public VehiclesInternalFrame() throws SQLException {
        initComponents();
        con = DBConnect.connect();
        LoaddTable();
        
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        
        //model drop down
        try {
            
            String query="Select modelName from model ";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        while(rs.next())
        {
            String a = rs.getString("modelName");
            modelbox.addItem(a);
        }
        
        
        
        //make drop down
        try {
            
            String query="Select makeName from make ";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        while(rs.next())
        {
            String a = rs.getString("makeName");
            makebox.addItem(a);
        }
        
        //type drop down
        try {
            
            String query="Select typeName from vehicletype ";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        while(rs.next())
        {
            String a = rs.getString("typeName");
            typebox.addItem(a);
        }
        
        
    }
    public void LoaddTable(){
        try {
            String sql = "SELECT mk.makeName as make, ml.modelName as model, vt.typeName, v.year, v.fuelType, v.availability, v.transmission, v.regNumber FROM vehicle v, make mk, model ml,vehicletype vt WHERE v.make= mk.makeId and ml.modelID=v.model and v.type=vt.vtId order by v.vehicleId ASC";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);  
        }
   
    }

    public boolean checkDigit(String year){
        boolean x=false;
        if((year.length()>4) || (year.length()<4)){
            x=false;
        }
        else{
            for(int i=0;i<year.length();i++){
                if (Character.isDigit(year.charAt(i))){
                    x= true;
                }
                else{
                    x= false;
                    break;
                }
            }
        }
        return x;
    }
       
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        yearbox = new javax.swing.JTextField();
        regbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        searchbox = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        modelbox = new javax.swing.JComboBox();
        typebox = new javax.swing.JComboBox();
        fuelbox = new javax.swing.JComboBox();
        tranbox = new javax.swing.JComboBox();
        availablebox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        makebox = new javax.swing.JComboBox();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1100, 641));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Model");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Year");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Type");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Fuel Type");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Availability");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Transmission");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Reg Number");

        regbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regboxActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Add Vehicle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Vehecle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete Vehicle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        modelbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--" }));
        modelbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelboxActionPerformed(evt);
            }
        });

        typebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--" }));
        typebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeboxActionPerformed(evt);
            }
        });

        fuelbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--", "Petrol", "Diesel", "Hybrid", "Electric" }));

        tranbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--", "Automatic", "Manual" }));

        availablebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--", "Available", "Unavailable", "Rented" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Make");

        makebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(regbox)
                                                    .addComponent(tranbox, 0, 166, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(fuelbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(availablebox, 0, 164, Short.MAX_VALUE)
                                                        .addGap(2, 2, 2))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(typebox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(yearbox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(modelbox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(makebox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(390, 390, 390))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(makebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(modelbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(typebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(yearbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fuelbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(availablebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tranbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(regbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        setBounds(-5, -35, 1152, 734);
    }// </editor-fold>//GEN-END:initComponents

    private void regboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regboxActionPerformed

    private void typeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String make = (String)makebox.getSelectedItem();
        int checkmake = makebox.getSelectedIndex();
        
        String model = (String)modelbox.getSelectedItem();
        int checkmodel = modelbox.getSelectedIndex();
        
        String type =  (String)typebox.getSelectedItem();
        int checktype = typebox.getSelectedIndex();
        
        String checkyear = (String)yearbox.getText();
        boolean checkyearnull = checkyear.isEmpty();
        boolean checknum = false;
        checknum = checkDigit(checkyear);
        String year = (String)(yearbox.getText());
        
        String fuel = (String)fuelbox.getSelectedItem();
        int checkfuel = fuelbox.getSelectedIndex();
        
        String available = (String)availablebox.getSelectedItem();
        int checkavailable = availablebox.getSelectedIndex();
        
        String tran = (String)tranbox.getSelectedItem();
        int checktran = tranbox.getSelectedIndex();
        
        String reg = (String)regbox.getText();
        boolean checkregnull = reg.isEmpty();
        
        boolean regvalidate = false;
        if(reg.length()==6)
        {
            for(int x =0; x<reg.length(); x++)
            {
                if(x<2)
                {
                    if(!Character.isAlphabetic(reg.charAt(x)))
                    {
                        regvalidate = false;
                        break;
                    }
                    else
                    {
                        regvalidate = true;  
                    }
                }
                else
                {
                    if(!Character.isDigit(reg.charAt(x)))
                    {
                        regvalidate = false;
                        break;
                    }
                    else
                    {
                        regvalidate = true;  
                    }
                }    
            }    
        }
        else if(reg.length()==7)
        {
            for(int x =0; x<reg.length(); x++)
            {
                if(x<3)
                {
                    if(!Character.isAlphabetic(reg.charAt(x)))
                    {
                        regvalidate = false;
                        break;
                    }
                    else
                    {
                        regvalidate = true;  
                    }
                }
                else if(x>=3)
                {
                    if(!Character.isDigit(reg.charAt(x)))
                    {
                        regvalidate = false;
                        break;
                    }
                    else
                    {
                        regvalidate = true;  
                    }
                }    
            }
        }
        
        if(checkmake==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a make");
        }
        else if(checkmodel==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a model");
        }
        else if(checktype==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a type");
        }
        else if(checkyearnull==true){
           JOptionPane.showMessageDialog(null, "Cannot perform action : please enter a year");        
        }
        else if(checknum==false){
           JOptionPane.showMessageDialog(null, "Cannot perform action : Entered year is Invalid");
        }
        else if(checkfuel==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a Fueltype");
        }
        else if(checkavailable==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select the availability");
        }
        else if(checktran==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a transmission");
        }
        else if(checkregnull==true){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please enter the registration number");
       }
        else if(regvalidate==false){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please enter valid registration number");
        }
        else{
            Vehicle vehi = new Vehicle(make,model,type,year,fuel,available,tran,reg);
            try {
                vehi.AddVehicle();
                LoaddTable();
            }
            catch (Exception e) {
            
                System.out.println(e);
            
            }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int row = -1;
        row = jTable1.getSelectedRow();
        if(row !=-1)
        {    
            String make = (String)makebox.getSelectedItem();
            int checkmake = makebox.getSelectedIndex();

            String model = (String)modelbox.getSelectedItem();
            int checkmodel = modelbox.getSelectedIndex();

            String type =  (String)typebox.getSelectedItem();
            int checktype = typebox.getSelectedIndex();

            String checkyear = (String)yearbox.getText();
            boolean checkyearnull = checkyear.isEmpty();
            boolean checknum = false;
            checknum = checkDigit(checkyear);
            String year = (String)(yearbox.getText());

            String fuel = (String)fuelbox.getSelectedItem();
            int checkfuel = fuelbox.getSelectedIndex();

            String available = (String)availablebox.getSelectedItem();
            int checkavailable = availablebox.getSelectedIndex();

            String tran = (String)tranbox.getSelectedItem();
            int checktran = tranbox.getSelectedIndex();

            String reg = (String)regbox.getText();
            boolean checkregnull = reg.isEmpty();
            int checklength = reg.length();

            boolean regvalidate = false;
            if(reg.length()==6)
            {
                for(int x =0; x<reg.length(); x++)
                {
                    if(x<2)
                    {
                        if(!Character.isAlphabetic(reg.charAt(x)))
                        {
                            regvalidate = false;
                            break;
                        }
                        else
                        {
                            regvalidate = true;  
                        }
                    }
                    else
                    {
                        if(!Character.isDigit(reg.charAt(x)))
                        {
                            regvalidate = false;
                            break;
                        }
                        else
                        {
                            regvalidate = true;  
                        }
                    }    
                }    
            }
            else if(reg.length()==7)
            {
                for(int x =0; x<reg.length(); x++)
                {
                    if(x<3)
                    {
                        if(!Character.isAlphabetic(reg.charAt(x)))
                        {
                            regvalidate = false;
                            break;
                        }
                        else
                        {
                            regvalidate = true;  
                        }
                    }
                    else if(x>=3)
                    {
                        if(!Character.isDigit(reg.charAt(x)))
                        {
                            regvalidate = false;
                            break;
                        }
                        else
                        {
                            regvalidate = true;  
                        }
                    }    
                }
            }
            
            if(checkmake==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a make");
            }
            else if(checkmodel==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a model");
            }
            else if(checktype==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a type");
            }
            else if(checkyearnull==true){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter a year");
            }
            else if(checknum==false){
                JOptionPane.showMessageDialog(null, "Cannot perform action : Entered year is Invalid");
            }
            else if(checkfuel==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a fueltype");
            }
            else if(checkavailable==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select the availability");
            }
            else if(checktran==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a trnsmission");
            }
            else if(checkregnull==true){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter the registration number");
            }
            else if(regvalidate==false){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter valid registration number");
            }
            else{
                String prevregnum = jTable1.getValueAt(row, 7).toString();
                Vehicle vehi = new Vehicle(make,model,type,year,fuel,available,tran,reg);
                int changes = prevregnum.compareTo(reg);
                int count = -1;
                if(changes ==0)
                {    
                    try {
                        vehi.UpdateVehicle();
                        LoaddTable();
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else
                {
                    try 
                    {
                        count = vehi.FindVehicleCount();
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(VehiclesInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(count == 0)
                    {    
                        try {
                            vehi.UpdateVehicle(prevregnum);
                            LoaddTable();
                        } catch (SQLException ex) 
                        {
                            Logger.getLogger(VehiclesInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Cannot Update Vehicle. Registration Number : "+reg+" has been already Registered with another Vehicle");
                    }
                }    
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select a Vehicle to Update From the List");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = -1;
        row = jTable1.getSelectedRow();
        if(row !=-1)
        {  
            String make = (String)makebox.getSelectedItem();
            int checkmake = makebox.getSelectedIndex();

            String model = (String)modelbox.getSelectedItem();
            int checkmodel = modelbox.getSelectedIndex();

            String type =  (String)typebox.getSelectedItem();
            int checktype = typebox.getSelectedIndex();

            String checkyear = (String)yearbox.getText();
            boolean checkyearnull = checkyear.isEmpty();
            boolean checknum = false;
            checknum = checkDigit(checkyear);
            String year = (String)yearbox.getText();

            String fuel = (String)fuelbox.getSelectedItem();
            int checkfuel = fuelbox.getSelectedIndex();

            String available = (String)availablebox.getSelectedItem();
            int checkavailable = availablebox.getSelectedIndex();

            String tran = (String)tranbox.getSelectedItem();
            int checktran = tranbox.getSelectedIndex();

            String reg = (String)regbox.getText();
            boolean checkregnull = reg.isEmpty();
            int checklength = reg.length();

            if(checkmake==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a make");
            }
            else if(checkmodel==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a model");
            }
            else if(checktype==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a type");
            }
            else if(checkyearnull==true){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter a year");
            }
            else if(checknum==false){
                JOptionPane.showMessageDialog(null, "Cannot perform action : Entered year is Invalid");
            }
            else if(checkfuel==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a fueltype");
            }
            else if(checkavailable==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select the availability");
            }
            else if(checktran==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a trnsmission");
            }
            else if(checkregnull==true){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter the registration number");
            }
            else if(checklength>7){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter valid registration number");
            }
            else{
                Vehicle vehi = new Vehicle(make,model,type,year,fuel,available,tran,reg);
                try {
                    vehi.DeleteVehicle();
                    LoaddTable();
                }
                catch (Exception e) {

                    System.out.println(e);

                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select a Vehicle to Delete From the List");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        String name = searchbox.getText();
        String sql = "select makeName from make where makeName like '%"+ name +"%' ";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex) {
            Logger.getLogger(AdminsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int row = jTable1.getSelectedRow();
        
        String make = jTable1.getValueAt(row, 0).toString();
        String model = jTable1.getValueAt(row, 1).toString(); 
        String type = jTable1.getValueAt(row, 2).toString();
        String year = jTable1.getValueAt(row, 3).toString();
        String fueltype = jTable1.getValueAt(row, 4).toString();
        String availability = jTable1.getValueAt(row, 5).toString();
        String tran = jTable1.getValueAt(row, 6).toString();
        String regno = jTable1.getValueAt(row, 7).toString();
        
        
       makebox.setSelectedItem(make);
       modelbox.setSelectedItem(model);
       typebox.setSelectedItem(type);
       yearbox.setText(year);
       fuelbox.setSelectedItem(fueltype);
       availablebox.setSelectedItem(availability);
       tranbox.setSelectedItem(tran);
       regbox.setText(regno);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void modelboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox availablebox;
    private javax.swing.JComboBox fuelbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox makebox;
    private javax.swing.JComboBox modelbox;
    private javax.swing.JTextField regbox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JComboBox tranbox;
    private javax.swing.JComboBox typebox;
    private javax.swing.JTextField yearbox;
    // End of variables declaration//GEN-END:variables
}
