package entity;

public class Islemci extends BilgisayarBileseni {

    private int cekirdek_sayisi;
    private float hiz;

    public Islemci() {
    }

    public Islemci(int urun_id, Kampanya kampanya ,int cekirdek_sayisi, float hiz, String marka, float fiyat, int stok ) {
        super(urun_id, marka, fiyat, stok, kampanya);
        this.cekirdek_sayisi = cekirdek_sayisi;
        this.hiz = hiz;
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

    public Islemci(int cekirdek_sayisi, float hiz, String marka, float fiyat, int stok, Kampanya kampanya) {
        super(marka, fiyat, stok, kampanya);
        this.cekirdek_sayisi = cekirdek_sayisi;
        this.hiz = hiz;
    }
    public Islemci(int urun_id,int cekirdek_sayisi, float hiz, String marka, float fiyat, int stok, Kampanya kampanya) {
        super(urun_id, marka, fiyat, stok, kampanya);
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
