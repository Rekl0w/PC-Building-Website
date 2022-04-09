/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author musabeytekin
 */
public class EkranKarti extends BilgisayarBileseni{
    private String model;
    private int bellek;

    public EkranKarti(String model, int bellek, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.model = model;
        this.bellek = bellek;
    }

    public EkranKarti(String model, int bellek, String marka, float fiyat) {
        super(marka, fiyat);
        this.model = model;
        this.bellek = bellek;
    }

    public EkranKarti() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBellek() {
        return bellek;
    }

    public void setBellek(int bellek) {
        this.bellek = bellek;
    }

    
    
}
