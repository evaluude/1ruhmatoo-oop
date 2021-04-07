import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Test {

    public static void main(String[] args) {

        Ruhmatrennid ruhmatrennid = new Ruhmatrennid(""); //Määrame randomiga rühmatrennide kohtade arvu
        ruhmatrennid.setBodybumpikohtadearv(1);
        ruhmatrennid.setJoogakohtadearv(ruhmatrennid.kohtadearv());
        ruhmatrennid.setZumbakohtadearv(ruhmatrennid.kohtadearv());
        boolean saabtrenni = false;
        int summa = 0;
        ArrayList<String> andmebaas = new ArrayList<>();

        for (int i = 0; ; i++) {    //Kogu programm on tsüklis
            String trenn = JOptionPane.showInputDialog(null,
                    "Kui soovid jõusaali minna kirjuta 'j', kui rühmatrenni kirjuta 'r'",
                    "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);

            String kliendiandmed = JOptionPane.showInputDialog(null,
                    "Sisesta oma eesnimi, perenimi ja isikukood komaga eraldatult ja tühikuid ära jäta",
                    "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);

            String[] kliendiandmedosadena = kliendiandmed.split(",");
            String eesnimi = kliendiandmedosadena[0];
            String perenimi = kliendiandmedosadena[1];
            String isikukood = kliendiandmedosadena[2];

            Klient uusklient = new Klient(eesnimi, perenimi, isikukood);

            String kasTahabKliendiks = JOptionPane.showInputDialog(null,
                    "Kas soovid hakata kliendiks? Kui jah, kirjuta 'j', kui ei kirjuta 'e'",
                    "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
            if (kasTahabKliendiks.equals("j")) {                   //Kui tahab kliendiks ja ei ole andmebaasis, siis lisab hinnale kuupileti
                if (!andmebaas.contains(uusklient.getIsikukood())) {
                    andmebaas.add(uusklient.getIsikukood());
                    summa += 30;

                } else {
                    JOptionPane.showMessageDialog(null,  //Kui inimene on juba klubiliige, siis hinnale kuupiletit ei lisandu
                            "Oled juba klubiliige!",
                            "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                    summa += 0;
                }
            }

            if (trenn.equals("j")) {        //kui inimene tahab jõusaali minna
                String kava = JOptionPane.showInputDialog(null,
                        "Kui soovid 2 € eest treeningkava kirjuta 'j', kui ei kirjuta 'e'",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                if (kava.equals("j")) {
                    //paneme käima meetodi, mis leiab random treeningkava ja lisame tasu
                    summa += 2;
                    Jousaal jousaal = new Jousaal();
                    String jousaaliKava = jousaal.randomTreeningkava();
                    System.out.println("Treeningkavaks saad sa: " + jousaaliKava);
                }
                if (andmebaas.contains(uusklient.getIsikukood())) {
                    summa += 0;

                } else {
                    if (uusklient.kasTaiskasvanu(uusklient.getIsikukood())) {   //kui ei taha kliendiks siis vastavalt vanusele lisame hinnale ühekorrapileti
                        summa += 5;
                    } else {
                        summa += 3;
                    }
                }

                String kasLopetame = JOptionPane.showInputDialog(null,
                        "Kui soovid veel inimesi trenni lisada kirjuta 'v' kui soovid lõpetada kirjuta 'l' ",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                JOptionPane.showMessageDialog(null,
                        "Tasuda tuleb: " + summa + " €",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                if (kasLopetame.equals("l"))
                    System.exit(0);


            } else if (trenn.equals("r")) {     //kui inimene tahab rühmatrenni minna
                while (saabtrenni == false) {       //tee nii kaua kui trennis vabu kohti
                    String misRuhmatrenni = JOptionPane.showInputDialog(null,
                            "Kui soovid minna Zumbasse kirjuta 'z', kui Bodypumpi kirjuta 'b', kui joogasse kirjuta 'j'",
                            "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                    saabtrenni = ruhmatrennid.lisatrenni(uusklient, misRuhmatrenni);

                    if (saabtrenni == false) {
                        String kasKuhugiMujale = JOptionPane.showInputDialog(null,
                                "Kahjuks on see trenn täis, kui soovid kuhugi mujale minna kirjuta 'm', kui ei soovi kirjuta 'e'",
                                "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                        if (kasKuhugiMujale.equals("e")) {
                            break;
                        }
                    }
                }
                if (kasTahabKliendiks.equals("j")) {              //Rühmatrennide hindade arvutamine
                    if (!andmebaas.contains(uusklient.getIsikukood())) {
                        andmebaas.add(uusklient.getIsikukood());
                        summa += 30;
                    }
                } else {
                    if (uusklient.kasTaiskasvanu(uusklient.getIsikukood())) {
                        summa += 8;
                    } else {
                        summa += 5;
                    }

                }

                String kasLopetame = JOptionPane.showInputDialog(null,
                        "Kui soovid veel inimesi trenni lisada kirjuta 'v' kui soovid lõpetada kirjuta 'l' ",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                if (kasLopetame.equals("v"))
                    saabtrenni = false;

                JOptionPane.showMessageDialog(null,
                        "Tasuda tuleb:" + summa + " €",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                if (kasLopetame.equals("l"))
                    System.exit(0);
            }
        }
    }
}

