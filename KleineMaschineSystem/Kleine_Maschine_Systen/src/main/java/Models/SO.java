package Models;

import oshi.PlatformEnum;


public class SO{
    
    private PlatformEnum nomeSO;

    public SO(PlatformEnum nomeSO) {
        this.nomeSO = nomeSO;
    }

    public PlatformEnum getNomeSO() {
        return nomeSO;
    }

    public void setNomeSO(PlatformEnum nomeSO) {
        this.nomeSO = nomeSO;
    }

    @Override
    public String toString() {
        return "Sistema {" + nomeSO + '}';
    }
    
    

   
    }

