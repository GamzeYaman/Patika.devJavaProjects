package com.company.address;

import com.company.user.User;

import java.util.Scanner;

public class AddressManager{

    public static void addAddress(User user) {
        Scanner scan = new Scanner(System.in);

        Address address;

        System.out.print("Lütfen girmek istediğiniz adres tipini seçiniz!");
        System.out.println("\n1.Ev Adresi " + "\n2.İş Adresi");
        int id = scan.nextInt();
        System.out.println("Lütfen adres detaylarını giriniz!");
        System.out.print("Şehir : ");
        String city = scan.next();
        System.out.print("İlçe : ");
        String district = scan.next();
        System.out.print("Mahalle : ");
        String neighborhood = scan.next();
        System.out.print("Sokak : ");
        String street = scan.next();

        if(id == 1){
            int addressId =+ user.getAddressArrayList().size();
            address = new HomeAddress(addressId, city, district, neighborhood, street);
        }else{
            int addressId =+ user.getAddressArrayList().size();
            address = new BusinessAddress(addressId, city, district, neighborhood, street);
        }

        user.setAddressArrayList(address);
        System.out.println("Adres başarıyla oluşturuldu!");
    }

    public static void deleteAddress(User user, int id) {
        user.getAddressArrayList().remove(id-1);
        System.out.println("Silme işlemi tamamlandı!");
    }


}
