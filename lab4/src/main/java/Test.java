import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Voer een account nummer in");
        String accountnummer = scan.next();


        try {
            int som = 0;
            for (int i = 0; i < 9; i++) {
                som += Character.getNumericValue(accountnummer.charAt(i)) * (9 - i);
            }

            if (som % 11 == 0) {
                System.out.println("Valid");
            } else {
                System.out.println("Not valid");
            }

            System.out.println(som);


        } catch (IllegalArgumentException e) {
            System.out.println("Geen juist accountnummer");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nummer is niet lang genoeg");
        }


    }
}

