package Webshop.Service;

import Webshop.Domain.Bestelling;
import Webshop.Domain.Item;
import Webshop.Domain.Klant;
import Webshop.Repo.BestellingRepo;
import Webshop.Repo.ItemRepo;
import Webshop.Repo.KlantRepo;

import java.math.BigDecimal;
import java.util.List;

import static Webshop.Repo.KlantRepo.klantrepo;

public class BestellingService {

    ItemRepo itemRepo = new ItemRepo();
    BestellingRepo bestellingRepo = new BestellingRepo();

    KlantRepo klantRepo = klantrepo;


    public void voegItemToe(String beschrijving, Bestelling bestelling){
            Item item = this.itemRepo.zoekItemOpBeschrijving(beschrijving);
            if (item == null){
                System.out.println("Dit artikel bestaat niet");
            } else {
                bestelling.voegToeAanBestelling(item);
            }

    }

    public BigDecimal totaalBedrag(List<Item> bestelling){
        BigDecimal totaal = new BigDecimal(0);
        for (int i = 0; i < bestelling.size(); i++) {
            totaal = totaal.add(bestelling.get(i).getPrijs());

        }

        return totaal;

    }

    public void bestellingPlaatsen(String antwoord, Bestelling bestelling){
        switch (antwoord){
            case "ja" -> {System.out.println("Je bestelling is geplaatst.");
                            bestellingRepo.addBestelling(bestelling);}

            case "nee" -> System.out.println("Je bestelling is niet geplaatst");

            default -> System.out.println("Dit is geen geldige optie, probeer het opnieuw");

        }
    }

    public void toevoegenKlantBestelling(String naam, Bestelling bestelling){
        bestelling.setNaam(naam);
    }

    public List<Bestelling> bestellingenBekijken(){
        return bestellingRepo.getBestellingData();
    }





}
