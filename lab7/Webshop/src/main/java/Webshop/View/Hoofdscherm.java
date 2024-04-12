package Webshop.View;

import static Webshop.App.*;
import static Webshop.View.Bestellingscherm.bestellingscherm;

public class Hoofdscherm {

    public void start(){
        System.out.println("Welkom bij de webshop");
        System.out.println("Wat wilt u doen?");
        System.out.println("(a) catalogus bekijken");
        System.out.println("(b) bestelling doen");
        System.out.println("(c) de webshop verlaten");

        String antwoord = readLine();

        switch (antwoord){
            case "a" -> new Catalogusscherm().start();
            case "b" -> bestellingscherm().start();
            case "c" -> {System.out.println("Tot ziens!");return;}
            default -> {
                System.out.println("Geen geldige keuze, probeer het opnieuw");new Hoofdscherm().start() ;}

        }
    }
}
