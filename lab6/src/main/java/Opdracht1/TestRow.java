package Opdracht1;

import java.util.Arrays;
import java.util.Scanner;

public class TestRow {
    Array arrayFuncties = new Array();

    public static void main(String[] args) {



        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;

        long[] array = {1,2,3,4};

        long[] array2 = Array.verdubbelArray(array);
//        long[] array2 = new long[8];
//        System.arraycopy(array, 0, array2, 0,4);
//
        Array.printArray(array2);
        Array.printArray(array);

        Array.multiply(array, 3);

        Array.printArray(array);



        Scanner scan = new Scanner(System.in);
        int[] list = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Welk nummer wil je aan de lijst toevoegen?");
            int antwoord = scan.nextInt();
            list[i] = antwoord;

        }
        int som = 0;
        for (int i = 0; i < list.length; i++) {
            som += list[i];

        }

        System.out.println(som);




    }
}
