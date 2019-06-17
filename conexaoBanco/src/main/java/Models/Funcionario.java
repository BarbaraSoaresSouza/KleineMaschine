/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Profissional
 */
public class Funcionario {
 
    private int codFuncionario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private int codCargo;
    private String senhaFuncionario;
    
    public String getSenhaFuncionario(){
      return senhaFuncionario;
    }
     
    public void setSenhaFuncionario(String senhaFuncionario){
    this.senhaFuncionario = senhaFuncionario;
    }
    
    public int getCodFuncionario(){
        return codFuncionario;
    }
    
    public void setCodFuncionario(int codFuncionario){
        this.codFuncionario = codFuncionario;
    }
    
    public String getNomeFuncionario(){
        return nomeFuncionario;
    }
    
    public void setNomeFuncionario(String nomeFuncionario){
        this.nomeFuncionario = nomeFuncionario;
    }
    
    public String getCpfFuncionario(){
        return cpfFuncionario;
    }
    
    public void setCpfFuncionario(String cpfFuncionario){
        this.cpfFuncionario = cpfFuncionario;
    }
    
    public int getCodCargo(){
        return codCargo;
    }
    
    public void setCodCargo(int codCargo){
        this.codCargo = codCargo;
    }
}
