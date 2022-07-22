package com.company;

public class Book{
    private String bookName;
    private int pageNumber;
    private String authorName;
    private int publishingDate;

    public Book(String bookName, int pageNumber, String authorName, int publishingDate){
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.publishingDate = publishingDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(int publishingDate) {
        this.publishingDate = publishingDate;
    }
}
