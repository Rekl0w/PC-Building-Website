
package entity;


public class BilgisayarBileseni {
    
    private int urun_id;
    private int kampanya_id;
    private String marka;
    private float fiyat;
    private int stok;
    
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
    

    public int getUrun_id() {
        return urun_id;
    }

    public int getKampanya_id() {
        return kampanya_id;
    }

    public String getMarka() {
        return marka;
    }

    public float getFiyat() {
        return fiyat;
    }

    public int getStok() {
        return stok;
    }

 
    
}
