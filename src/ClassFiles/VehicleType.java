/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vince Lance
 */
public class VehicleType {

    private String typeName;
    private double keymoney;
    private double dailycharge;
    
    public VehicleType(){ 
    }

    public VehicleType(String typeName,double keymoney,double dailycharge)
    {
        this.keymoney=keymoney;
        this.typeName=typeName;
        this.dailycharge=dailycharge;
    }

    public boolean FindVehicleType() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select typeName from vehicletype where typeName= '" +this.typeName+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next();
    }

    public int FindVehicleTypeCount() throws SQLException{
        int count = 0;
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select typeName from vehicletype where typeName= '" +this.typeName+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        while(rs.next())
        {
            count++;
        }
        return count;
    }

    
    public void AddVehicleType() throws SQLException{
        if(FindVehicleType())
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. Vehicle type Already Exists");
            
        }
        else
        {
            Connection conn = DBConnect.connect();
            try {

                String query = "INSERT INTO vehicletype (typeName,keymoney,dailycharge) VALUES ('" +this.typeName+ "', '"+ this.keymoney + "', '" + this.dailycharge+"')";
                PreparedStatement stmnt = conn.prepareStatement(query);
                stmnt.execute();
            } 
            catch (Exception e) {
                  System.out.println(e);
                  
            }
            JOptionPane.showMessageDialog(null, "Vehicle Type Added Successfully");
            
        }
    }

    
    public boolean UpdateVehicleType() throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE vehicletype SET typeName='"+ this.typeName +"',keymoney='"+ this.keymoney+"' where typename = '" +this.typeName+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "VehicleType Updated Successfully");
        }
        catch (Exception e){

            System.out.println(e);
        }
        return true;
    }
    
    public boolean UpdateVehicleType(String inputvtype) throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE vehicletype SET typeName='"+ this.typeName +"',keymoney='"+ this.keymoney+"' where typename = '" +inputvtype+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "VehicleType Updated Successfully");
        }
        catch (Exception e){

            System.out.println(e);
        }
        return true;
    }
    
    public void DeleteVehicleType(){
    
        Connection conn = DBConnect.connect();
        try {
            
            String query="DELETE from vehicletype where typeName='"+ this.typeName +"'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
           
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        JOptionPane.showMessageDialog(null, "Vehicle Type Deleted Successfully");
    }

}