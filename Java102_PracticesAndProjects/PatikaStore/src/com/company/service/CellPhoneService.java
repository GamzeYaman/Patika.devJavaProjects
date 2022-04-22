package com.company.service;

import com.company.products.CellPhone;
import com.company.products.Product;
import com.company.service.IService;

import java.util.ArrayList;
import java.util.Scanner;

public class CellPhoneService implements IService {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Product> cellphoneList = new ArrayList<>();

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
        System.out.print("Kamera Kapasitesi : ");
        int camera = scanner.nextInt();
        System.out.print("Pil Gücü : ");
        double batteryPower = scanner.nextDouble();
        System.out.print("Ürün Rengi : ");
        String productColor = scanner.next();

        Product newCellphone = new CellPhone()
                .id(id)
                .productName(productName)
                .productPrice(productPrice)
                .brand(productBrand)
                .storage(storage)
                .screenSize(screenSize)
                .RAM(ram)
                .camera(camera)
                .batteryPower(batteryPower)
                .productColor(productColor)
                .buildProduct();

        cellphoneList.add(newCellphone);
        id++;
    }

    @Override
    public void listItems() {

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                   | Fiyat      | Marka      | Depolama    | Ekran Boyutu  | Kamera     | Pil    | RAM        | Renk      |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        if(!cellphoneList.isEmpty()){
            for(Product cellphone : cellphoneList){
                System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n" ,
                        cellphone.getId(), cellphone.getProductName(), cellphone.getProductPrice(), cellphone.getBrand(), cellphone.getStorage(), cellphone.getScreenSize(),
                        cellphone.getCamera(), cellphone.getBatteryPower(), cellphone.getRAM(), cellphone.getProductColor()
                        );
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println();
    }

    @Override
    public void deleteItem() {
        System.out.print("Silmek istediğiniz ürünün id numarasını giriniz : ");
        int id = scanner.nextInt();

        if(validationOfId(id)){
            for(Product cellphone : cellphoneList){
                if(cellphone.getId() == id){
                    cellphoneList.remove(cellphone);
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
            for(Product cellphone : cellphoneList){
                if(cellphone.getId() == productId){
                    printCellphone(cellphone);
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
            for(Product cellphone : cellphoneList){
                cellphone.getBrand().toLowerCase();
                if(cellphone.getBrand().equals(productBrand)){
                    printCellphone(cellphone);
                }
            }
        }else{
            System.out.println("Marka ismini boş geçemezssiniz!");
        }

    }

    @Override
    public void productMenu() {

        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Ürün Menüsü \n" + "1.Ürünleri Listele \n" + "2.Ürün Ekle \n" + "3.Ürün Numarasına Göre Ürün Listele \n" + "4.Girilen Markanın Ürünlerini Listele  \n" + "5.Ürün Sil \n" + "0.Çıkış");
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

    private void printCellphone(Product cellphone) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                   | Fiyat      | Marka      | Depolama    | Ekran Boyutu  | Kamera     | Pil    | RAM        | Renk      |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n" ,
                cellphone.getId(), cellphone.getProductName(), cellphone.getProductPrice(), cellphone.getBrand(), cellphone.getStorage(), cellphone.getScreenSize(),
                cellphone.getCamera(), cellphone.getBatteryPower(), cellphone.getRAM(), cellphone.getProductColor()
        );
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private Boolean validationOfId(int id) {
        if(id <= 0){
            return false;
        }
        return true;
    }

}
