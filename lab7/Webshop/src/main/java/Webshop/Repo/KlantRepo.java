package Webshop.Repo;

import Webshop.Domain.Bestelling;
import Webshop.Domain.Klant;

import java.util.ArrayList;
import java.util.List;

public enum KlantRepo {
    klantrepo;

    private List<Klant> klantenData = new ArrayList<>();

    public Klant zoek(String naam){
        return this.klantenData.stream().filter(k -> k.getNaam().equals(naam)).findFirst().orElse(null);
    }

    public void toevoegen(Klant klant){
        this.klantenData.add(klant);
    }

    public List<Klant> getKlantenData() {
        return klantenData;
    }


}
