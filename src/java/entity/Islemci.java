/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author musabeytekin
 */
public class Islemci extends BilgisayarBileseni{
    
    private int cekirdek_sayisi;
    private int hiz;

    public Islemci() {
    }

    public Islemci(int cekirdek_sayisi, int hiz, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.cekirdek_sayisi = cekirdek_sayisi;
        this.hiz = hiz;
    }

    public Islemci(int cekirdek_sayisi, int hiz, String marka, float fiyat) {
        super(marka, fiyat);
        this.cekirdek_sayisi = cekirdek_sayisi;
        this.hiz = hiz;
    }

    public int getCekirdek_sayisi() {
        return cekirdek_sayisi;
    }

    public void setCekirdek_sayisi(int cekirdek_sayisi) {
        this.cekirdek_sayisi = cekirdek_sayisi;
    }

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }
    
    
}
