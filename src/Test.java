import javax.swing.JOptionPane;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        Ruhmatrennid ruhmatrennid = new Ruhmatrennid(""); //Määrame randomiga rühmatrennide kohtade arvu
        ruhmatrennid.setBodybumpikohtadearv(1);
        ruhmatrennid.setJoogakohtadearv(ruhmatrennid.kohtadearv());
        ruhmatrennid.setZumbakohtadearv(ruhmatrennid.kohtadearv());
        boolean saabtrenni = false;
        int summa = 0;

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

            //Kontrolli, kas klient on juba klientide listis isikukoodi järgi, kui ei ole, siis küsi kas tahab kliendiks saada
            Klient uusklient = new Klient(eesnimi, perenimi, isikukood);
            //if(isikukood ei ole andmebaasis)
            String kasTahabKliendiks = JOptionPane.showInputDialog(null,
                    "Sa pole meie andmebaasis, kas soovid hakata kliendiks? Kui jah, kirjuta 'j'",
                    "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
            //uusklient.lisalisti


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

                if (kasTahabKliendiks.equals("j")){       //kui inimene tahab saada kliendiks, siis lisame hinnale kuupileti
                    summa+=30;
                }
                else {
                    if (uusklient.kasTaiskasvanu(uusklient.getIsikukood())) {   //kui ei taha kliendiks siis vastavalt vanusele lisame hinnale ühekorrapileti
                        summa += 5;
                    } else{
                        summa += 3;
                    }
                }

                    String kasLopetame = JOptionPane.showInputDialog(null,
                            "Kui soovid veel inimesi trenni lisada kirjuta 'v' kui soovid lõpetada kirjuta 'l' ",
                            "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                    System.out.println("Tasuda tuleb sul " + summa + " €");
                    if (kasLopetame.equals("l"))
                        System.exit(0);



                } else if (trenn.equals("r")) {     //kui inimene tahab rühmatrenni minna
                    while (saabtrenni == false) {       //tee nii kaua kui trennis vabu kohti
                        String misRuhmatrenni = JOptionPane.showInputDialog(null,
                                "Kui soovid minna Zumbasse kirjuta 'z', kui Bodypumpi kirjuta 'b', kui joogasse kirjuta 'j'",
                                "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                       // Ruhmatrennid ruhmatrennid2 = new Ruhmatrennid(misRuhmatrenni);
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
                    if (kasTahabKliendiks.equals("j")) {
                        summa += 30;
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
                        saabtrenni=false;

                    System.out.println("Tasuda tuleb sul " + summa + " €");
                    if (kasLopetame.equals("l"))
                        System.exit(0);

                }
            }
        }
    }

