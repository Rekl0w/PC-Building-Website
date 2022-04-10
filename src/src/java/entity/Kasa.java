package entity;

public class Kasa extends BilgisayarBileseni {

    private String boyut;
    private Kampanya kampanya;

    public Kasa() {
    }

    public Kasa(int urun_id, String boyut, String marka, float fiyat, int stok,Kampanya kampanya) {
        super(urun_id,marka, fiyat, stok);
        this.boyut = boyut;
        this.kampanya = kampanya;
    }

    public Kasa(String boyut, String marka, float fiyat) {
        super(marka, fiyat);
        this.boyut = boyut;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public Kampanya getKampanya() {
        return kampanya;
    }

    public void setKampanya(Kampanya kampanya) {
        this.kampanya = kampanya;
    }

}
