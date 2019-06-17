package DadosOshi;

import oshi.SystemInfo;

public class Memoria {

    public long capturaMemoria() {

        long RAMusada;
        
        SystemInfo sc = new SystemInfo();

        RAMusada = sc.getHardware().getMemory().getAvailable();

        return RAMusada;
    }

    public float capturaTotalRam() {
        float totalRam;

        SystemInfo totalR = new SystemInfo();

        totalRam = totalR.getHardware().getMemory().getTotal();
        
        return totalRam ;
        
        

    }
}

