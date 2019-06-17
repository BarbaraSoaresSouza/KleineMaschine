package DAO;

import Conex�o.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.cpuMODEL;
import model.discoMODEL;
import model.memoriaMODEL;
import Models.SO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//------------------------------------------------------------------------------
public class InformacoesDAO {

    public Connection con = null;

    public InformacoesDAO() throws SQLException {

        // Abre aconex�o com o banco.
        con = ConnectionFactory.getConnection();

    }
//------------------------------------------------------------------------------     

    public boolean saveInfo(cpuMODEL ip, memoriaMODEL totalR, cpuMODEL processador, SO nomeSO, discoMODEL disc, discoMODEL diskt) {

        // tabela ondejd ser� armazenado os dados do Oshi na coluna ProcessadorDiagnostico
        //(podendo ser em qualquer outra tabela.
        String sql = "INSERT INTO tbMaquina( idMaquina, sistemaOperacional, totalDeMemoria, espacoDisco, nmProcessador,"
                + "  usoDiscoDisponivel"
                // valor que ser� inserido
                + ")VALUES(?,?,?,?,?,?)";

        // parametro que far� o insert no banco
        PreparedStatement stmtinf = null;

        // boolean
        try {

            stmtinf = con.prepareStatement(sql);
            stmtinf.setString(1, ip.capturaIp());     // '1' significa a posi��o do simbolo '?' dentro do values.(Em qual coluna o dado ser� inserido.
            stmtinf.setString(2, nomeSO.toString());
            stmtinf.setFloat(3, totalR.capturaTotalRam());
            stmtinf.setString(4, disc.toString());
            stmtinf.setString(5, processador.capturaNomeProcessador());
            stmtinf.setString(6, diskt.toString());
            // salva o dado no banco
            stmtinf.executeUpdate();

            // inssert feito
            System.out.println("ALELUIA!");
            return true;

            // falha no insert
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {

            // fecha a conex�o
            ConnectionFactory.closeConnection(con, stmtinf);
        }
    }

}


