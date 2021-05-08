import javax.swing.JOptionPane;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        Ruhmatrennid ruhmatrennid = new Ruhmatrennid(""); //Määrame randomiga rühmatrennide kohtade arvu
        int algnebodypumpkohad=ruhmatrennid.kohtadearv();
        int algnezumbakohad=ruhmatrennid.kohtadearv();
        int algnejoogakohad=ruhmatrennid.kohtadearv();
        ruhmatrennid.setBodybumpikohtadearv(algnebodypumpkohad); //Määrame randomiga rühmatrennide kohtade arvu
        ruhmatrennid.setJoogakohtadearv(algnejoogakohad);
        ruhmatrennid.setZumbakohtadearv(algnezumbakohad);
        boolean saabtrenni = false;
        List<String> andmebaas = new ArrayList<>();
        try(BufferedReader in =new BufferedReader(new InputStreamReader
                (new FileInputStream("andmebaas.txt"), StandardCharsets.UTF_8))){
            String rida;
            while((rida=in.readLine())!=null) {
                andmebaas.add(rida.strip());
            }
        } catch(IOException e){
            System.out.println("Viga");
            e.printStackTrace();
            }
        for (String andmed:andmebaas) {
            System.out.println(andmed);
        }

        while(true) {    //Kogu programm on tsüklis
            int summa = 0;
            int kuieilahetrennisumma = 1;
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
            if (!andmebaas.contains(isikukood)) {       //kui andmebaasis pole isikukoodi, siis küsi kas tahab saada kliendiks
                String kasTahabKliendiks = JOptionPane.showInputDialog(null,
                        "Kas soovid hakata kliendiks? Kui jah, kirjuta 'j', kui ei kirjuta 'e'",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                if (kasTahabKliendiks.equals("j")) {                   //Kui tahab kliendiks siis lisab hinnale kuupileti
                    andmebaas.add(isikukood);
                    summa += 30;
                }
            } else if (andmebaas.contains(isikukood)) {
                JOptionPane.showMessageDialog(null,  //Kui inimene on juba klubiliige, siis hinnale kuupiletit ei lisandu
                        "Oled juba klubiliige!",
                        "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                summa += 0;
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
                if (!andmebaas.contains(isikukood))
                    if (uusklient.kasTaiskasvanu(uusklient.getIsikukood())) {   //kui ei ole klient, siis vastavalt vanusele lisame hinnale ühekorrapileti
                        summa += 5;
                    } else {
                        summa += 3;
                    }


            } else if (trenn.equals("r")) {     //kui inimene tahab rühmatrenni minna
                while (!saabtrenni) {       //tee nii kaua kui trennis vabu kohti
                    String misRuhmatrenni = JOptionPane.showInputDialog(null,
                            "Kui soovid minna Zumbasse kirjuta 'z', kui Bodypumpi kirjuta 'b', kui joogasse kirjuta 'j'",
                            "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                    saabtrenni = ruhmatrennid.lisatrenni(uusklient, misRuhmatrenni);

                    if (!saabtrenni) { //kui trennis kohad täis
                        String kasKuhugiMujale = JOptionPane.showInputDialog(null,
                                "Kahjuks on see trenn täis, kui soovid kuhugi mujale minna kirjuta 'm', kui ei soovi kirjuta 'e'",
                                "Tere tulemast spordiklubisse!", JOptionPane.QUESTION_MESSAGE);
                        if (kasKuhugiMujale.equals("e")) {
                            kuieilahetrennisumma = 0; //kui trenni ei lähe ss summaks tuleb 0
                            summa = kuieilahetrennisumma;
                            break;
                        }
                    }
                }
                if (!andmebaas.contains(isikukood) && kuieilahetrennisumma != 0) {
                    if (uusklient.kasTaiskasvanu(uusklient.getIsikukood())) {
                        summa += 8;
                    } else {
                        summa += 5;
                    }

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
                break;
        }
        try{
            FileWriter kirjutab=new FileWriter("trenniinfo.txt");
            kirjutab.write("Klientide isikukoodid: "+System.lineSeparator());
            for (String andmed : andmebaas) {
                kirjutab.write(andmed+ System.lineSeparator());
            }
            kirjutab.write("Bodypumpi kohtade arv:"+algnebodypumpkohad+", ");
            kirjutab.write("Bodypumpi vabade kohtade arv:"+ruhmatrennid.getBodybumpikohtadearv()+System.lineSeparator());
            kirjutab.write("Zumba kohtade arv:"+algnezumbakohad+", ");
            kirjutab.write("Zumba vabade kohtade arv:"+ruhmatrennid.getZumbakohtadearv()+System.lineSeparator());
            kirjutab.write("Jooga kohtade arv:"+algnejoogakohad+", ");
            kirjutab.write("Jooga vabade kohtade arv:"+ruhmatrennid.getJoogakohtadearv());
            kirjutab.close();
        }catch (IOException e){
            System.out.println("Viga");
            e.printStackTrace();
        }
    }
}



