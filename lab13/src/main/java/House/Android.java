package House;

public class Android extends Human implements Chargeable {
    int level;

    @Override
    String greet() {
        return "I'm only half human, but human still.... My energy level is: " + this.level + "%";
    }

    @Override
    public int charge(int amount) {
        if (this.level + amount <= 100) {
            setLevel(getLevel()+amount);
        } else {
            System.out.println("Not possible to charge to more than 100");

        }
        return getLevel();
    }

    public Android(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
