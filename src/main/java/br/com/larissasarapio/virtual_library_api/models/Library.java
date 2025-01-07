package br.com.larissasarapio.virtual_library_api.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Book> listBooksAvailable() {
        return books.stream().filter(Book::isAvailable).toList();
    }

    public double calcPenalty(Loan loan) {
        long daysDelay = ChronoUnit.DAYS.between(loan.getDataReturn(), LocalDate.now());
        return daysDelay > 0 ? daysDelay * 2.0 : 0.0;
    }
    
}
