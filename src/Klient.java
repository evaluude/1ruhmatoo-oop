import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Klient {

    public static void main(String[] args) {
        Klient klient = new Klient("lisa", "batraica", "49812056030");
        klient.kasTaiskasvanu(klient.getIsikukood());
        System.out.println(klient.kasTaiskasvanu(klient.getIsikukood()));
    }

    private String eesnimi;
    private String perenimi;
    private String isikukood;

    public String getEesnimi() {
        return eesnimi;
    }

    public String getPerenimi() {
        return perenimi;
    }


    public String getIsikukood() {
        return isikukood;
    }

    public Klient(String eesnimi, String perenimi, String isikukood) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.isikukood = isikukood;

    }


    public Boolean kasTaiskasvanu(String isikukood) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //Leian tänase kuupäeva
        String kuupaev = formatter.format(new Date());
        int preaguneAasta = Integer.parseInt(kuupaev.substring(6, 10));
        int preaguneKuu = Integer.parseInt(kuupaev.substring(3, 5));
        int preagunePaev = Integer.parseInt(kuupaev.substring(0, 2));

        int aasta = Integer.parseInt(isikukood.substring(1, 3));
        int kuu = Integer.parseInt(isikukood.substring(3, 5));
        int paev = Integer.parseInt(isikukood.substring(5, 7));

        if (aasta >= 0 && aasta <= 21) aasta = aasta + 2000;
        if (aasta >= 22 && aasta <= 99) aasta = aasta + 1900;

        if (preaguneAasta - aasta > 18) {
            return true;
        } else if (preaguneAasta - aasta == 18 && preaguneKuu - kuu > 0) {

            return true;
        } else return preaguneAasta - aasta == 18 && preaguneKuu - kuu == 0 && preagunePaev >= paev;
    }
}
