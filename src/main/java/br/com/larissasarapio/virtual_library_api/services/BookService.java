package br.com.larissasarapio.virtual_library_api.services;

import org.springframework.stereotype.Service;

import br.com.larissasarapio.virtual_library_api.domain.Book;
import br.com.larissasarapio.virtual_library_api.dtos.BookDTO;
import br.com.larissasarapio.virtual_library_api.repositories.BookRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Book createBook(BookDTO bookDTO) {

        Book newBook = new Book(bookDTO);

        return bookRepository.save(newBook);

    }
}
