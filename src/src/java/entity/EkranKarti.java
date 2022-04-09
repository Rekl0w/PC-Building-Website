package entity;

public class EkranKarti extends BilgisayarBileseni {

    private String model;
    private int bellek;

    public EkranKarti(String model, int bellek, String marka, float fiyat, int stok, int kampanya_id) {
        super(marka, fiyat, stok, kampanya_id);
        this.model = model;
        this.bellek = bellek;
    }

    public EkranKarti(String model, int bellek, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.model = model;
        this.bellek = bellek;
    }

    public EkranKarti(String model, int bellek, String marka, float fiyat) {
        super(marka, fiyat);
        this.model = model;
        this.bellek = bellek;
    }

    public EkranKarti() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBellek() {
        return bellek;
    }

    public void setBellek(int bellek) {
        this.bellek = bellek;
    }

}
