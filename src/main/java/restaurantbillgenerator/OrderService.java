package restaurantbillgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    Scanner input=new Scanner(System.in);
    List<Order> orderList=new ArrayList<>();

    public void createOrder (DishService dishService){

        int dishCode=-1;
        while (dishCode!=0){
            System.out.println("Lütfen ürün kodunu giriniz:(ÇIKIŞ:0)");
            dishCode=input.nextInt();//code ile ürünü bulmamız gerekiyo
            Dish dish=dishService.findDishByCode(dishCode);
            if (dish.getKod()>0){
                System.out.println("Adet giriniz:");
                int num=input.nextInt();
                Order order=new Order(dish,num);
                order.setPrice();
                order.setOrderCode(1000+this.orderList.size());
                this.orderList.add(order);
            }

            for (Order order:this.orderList){
                System.out.printf("Sipariş kodu:%-5s  lezzet kodu:%-4s  adı:%-20s  adet:%-3s\n ",
                        order.orderCode,order.dish.getKod(),order.dish.getYiyecekIsmi(),order.numOfDish);
            }


        }
    }

    public void deleteOrder(){
        boolean isValid=true;
        if (this.orderList.isEmpty()){
            System.out.println("Siparişiniz bulunmamaktadır.");

        }else {
            System.out.println("Iptal etmek isteidğiniz siparişin kodunu giriniz");


            int code = input.nextInt();
            for (Order order : this.orderList) {
                if (order.orderCode == code) {
                    this.orderList.remove(order);
                    System.out.println("Siparişiniz iptal edildi: " + order.dish.toString());
                    isValid = true;
                    break;
                } else {
                    isValid = false;
                }
            }
            if (!isValid) {
                System.out.println("Sipariş kodu geçersiz!");
            }

        }

    }
    public void printBill(){
        double totalPrice=0.0;
        System.out.println("        Lezzet Fişiniz          ");
        for (Order order:this.orderList){
            System.out.printf("Lezzet kodu:%-5s  adı:%-20s  adet:%-5s  sipariş tutarı:%-5s Lira \n",
            order.dish.getKod(), order.dish.getYiyecekIsmi(),order.numOfDish,order.orderPrice);
            totalPrice+=order.orderPrice;
        }
        System.out.println("Toplam Tutar: "+totalPrice);
        System.out.println("Afiyet olsun...");
        this.orderList=new ArrayList<>();
    }


}
