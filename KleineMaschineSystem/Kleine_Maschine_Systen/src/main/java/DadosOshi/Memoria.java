package DadosOshi;

import java.text.DecimalFormat;
import oshi.SystemInfo;
import java.lang.NumberFormatException;

public class Memoria {

    public float capturaMemoria() {

        float RAMusada;
        float tuaMae;
        SystemInfo sc = new SystemInfo();

        RAMusada = sc.getHardware().getMemory().getAvailable();
        DecimalFormat df = new DecimalFormat("0.#");
       // df.applyPattern("#,##");
        
        //String a = df.format(RAMusada);
        
        float estaMERDA = RAMusada / 1024 /1024 /1024;
        
        String estaPorra = df.format(estaMERDA);

        System.out.println("Você está utilizando " + df.format(estaMERDA) + " de sua RAM");
        
        
       // RAMuse = Float.parseFloat(a);
        
        
        return estaMERDA;
    }

    public float capturaTotalRam() {
        float totalRam;

        SystemInfo totalR = new SystemInfo();

        totalRam = totalR.getHardware().getMemory().getTotal();

        return totalRam;

    }
}
