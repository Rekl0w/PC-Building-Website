/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author musabeytekin
 */
public class Klavye extends BilgisayarBileseni{
    private String switch_modeli;

    public Klavye(String switch_modeli, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.switch_modeli = switch_modeli;
    }

    public Klavye(String switch_modeli, String marka, float fiyat) {
        super(marka, fiyat);
        this.switch_modeli = switch_modeli;
    }

    public Klavye() {
    }

    public String getSwitch_modeli() {
        return switch_modeli;
    }

    public void setSwitch_modeli(String switch_modeli) {
        this.switch_modeli = switch_modeli;
    }
    
    
    
}
