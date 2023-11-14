package com.llm;

import java.util.LinkedList;
import java.util.Queue;

public class BookItem {

    private Book book;
    private Rack rack;
    private Barcode barcode;
    private BookStatus bookStatus;
    private Queue<Member> reservationList = new LinkedList<>();
    private Queue<Member> reissueList = new LinkedList<>();

    public void addMemberToReservationList(Member member){
        reservationList.add(member);
    }

    public void addMemberToReissueList(Member member){
        reissueList.add(member);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
