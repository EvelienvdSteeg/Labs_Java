package House;

public class House<T extends Human> {

    T person;

    @Override
    public String toString() {
        return "This house is owned by " + person + " and it says " + person.greet();
    }
}
