import java.util.ArrayList;
import java.util.List;

public class Ruhmatrennid {
    private int zumbakohtadearv;
    private int joogakohtadearv;
    private int bodybumpikohtadearv;
    private String trenn;
    private List<Klient> zumbanimekiri= new ArrayList<>();
    private List<Klient> jooganimekiri= new ArrayList<>();
    private List<Klient> bodypumpinimekiri= new ArrayList<>();


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

    public Ruhmatrennid(String trenn) {
        this.trenn = trenn;
    }

    public int kohtadearv(){
        return ((int)(Math.random()*20))+10;
    }

    public boolean kasOnVabu(String trenn){
        if(trenn.equals("j")){
            if(joogakohtadearv==0)
                return false;
        }else if(trenn.equals("z")){
            if(zumbakohtadearv==0)
                return false;
        }else if(trenn.equals("b")){
            if(getBodybumpikohtadearv()==0){
                System.out.println(getBodybumpikohtadearv());
                System.out.println(bodybumpikohtadearv);
                return false;}
        }return true;
    }

    public boolean lisatrenni(Klient klient, String trenn){
        if(kasOnVabu(trenn)==false)
            return false;
        switch (trenn) {
                case "z":
                    if(zumbakohtadearv!=0){
                        zumbanimekiri.add(klient);
                        zumbakohtadearv-=1;
                        break;
                    }
                case "b":
                    if(bodybumpikohtadearv!=0){
                       bodypumpinimekiri.add(klient);
                        bodybumpikohtadearv-=1;
                        break;
                    }
                case "j":
                    if(joogakohtadearv!=0){
                        jooganimekiri.add(klient);
                        joogakohtadearv-=1;
                        break;
                    }
            }return true;

        }

    }

