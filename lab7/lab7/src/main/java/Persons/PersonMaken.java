package Persons;

public record PersonMaken(String name, int age, Gender gender) {
    public String toString() {
        return name  +
                " (" + age + ")"+
                " is " + gender ;
    }
}
