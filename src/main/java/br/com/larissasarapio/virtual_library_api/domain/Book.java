package br.com.larissasarapio.virtual_library_api.domain;

import java.util.UUID;

import br.com.larissasarapio.virtual_library_api.dtos.BookDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        String meuNovoLivro = "title: " + getTitle() + 
                              " author: " + getAuthor() +
                              " avaible: " + isAvailable();
        return meuNovoLivro;
    }

    public Book(BookDTO bookDTO) {
        this.title = bookDTO.title();
        this.author = bookDTO.author();
        this.available = bookDTO.available();
    }
}


