package entity;

public class Ram extends BilgisayarBileseni {

    private int bellek;

    public Ram() {
    }

    public Ram(int urun_id, int bellek, String marka, float fiyat, int stok, Kampanya kampanya) {
        super(urun_id, marka, fiyat, stok, kampanya);
        this.bellek = bellek;
    }

    public Ram(int bellek, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.bellek = bellek;
    }

    public Ram(int bellek, String marka, float fiyat) {
        super(marka, fiyat);
        this.bellek = bellek;
    }

    public int getBellek() {
        return bellek;
    }

    public void setBellek(int bellek) {
        this.bellek = bellek;
    }

}
