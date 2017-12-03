package Paradigms.List8;

public class ArgModifiers{
    int zawartosc = 0;

    static void argNiemodyfikowalny(final ArgModifiers zmienna)
    {
        zmienna.zawartosc = 1;
        // Pytanie 1
        //zmienna = null; nie mozna przypisac nowego obiektu do final referencji
    }

    static void argModyfikowalny(ArgModifiers zmienna){
        zmienna.zawartosc = 1;
        zmienna = null;  // to nic nie spowoduje, tylko wyzeruje referencje do kopii referencji
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        ArgModifiers modyfikowalna = new ArgModifiers();
        final ArgModifiers niemodyfikowalna = new ArgModifiers();

        // a)
        argNiemodyfikowalny(modyfikowalna);
        System.out.println(modyfikowalna.zawartosc);

        // b)
        argNiemodyfikowalny(niemodyfikowalna);
        System.out.println(niemodyfikowalna.zawartosc);

        // c)
        argModyfikowalny(modyfikowalna);
        System.out.println(modyfikowalna.zawartosc);

        // d)
        argModyfikowalny(niemodyfikowalna);
        System.out.println(niemodyfikowalna.zawartosc);
    }
}
