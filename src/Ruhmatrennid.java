import java.util.ArrayList;
import java.util.List;

public class Ruhmatrennid {
    private int zumbakohtadearv=0;
    private int joogakohtadearv=0;
    private int bodybumpikohtadearv=0;

    public int getZumbakohtadearv() {
        return zumbakohtadearv;
    }

    public void setZumbakohtadearv(int zumbakohtadearv) {
        this.zumbakohtadearv = zumbakohtadearv;
    }

    public int getJoogakohtadearv() {
        return joogakohtadearv;
    }

    public void setJoogakohtadearv(int joogakohtadearv) {
        this.joogakohtadearv = joogakohtadearv;
    }

    public int getBodybumpikohtadearv() {
        return bodybumpikohtadearv;
    }

    public void setBodybumpikohtadearv(int bodybumpikohtadearv) {
        this.bodybumpikohtadearv = bodybumpikohtadearv;
    }

    private String trenn;
    private List<Klient> zumbanimekiri= new ArrayList<>();
    private List<Klient> jooganimekiri= new ArrayList<>();
    private List<Klient> bodypumpinimekiri= new ArrayList<>();

    public Ruhmatrennid(String trenn) {
        this.trenn = trenn;
    }

    public int kohtadearv(){
        return ((int)(Math.random()*20))+10;
    }

    public void lisatrenni(Klient klient,String ruhmatrenn){
        switch (ruhmatrenn) {
                case "z":
                    if(zumbakohtadearv!=0){
                        zumbanimekiri.add(klient);
                        zumbakohtadearv-=1;}
                    break;
                case "b":
                    if(bodybumpikohtadearv!=0){
                       bodypumpinimekiri.add(klient);
                        bodybumpikohtadearv-=1;}
                    break;
                case "j":
                    if(joogakohtadearv!=0){
                        jooganimekiri.add(klient);
                        joogakohtadearv-=1;}
                    break;
            }

    }
}
