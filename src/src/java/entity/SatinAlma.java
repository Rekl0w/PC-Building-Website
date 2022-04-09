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

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public float getTutar() {
        return tutar;
    }

    public void setTutar(float tutar) {
        this.tutar = tutar;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

}
