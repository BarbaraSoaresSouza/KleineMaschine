package DadosOshi;

import Models.SO;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;

public class Processos {

    //LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
    public PlatformEnum capturaProcesso() {

        SystemInfo sistema = new SystemInfo();
        OperatingSystem os = sistema.getOperatingSystem();

        HardwareAbstractionLayer hal = sistema.getHardware();
        GlobalMemory memoria = hal.getMemory();

        //Lista os Processos da cpu e suas devidas Porcentagens 
        List<OSProcess> procs = Arrays.asList(os.getProcesses(5, ProcessSort.CPU));

        PlatformEnum nomeSO = SystemInfo.getCurrentPlatformEnum();
        return null;

    }

    public String nomeSO() {

        String SysOp;

        PlatformEnum nomSO = SystemInfo.getCurrentPlatformEnum();

        SO so = new SO(nomSO);

        so.setNomeSO(nomSO);
        SysOp = so.toString();

        return SysOp;

    }

}
