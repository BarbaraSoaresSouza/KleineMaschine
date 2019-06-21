package Main;


import DAO.DiagnosticoDAO;

import DAO.InformacoesDAO;
//------------------------------------------------------------------------------
import DadosOshi.Cpu;
import DadosOshi.Disco;
import DadosOshi.DiscoTotal;
import DadosOshi.Memoria;
import DadosOshi.Processos;
import Logs.Arquivo;
import Logs.Diretorio;
//------------------------------------------------------------------------------
import Models.Diagnostico;

import Models.Informacoes;
import Models.SO;
import java.io.FileNotFoundException;
//------------------------------------------------------------------------------
import java.sql.SQLException;
import java.util.List;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import view.Login;

public class Computador {

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        //Funcionario funcionario = new Funcionario();       
        //funcionario.setNomeFuncionario("João de Deus");              
        //funcionario.setCpfFuncionario("8745757854"); 
        //funcionario.setSenhaFuncionario("666999");
        //FuncionarioDAO fdao = new FuncionarioDAO();        
        //fdao.save(funcionario);       
        
        
        //Variaveis
       Diretorio log; //Variavel que guarda a instancia da classe Diretorio
        
       Arquivo txt; //Variavel que guarda a instancia da classe Arquivo
        
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //Inicializando a váriavel log criando a instancia  da classe Diretorio 
        log = new Diretorio(); 
        
        //Chamando o metodo criarDiretorio da classe Diretorio
        log.criarDiretorio();
        
        //Inicializando a váriavel txt criando a instancia da classe Arquivo 
        txt = new Arquivo();
        
        //Chamando o metodo criarArquivo da classe Diretorio
        txt.criarArquivo();
        
       
          Processos procs1 = new Processos();
          List os = procs1.capturaProcesso();
          System.out.println(os);

        //----------------------------------------------------------------------
        
        Cpu cpu = new Cpu();
        double usocpU = cpu.capturaCpu();

        //----------------------------------------------------------------------
        
        Memoria memoria = new Memoria();
        float RAMuse = memoria.capturaMemoria();

        //----------------------------------------------------------------------
        Disco disc = new Disco();
        disc.NumeroDeParticoesDeDisco();
        disc.toString();
        System.out.println(disc.toString());
        //----------------------------------------------------------------------
        
        DiscoTotal diskt = new DiscoTotal();
        diskt.DiscoTotal();
        diskt.toString();
        System.out.println(diskt.toString());

        //----------------------------------------------------------------------
       
        Diagnostico diagnostico = new Diagnostico();
        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
        diagnosticoDAO.saveDia(cpu, memoria, disc);

        //----------------------------------------------------------------------
       
        String SysOp;
        PlatformEnum nomSO = SystemInfo.getCurrentPlatformEnum();
        SO so = new SO(nomSO);
        so.setNomeSO(nomSO);
        SysOp = so.toString();
       
        //----------------------------------------------------------------------
        
        Informacoes informacoes = new Informacoes();
        InformacoesDAO informacoesDAO = new InformacoesDAO();
        informacoesDAO.saveInfo(cpu, memoria, cpu, so, disc, diskt);
        
        //----------------------------------------------------------------------
        
        Login login = new Login();
        login.setUndecorated(true);
        login.setVisible(true);
    }

}
