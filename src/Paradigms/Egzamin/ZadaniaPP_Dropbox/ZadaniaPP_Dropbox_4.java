package Paradigms.Egzamin.ZadaniaPP_Dropbox;

public class ZadaniaPP_Dropbox_4 {
    public static void main(String[] args){
        Base base = new Base();
        base.sayHello();

        Deriv deriv = new Deriv();
        deriv.sayHello();

        Base derivInBaseBody = new Deriv();
        derivInBaseBody.sayHello();
        ((Base)derivInBaseBody).sayHello();
        //derivInBaseBody.sayDerivlo();
        // brak takiej funkcji

        ((Deriv)derivInBaseBody).sayDerivLo();
        // juz jest taka funkcja

        Base tempB = ((Base)deriv);
        tempB.sayHello();
    }
}
