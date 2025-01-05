package br.com.larissasarapio.virtual_library_api.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loan {
    private User user;
    private Book book;
    private LocalDate dataLoan;
    private LocalDate dataReturn;

    public Loan(User user, Book book) {
        this.user = user;
        this.book = book;
        this.dataLoan = LocalDate.now();
        this.dataReturn = dataLoan.plusDays(14);

    }

    public String detailsLoan() {
        return String.format("Book: %s | User: %s | Return by: %s",
            book.getTitle(), user.getName(), dataReturn.toString());
    }
    
}
