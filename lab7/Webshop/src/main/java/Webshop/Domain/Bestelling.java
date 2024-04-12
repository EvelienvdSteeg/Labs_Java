package Webshop.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bestelling {
    private Date datum;
    private List<Item> lijstBesteldeItems = new ArrayList<>();
    private String naam;

    public Bestelling(Date datum, List<Item> lijstBesteldeItems, String naam) {
        this.datum = datum;
        this.lijstBesteldeItems = lijstBesteldeItems;
        this.naam = naam;
    }

    public Bestelling(){

    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Item> getLijstBesteldeItems() {
        return lijstBesteldeItems;
    }

    public void voegToeAanBestelling(Item item){
        this.lijstBesteldeItems.add(item);
    }


    @Override
    public String toString() {
        return "Bestelling{" +
                "datum=" + datum +
                ", lijstBesteldeItems=" + lijstBesteldeItems +
                ", naam='" + naam + '\'' +
                '}';
    }
}
