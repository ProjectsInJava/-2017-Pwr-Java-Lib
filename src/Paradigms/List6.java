package Paradigms;

import java.util.ArrayList;
import java.util.Iterator;

public class List6 {
    static boolean isEqualSimpleType(int argLeft, int argRight)
    {
        return argLeft == argRight;
    }
    static boolean isEqualPackagedType(Integer argLeft, Integer argRight)
    {
        return argLeft == argRight;
    }

    public static void Exercise3()
    {
        System.out.println("*********** Comparator when primitive types as args ***********");
        System.out.println(isEqualSimpleType(500,500));

        System.out.println("*********** Comparator when packaged types as args ***********");
        System.out.println(isEqualPackagedType(500,500));
    }
    public static void Exercise4()
    {
        System.out.println("*********** Flyweight ***********");
        String s1 = "foo";
        String s2 = "foo";
        System.out.println("Reference compare");
        System.out.println(s1 == s2);
        System.out.println("Value compare");
        System.out.println(s1.equals(s2));
        String s3 = new String("foo");

        System.out.println("*********** Explicit create new object ***********");
        System.out.println("Reference compare");
        System.out.println(s1 == s3);
        System.out.println("Value compare");
        System.out.println(s1.equals(s3));
    }

    public static void Exercise5()
    {
        System.out.println("*********** For Each, Range Based Loop ***********");
        System.out.println("*********** Modyfing vals by local variable ******");
        int[] ints = {1,2,3};
        for (int it : ints) {
            it = 0;
            System.out.print(it);
        }
        System.out.println("\n*********** Check if modified, should be 0 everywhere ******");
        for (int it : ints) {
            System.out.print(it);
        }

        System.out.println("\n*********** For and accessing with operator[] ***********");
        System.out.println("*********** Modyfing vals by Array Access Expression ******");
        int[] ints2 = ints;
        for (int i = 0; i < ints2.length; i++) {
            ints2[i] = 0;
            System.out.print(ints2[i]);
        }
        System.out.println("\n*********** Check if modified, should be 0 everywhere ******");
        for (int i : ints) {
            System.out.print(i);
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
//        Exercise3();
//        Exercise4();
        Exercise5();
    }
}
