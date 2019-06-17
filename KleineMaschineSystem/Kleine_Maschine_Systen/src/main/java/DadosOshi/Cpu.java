
package DadosOshi;

import static java.lang.Thread.sleep;
import java.text.DecimalFormat;





import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.PlatformEnum;

import oshi.SystemInfo;

public class Cpu {

    public static double capturaCpu() {

        SystemInfo cpu = new SystemInfo();

        double cpu1 = cpu.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
        double usoCpu = cpu1 * (400);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("##,00%");

        System.out.println("Você está utilizando " + df.format(usoCpu) + " de sua CPU");

        return usoCpu;
        
        
       
    }
    // public static cpCpu(df.formatBytes(usoCpu)){
    
    
    
    
    
 


    public String capturaIp() {

        String ipMaquina;

        SystemInfo ip = new SystemInfo();

        ipMaquina = ip.getOperatingSystem().getNetworkParams().getIpv4DefaultGateway();

        return ipMaquina;

    }

    public String capturaNomeProcessador() {

        SystemInfo processadorMaquina = new SystemInfo();

        String processador = processadorMaquina.getHardware().getProcessor().getName();
        
        System.out.println("Processador: "+ processador);
        return processador;
        
    }
}
