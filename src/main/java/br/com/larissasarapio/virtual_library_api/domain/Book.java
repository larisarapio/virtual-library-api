package br.com.larissasarapio.virtual_library_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Book {
    private String title;
    private String author;
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
}


