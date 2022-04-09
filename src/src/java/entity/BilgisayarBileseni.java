package entity;

public class BilgisayarBileseni {

    private int urun_id;
    private String marka;
    private float fiyat;
    private int stok;
    private int kampanya_id;

    public BilgisayarBileseni(int urun_id, String marka, float fiyat, int stok) {
        this.urun_id = urun_id;
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
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

    public BilgisayarBileseni(int urun_id, String marka, float fiyat, int stok, int kampanya_id) {
        this.kampanya_id = kampanya_id;
        this.urun_id = urun_id;
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public BilgisayarBileseni(String marka, float fiyat, int stok, int kampanya_id) {
        this.marka = marka;
        this.fiyat = fiyat;
        this.stok = stok;
        this.kampanya_id = kampanya_id;
    }

    public void setKampanya_id(int kampanya_id) {
        this.kampanya_id = kampanya_id;
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

    public int getKampanya_id() {
        return kampanya_id;
    }

}
