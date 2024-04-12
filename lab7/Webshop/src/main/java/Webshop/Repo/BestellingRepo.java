package Webshop.Repo;

import Webshop.Domain.Bestelling;

import java.util.ArrayList;
import java.util.List;

public class BestellingRepo {
    private List<Bestelling> bestellingData = new ArrayList<>();

    public void addBestelling(Bestelling bestelling){
        this.bestellingData.add(bestelling);
    }

    public List<Bestelling> getBestellingData() {
        return bestellingData;
    }
}
