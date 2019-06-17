/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



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