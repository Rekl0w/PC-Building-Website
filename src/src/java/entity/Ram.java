package entity;

public class Ram extends BilgisayarBileseni {

    private int bellek;

    public Ram() {
    }

    public Ram(int bellek, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.bellek = bellek;
    }

    public Ram(int bellek, String marka, float fiyat) {
        super(marka, fiyat);
        this.bellek = bellek;
    }

    public Ram(int aInt, String string, float aFloat, int aInt0, Kampanya findById) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getBellek() {
        return bellek;
    }

    public void setBellek(int bellek) {
        this.bellek = bellek;
    }

}
