/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author musabeytekin
 */
public class Kasa extends BilgisayarBileseni{
    private String boyut;

    public Kasa() {
    }

    public Kasa(String boyut, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.boyut = boyut;
    }

    public Kasa(String boyut, String marka, float fiyat) {
        super(marka, fiyat);
        this.boyut = boyut;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }
    
    
    
}
