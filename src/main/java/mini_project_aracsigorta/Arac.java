package mini_project_aracsigorta;

import java.util.Scanner;

public class Arac {
    public String aracTipi;
    public int prim;


    public int primHesapla(int donem){
       if(donem==1){
          switch (aracTipi){
              case "otomobil":
                  prim=2000;
                  break;
              case "kamyon":
                  prim=3000;
                  break;
              case "otobüs":
                  otobusPrimHesapla(donem);
                  break;
              case "motosiklet":
                  prim=1500;
                  break;
              default:
                  System.out.println("Hatalı giriş yaptınız.");
                  prim=0;
                  break;

          }

       } else if (donem==2) {
           switch (aracTipi){
               case "otomobil":
                   prim=2500;
                   break;
               case "kamyon":
                   prim=3500;
                   break;
               case "otobüs":
                   otobusPrimHesapla(donem);
                   break;
               case "motosiklet":
                   prim=1750;
                   break;
               default:
                   System.out.println("Hatalı giriş yaptınız.");
                   prim=0;
                   break;

           }
       }else{
           System.out.println("Hatalı giriş yaptınız!");
           prim=0;
       }
       return prim;
    }

    public int otobusPrimHesapla(int donem){
        Scanner input=new Scanner(System.in);
        System.out.println("Lütfen otobüs tipiniz giriniz");
        System.out.println("1-(18-30 koltuk)\n2-31 ve üzeri koltuk");
        int otobusTipi=input.nextInt();
        switch (otobusTipi){
            case 1:
                if(donem==1){
                    prim=4000;
                } else  {
                    prim=4500;
                }


            case 2:
                if (donem==1){
                    prim=5000;
                }else  {
                    prim=5500;
                }
                break;

        }
        return prim;

    }

}
