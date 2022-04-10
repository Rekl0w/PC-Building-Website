package entity;

public class Klavye extends BilgisayarBileseni {

    private String switch_modeli;

    public Klavye(int urun_id, String marka, String switch_modeli, float fiyat, int stok, Kampanya kampanya) {
        super(urun_id, marka, fiyat, stok, kampanya);
        this.switch_modeli = switch_modeli;
    }

    public Klavye(String switch_modeli, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.switch_modeli = switch_modeli;
    }

    public Klavye(String switch_modeli, String marka, float fiyat) {
        super(marka, fiyat);
        this.switch_modeli = switch_modeli;
    }

    public Klavye() {
    }

    public Klavye(String string, String string0, float aFloat, int aInt, Kampanya findById) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getSwitch_modeli() {
        return switch_modeli;
    }

    public void setSwitch_modeli(String switch_modeli) {
        this.switch_modeli = switch_modeli;
    }

}
