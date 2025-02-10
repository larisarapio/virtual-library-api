package br.com.larissasarapio.virtual_library_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.larissasarapio.virtual_library_api.domain.Book;
import br.com.larissasarapio.virtual_library_api.dtos.BookDTO;
import br.com.larissasarapio.virtual_library_api.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(BookDTO bookDTO) {
        validateBookData(bookDTO);
        validateTitleDoesNotExist(bookDTO.title());
        Book newBook = new Book(bookDTO);

        return bookRepository.save(newBook);

    }

    private void validateBookData(BookDTO bookDTO) {
        if (isNullOrEmpty(bookDTO.title())) {
            throw new IllegalArgumentException("Title is required!");
        }

        if (isNullOrEmpty(bookDTO.author())) {
            throw new IllegalArgumentException("Description is required!");
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private void validateTitleDoesNotExist(String title) {
        if (bookRepository.existsByTitle(title)) {
            throw new IllegalArgumentException("Book with this title already exists!");
        }
    }

    public List<Book> listBooks() {
        return this.bookRepository.findAll();
    }

 
}
