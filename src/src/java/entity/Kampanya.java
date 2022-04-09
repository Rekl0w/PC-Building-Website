
package entity;


public class Kampanya {
    private int kampanya_id;
    private float indirim_yuzdesi;

    public Kampanya() {
    }

    public Kampanya(int kampanya_id, float indirim_yuzdesi) {
        this.kampanya_id = kampanya_id;
        this.indirim_yuzdesi = indirim_yuzdesi;
    }

    public int getKampanya_id() {
        return kampanya_id;
    }

    public void setKampanya_id(int kampanya_id) {
        this.kampanya_id = kampanya_id;
    }

    public float getIndirim_yuzdesi() {
        return indirim_yuzdesi;
    }

    public void setIndirim_yuzdesi(float indirim_yuzdesi) {
        this.indirim_yuzdesi = indirim_yuzdesi;
    }
    
    
}
