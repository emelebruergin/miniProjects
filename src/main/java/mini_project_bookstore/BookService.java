package mini_project_bookstore;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService implements ProductService{
    Scanner inp=new Scanner(System.in);
    List<Book> bookList=new ArrayList<>();

public BookService(){
    Book book1=new Book(1,"Vadideki Zambak","150 Lira",25,"Balzac","Penguen");
    Book book2=new Book(2,"Suç ve Ceza","150 Lira",12,"Dostoyevski","Penguen");
    Book book3=new Book(3,"Sefiller","125 Lira",15,"V.Hugo","Dream");
    this.bookList.add(book1);
    this.bookList.add(book2);
    this.bookList.add(book3);
}
    @Override
    public void processMenu() {

        int choice=-1;
        while (choice!=0){
            System.out.println("--------------------------------------------------");
            System.out.println("1-Kitapları Listele");
            System.out.println("2-Kitap Ekle");
            System.out.println("3-Kitap Sil");
            System.out.println("4-Yayınevine göre filtrele");
            System.out.println("0-Geri Dön");
            System.out.println("Seçiminiz: ");
            choice=inp.nextInt();

            switch (choice){
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    System.out.println("Yayınevi:");
                    String pub=inp.next();
                    filterProduct(pub);
                    break;
                case 0:
                    System.out.println("Ana menuye yönlendiriliyorsunuz.");
                    break;
                default:
                    System.out.println("Hatalı giriş.");
                    break;
            }
        }



    }

    @Override
    public void listProduct() {
        System.out.println("---------------------------------------------");
        System.out.printf("%-2s | %-30s |%-15s | %-10s | %-7s | %-5s\n","ID","Kitap Adı","Yazar Adı","Yayınevi","Birim fiyat","Stok");
        for (Book book:this.bookList){
            System.out.printf("%-2s | %-30s |%-15s | %-10s | %-7s | %-5s\n",book.getId(),book.getName(),
                    book.getAuthorName(),book.getPublisher(),book.getPrice(),book.getStock());

        }
        System.out.println("---------------------------------------------");

    }

    @Override
    public void addProduct() {

        System.out.println("Kitap adı:");
        String bookNAme=inp.nextLine();

        System.out.println("Yazar adı:");
        String authorName=inp.nextLine();

        System.out.println("Yayin evi:");
        String pub=inp.nextLine();

        System.out.println("Birim fiyat:");
        String price=inp.nextLine();

        System.out.println("Stok:");
        int stock=inp.nextInt();


        Book newBook= new Book(this.bookList.get(this.bookList.size()-1).getId()+1,bookNAme,price,stock,authorName,pub);
        this.bookList.add(newBook);
    }

    @Override
    public void removeProduct() {

        System.out.printf("Kitap id:");
        int id=inp.nextInt();
        boolean isExist=true;
        for (Book book:bookList){
            if(book.getId()==id){
                this.bookList.remove(book);
                System.out.println("Kitap Silindi");
                isExist=true;
                break;
            }else {
               isExist=false;
            }
        }
        if (!isExist){
            System.out.println("Kitap Bulunamadı..");
        }

    }

    @Override
    public void filterProduct(String filter) {
    for (Book book:this.bookList){
        if (book.getPublisher().equalsIgnoreCase(filter)){
            System.out.printf("%-2s | %-30s |%-15s | %-10s | %-7s | %-5s\n",book.getId(),
                    book.getName(),book.getAuthorName(),book.getPublisher(),book.getPrice(),book.getStock());

        }
    }
    }
}
