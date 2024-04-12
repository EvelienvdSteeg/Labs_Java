import java.util.Scanner;

public class Opdracht3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welk seizoen wil je checken?");


        Seasons seizoen = Seasons.valueOf(scan.next());


        try {
            switch (seizoen) {
                case AUTUMN -> System.out.println("koud");
                case WINTER -> System.out.println("koud");
                case SPRING -> System.out.println("warm");
                case SUMMER -> System.out.println("warm");
                case null, default -> System.out.println("unknown");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Dit is geen geldig seizoen");

        }
    }
}
