import java.io.*;
import java.util.*;


public class FilterTester{

    public static void main(String[] args) {

        String[] list = new String[]{"Cat","Anvitha", "Anvi","Ball" ,"tom", "me"};

        for (String s : list)
            System.out.println(s);
        System.out.println();

        Filter f = new Filter() {
            public boolean accept(String x) {
                if (x.length() <= 3)
                {
                    return true;
                }
                    return false;
            }
        };

            String[] str = filter(list, f);
            for(int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
            }
    }


    public static String[] filter(String[] a, Filter f) {
        ArrayList<String> s = new ArrayList<String>() ;
        for (int i = 0; i < a.length; i++)
        {
            String toCheck = a[i];
            boolean Isaccepted = f.accept(toCheck);

            if (Isaccepted)
            {
                s.add(toCheck);
            }
        }
        String[] stringArr = s.toArray(new String[0]);
        return stringArr;

    }
}
