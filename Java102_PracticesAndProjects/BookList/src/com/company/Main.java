package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Goblin Kral", 416, "Katherine Addison", 2014);
        Book book2 = new Book("Ejderhanın Gözü", 210, "Stephen King", 2002);
        Book book3 = new Book("Gregor ve Gri Kehanet", 304, "Suzanne Collins", 2014);
        Book book4 = new Book("Açlık Oyunları 1", 374, "Suzanne Collins", 2011);
        Book book5 = new Book("Labirent", 375, "Arthur Rush", 2009);
        Book book6 = new Book("Sana Her Şeyi Öğrettim Bir Şey Hariç", 375, "James Dashner", 2009);
        Book book7 = new Book("Alacakaranlık", 385, "Stephenie Meyer", 2010);
        Book book8 = new Book("Hobbit", 375, "J.R.R. Tolkien", 2008);
        Book book9 = new Book("Yolda", 86, "Jack Kerouac", 2012);
        Book book10 = new Book("Şibumi", 75, "Trevanian", 2011);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        System.out.println("############ Tüm Kitaplar ############");
        books.stream().map(book -> (book.getBookName() + " -- " + book.getAuthorName())).forEach(book -> System.out.println(book));

        System.out.println();
        System.out.println("############ Sayfa Sayısı 100'den Fazla Olan Kitaplar ############");
        books.stream().filter(book -> book.getPageNumber() > 100).map(book -> book.getBookName() + " -- " + book.getAuthorName()).forEach(book -> System.out.println(book));

    }
}
