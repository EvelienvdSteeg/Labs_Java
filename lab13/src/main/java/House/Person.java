package House;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Person extends Human implements Comparable<Person>{
    private String name;
    private int age;

    private Gender gender = Gender.UNKNOWN;

    private static int maxAge = 130;


    private static String rights = "All humans are created equal";


    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void haveBirthday() {
        if (age > maxAge) {
            throw new PersonDiedException();
        } else {
            this.age++;
        }
    }

    public static String universalRights() {
        return Person.rights;
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
        this("geen naam", 0, Gender.UNKNOWN);
    }

    @Override
    public String toString() {
        return name +
                " (" + age + ")" +
                " is " + gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return this.age == person.age && Objects.equals(this.name, person.name) && this.gender == person.gender;
    }

    @Override
    @MyAnnotation
    public int hashCode() {
        return 1;
    }

    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();

    }

    @Override
    String greet() {
        return "Hello my name is " + getName() + " Nice to meet you!";
    }

    @Override
    public int compareTo(Person o) {
        return o.getAge();
    }


    private class HistoryRecord{
        String description;

        public HistoryRecord(String description){
            this.description = description;
        }

        @Override
        public String toString() {
            return  description;
        }


    }

    List<HistoryRecord> histories = new ArrayList<>();
    int counter = 0;
    public void addHistory(String description){
        HistoryRecord historyRecord = new HistoryRecord(description);
        histories.add(historyRecord);
        counter++;
    }

    public void printHistory(){
        for(HistoryRecord history : this.histories){
            System.out.println(history);
        }
    }

    public Human createSubHuman(){
        return new Human(){
            @Override
            String greet() {
                return "Sub is the best.";
            }
        };
    }



    public static <T> List<T> copy(List<T> from, List<T> to){
        for (T t : from) {
            to.add(t);
        }
        return to;
    }

    public static <T > List<T> copy2(List<? extends T> from, List<T> to){
        for (T t : from) {
            to.add(t);
        }
        return to;
    }
}
