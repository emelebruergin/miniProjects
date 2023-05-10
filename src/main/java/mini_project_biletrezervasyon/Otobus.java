package mini_project_biletrezervasyon;

import java.util.ArrayList;
import java.util.List;

public class Otobus {
    public String plakaNo;

    public List<String> koltuklar=new ArrayList<>();


    public Otobus(String plakaNo, List<String> koltuklar) {
        this.plakaNo = plakaNo;
        this.koltuklar = koltuklar;
    }


}
