package restaurantbillgenerator;

import java.util.Scanner;

public class RestaurantCafeBillGenerator {
    public static void main(String[] args) {

        baslat();


    }

    public static void baslat() {

        Scanner inp=new Scanner(System.in);
        OrderService orderService=new OrderService();
        System.out.println("Merhaba");
        System.out.println("1-Restaurant");
        System.out.println("2-Cafe");
        int option=inp.nextInt();
        if (option==1){
            DishService dishService = new DishService();
            dishService.fillDishList();
            getSelectionMenu(dishService,orderService);
        }else {
            DishService dishService=new CafeDishService();
            dishService.fillDishList();
            getSelectionMenu(dishService,orderService);
        }




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
