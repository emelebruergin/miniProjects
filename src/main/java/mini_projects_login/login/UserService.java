package mini_projects_login.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    List <String> userNameList =new ArrayList<>();
    List <String> emailList =new ArrayList<>();
    List <String> passwordList =new ArrayList<>();

    public void showMenu(){
        System.out.println("====TECHPROEDUCATION====");
        System.out.println("1-Uye Ol\n2-Giriş Yap\n3-Çıkış\nSeçiminiz: ");
    }

    public void register(){
        Scanner input=new Scanner(System.in);
        System.out.println("Lütfen ad-soyad giriniz.");
        String name=input.nextLine();

        String userName;
        boolean existUserName;
        do {
            System.out.println("Lütfen kullanıcı adı giriniz.");
            userName=input.nextLine();
            existUserName = userNameList.contains(userName);
            if (existUserName){
                System.out.println("Bu username daha once kullanılmıştır.Yeni bir username deneyiniz.");

            }
        }while(existUserName);


        String email;
        boolean isValid;
        boolean existEmail;
        do {
            System.out.println("Lütfen email giriniz");
            email=input.nextLine().trim();
            isValid=validateEmail(email);
            existEmail= emailList.contains(email);
            if (existEmail){
                isValid=false;
                System.out.println("Bu email daha once kullanılmıştır.Yeni bir email deneyiniz.");
            }
        }while (!isValid);


        String password;
        boolean isValidPsw;

        do {
            System.out.println("Sifrenizi giriniz.");
            password=input.nextLine();
            isValidPsw=validatePassword(password);

        }while(!isValidPsw);

        User user=new User(name,userName,email,password);
        userNameList.add(userName);
        emailList.add(email);
        passwordList.add(password);


        System.out.println(user);
        System.out.println("Tebrikler kayıt işleminiz gercekleşmiştir.");
        System.out.println("Kullanici adi veya email ve sifre ile sisteme giriş yapabilirsiniz.");







    }
    public void login(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Kullanıcı adı veya email giriniz");
        String usernameOrEmail=scanner.nextLine();
        boolean isEmail=emailList.contains(usernameOrEmail);
        boolean isUsername=userNameList.contains(usernameOrEmail);

        if (isEmail||isUsername){


            while (true){

                System.out.println("Sifre giriniz");
                String password=scanner.nextLine();
            int idx;
            if (isUsername){
               idx= userNameList.indexOf(usernameOrEmail);
            }else {
                idx=emailList.indexOf(usernameOrEmail);
            }


            if (passwordList.get(idx).equals(password)){
                System.out.println("Sisteme giriş yaptınız.");
                break;
            }else {
                System.out.println("Sifreniz yanlış, tekrar deneyiniz.");
            }
        }
    }else{
            System.out.println("Sisteme kayıtlı kullanıcı bulunamadı.\nBilgileri kontrol ediniz yada üye olunuz.");
        }
    }
    public static boolean validatePassword(String password){
        boolean isValid;
       boolean space= password.contains(" ");
       boolean lengthGt6=password.length()>=6;
       boolean existUpper= password.replaceAll("[^A-Z]","").length()>0;
       boolean existLower=password.replaceAll("[^a-z]","").length()>0;
       boolean existDigit=password.replaceAll("[^0-9]","").length()>0;
       boolean existSymbol=password.replaceAll("[\\P{Punct}]","").length()>0;

       if (space){
           System.out.println("Sifre boşluk içeremez");
       } else if (!lengthGt6) {
           System.out.println("Sifre en az 6 karakter içermeli");
       } else if (!existUpper) {
           System.out.println("Sifre en az bir büyük harf içermelidir");
       } else if (!existLower) {
           System.out.println("Sifre en az bir kücük harf içermelidir");
       }else if (!existDigit){
           System.out.println("Sifre en az bir rakam içermelidir");
       } else if (!existSymbol) {
           System.out.println("Sifre en az bir sembol içermelidir");
       }
       isValid= !space && lengthGt6 && existUpper && existLower && existDigit && existSymbol;



       if(!isValid){
           System.out.println("Tekrar deneyiniz");
       }
        return isValid;
    }

    public static boolean validateEmail(String email){
        boolean isValid;
        boolean space=email.contains(" ");
        boolean isContainAt=email.contains("@");

        if (space){
            System.out.println("Email bosluk içeremez");
            isValid=false;
        }else if (!isContainAt){
            System.out.println("Email '@' içermelidir");
            isValid=false;
        }else {
           String firsPart= email.split("@")[0];
           String secondPart=email.split("@")[1];

           boolean checkStart=firsPart.replaceAll("[a-zA-Z0-9_.-]","").length()==0;
           boolean checkEnd= secondPart.equals("gmail.com") ||
                   secondPart.equals("yahoo.com") ||
                   secondPart.equals("hotmail.com");
           if (!checkStart){
               System.out.println("Email kucuk har,buyuk harf,rakam ve '_.-' bunlar dışında karakter içeremez");

           } else if (!checkEnd) {
               System.out.println("Email gmail.com , hotmail.com  veya yahoo.com ile bitmeli. ");
           }
           isValid=checkEnd&&checkStart;


        }
        return isValid;



    }



}
