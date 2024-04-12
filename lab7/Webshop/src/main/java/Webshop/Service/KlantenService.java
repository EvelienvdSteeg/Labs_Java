package Webshop.Service;

import Webshop.Domain.Bestelling;
import Webshop.Domain.Klant;
import Webshop.Repo.KlantRepo;

import java.util.List;

public class KlantenService {

    KlantRepo klantRepo = KlantRepo.klantrepo;

    public Boolean checkBestaan(String naam){
        boolean bestaan;
        if (klantRepo.zoek(naam) == null){
            System.out.println("Je staat nog niet in ons systeem");
            bestaan = false;

        } else {
            bestaan = true;
        }
        return bestaan;

    }

    public void toevoegenKlant(Klant klant){
        this.klantRepo.toevoegen(klant);
    }

    public List<Klant> klantenBekijken(){
        return klantRepo.getKlantenData();
    }

    public void bestellingToevoegen(Klant klant, Bestelling bestelling){
        klant.voegToe(bestelling);
    }
}
