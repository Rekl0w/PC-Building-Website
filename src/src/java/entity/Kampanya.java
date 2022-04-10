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

    public Kampanya(float indirim_yuzdesi) {
        this.indirim_yuzdesi = indirim_yuzdesi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.kampanya_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kampanya other = (Kampanya) obj;
        return this.kampanya_id == other.kampanya_id;
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

    @Override
    public String toString() {
        return String.valueOf(this.getIndirim_yuzdesi()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
