package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private User user;

    private String bookName;
    private boolean isReturn;

    public User getUser() {
        return user;
    }

    public String getBookName() {
        return bookName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    protected UserLoanHistory() {

    }

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void returnBook() {
        isReturn = true;
    }


}
