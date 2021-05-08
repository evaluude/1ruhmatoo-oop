import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jousaal {
    private final String kava1 =
            "Surumine kangiga lamades\t                           3 x 8 - 10\t\n" +
                    "Lendamine küljele trenazööril                3 x 8 - 10\t\n" +
                    "Ületõmme hantliga (pullover)\t               3 x 8 - 10\t\n" +
                    "Küünarvarte sirutamine trenazööril\t         3 x 8 - 10\t\n" +
                    "Küünarvarte kõverdamine hantlitega istudes\t 3 x 8 - 10\t\n" +
                    "Jalapress trenazööril\t                      3 x 8 - 10\t\n" +
                    "Jalgade kõverdamine trenazööril istudes\t    3 x 8 - 10\t\n" +
                    "Pöiasirutus trenazööril seistes\t            3 x 8 - 10\t\n" +
                    "Keresirutus horisontaalsel alaseljapingil\t  3 x 10 - 12\t\n" +
                    "Jalgade tõsted kaldpinnal\t                  3 x max\n";
    private final String kava2 =
            "Sörkjooks 1,5 min\t\t\n" +
                    "30 sek sprinti\t\t\n" +
                    "Surumine kangiga lamades\t1x10-12\t\n" +
                    "Tõmme plokil ülalt ette\t1x10-12\t\n" +
                    "Keharaskusega kükk\t1x20\t\n" +
                    "Sörkjooks 1,5 min\t\t\n" +
                    "30 sek sprinti\t\t\n" +
                    "Surumine üles hantlitega seistes\t1x10\t\n" +
                    "Jõutõmme kangiga sirgete jalgadega\t1x10\t\n" +
                    "Kätekõverdused\t1x10\t\n" +
                    "Sörkjooks 1,5 min+30 sek sprinti\t\t\n" +
                    "Tõmme vastu kõhtu kangiga kummargil\t1x12\t\n" +
                    "Väljaaste, hantlid käes\t1x12\t\n" +
                    "Küünarvarte kõverdamine kangiga seistes\t1x12\n" +
                    "\n";
    private final String kava3 = "Surumine smithi masinal istudes\t1X15(sooj), 1x 12(sooj), 1x8-10\t\n" +
            "Lendamine hantlitega küljele istudes\t1x 12(sooj), 1x8-10\t\n" +
            "Käe küljele tõste plokksüsteemil (Lendamine küljele plokil)\t1x20(sooj), 1x8-10\t\n" +
            "Õlatõste hantlitega seistes\t1x12(sooj), 1x10-12\t\n" +
            "Ploki alla surumine triitsepsile\t1x 15(sooj), 1x 12(sooj), 1x8-10\t\n" +
            "Prantsuse surumine kangiga lamades\t1x12(sooj), 1x8-10\t\n" +
            "Keretõste kõhupingil\t3x20-25\t\n" +
            "Jalgade tõsted kaldpingil\t3x12-15\n";

    private int jousaaliKohtadearv = 0;
    private List<Klient> jousaaliNimekiri = new ArrayList<>();

    public Jousaal() {
    }

    public String getKava1() {
        return kava1;
    }

    public String getKava2() {
        return kava2;
    }

    public String getKava3() {
        return kava3;
    }

    public int getJousaaliKohtadearv() {
        return jousaaliKohtadearv;
    }

    public void setJousaaliKohtadearv(int jousaaliKohtadearv) {
        this.jousaaliKohtadearv = jousaaliKohtadearv;
    }

    public List<Klient> getJousaaliNimekiri() {
        return jousaaliNimekiri;
    }

    public void setJousaaliNimekiri(List<Klient> jousaaliNimekiri) {
        this.jousaaliNimekiri = jousaaliNimekiri;
    }

    public int kohtadearv() {
        return ((int) (Math.random() * 20)) + 10;
    }


    public String randomTreeningkava() {
        Random number = new Random();
        int kava = number.nextInt(3 - 1) + 1;
        if (kava == 1) return kava1;
        if (kava == 2) return kava2;
        else return kava3;
    }
}
