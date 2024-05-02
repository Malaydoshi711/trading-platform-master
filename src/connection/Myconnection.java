package connection;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Myconnection
{
    public static final String username ="root";
    public static final String password="Gauri@040304";
    public static final String url ="jdbc:mysql://localhost:3306/project";
    public static Connection con = null;
    
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
                    
}   catch (Exception ex){
    JOptionPane.showMessageDialog(null, ""+ex,"",JOptionPane.WARNING_MESSAGE);
        
        }
        return con;
     
    }
}