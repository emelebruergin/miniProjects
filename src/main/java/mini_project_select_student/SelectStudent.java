package mini_project_select_student;

import java.util.Scanner;

public class SelectStudent {
    /*
    Proje: Spor kursu için seçilecek öğrencileri belirleyen
    bir uygulama yazınız.

    kurs gereklilikleri:
    erkekler: boy 1.60 ve üstü
              kilo:70-90 kg
    kızlar:   boy:1.50 ve üstü
              kilo: 50-70 kg

    kullanıcıdan öğrenci sayısı ve herbir öğrenci
    için isim,cinsiyet, kilo ve boy bilgilerini girmesini isteyiniz.
     */

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Merhaba,lütfen formu doldurun!");
        System.out.println("Lütfen ogrenci sayısını giriniz");
        int ogrenciSayisi=input.nextInt();

        String [] students=new String[ogrenciSayisi];
        String [] gender=new String[ogrenciSayisi];
        double [] height=new double[ogrenciSayisi];
        double [] weight=new double[ogrenciSayisi];
        boolean isSuccess=true;

        do {
            isSuccess=true;

        for (int i=0;i<ogrenciSayisi;i++){
            System.out.println("Ogrenci ismini giriniz.");
            students[i]=input.next();
            System.out.println("Ogrenci cinsiyetini giriniz.");
            String gen=input.next().toUpperCase().substring(0,1);

            if (gen.equals("K") || gen.equals("E")){
                gender[i]=gen;
            }else {
                System.out.println("Hatali giriş yaptınız");
                isSuccess=false;
                break;
            }

            System.out.println("boy: ");
            height[i]=input.nextDouble();

            System.out.println("kilo: ");
            weight[i]= input.nextDouble();
        }
    }while (!isSuccess);


        System.out.println();
        int counter=0;
        System.out.println("***Kursa seçilen öğrenciler***");
        for (int i=0;i<ogrenciSayisi;i++){
            if(gender[i].equals("K") && weight[i]>=50 && weight[i]<=70 && height[i]>=1.50 ){
                System.out.println("isim: "+students[i]+" cinsiyet: "+gender[i]+" boy: "+height[i]+" kilo: "+weight[i]);
                counter++;
            } else if (gender[i].equals("E") && weight[i]>=70 && weight[i]<=90 && height[i]>=1.60) {
                System.out.println("isim: "+students[i]+" cinsiyet: "+gender[i]+" boy: "+height[i]+" kilo: "+weight[i]);
                counter++;
            }
        }

        if(counter==0){
            System.out.println("Maalesef kurs gereksinimlerini sağlayan öğrenci yoktur");
        }


    }


}
