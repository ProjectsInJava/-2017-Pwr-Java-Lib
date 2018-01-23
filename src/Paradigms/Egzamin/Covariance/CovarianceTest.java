package Paradigms.Egzamin.Covariance;

public class CovarianceTest {
    public static void main(String[] args){
        Pracownik[] progr = new Pracownik[3];
        progr[0] = new Pracownik();
        progr[1] = new Pracownik();
        progr[2] = new Pracownik();

        /*
        Osoba[] os = progr;
        os[0] = new Osoba();
        */

        Osoba[] os2 = new Osoba[3];
        os2[0] = new Pracownik();
    }
}
