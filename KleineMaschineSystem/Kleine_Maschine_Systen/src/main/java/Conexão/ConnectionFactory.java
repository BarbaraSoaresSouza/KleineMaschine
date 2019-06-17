package Conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {

    private static final String USER = "bandtec";
    private static final String PASSWORD = "@Bacons2";
    private static final String URL = "jdbc:sqlserver://kmaschine.database.windows.net:1433;database=KleineMaschine;user=bandtec@kmaschine;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    
    public static Connection getConnection() throws SQLException {

        try {

          Class.forName(DRIVER);
          return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } 
         
        catch (ClassNotFoundException |SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
         
       }
        
}
        public static void closeConnection(Connection con){
            
            if (con != null){
            
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println("Erro" + ex);
                }
            
       }
    } 
                public static void closeConnection(Connection con, PreparedStatement stmt){
            
            if (stmt != null){
            
                try {
                    stmt.close();
                } catch (SQLException ex) {
                   System.err.println("Erro " + ex);
                }
                 closeConnection(con);
       }
    }
                public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
            
            if (rs != null){
            
                try {
                    rs.close();
                } catch (SQLException ex) {
                   System.err.println("Erro " + ex);
                }
                 closeConnection(con, stmt);
       }
    }

  
}
    
    
    


