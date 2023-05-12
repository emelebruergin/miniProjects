package mini_project_bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotebookService implements ProductService{

    Scanner inp=new Scanner(System.in);
    List<Notebook> notebookList=new ArrayList<>();

    public NotebookService(){
        Notebook notebook1=new Notebook(1,"sarı","50 Lira",25,"Fatih","120");
        Notebook notebook2=new Notebook(2,"kırmızı","25 Lira",12,"Fatih","210");
        Notebook notebook3=new Notebook(3,"turuncu","23",15,"Make","220");
        this.notebookList.add(notebook1);
        this.notebookList.add(notebook2);
        this.notebookList.add(notebook3);
    }


    @Override
    public void processMenu() {
        int choice=-1;
        while (choice!=0){
            System.out.println("--------------------------------------------------");
            System.out.println("1-Defterleri Listele");
            System.out.println("2-Defter Ekle");
            System.out.println("3-Defter Sil");
            System.out.println("4-Markaya göre filtrele");
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
                    System.out.println("Marka:");
                    String brand=inp.next();
                    filterProduct(brand);
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
        System.out.printf("%-2s | %-30s |%-15s | %-10s | %-7s | %-5s\n","ID","Defter Adı","Marka","Sayfa","Birim fiyat","Stok");
        for (Notebook notebook:this.notebookList){
            System.out.printf("%-2s | %-30s |%-15s | %-10s | %-7s | %-5s\n",notebook.getId(),notebook.getName(),
                    notebook.getBrand(),notebook.getSheet(),notebook.getPrice(),notebook.getStock());

        }
        System.out.println("---------------------------------------------");

    }

    @Override
    public void addProduct() {
        System.out.println("Defter adı:");
        String notebookName=inp.nextLine();

        System.out.println("Marka:");
        String brandname=inp.nextLine();

        System.out.println("Sayfa:");
        String sheet=inp.nextLine();

        System.out.println("Birim fiyat:");
        String price=inp.nextLine();

        System.out.println("Stok:");
        int stock=inp.nextInt();


        Notebook newNotebook= new Notebook(this.notebookList.get(this.notebookList.size()-1).getId()+1,notebookName,price,stock,brandname,sheet);
        this.notebookList.add(newNotebook);
    }

    @Override
    public void removeProduct() {

        System.out.printf("Defter id:");
        int id=inp.nextInt();
        boolean isExist=true;
        for (Notebook notebook:notebookList){
            if(notebook.getId()==id){
                this.notebookList.remove(notebook);
                System.out.println("Defter Silindi");
                isExist=true;
                break;
            }else {
                isExist=false;
            }
        }
        if (!isExist){
            System.out.println("Defter Bulunamadı..");
        }

    }

    @Override
    public void filterProduct(String filter) {
        for (Notebook notebook:this.notebookList){
            if (notebook.getBrand().equalsIgnoreCase(filter)){
                System.out.printf("%-2s | %-30s |%-15s | %-10s | %-7s | %-5s\n",notebook.getId(),
                        notebook.getName(),notebook.getBrand(),notebook.getSheet(),notebook.getPrice(),notebook.getStock());

            }
        }

    }
}
