package DadosOshi;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;

import oshi.util.FormatUtil;

import oshi.hardware.HardwareAbstractionLayer;

import oshi.software.os.OperatingSystem;

    public class  DiscoTotal {
     
    public SystemInfo systemInfo;
    public HardwareAbstractionLayer hardware;
    public OperatingSystem operatingSystem;

    public DiscoTotal() {
       systemInfo = new SystemInfo();
       hardware = systemInfo.getHardware();
       operatingSystem = systemInfo.getOperatingSystem();
    }
    
    public int NumeroDeParticoesDeDisco() {
        return operatingSystem.getFileSystem().getFileStores().length;
    }

    public long DiscoTotal() {
        
        int numeroDeParticoes = NumeroDeParticoesDeDisco();
        
        long d = 0;
        HWDiskStore[] disco = hardware.getDiskStores();
        
        for (int i = 0; i < disco.length; i++) {
             d = disco[i].getSize()/1000000000;
                    
        }
        Disco a = new Disco();
       
       long conta =  d - a.NumeroDeParticoesDeDisco();
       
        System.out.println("Total do Disco é "+conta);
      
        return d;
    }

  
    
    @Override
    public String toString() {
        return "disco{" + " memoria Total = " + DiscoTotal() +'}';
    }

      /*  public static void main(String[] args) {
            
           Disco disc = new Disco();
        disc.NumeroDeParticoesDeDisco();
        System.out.println(disc.toString());
            
            
        }*/
    
    }

