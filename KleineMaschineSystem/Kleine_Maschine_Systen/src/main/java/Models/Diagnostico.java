
package Models;

public class Diagnostico {
  
  private double cpu;
  private long memoria;
  private double disco;
  
   
   
    public double getUsoCpu(){
  
        return cpu;
    }
    
    public void setUsoCpu(double cpu){
       this.cpu = cpu;
       
    }
    
     public long RAMusada(){
      return memoria;
    }
    
    public long setRAMusada(long memoria){
      this.memoria = memoria;
        return memoria;
    
    }
    
    
    public double getDisk(){
        return disco;
    }
    
    public double setDisk(double disco){
      this.disco = disco;
        return disco;
    }

}




