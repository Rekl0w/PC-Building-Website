/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author musabeytekin
 */
public class Ram extends BilgisayarBileseni{
    private int bellek;

    public Ram() {
    }

    public Ram(int bellek, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.bellek = bellek;
    }

    public Ram(int bellek, String marka, float fiyat) {
        super(marka, fiyat);
        this.bellek = bellek;
    }

    public int getBellek() {
        return bellek;
    }

    public void setBellek(int bellek) {
        this.bellek = bellek;
    }
    
    
}
