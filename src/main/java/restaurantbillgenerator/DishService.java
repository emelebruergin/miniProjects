package restaurantbillgenerator;

import java.util.ArrayList;
import java.util.List;

public class DishService {
    List<Dish> dishList =new ArrayList<>();

    public void fillDishList(){
        Dish yiyecek1=new Dish(100,"Adana Kebabı",220);
        Dish yiyecek2=new Dish(101,"Urfa Kebabı",200.0);
        Dish yiyecek3=new Dish(102,"Çökertme Kebabı",200.0);
        Dish yiyecek4=new Dish(200,"Baklava",100.0);
        Dish yiyecek5=new Dish(201,"Kadayıf",85.0);
        Dish yiyecek6=new Dish(202,"Künefe",75.0);
        Dish yiyecek7=new Dish(300,"Yayık Ayranı",30.0);
        Dish yiyecek8=new Dish(301,"Kola",35.0);
        Dish yiyecek9=new Dish(302,"Çay",15.0);
        Dish yiyecek10=new Dish(303,"Su",7.5);

        this.dishList.add(yiyecek1);
        this.dishList.add(yiyecek2);
        this.dishList.add(yiyecek3);
        this.dishList.add(yiyecek4);
        this.dishList.add(yiyecek5);
        this.dishList.add(yiyecek6);
        this.dishList.add(yiyecek7);
        this.dishList.add(yiyecek8);
        this.dishList.add(yiyecek9);
        this.dishList.add(yiyecek10);

    }

    public void showDishMenu(){
        System.out.println("              Lezzetlerimiz              ");
        System.out.printf("%-3s   %-20s   %-5s  \n","Kod","Adı","Fiyat");
        System.out.printf("%-3s   %-20s   %-5s  \n","---","---","-----");

        for (Dish dish:this.dishList){
            System.out.printf("%-3s   %-20s   %-5s  Lira\n",dish.getKod(),dish.getYiyecekIsmi(),dish.getUcret());
        }


    }

    public  Dish findDishByCode(int code){
        if(code==0){
            System.out.println("Ana menuye yönlendiriliyorsunuz.");
        }else {
            for (Dish dish:this.dishList){
                if (dish.getKod()==code){
                    return dish;
                }
            }
            System.out.println("Urun bulunamadı");
        }
        return new Dish(0,"",0);
    }
}
