package lab5;

public class Fibo {

    public static long[] run(int n) {
        if (n < 93) {
            long[] lijst = new long[n];{}
            for (int i = 0; i < n; i++) {
                if (i < 2) {
                    lijst[i] = 1;
                } else {
                    lijst[i] = lijst[i - 1] + lijst[i - 2];
                }
            }
            return lijst;

        } else {
            return null;
        }



    }

}



