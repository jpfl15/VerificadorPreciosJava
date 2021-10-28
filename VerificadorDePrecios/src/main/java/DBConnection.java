import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnection {
    public Connection connection;
    public String bd_name = "verificador_de_precios";
    public String url = "jdbc:mysql://127.0.0.1:3306/" + bd_name;
    public String username = "root";
    public String password = "";

    public DBConnection() {
        this.connection = connect();
    }

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No fue posible desconectarse!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet ExeccuteResultSet(String query){
        ResultSet rs = null;
        try{
           Statement st = connection.createStatement(); 
           rs = st.executeQuery(query);
           return rs;
        }catch(SQLException e){
            
        }
        return rs;
    }
}
