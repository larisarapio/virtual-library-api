package br.com.larissasarapio.virtual_library_api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.larissasarapio.virtual_library_api.domain.Book;
import br.com.larissasarapio.virtual_library_api.dtos.BookDTO;
import br.com.larissasarapio.virtual_library_api.services.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    
    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        Book book = bookService.createBook(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.CREATED);

    } 

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> listBooks(){
        List<Book> books = this.bookService.listBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
        
    }
}
