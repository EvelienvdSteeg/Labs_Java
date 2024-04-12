package Annotations;



import java.lang.reflect.Method;

import static Annotations.Gender.MALE;
import static Annotations.Gender.UNKNOWN;


public class Main {

    public static void main(String[] args) {
        Android bot = new Android(90);
        System.out.println(bot.greet());
        bot.charge(10);
        System.out.println(bot.greet());
        Person p1 = new Person("Piet", 45, MALE);
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

        Class<Person> personClass = Person.class;

//        for (Method m : personClass.getMethods()) {
//            if (m.isAnnotationPresent(MyAnnotation.class)) {
//                System.out.println(m.getName() + " " + m.getAnnotation(MyAnnotation.class).value);
//            } else {
//                System.out.println(m.getName());
//            }
//        }

        House<Person> hp = new House<>();

        hp.person = new Person("Piet", 10, UNKNOWN);
        System.out.println(hp);

        House<Employee> he = new House<>();
        he.person = new Employee();
        he.person.setName("Puk");
        System.out.println(he);






    }
}
