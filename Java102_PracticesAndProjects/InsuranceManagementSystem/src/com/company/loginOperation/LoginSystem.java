package com.company.loginOperation;

import com.company.account.Account;
import com.company.account.AccountManager;
import com.company.exception.InvalidAuthenticationException;

import java.util.Scanner;

public class LoginSystem {
    Scanner scan = new Scanner(System.in);

    AccountManager accountManager = new AccountManager();

    public void login() {
        System.out.println("Sisteme Hoşgeldiniz!");
        System.out.print("Eposta adresinizi giriniz : ");
        String email = scan.next();

        System.out.print("Şifre giriniz : ");
        String password = scan.next();

        Account loginAccount = accountManager.login(email, password);
        if(loginAccount != null){
            run(loginAccount);
        }else{
            System.out.print("Böyle bir kullanıcı yoktur!");
        }
    }

    private void run(Account account){
        while(true){
            System.out.println("--------İşlemler---------");
            System.out.println("1.Kullanıcı Bilgilerini Göster" +
                    "\n2.Kullanıcı Yeni Poliçe Ekle" +
                    "\n3.Kullanıcı Adresi Ekle" +
                    "\n4.Kullanıcı Adresi Sil" +
                    "\n5.Kullanıcı Poliçeleri Görüntüle" +
                    "\n6.Kullanıcı Adresi Görüntüle" +
                    "\n7.Çıkış Yap");
            int option = scan.nextInt();

            switch (option){
                case 1:
                    account.showUserInfo();
                    break;
                case 2:
                    account.addPolicy();
                    break;
                case 3:
                    account.addAddress();
                    break;
                case 4:
                    account.deleteAddress();
                    break;
                case 5:
                    account.printInsurances();
                    break;
                case 6:
                    account.printAddreses();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Geçersiz değer girildi!");
            }
        }
    }

}
