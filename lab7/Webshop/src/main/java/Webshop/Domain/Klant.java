package Webshop.Domain;

import java.util.ArrayList;
import java.util.List;

public class Klant {
    private String naam;
    private String woonplaats;
    private List<Bestelling> lijstBestellingen = new ArrayList<>();


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public List<Bestelling> getLijstBestellingen() {
        return lijstBestellingen;
    }

    public void voegToe(Bestelling bestelling) {
        this.lijstBestellingen.add(bestelling);
    }

    public Klant(String naam, String woonplaats, List<Bestelling> lijstBestellingen) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.lijstBestellingen = lijstBestellingen;
    }

    public Klant(String naam){
        this.naam = naam;
    }

    public Klant(String naam, String woonplaats){
        this.naam = naam;
        this.woonplaats = woonplaats;
    }

    public Klant(){

    }



    @Override
    public String toString() {
        return "Klant{" +
                "naam='" + naam + '\'' +
                ", woonplaats='" + woonplaats + '\'' +
                ", lijstBestellingen=" + lijstBestellingen +
                '}';
    }


}
