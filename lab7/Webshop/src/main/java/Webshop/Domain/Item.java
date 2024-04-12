package Webshop.Domain;

import java.math.BigDecimal;

public class Item {

    private String ID;
    private BigDecimal prijs;
    private String beschrijving;

    public Item(String ID, BigDecimal prijs, String beschrijving) {
        this.ID = ID;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
    }

    public String getID() {
        return ID;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    @Override
    public String toString() {
        return  beschrijving + " \u20AC" + prijs;

    }
}
