
package DadosOshi;

import oshi.SystemInfo;

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
        long memoriaTotal = 0;

        for (int i = 0; i < numeroDeParticoes; i++) {

            memoriaTotal += operatingSystem.getFileSystem().getFileStores()[i].getTotalSpace();
        }
        return memoriaTotal;
    }

  
    
    @Override
    public String toString() {
        return "disco{" + " memoria Total = " + FormatUtil.formatBytes(DiscoTotal()) + '}';
    }

}


