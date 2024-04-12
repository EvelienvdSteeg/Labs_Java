package Webshop;

import Webshop.View.Bestellingscherm;
import Webshop.View.Hoofdscherm;

import java.util.Scanner;

public class App {

    private static final Scanner scan = new Scanner(System.in);

    public static String readLine() { return scan.nextLine(); }

    public static String prompt(String message) {
        System.out.print(message);
        return scan.nextLine();
    }

    public static void main(String[] args) {
        new Hoofdscherm().start();


    }


}
