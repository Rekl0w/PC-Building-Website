/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author musabeytekin
 */
public class Anakart extends BilgisayarBileseni{
    
    private String cpu_soketi;
    private int bellek_saat_hizi;

    public Anakart() {
    }

    public Anakart(String cpu_soketi, int bellek_saat_hizi, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.cpu_soketi = cpu_soketi;
        this.bellek_saat_hizi = bellek_saat_hizi;
    }

    public Anakart(String cpu_soketi, int bellek_saat_hizi, String marka, float fiyat) {
        super(marka, fiyat);
        this.cpu_soketi = cpu_soketi;
        this.bellek_saat_hizi = bellek_saat_hizi;
    }

    public String getCpu_soketi() {
        return cpu_soketi;
    }

    public void setCpu_soketi(String cpu_soketi) {
        this.cpu_soketi = cpu_soketi;
    }

    public int getBellek_saat_hizi() {
        return bellek_saat_hizi;
    }

    public void setBellek_saat_hizi(int bellek_saat_hizi) {
        this.bellek_saat_hizi = bellek_saat_hizi;
    }

    
    
    
}
