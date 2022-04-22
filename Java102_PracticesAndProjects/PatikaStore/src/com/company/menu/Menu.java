package com.company.menu;

import com.company.brand.Brand;
import com.company.service.CellPhoneService;
import com.company.service.NotebookService;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    NotebookService notebookService = new NotebookService();
    CellPhoneService cellPhoneService = new CellPhoneService();

    public void run(){
        while(true){
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri \n" + "2 - Cep Telefonu İşlemleri \n" + "3 - Marka Listele \n" + "0 - Çıkış Yap");

            System.out.print("Tercihiniz : ");
            int option = scanner.nextInt();

            addingBrands();

            boolean isExit = false;

            switch (option){
                case 1:
                    notebookService.productMenu();
                    break;
                case 2:
                    cellPhoneService.productMenu();
                    break;
                case 3:
                    Brand.print();
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println("Geçerli bir sayı giriniz!");
            }

            if (isExit) {
                System.out.println("Mağazadan ayrıldınız, hoşçakalın!");
                return;
            }
        }
    }

    private void addingBrands() {
        String[] brands = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        int id = 0;
        for(String brand : brands){
            Brand.addBrand(brand, id++);
        }
    }
}