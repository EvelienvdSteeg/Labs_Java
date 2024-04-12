import java.util.Scanner;

public class Opdracht2 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Welk nummer wil je de tafel van weten?");
//        int antwoord = scan.nextInt();

        for (int i = 1; i < 11; i++) {
            printTable(i);
        }

    }

    public static void printTable(int antwoord){
        for (int i = 1; i < 11; i++) {
            System.out.println(i + "x" + antwoord + "=" + i*antwoord);

        }
    }
}
