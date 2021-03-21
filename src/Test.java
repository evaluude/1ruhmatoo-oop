import javax.swing.JOptionPane;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
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
        //if("ei ole klient"==true)
        System.out.println("Kas tahad hakata kliendiks?");
        //kui jaa lisa ta klientide listi, kui ei siis
        //Klient uusklient= new Klient(eesnimi,perenimi,isikukood)
        //kui ei taha kliendiks siis vastavalt vanusele läheb ühe korra pileti hind
        if (trenn.equals("j")) {
            String kava = JOptionPane.showInputDialog(null,
                    "Kui soovid treeningkava kirjuta 'j', kui ei kirjuta 'e'",
                    "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
            if (kava.equals("j")) {
                //pane käima meetod kust saad leida random treeningkava
                System.out.println("Treeningkavaks saad sa: ");
            }

        } else if (trenn.equals("r")) {
            String ruhmatrenn = JOptionPane.showInputDialog(null,
                    "Kui soovid minna Zumbasse kirjuta 'z', kui Bodypumpi kirjuta 'b', kui joogasse kirjuta 'j'",
                    "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
            Ruhmatrennid ruhmatrennid=new Ruhmatrennid(ruhmatrenn);
            ruhmatrennid.setBodybumpikohtadearv(ruhmatrennid.kohtadearv());
            ruhmatrennid.setJoogakohtadearv(ruhmatrennid.kohtadearv());
            ruhmatrennid.setZumbakohtadearv(ruhmatrennid.kohtadearv());
            System.out.println(ruhmatrennid.getBodybumpikohtadearv());

        }
    }
}
