package DadosOshi;

import java.text.DecimalFormat;
import oshi.SystemInfo;
import java.lang.NumberFormatException;

public class Memoria {

    public float capturaMemoria() {

     
        SystemInfo sc = new SystemInfo();
       long totalRam = sc.getHardware().getMemory().getTotal();
       long RAMusada = sc.getHardware().getMemory().getAvailable();
       
        
        int estaMERDA = (int)((RAMusada *100)/totalRam);
        

        System.out.println("Você está utilizando " + estaMERDA+ " de sua RAM");
        
        
       // RAMuse = Float.parseFloat(a);
        
        
        return estaMERDA;
    }

    public float capturaTotalRam() {

        SystemInfo totalR = new SystemInfo();

       long totalRam = totalR.getHardware().getMemory().getTotal();
        int  totalRAM = (int) ((totalRam *100)/totalRam);
           DecimalFormat df = new DecimalFormat();
        df.applyPattern("##,00");
        String a = df.format(totalRAM);
       float usoMem = Float.parseFloat(a);

        return usoMem;

    }
}
