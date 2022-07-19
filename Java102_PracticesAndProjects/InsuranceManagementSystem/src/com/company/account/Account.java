package com.company.account;

import com.company.Enum.AuthenticationStatus;
import com.company.address.Address;
import com.company.address.AddressManager;
import com.company.exception.InvalidAuthenticationException;
import com.company.insurance.Insurance;
import com.company.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account implements Comparable<Account> {
    Scanner scan = new Scanner(System.in);

    private AuthenticationStatus authenticationStatus;
    private User user;


    public Account(User user){
        this.user = user;
    }

    public final void showUserInfo(){
        System.out.println("Kullanıcı Bilgileri : ");
        System.out.println("İsim-Soyisim: " + user.getName() + " " + user.getSurname() + "\nKullanıcı Eposta: " +  user.getEmail() + "\nMeslek: " + user.getProfession()
        + "\nYaş: " + user.getAge());
    }

    public void login(String email, String password, Account account) throws InvalidAuthenticationException {
        if(account.getUser().getEmail().equals(email)  && account.getUser().getPassword().equals(password)){
            authenticationStatus = AuthenticationStatus.SUCCESS;
        }else{
            throw new InvalidAuthenticationException("Giriş işlemi başarısız!");
        }
    }

    public void addAddress(){
        AddressManager.addAddress(this.user);
    }

    public void deleteAddress(){
        printAddreses();
        System.out.print("Silmek istediğiniz addresin numarasını giriniz: ");
        int addressId = scan.nextInt();
        AddressManager.deleteAddress(this.user, addressId);
    }

    public abstract void addPolicy();

    public void printInsurances(){
        for(Insurance insurance: user.getInsuranceArrayList()){
            System.out.println( "Poliçe Adı: " + insurance.getInsuranceName() + "\nPoliçe Fiyatı: " + insurance.getInsurancePrice() + "\nBaşlangıç Tarihi: " + insurance.getBeginingDate() );
        }
    }

    public void printAddreses(){
        for(Address address: user.getAddressArrayList()){
            address.showAddressInfo();
        }
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
