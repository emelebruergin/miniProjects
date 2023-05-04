package mini_project_sayisal_loto;

import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {
    /*
    Proje: Sayısal Loto Uygulaması
    bilet için rastgele n tane sayı üretilsin.
    sayısal lotoda tekrarlı sayılar olmamalı.

    n (hane sayısı),sayılar için min ve max değerler
    kullanıcıdan alınsın.

    sonuc ve bilet karsılastırılsın,kaç eşleşme oldugu kullanıcıya bildirilsin.
     */
    public static void main(String[] args) {
        startLoto();


        }
        public static void startLoto() {
            Scanner input = new Scanner(System.in);
            System.out.println("Sayısal loto kaç haneli olsun?");
            int slots = input.nextInt();
            System.out.println("Sayılar için min değer giriniz");
            int min = input.nextInt();
            System.out.println("Sayılar için max değer giriniz");
            int max = input.nextInt();

            int[] lotoArr = new int[slots];
            int[] ticketArr = new int[slots];

            int randomNumber1 = 0;
            int randomNumber2 = 0;
            Random random = new Random();
            boolean isRepeated;
            for (int i = 0; i < slots; i++) {
                do {
                    isRepeated = false;
                    randomNumber1 = random.nextInt(max + 1 - min) + min;
                    for (int j = 0; j < slots; j++) {
                        if (lotoArr[j] == randomNumber1) {
                            isRepeated = true;
                            break;
                        }
                    }

                } while (isRepeated);
                lotoArr[i] = randomNumber1;


                do {
                    isRepeated = false;
                    randomNumber2 = random.nextInt(max + 1 - min) + min;
                    for (int j = 0; j < slots; j++) {
                        if (ticketArr[j] == randomNumber2) {
                            isRepeated = true;
                            break;
                        }
                    }

                } while (isRepeated);
                ticketArr[i] = randomNumber2;
            }
            System.out.println("Benim biletim: ");
            for (int i = 0; i < ticketArr.length; i++) {
                System.out.print(ticketArr[i] + " ");
            }

            System.out.println();
            System.out.println("Loto sonucu: ");
            for (int i = 0; i < lotoArr.length; i++) {
                System.out.print(lotoArr[i] + " ");
            }

            System.out.println();

            int result=compareArr(lotoArr,ticketArr);

            if(result==0){
                System.out.println("Hiç eşleşme yok!");
            }else {
                System.out.println("Tebrikler "+result+" eşleşme var!");
            }

        }

        public static int compareArr(int[]arr,int[]brr){
        int counter=0;
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<i+1;j++){
                if(arr[i]==brr[j]){
                    counter++;
                }
            }
        }return counter;
        }
}
