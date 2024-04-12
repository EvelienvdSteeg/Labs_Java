package Opdracht1;

import java.util.Arrays;
import java.util.Random;

public class Sudoku {
    public static void main(String[] args) {

        int[] nummers = {1,2,3,4,5,6,7,8,9};
        int[][] sudoku = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                sudoku[i][j] = randomNumber();

            }

        }

        System.out.println(Arrays.deepToString(sudoku));
    }

    public static int randomNumber(){

        int number = (int) (Math.random() * (9 - 1 + 1) + 1);
        return number;
    }


}
