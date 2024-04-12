package lab5;

import java.util.Collections;
import java.util.List;

public class Opdracht1 {
    public static int greatest(int a, int b){
        if (a>b){
            return a;
        } else {
            return b;
        }
    }

    public static String greatest (String a, String b){
        if(a.length()>b.length()){
            return a;
        } else {
            return b;
        }
    }

    public static int greatest (List<Integer> lijst){
        return Collections.max(lijst);
    }
}
