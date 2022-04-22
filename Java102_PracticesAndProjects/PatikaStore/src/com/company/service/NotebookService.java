package com.company.service;

import com.company.products.Notebook;
import com.company.products.Product;
import com.company.service.IService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class NotebookService implements IService {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Product> notebookList = new ArrayList<>();

    @Override
    public void addItem() {
        int id = 1;
        System.out.print("Ürün Adı : ");
        String productName = scanner.next();
        System.out.print("Ürün Fiyatı : ");
        double productPrice = scanner.nextDouble();
        System.out.print("Marka : ");
        String productBrand = scanner.next();
        System.out.print("Depolama : ");
        int storage = scanner.nextInt();
        System.out.print("Ekran Boyutu : ");
        double screenSize = scanner.nextDouble();
        System.out.print("RAM : ");
        int ram = scanner.nextInt();

        Product newNotebook = new Notebook()
                .id(id)
                .productName(productName)
                .productPrice(productPrice)
                .brand(productBrand)
                .storage(storage)
                .screenSize(screenSize)
                .RAM(ram)
                .buildProduct();

        notebookList.add(newNotebook);
        id++;
    }

    @Override
    public void listItems() {

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                   | Fiyat      | Marka      | Depolama    | Ekran Boyutu  | RAM        |");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        if(!notebookList.isEmpty()){
            for(Product notebook : notebookList){
                System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n",
                        notebook.getId(), notebook.getProductName(), notebook.getProductPrice(), notebook.getBrand(), notebook.getStorage(), notebook.getScreenSize(),
                        notebook.getRAM()
                );
            }

            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
        System.out.println();
    }

    @Override
    public void deleteItem() {
       System.out.print("Silmek istediğiniz ürünün id numarasını giriniz : ");
       int id = scanner.nextInt();

       if(!(id <= 0)){
           for (Product notebook : notebookList){
               if(notebook.getId() == id){
                   notebookList.remove(notebook);
                   break;
               }
           }
           System.out.println(id + " numaralı ürün silindi!");

       }else{
           System.out.println("Geçersiz sayı girdiniz!");
       }

    }

    @Override
    public void filterItemById() {
        System.out.print("Listelemek istediğiniz ürünün id numarasını giriniz : ");
        int productId = scanner.nextInt();

        if(validationOfId(productId)){
            for(Product notebook : notebookList){
                if(notebook.getId() == productId){
                    printNotebook(notebook);
                }
            }
        }else{
            System.out.println("Girdiğini id numarasına ait ürün bulunamadı!");
        }
    }


    @Override
    public void filterItemByBrand() {
        System.out.print("Listelemek istediğiniz ürünlerin markasını giriniz : ");
        String productBrand = scanner.next();

        if(!(productBrand == null)){
            productBrand.toLowerCase();
            for(Product notebook : notebookList){
                notebook.getBrand().toLowerCase();
                if(notebook.getBrand().equals(productBrand)){
                    printNotebook(notebook);
                }
            }
        }else{
            System.out.println("Marka ismini boş geçemezssiniz!");
        }
    }

    @Override
    public void productMenu() {
        while(true){
            System.out.println("-----------------------------------");
            System.out.println("Ürün Menüsü \n" + "1.Ürünleri Listele \n" + "2.Ürün Ekle \n" + "3.Ürün Numarasına Göre Ürün Listele \n" + "4.Girilen Markanın Ürünlerini Listele \n" + "5.Ürün Sil \n"+ "0.Çıkış");
            System.out.println("-----------------------------------");
            System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
            int option = scanner.nextInt();

            boolean isExit = false;

            switch (option){
                case 1:
                    listItems();
                    break;
                case 2:
                    addItem();
                    System.out.println("--------Ürün eklendi.---------");
                    break;
                case 3:
                    filterItemById();
                    break;
                case 4:
                    filterItemByBrand();
                    break;
                case 5:
                    deleteItem();
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println("Geçerli bir sayı giriniz!");
            }

            if (isExit) {
                return;
            }
        }
    }

    private void printNotebook(Product notebook) {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                   | Fiyat      | Marka      | Depolama    | Ekran Boyutu  | RAM        |");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n",
                notebook.getId(), notebook.getProductName(), notebook.getProductPrice(), notebook.getBrand(), notebook.getStorage(), notebook.getScreenSize(),
                notebook.getRAM()
        );
    }

    private Boolean validationOfId(int id) {
        if(id <= 0){
            return false;
        }
        return true;
    }

}
