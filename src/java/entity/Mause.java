/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author musabeytekin
 */
public class Mause extends BilgisayarBileseni{
    private String baglanma_sekli;

    public Mause() {
    }

    public Mause(String baglanma_sekli, String marka, float fiyat, int stok) {
        super(marka, fiyat, stok);
        this.baglanma_sekli = baglanma_sekli;
    }

    public Mause(String baglanma_sekli, String marka, float fiyat) {
        super(marka, fiyat);
        this.baglanma_sekli = baglanma_sekli;
    }

    public String getBaglanma_sekli() {
        return baglanma_sekli;
    }

    public void setBaglanma_sekli(String baglanma_sekli) {
        this.baglanma_sekli = baglanma_sekli;
    }
    
    
}
