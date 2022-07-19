package com.company.account;

import com.company.exception.InvalidAuthenticationException;
import com.company.user.User;

import java.util.TreeSet;

public class AccountManager {

    TreeSet<Account> accounts = new TreeSet<>();

    public void addUsers(){
        User user1 = new User("Ayşe", "Yılmaz", "ayse@gmail.com", "ayse1", "Öğretmen", 28);
        Account account1 = new Individual(user1);

        User user2 = new User("Ahmet", "Topal", "ahmet@gmail.com", "ahmet1", "Doktor", 33);
        Account account2 = new Enterprise(user2);

        accounts.add(account1);
        accounts.add(account2);
    }


    public Account login(String email, String password) {
        addUsers();
        try{
            for(Account account: accounts){
                if(account.getUser().getEmail().equals(email) && account.getUser().getPassword().equals(password)){
                    account.login(email, password, account);
                    return account;
                }
            }
            throw new InvalidAuthenticationException("Email veya şifre yanlış!");

        }
        catch(InvalidAuthenticationException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
