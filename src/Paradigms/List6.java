package Paradigms;

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

    public static void main (String[] args) throws java.lang.Exception
    {
        Exercise3();
//        Exercise4();
    }
}
