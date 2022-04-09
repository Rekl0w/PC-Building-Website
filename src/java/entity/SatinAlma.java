
package entity;


public class SatinAlma {
    private int kullanici_id;
    private int urun_id;
    private float tutar;
    private String tarih;

    public SatinAlma(int kullanici_id, int urun_id, float tutar, String tarih) {
        this.kullanici_id = kullanici_id;
        this.urun_id = urun_id;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public SatinAlma(float tutar, String tarih) {
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public SatinAlma(float tutar) {
        this.tutar = tutar;
    }
    
}
