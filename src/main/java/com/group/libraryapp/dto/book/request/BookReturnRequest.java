package com.group.libraryapp.dto.book.request;

public class BookReturnRequest {
    String userName;
    String bookName;

    public BookReturnRequest(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return bookName;
    }
}
