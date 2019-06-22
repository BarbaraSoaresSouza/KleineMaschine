
package DadosOshi;

import oshi.SystemInfo;

import oshi.util.FormatUtil;

import oshi.hardware.HardwareAbstractionLayer;

import oshi.software.os.OperatingSystem;

    public class  Disco {
     
    public SystemInfo systemInfo;
    public HardwareAbstractionLayer hardware;
    public OperatingSystem operatingSystem;

    public Disco() {
       systemInfo = new SystemInfo();
       hardware = systemInfo.getHardware();
       operatingSystem = systemInfo.getOperatingSystem();
    }
    
    public int NumeroDeParticoesDeDisco() {
        return operatingSystem.getFileSystem().getFileStores().length;
    }

   
    public int DiscoDisponível() {
        int numeroDeParticoes = NumeroDeParticoesDeDisco();

        long DiscoDisponivel = 0;
    
        int a=0;
        for (int i = 0; i < numeroDeParticoes; i++) {
            
            DiscoDisponivel += operatingSystem.getFileSystem().getFileStores()[i].getUsableSpace();
            
            System.out.println(DiscoDisponivel);
            
            int discoDD = (int)(DiscoDisponivel/DiscoDisponivel) ;
            
                        a=(int) + discoDD;

                        System.out.println(a);


        }  
        
        return a;
    }

}
