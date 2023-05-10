package mini_project_aracsigorta;

import java.util.Scanner;

public class AracSigortaApplication {
    /*
    Proje: Araç Sigorta Prim Hesaplama
    Araç tipleri: otompobil,kamyon,otobüss,motosiklet
                  otobüs:18-30 koltuk veya 31 ve üstü koltuk
          Tarife dönemi: Aralık 2022,Haziran 2022

          1.Dönem                        2.Dönem
          otomobil:2000                otomobil:2500
          kamyon:3000                  kamyon:3500
          otobüs: tip1:4000            otobüs: tip1:4500
                  tip2:5000                    tip2:5500
          motosiklet: 1500             motosiklet: 1750

          hatalı girişte hesaplama başarısız uyarısı verip tekrar menü gösterilsin.

     */

    public static void main(String[] args) {
        startt();
    }
    public static void startt() {
        boolean isFail = true;
        Scanner input = new Scanner(System.in);
        Arac obj = new Arac();
        do {
            isFail = true;
            System.out.println("--Arac Sigorta Prim Hesaplama");
            System.out.println("Lütfen tarife dönemi seçiniz");
            System.out.println("1.Haziran 2023");
            System.out.println("2.Aralık 2023");
            int donem = input.nextInt();
            if (donem == 1 || donem == 2) {
                System.out.println("Araç tipini giriniz");
                System.out.println("otomobil,kamyon,otobüs,motosiklet");
                obj.aracTipi=input.next();
                obj.prim=obj.primHesapla(donem);
                int select;
                String donemAdi=donem==1 ? "Haziran 2023" : "Aralık 2023";
                if(obj.prim>0){
                    System.out.println("Hesaplama başarıyla tamamlandı..");
                    System.out.println("Araç tipi: "+obj.aracTipi);
                    System.out.println("Tarife donemi: "+ donemAdi);
                    System.out.println("Aracınızın ilgili dönem sigorta primi: "+ obj.prim);
                    System.out.println("Yeni işlem için 1, çıkış için 0 giriniz..");
                    select=input.nextInt();
                    if (select==1){
                        isFail=false;
                    }else {
                        isFail=true;
                    }


                }else {
                    System.out.println("Hesaplama başarısız, tekrar deneyiniz");
                    System.out.println("Yeni işlem için 1, çıkış için 0 giriniz: ");
                    select=input.nextInt();
                    if(select==1){
                        isFail=false;
                    } else {
                        isFail=true;
                    }
                }


            } else {
                System.out.println("Hatalı Giriş Yaptınız");
                isFail = false;
            }
        } while (!isFail);
        System.out.println("Iyi gunler dileriz...");


    }
}
