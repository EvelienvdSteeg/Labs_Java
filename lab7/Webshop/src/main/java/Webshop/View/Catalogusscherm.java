package Webshop.View;

import Webshop.Service.CatalogusService;

import java.time.Year;

import static Webshop.App.*;

public class Catalogusscherm {
    CatalogusService catalogusService = new CatalogusService();
    int catalogus;

    public void start() {


        while (true) {
            System.out.println("Wat wil je doen?");
            System.out.println("(a) catalogus 2023 bekijken");
            System.out.println("(b) catalogus 2024 bekijken");
            System.out.println("(c) terug naar het hoofdmenu");

            String keuze = readLine();

            switch (keuze) {
                case "a" -> {int catalogus = 2023;bekijken(catalogus);}
                case "b" -> {int catalogus = 2024; bekijken(catalogus);}
                case "c" -> {new Hoofdscherm().start();return;}
                default -> System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }



    public void bekijken(int catalogus){

        System.out.println(catalogusService.catalogusRepo.vindCatalogus(Year.of(catalogus)));

    }
}
