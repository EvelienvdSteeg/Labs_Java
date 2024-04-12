package Webshop.View;

import Webshop.Domain.Klant;
import Webshop.Service.KlantenService;

import static Webshop.App.prompt;

public class KlanttoevoegenScherm {

    KlantenService klantenService = new KlantenService();

    public void toevoegenKlant() {
        String naam = prompt("Wat is je naam? ");
        String woonplaats = prompt("Wat is je woonplaats? ");
        klantenService.toevoegenKlant(new Klant(naam, woonplaats));

    }
}
