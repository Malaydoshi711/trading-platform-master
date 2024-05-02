
package dao;

import connection.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Logindata {
    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    public void insert(String email,String pass){
        String sql ="insert into login values(?,?)";
        try {
            
            ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2,pass);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "user added successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logindata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePassword(String email, String newPass) {
    String sql = "UPDATE login SET password = ? WHERE email = ?";
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, newPass);
        ps.setString(2, email);
        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Password updated successfully");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Logindata.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    public void deleteUser(String email) {
    String sql = "DELETE FROM login WHERE email = ?";
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, email);
        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "User deleted successfully");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Logindata.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}
