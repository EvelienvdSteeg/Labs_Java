package Opdracht1;

import static Opdracht1.Gender.*;

public class Main {

    public static void main(String[] args) {
        Android bot = new Android(90);
        System.out.println(bot.greet());
        bot.charge(10);
        System.out.println(bot.greet());
        Person p1 = new Person("Piet",45,MALE);
        Employee e1 = new Employee();
        e1.setName("Jan");
        System.out.println(e1.greet());
        Person p2;
        p2 = e1;
        System.out.println(p2.greet());

        p1.addHistory("Beschrijving");
        p1.addHistory("Beschrijving2");
        p1.printHistory();

        Human h1 = p1.createSubHuman();

        System.out.println(h1.greet());


    }
}
