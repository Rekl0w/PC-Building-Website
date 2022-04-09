
package entity;


public class Kasa extends BilgisayarBileseni{
    private String boyut;
    private int kampanya_id;

    public Kasa() {
    }

    public Kasa(int kampanya_id, String boyut, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.boyut = boyut;
        this.kampanya_id = kampanya_id;
    }

    public Kasa(String boyut, String marka, float fiyat) {
        super(marka, fiyat);
        this.boyut = boyut;
        this.kampanya_id = kampanya_id;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public int getKampanya_id() {
        return kampanya_id;
    }

    public void setKampanya_id(int kampanya_id) {
        this.kampanya_id = kampanya_id;
    }
    
    
    
}
