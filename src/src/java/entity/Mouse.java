package entity;

public class Mouse extends BilgisayarBileseni {

    private String baglanma_sekli;

    public Mouse() {
    }

    public Mouse(String baglanma_sekli, int urun_id, String marka, float fiyat, int stok, Kampanya kampanya) {
        super(urun_id, marka, fiyat, stok, kampanya);
        this.baglanma_sekli = baglanma_sekli;
    }

    public Mouse(String baglanma_sekli, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.baglanma_sekli = baglanma_sekli;
    }

    public Mouse(String baglanma_sekli, String marka, float fiyat) {
        super(marka, fiyat);
        this.baglanma_sekli = baglanma_sekli;
    }

    public Mouse(String string, String string0, float aFloat, int aInt, Kampanya findById) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getBaglanma_sekli() {
        return baglanma_sekli;
    }

    public void setBaglanma_sekli(String baglanma_sekli) {
        this.baglanma_sekli = baglanma_sekli;
    }

}
