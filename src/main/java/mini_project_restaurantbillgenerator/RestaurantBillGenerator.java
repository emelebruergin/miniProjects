package mini_project_restaurantbillgenerator;

import java.util.Scanner;

public class RestaurantBillGenerator {
    /*
    Proje: Reastaurant Fiş Üretme Uygulaması
           1-Bir rastaurantın online sipariş sisteminde hesabı
           yazdıran uygulama tasarlayınız.

           2-Restauranttaki yiyecekler bir listte tutulsun.
             Yiyeceklerin kodu,ismi,ücreti

           3-Yiyecek menüsü,sipariş oluşturma/iptal ve hesap
             oluşturma için seçim menüsü gösterilsin.

           4-Yiyecek menü:Listedeki yiyecekleri menü şeklinde listelensin
             Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                           Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                           Her bir yiyecek siparişi için tutar hesaplansın

             Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
             Hesap oluşturma:Tutarları ile birlikte tüm siparişleri ve
                             toplam tutarı gösteren bir hesap fişi yazdırılsın.



         Şirket büyüdü cafe kısmı açıldı.
         aynı uygulama cafe kısmında da kullanılsın.
         Cafede farklı menu var.
           Dish dish1=new Dish(401,"Tiramisu",35.0);
           Dish dish1=new Dish(402,"Dondurma",25.0);
           Dish dish1=new Dish(403,"Profiterol",25.0);
           Dish dish1=new Dish(404,"Kahve",17.5);
           Dish dish1=new Dish(405,"Çay",7.5);
           Dish dish1=new Dish(406,"Portakal Suyu",25.5);
           Uygulama başladığında restaurant/cafe seceneği olsun
     */

    public static void main(String[] args) {

       baslat();


    }

    public static void baslat() {
        OrderService orderService=new OrderService();
        DishService dishService = new DishService();
        dishService.fillDishList();
        getSelectionMenu(dishService,orderService);

    }

    public static void getSelectionMenu(DishService dishService,OrderService orderService){
        Scanner input=new Scanner(System.in);
        int secim=-1;
        while (secim!=0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("*** Lezzet Restaurant Sipariş Uygulaması ***");
            System.out.println("====Hoşgeldiniz====");
            System.out.println("1-Menü\n2-Sipariş Gir\n3-Sipariş iptal\n4-Hesap oluşturma\n0-ÇIKIŞ");
            System.out.println("Seçiminiz:");
            secim=input.nextInt();
            System.out.println("------------------------------------------------------------------------");

            switch (secim){
                case 1:
                    dishService.showDishMenu();
                    break;
                case 2:
                    orderService.createOrder(dishService);
                    break;
                case 3:
                    orderService.deleteOrder();
                    break;
                case 4:
                orderService.printBill();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatali giriş yaptınız!...");
                    break;

            }
        }
        System.out.println("Iyi Gunler Dileriz...");

    }
}
