package Paradigms.Egzamin;

public class HIT_Inne_18_B extends HIT_Inne_18
{
    HIT_Inne_18_B()
    {
        k++;
    }
    public static void main(String[] ags)
    {
        System.out.print("PRZED: " + k);
        HIT_Inne_18_B w = new HIT_Inne_18_B();
        System.out.println("PO: " + k);
        w.metodaA();
    }
}
