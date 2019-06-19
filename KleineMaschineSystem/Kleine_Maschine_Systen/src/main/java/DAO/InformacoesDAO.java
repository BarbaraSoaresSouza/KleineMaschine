package DAO;

import DadosOshi.Cpu;
import DadosOshi.Disco;
import DadosOshi.DiscoTotal;
import DadosOshi.Memoria;
import DadosOshi.Processos;
import Models.SO;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//------------------------------------------------------------------------------
public class InformacoesDAO {

    public Connection con = null;

    public InformacoesDAO() throws SQLException {

        // Abre aconexão com o banco.
        con = ConnectionFactory.getConnection();

    }
//------------------------------------------------------------------------------     

    public boolean saveInfo(Cpu ip, Memoria totalR, Cpu processador, SO nomeSO, Disco disco, DiscoTotal diskt) {

        // tabela ondejd será armazenado os dados do Oshi na coluna ProcessadorDiagnostico
        //(podendo ser em qualquer outra tabela.
        String sql = "INSERT INTO tbMaquina( idMaquina, sistemaOperacional, totalDeMemoria, espacoDisco, nmProcessador, usoDiscoDisponivel"
              
                // valor que será inserido
                + ")VALUES(?,?,?,?,?,?)";

        // parametro que fará o insert no banco
        PreparedStatement stmtinf = null;

        // boolean
        try {

            stmtinf = con.prepareStatement(sql);
            stmtinf.setString(1, ip.capturaIp());     // '1' significa a posição do simbolo '?' dentro do values.(Em qual coluna o dado será inserido.
            stmtinf.setString(2, nomeSO.toString());
            stmtinf.setFloat(3, totalR.capturaTotalRam());
            stmtinf.setLong(4, diskt.DiscoTotal());
            stmtinf.setString(5, processador.capturaNomeProcessador());
            stmtinf.setLong(6, diskt.NumeroDeParticoesDeDisco());
            // salva o dado no banco
            stmtinf.executeUpdate();

            // inssert feito
            System.out.println("INFORMAÇÕES SALVAS COM SUCESSO!");
            return true;

            // falha no insert
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {

            // fecha a conexão
            ConnectionFactory.closeConnection(con, stmtinf);
        }
    }

}
