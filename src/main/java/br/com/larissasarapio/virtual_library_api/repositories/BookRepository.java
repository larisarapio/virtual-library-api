package br.com.larissasarapio.virtual_library_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.larissasarapio.virtual_library_api.domain.Book;

public interface BookRepository extends JpaRepository<Book, UUID>{
    
}
