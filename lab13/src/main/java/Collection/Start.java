package Collection;

public class Start {
    public static void main(String[] args) {
        MyIntCollection collection1 = new MyIntCollection();
        collection1.addToList(5);
        collection1.addToList(6);
        collection1.addToList(11);


        System.out.println(collection1.getLength());


    }
}
