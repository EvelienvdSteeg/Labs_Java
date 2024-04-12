import java.util.Scanner;

public class HelloClass {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.printf("hello world %s" , args[0] );
        System.out.println(" hello world" + 4);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = in.nextLine();
        System.out.println("Username is: " + userName);
        int plusTwo = Math.abs(-2);
        System.out.println(plusTwo);

    }
}
