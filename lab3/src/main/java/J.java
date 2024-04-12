public class J {
    public static void main(String[] args) {
        int i = 3;
        int j = i < 3 ? i++ + ++i : ++i >>> 1;
        System.out.println(j);
    }
}
