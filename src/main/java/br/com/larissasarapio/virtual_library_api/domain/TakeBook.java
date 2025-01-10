package br.com.larissasarapio.virtual_library_api.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TakeBook {
    private User user;
    private Book book;
    private LocalDate dataLoan;
    private LocalDate dataReturn;

    public TakeBook(User user, Book book) {
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
