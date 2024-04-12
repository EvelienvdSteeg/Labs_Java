package Opdracht1;

public class Array {



    public static long[] verdubbelArray(long[] array1){
        long[] array2 = new long[array1.length *2];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];

        }
        return array2;

    }

    public static void printArray(long[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

        }
        System.out.println("\n");

    }

    static void multiply(long[] input, int multiplier){
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i]*multiplier;
        }
    }
}
