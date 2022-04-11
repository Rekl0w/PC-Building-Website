package entity;

public class Monitor extends BilgisayarBileseni {

    private int ekran_yenileme_hizi;
    private int boyut;

    public Monitor() {
    }

    public Monitor(int urun_id,int boyut, int ekran_yenileme_hizi, String marka, float fiyat, int stok, Kampanya kampanya) {
        super(urun_id, marka, fiyat, stok, kampanya);
        this.ekran_yenileme_hizi = ekran_yenileme_hizi;
        this.boyut = boyut;
    }

    public Monitor(int ekran_yenileme_hizi, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.ekran_yenileme_hizi = ekran_yenileme_hizi;
    }

    public Monitor(int ekran_yenileme_hizi, String marka, float fiyat) {
        super(marka, fiyat);
        this.ekran_yenileme_hizi = ekran_yenileme_hizi;
    }


    public int getEkran_yenileme_hizi() {
        return ekran_yenileme_hizi;
    }

    public void setEkran_yenileme_hizi(int ekran_yenileme_hizi) {
        this.ekran_yenileme_hizi = ekran_yenileme_hizi;
    }

    public int getBoyut() {
        return boyut;
    }

    public void setBoyut(int boyut) {
        this.boyut = boyut;
    }

}
