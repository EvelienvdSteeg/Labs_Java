package lab5;

public class Opdracht3 {
    public static int factorial (int a){
        if (a <= 1){
            return 1;
        } else {
            return a * factorial(a-1);
        }
    }
}
