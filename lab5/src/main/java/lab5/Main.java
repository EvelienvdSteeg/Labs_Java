package lab5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lijst = List.of(1, 8, 6, 9, 4, 3);
        System.out.println(Opdracht1.greatest(lijst));

        System.out.println(Opdracht3.factorial(5));
        System.out.println(Arrays.toString(Fibo.run(92)));


    }


}
