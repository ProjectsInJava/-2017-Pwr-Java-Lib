package Paradigms;

public class List6 {
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

    public static void main (String[] args) throws java.lang.Exception
    {
//        Exercise4();
    }
}
