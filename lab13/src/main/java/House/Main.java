package House;


import com.sun.source.util.Trees;

import java.util.*;

import static House.Gender.*;


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



        Class<Person> personClass = Person.class;

//        for (Method m : personClass.getMethods()) {
//            if (m.isAnnotationPresent(MyAnnotation.class)) {
//                System.out.println(m.getName() + " " + m.getAnnotation(MyAnnotation.class).value);
//            } else {
//                System.out.println(m.getName());
//            }
//        }

        House<Person> hp = new House<Person>();

        hp.person = new Person("Piet", 10, UNKNOWN);
        System.out.println(hp);

        House<Employee> he = new House<Employee>();
        he.person = new Employee();
        he.person.setName("Puk");
        System.out.println(he);

        List<Person> persons1 = new ArrayList<>();
        List<Person> persons2 = new ArrayList<>();

        List<Human> humans1 = new ArrayList<>();
        persons1.add(p1);
        persons1.add(p2);
        System.out.println(persons1);
        System.out.println(persons2);

        Person.copy(persons1, persons2);
        System.out.println(persons2);
        Person.copy2(persons1, humans1);

        System.out.println("Lijst van humans" + humans1);

        p1.addHistory("Beschrijving");
        p1.addHistory("Beschrijving2");
        p1.printHistory();


        Person p3 = new Person("Piet", 42, MALE);
        Person p4 = new Person("Piet", 42, MALE);
        Person p5 = new Person("Piet", 42, FEMALE);
        Person p6 = new Person("Jan", 42, MALE);
        Set<Person> personSet = new HashSet<>();
        personSet.add(p1);
        personSet.add(p3);
        System.out.println(personSet);
        personSet.add(p4);

        System.out.println(personSet);
        personSet.add(p5);
        System.out.println(personSet);
        personSet.add(p6);
        System.out.println(personSet);

        TreeMap<Integer, Person> boom = new TreeMap<>();
        boom.put(15, p4);
        boom.put(10, p2);
        System.out.println(boom);
        System.out.println(boom.headMap(5).values());

        TreeSet<Person> boomset = new TreeSet<>();
        boomset.add(p4);
        boomset.add(p5);
        boomset.add(p1);
        System.out.println(boomset);


    }
}
