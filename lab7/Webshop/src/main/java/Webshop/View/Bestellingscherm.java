package Webshop.View;

import Webshop.Domain.Bestelling;
import Webshop.Domain.Klant;
import Webshop.Service.BestellingService;
import Webshop.Service.KlantenService;

import java.util.Date;

import static Webshop.App.prompt;
import static Webshop.App.readLine;

public class Bestellingscherm {


    // singleton design pattern begin -----------

    private static Bestellingscherm self;

    private Bestellingscherm() {}

    public static synchronized Bestellingscherm bestellingscherm() {
        if (self == null) self = new Bestellingscherm();
        return self;
    }
// singleton design pattern end -------------

    BestellingService bestellingService = new BestellingService();
    KlantenService klantenService = new KlantenService();



    public void start() {


        while (true) {
            System.out.println("Wat wil je doen?");
            System.out.println("(a) een nieuwe bestelling maken");
            System.out.println("(b) terug naar het hoofdmenu");

            String keuze = readLine();

            switch (keuze) {
                case "a" -> {
                    String artikelToevoegen = "ja";
                    voegToe(artikelToevoegen);
                }
                case "b" -> {
                    new Hoofdscherm().start();
                    return;
                }
                default -> System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }


    public void voegToe(String artikelToevoegen) {
        Bestelling huidigeBestelling = new Bestelling();
        Klant klant = new Klant();
        //zolang de klant items wil toevoegen krijgt hij de vraag welk artikel
        while (artikelToevoegen.equals("ja")) {

            System.out.println("Welk artikel wil je toevoegen aan je winkelmand?");
            String antwoordItemToevoegen = readLine();
            bestellingService.voegItemToe(antwoordItemToevoegen, huidigeBestelling);
            System.out.println("Wil je nog een artikel toevoegen?");
            artikelToevoegen = readLine();
        }

        //Check of de bestelling lijst items bevat, alleen dan kan een bestelling geplaatst worden.
        if (!huidigeBestelling.getLijstBesteldeItems().isEmpty()) {

            System.out.println("Dit is je totale bestelling: ");
            System.out.println(huidigeBestelling.getLijstBesteldeItems());

            System.out.println("Het totale bedrag wat je moet betalen is: ");
            System.out.println(bestellingService.totaalBedrag(huidigeBestelling.getLijstBesteldeItems()));

            System.out.println("Wil je de bestelling plaatsen? (ja/nee)");
            String antwoordBestelling = readLine();


            //Bestelling plaatsen
            if (antwoordBestelling.equals("ja")) {

                //Check of de klant al in de database staat
                String naam = prompt("Wat is je naam? ");
                if (!klantenService.checkBestaan(naam)){
                    new KlanttoevoegenScherm().toevoegenKlant();
                    huidigeBestelling.setNaam(naam);
                    klant.setNaam(naam);
                    System.out.println("Je bent toegevoegd aan het klantenbestand");
                } else {
                    huidigeBestelling.setNaam(naam);
                    klant.setNaam(naam);
                    System.out.println("Je staat al in ons klantenbestand");
                }



                huidigeBestelling.setDatum(new Date());
                bestellingService.bestellingPlaatsen(antwoordBestelling, huidigeBestelling);
                klantenService.bestellingToevoegen(klant, huidigeBestelling);

            }


        }


    }


}

