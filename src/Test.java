import javax.swing.JOptionPane;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Ruhmatrennid ruhmatrennid=new Ruhmatrennid(""); //Määrame randomiga rühmatrennide kohtade arvu
        ruhmatrennid.setBodybumpikohtadearv(ruhmatrennid.kohtadearv());
        ruhmatrennid.setJoogakohtadearv(ruhmatrennid.kohtadearv());
        ruhmatrennid.setZumbakohtadearv(ruhmatrennid.kohtadearv());
        boolean saabtrenni=false;

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
            Klient uusklient= new Klient(eesnimi,perenimi,isikukood);
            //if(isikukood ei ole andmebaasis)
                String kasTahabKliendiks = JOptionPane.showInputDialog(null,
                    "Sa pole meie andmebaasis, kas soovid hakata kliendiks? Kui jaa kirjuta 'j'",
                    "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
            if(kasTahabKliendiks.equals("j"))
                //uusklient.lisalisti
            //kui ei taha kliendiks siis vastavalt vanusele läheb ühe korra pileti hind

            if (trenn.equals("j")) {        //kui inimene tahab jõusaali minna
                String kava = JOptionPane.showInputDialog(null,
                        "Kui soovid treeningkava kirjuta 'j', kui ei kirjuta 'e'",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                if (kava.equals("j")) {
                    //pane käima meetod kust saad leida random treeningkava
                    System.out.println("Treeningkavaks saad sa: ");
                }

            } else if (trenn.equals("r")) {     //kui inimene tahab rühmatrenni minna
                while(saabtrenni==false){       //tee nii kaua kui trennis vabu kohti
                    String misRuhmatrenni = JOptionPane.showInputDialog(null,
                            "Kui soovid minna Zumbasse kirjuta 'z', kui Bodypumpi kirjuta 'b', kui joogasse kirjuta 'j'",
                            "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                    Ruhmatrennid ruhmatrennid2=new Ruhmatrennid(misRuhmatrenni);
                    saabtrenni=ruhmatrennid2.lisatrenni(uusklient,misRuhmatrenni);
                    if(saabtrenni==false){
                        String kasKuhugiMujale = JOptionPane.showInputDialog(null,
                                "Kahjuks on see trenn täis, kui soovid kuhugi mujale minna kirjuta 'm', kui ei soovi kirjuta 'e'",
                                "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                        if(kasKuhugiMujale.equals("e")) {
                            System.out.println("Peatse kohtumiseni!");
                            System.exit(0);
                        }
                    }
                }
                System.out.println("Kokku tuleb sul tasuda"+ summa);
                String kasLopetame = JOptionPane.showInputDialog(null,
                        "Kui soovid veel inimesi trenni lisada kirjuta 'v' kui soovid lõpetada kirjuta 'l' ",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                if(kasLopetame.equals("l"))
                    System.exit(0);


        }}
    }
}
