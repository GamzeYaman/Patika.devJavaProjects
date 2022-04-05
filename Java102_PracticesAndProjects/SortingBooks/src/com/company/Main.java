package com.company;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Goblin Kral", 416, "Katherine Addison", 2014);
        Book book2 = new Book("Ejderhanın Gözü", 210, "Stephen King", 2002);
        Book book3 = new Book("Gregor ve Gri Kehanet", 304, "Suzanne Collins", 2014);
        Book book4 = new Book("Açlık Oyunları 1", 374, "Suzanne Collins", 2011);
        Book book5 = new Book("Labirent", 375, "James Dashner", 2009);

        TreeSet<Book> books =  new TreeSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for(Book book: books){
            System.out.println(book.getBookName() + ", " + book.getAuthorName() + ", " + book.getPageNumber() + ", " + book.getPublishingDate());
        }

        System.out.println("**********************************");
        TreeSet<Book> booksWithPageNum = new TreeSet<>(new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2) {
                return (o1.getPageNumber() - o2.getPageNumber());
            }
        });

        booksWithPageNum.add(book1);
        booksWithPageNum.add(book2);
        booksWithPageNum.add(book3);
        booksWithPageNum.add(book4);
        booksWithPageNum.add(book5);

        for(Book book: booksWithPageNum){
            System.out.println( book.getPageNumber() + ", " + book.getBookName() + ", " + book.getAuthorName() + ", " + book.getPublishingDate());
        }
    }
}
