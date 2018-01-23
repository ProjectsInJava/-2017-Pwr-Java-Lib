package Paradigms.Egzamin;

public class Egz17 {
    private int wartosc;

    public Egz17(int wartosc)
    {
        this.wartosc = wartosc;
    }

    public boolean equals(Egz17 inny)
    {
        return this.wartosc == inny.wartosc;
    }

    public static void main(String[] args)
    {
        Egz17 e = new Egz17(8);
        Egz17 f = new Egz17(8);

        System.out.println(e.wartosc == f.wartosc);
        System.out.println(e.equals(f));
    }
}
