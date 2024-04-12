public class NaamPersonen {
    public static void main(String[] args) {
        Trainee client1 = new Trainee("Jan");
        Trainee client2 = new Trainee("Piet");
        client2 = client1;
        client2.firstName = "Joris";
    }
}
