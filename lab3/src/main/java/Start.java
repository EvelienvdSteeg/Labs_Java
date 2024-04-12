public class Start {

    public static void main(String[] args) {
        Trainee naam = new Trainee(" Evelien"," van der Steeg");
        naam.firstName = "Evelien";
        naam.lastName = "van der Steeg";
        System.out.println(naam);



        Enum.Weekdays woensdag = Enum.Weekdays.Woensdag;
        System.out.println(woensdag.ordinal());

    }

}
