package com.llm;

import java.util.List;

public class Member extends Person{

    private MemberStatus status;
    private List<BorrowRequest> borrowRequests;

    public BookItem reserveBook(BookItem bookItem){
        if(bookItem.getBookStatus().equals(BookStatus.NOT_AVAILABLE)){
           throw  new RuntimeException("Book not available.");
        }else{
            bookItem.addMemberToReservationList(this);
        }
        return bookItem;
    }

    public BookItem renewBook(BookItem bookItem){
       bookItem.addMemberToReissueList(this);
    }

}
