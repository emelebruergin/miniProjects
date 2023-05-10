package mini_project_biletrezervasyon;

public class Bilet {
    public int yas;
    public int mesafe;
    public int yolculukTipi;
    public int koltukNo;
    public double toplamUcret;

    public void biletYazdir(Otobus otobus){
        System.out.println("Toplam tutar: "+toplamUcret);
        System.out.println("---Bilet Detay---");
        System.out.println("Otobüs plaka: "+ otobus.plakaNo);
        System.out.println("Yolculuk Tipi: "+(yolculukTipi==1 ? "Tek Yön" : "Gidiş-Dönüş"));
        System.out.println("Koltuk no: "+koltukNo);
        System.out.println("Keyifli Yolculuklar Dileriz...");

    }


}
