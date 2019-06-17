package Main;

import oshi.util.FormatUtil;
import DAO.DiagnosticoDAO;
import DAO.FuncionarioDAO;
import DAO.InformacoesDAO;
//------------------------------------------------------------------------------
import DadosOshi.Cpu;
import DadosOshi.Disco;
import DadosOshi.DiscoTotal;
import DadosOshi.Memoria;
//------------------------------------------------------------------------------
import Models.Diagnostico;
import Models.Funcionario;
import Models.Informacoes;
import Models.SO;
//------------------------------------------------------------------------------
import java.sql.SQLException;
import oshi.PlatformEnum;
import oshi.SystemInfo;

public class Computador {

    public static void main(String[] args) throws SQLException {
         

        //Funcionario funcionario = new Funcionario();       
        //funcionario.setNomeFuncionario("João de Deus");              
        //funcionario.setCpfFuncionario("8745757854"); 
        //funcionario.setSenhaFuncionario("666999");
        //FuncionarioDAO fdao = new FuncionarioDAO();        
        //fdao.save(funcionario);                            

        //----------------------------------------------------------------------
      
    	Cpu cpu = new Cpu();
        double usoCpu = cpu.capturaCpu();

        //----------------------------------------------------------------------
        Memoria memoria = new Memoria();
        long RAMusada = memoria.capturaMemoria();

        //----------------------------------------------------------------------
        Disco disco = new Disco();
        disco.NumeroDeParticoesDeDisco();
        System.out.println(disco.toString());
        
        
        DiscoTotal diskt = new DiscoTotal();
        System.out.println(diskt.toString());
        


        //----------------------------------------------------------------------
        Diagnostico diagnostico = new Diagnostico();
        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
        diagnosticoDAO.saveDia(cpu, memoria, disco);

        //----------------------------------------------------------------------
         
          String SysOp;

        PlatformEnum nomSO = SystemInfo.getCurrentPlatformEnum();

        SO so = new SO(nomSO);

        so.setNomeSO(nomSO);
        SysOp = so.toString();
        
        //----------------------------------------------------------------------
        
        
        //----------------------------------------------------------------------
         
        Informacoes informacoes = new Informacoes();
        InformacoesDAO informacoesDAO = new InformacoesDAO();
        informacoesDAO.saveInfo(cpu, memoria, cpu, so, disco, diskt);
        
      
 
       // DiscoTotal estaMerda = new DiscoTotal();
        //estaMerda.DiscoTotal();
        

    }
}
        
    


