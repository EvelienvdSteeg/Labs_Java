package Collection;

import java.util.Arrays;

public class MyIntCollection {
    private Integer[] intlist = new Integer[4];

    private int length = listLength();

    public int getLength() {
        return length;
    }



    int count = 0;

    public Integer[] addToList(int item) {
        this.intlist[count] = item;
        count++;
        return intlist;
    }

    @Override
    public String toString() {
        return "MyIntCollection{" +
                "intlist=" + Arrays.toString(intlist) +
                '}';
    }

    private int listLength() {
        for (Integer i : intlist) {
            if (i != null) {
                length++;
            }

        }
        return length;
    }
}
