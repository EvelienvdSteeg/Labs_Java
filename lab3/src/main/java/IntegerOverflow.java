public class IntegerOverflow {
    public static void main(String[] args) {
        int number = 2147483647;
        long overflow = (long) number +1;
        System.out.println("number is: " + number);
        System.out.println("number is: " + ++number);
        System.out.println(overflow);




    }
}
