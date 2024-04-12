package Persons;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static Persons.Gender.MALE;

public class PersonStart {
    public static void main(String[] args) throws Throwable {
        Person p1 = new Person("Jan" , 45, MALE);
        Person p2 = new Person("Jan" , 45, MALE);
        Person p3 = new Person("Jan" , 43, MALE);

        Object p4 = new Person("Jan", 45, MALE);

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);

        PersonMaken p5 = new PersonMaken("Jan", 45, MALE);
        PersonMaken p6 = new PersonMaken("Jan", 45, MALE);
        PersonMaken p7 = new PersonMaken("Jan", 43, MALE);

        Set<PersonMaken> set2 = new HashSet<>();
        set2.add(p5);
        set2.add(p6);
        set2.add(p7);
        System.out.println(set2);





//        Class<Person> personClass = Person.class;
//        for(Method a: personClass.getDeclaredMethods()){
//            System.out.println(a.getName() + Arrays.toString(a.getParameterTypes()));
//        }









    }


}
