package DAO;

import model.cpuMODEL;
import model.discoMODEL;

import model.memoriaMODEL;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



//------------------------------------------------------------------------------
        public class DiagnosticoDAO{

        public Connection con = null; 
        
        public DiagnosticoDAO() throws SQLException{
    
        con = ConnectionFactory.getConnection(); 
       // Abre aconex�o com o banco.

    
    }
//------------------------------------------------------------------------------     
        public boolean saveDia(cpuMODEL cpu, memoriaMODEL memoria,discoMODEL disco){
 
             
            // tabela ondejd ser� armazenado os dados do Oshi na coluna ProcessadorDiagnostico (podendo ser em qualquer outra tabela.
            String sql ="INSERT INTO tbDiagnostico( usoCPUDiagnostico, usoMemoriaDiagnostico, usoDiscoDiagnostico ,horadataDiag "
            + ")VALUES(?, ?,?,GETDATE())"; // valor que ser� inserido
        
            PreparedStatement stmtdi = null; // parametro que far� o insert no banco
        
        
            try { // boolean
            
            stmtdi = con.prepareStatement(sql); 
            stmtdi.setDouble(1,cpu.capturaCpu()); // '1' significa a posi��o do simbolo '?' dentro do values.(Em qual coluna o dado ser� inserido.
            stmtdi.setLong (2, memoria.capturaMemoria());
          //  stmtdi.setLong(3, disco.NumeroDeParticoesDeDisco());
            stmtdi.executeUpdate(); // salva o dado no banco
            
            System.out.println("ALELUIA!");
            return true; // inssert feito
             
            
          } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;  // falha no insert
          } finally{
            ConnectionFactory.closeConnection(con, stmtdi); // fecha a conex�o
        }
    }

  
}
