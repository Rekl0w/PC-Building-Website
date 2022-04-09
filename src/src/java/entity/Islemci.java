
package entity;


public class Islemci extends BilgisayarBileseni{
    
    private int cekirdek_sayisi;
    private float hiz;

    public Islemci() {
    }

    public Islemci(int cekirdek_sayisi, float hiz, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.cekirdek_sayisi = cekirdek_sayisi;
        this.hiz = hiz;
    }

    public Islemci(int cekirdek_sayisi, float hiz, String marka, float fiyat) {
        super(marka, fiyat);
        this.cekirdek_sayisi = cekirdek_sayisi;
        this.hiz = hiz;
    }

    public Islemci(int cekirdek_sayisi, float hiz, String marka, float fiyat, int stok, int kampanya_id) {
        super(marka, fiyat, stok, kampanya_id);
        this.cekirdek_sayisi = cekirdek_sayisi;
        this.hiz = hiz;
    }
    
    

    public int getCekirdek_sayisi() {
        return cekirdek_sayisi;
    }

    public void setCekirdek_sayisi(int cekirdek_sayisi) {
        this.cekirdek_sayisi = cekirdek_sayisi;
    }

    public float getHiz() {
        return hiz;
    }

    public void setHiz(float hiz) {
        this.hiz = hiz;
    }
    
    
}
