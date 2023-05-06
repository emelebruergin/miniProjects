package biletrezervasyon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiletRezervasyon {
    /*
    Proje: Mesafeye ve sartlara göre ucak bileti fiyatı hesaplayan uygulama
           Kullanıcıdan Mesafe (KM) , yaşı ve yolculuk tipi (Tek yön, Gidiş-Dönüş)
           koltuk no bilgilerini alın.
           mesafe başına ücret 1 TL/km olarak alın.(Gidiş-Dönüş için *2)
           ilk olarak uçuşun toplam fiyatini hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın;

           Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı ,yolculuk tipi ise 1 veya 2)olnalıdır.
           Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
           1-Kişi "Yolculuk Tipini" gidiş-dönüş seçöiş ise bilet fiyatı üzerinden %20 indirim uygulanır
           2-Yaş indirimi:
             Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
             Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
             Kişi 65 yaşından büyükse bilet fiyatı üzerinden %30 indirim uygulanır.
           3-Tekli koltuk ücreti:
             Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 arttırılır.


     */

    public static void main(String[] args) {
        List<String> koltukNo=new ArrayList<>();
        for (int i=1;i<33;i++){
            koltukNo.add(String.valueOf(i));
        }

        Bilet bilet=new Bilet();
        Otobus otobus=new Otobus("34 IST 78",koltukNo);
        starttt(bilet,otobus);

    }

    public static void starttt(Bilet bilet,Otobus otobus){
        Scanner input=new Scanner(System.in);
        int select;
        do {
            System.out.println("Bilet Rezervasyon Sistemine Hoşgeldiniz...");
            System.out.print("Lütfen gidilecek mesafeyi km olarak giriniz: ");
            bilet.mesafe=input.nextInt();
            System.out.println("Yolculuk tipini seçiniz:\n1)Tek Yön\n2)Gidiş-Dönüş");
            bilet.yolculukTipi=input.nextInt();
            System.out.println("Yaşınızı giriniz: ");
            bilet.yas=input.nextInt();
            System.out.println("Koltuk no seçiniz: ");
            System.out.println("Tekli koltuk fiyatı %20 daha fazladır.");
            System.out.println(otobus.koltuklar);
            bilet.koltukNo=input.nextInt();
            otobus.koltuklar.remove(String.valueOf(bilet.koltukNo));

            boolean check=bilet.yolculukTipi==1 || bilet.yolculukTipi==2;
            if (bilet.mesafe>0 && bilet.yas>0 && check){
               bilet.toplamUcret= toplamTutar(bilet);
               bilet.biletYazdir(otobus);

            }else{
                System.out.println("Hatalı giriş yaptınız!");

            }
            System.out.println("Yeni işlem için 1, çıkış için 0 giriniz");
            select=input.nextInt();

        }while(select!=0);

        System.out.println("Iyi Günler Dileriz...");

    }

    public static double toplamTutar(Bilet bilet){
        int mesafe=bilet.mesafe;
        int yolculukTipi= bilet.yolculukTipi;
        int koltukNo= bilet.koltukNo;
        int yas= bilet.yas;
        double total=0;
        switch (yolculukTipi){
            case 1:
                if (koltukNo%3==0){
                    total=mesafe*1.2;
                }else{
                    total=mesafe;
                }
                System.out.println("Tutar: "+total);
                break;
            case 2:
                if (koltukNo%3==0){
                    total=mesafe*1.2*2;

                }else{
                    total=mesafe*2;
                }
                System.out.println("Tutar: "+total);
                total=total*0.8;
                System.out.println("Çift yön indirimli tutar: "+total);
                break;
        }

        if (yas<=12){
            total=total/2;
            System.out.println("Yas indirimli tutar: "+total);
        } else if (yas>12) {
            total=total*0.9;
            System.out.println("Yas indirimli tutar: "+total);
        } else if (yas>65) {
            total=total*0.7;
            System.out.println("Yas indirimli tutar: "+total);
        }
        return total;


    }




}
