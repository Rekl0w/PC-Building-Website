package entity;

import java.util.List;

public class BilgisayarBileseni {

    private int urun_id;
    private String marka;
    private float fiyat;
    private int stok;
    private Kampanya kampanya;
    private List<Kullanici> kullanicilar;

    public BilgisayarBileseni(String marka, float fiyat, int stok, Kampanya kampanya, List<Kullanici> kullanicilar) {
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
        this.kampanya = kampanya;
        this.kullanicilar = kullanicilar;
    }

    

    public BilgisayarBileseni(int urun_id, String marka, float fiyat, int stok) {
        this.urun_id = urun_id;
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public BilgisayarBileseni(int urun_id, String marka, float fiyat, int stok, List<Kullanici> kullanicilar) {
        this.urun_id = urun_id;
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
        this.kullanicilar = kullanicilar;
    }

    public BilgisayarBileseni() {
    }

    public BilgisayarBileseni(String marka, float fiyat, int stok) {
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public BilgisayarBileseni(String marka, float fiyat) {
        this.marka = marka;
        this.fiyat = fiyat;
    }

    public BilgisayarBileseni(int urun_id, String marka, float fiyat, int stok, Kampanya kampanya) {
        this.kampanya = kampanya;
        this.urun_id = urun_id;
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public BilgisayarBileseni(String marka, float fiyat, int stok, Kampanya kampanya) {
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
        this.kampanya = kampanya;
    }

    public void setKampanya(Kampanya kampanya) {
        this.kampanya = kampanya;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Kampanya getKampanya() {
        return kampanya;
    }
    
    public List<Kullanici> getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(List<Kullanici> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }
    

}
