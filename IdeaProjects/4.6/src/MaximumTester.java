import javax.lang.model.type.NullType;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.KeyEvent;

public class MaximumTester{
        public static void main(String[] args)
        {
                ArrayList<String> list = new ArrayList<String>(30);
                Scanner reader = new Scanner(System.in);


                System.out.println("Enter the list of strings:");

                String n;
                while((n = (reader.nextLine())).length() > 0){
                        list.add(n);
                }

                if(list.size() > 0) {
                        System.out.println("Following is the arraylist :");

                        for (String s : list) {
                                System.out.println(s);

                        }
                        System.out.println();

                        StringComparator strcomp = new StringComparator();
                        Collections.sort(list, strcomp);

                        System.out.println("The largest string in the arraylist:");
                        System.out.println(list.get(list.size() - 1));
                }
                else{
                        System.out.println("No input entered");
                }

        }
}
