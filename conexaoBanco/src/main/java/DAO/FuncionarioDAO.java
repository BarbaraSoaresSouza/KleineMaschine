/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Funcionario;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class FuncionarioDAO{
    
    private Connection con = null;
    
    public FuncionarioDAO() throws SQLException{
    
    con = ConnectionFactory.getConnection();
    
    }
     
    public boolean save(Funcionario funcionario){
    
         String sql ="INSERT INTO tbDadosFuncionario( nomeFuncionario, cpfFuncionario, senhaFuncionario"
            + ")VALUES(?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getCpfFuncionario());
            stmt.setString(3, funcionario.getSenhaFuncionario());
              
            stmt.executeUpdate();
            System.out.println("sucesso");
            return true;
             
            
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
        
    
    }
    
}
  

