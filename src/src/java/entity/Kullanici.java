
package entity;


public class Kullanici {
    private int kullanici_id;
    private String ad_soyad;
    private String sifre;

    public Kullanici() {
    }

    public Kullanici(int kullanici_id, String ad_soyad, String sifre) {
        this.kullanici_id = kullanici_id;
        this.ad_soyad = ad_soyad;
        this.sifre = sifre;
    }

    public Kullanici(String ad_soyad, String sifre) {
        this.ad_soyad = ad_soyad;
        this.sifre = sifre;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }
    
    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    
    
}
