
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

   
    public long DiscoDisponível() {
        int numeroDeParticoes = NumeroDeParticoesDeDisco();

        long DiscoDisponivel = 0;

        for (int i = 0; i < numeroDeParticoes; i++) {
            DiscoDisponivel += operatingSystem.getFileSystem().getFileStores()[i].getUsableSpace();

        }
        
        return DiscoDisponivel;
    }
    
    @Override
    public String toString() {
        return "disco{" + "memoria utilizada = " + FormatUtil.formatBytes(DiscoDisponível()) + '}';
    }

}
