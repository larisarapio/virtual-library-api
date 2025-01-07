package br.com.larissasarapio.virtual_library_api;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.larissasarapio.virtual_library_api.models.Book;
import br.com.larissasarapio.virtual_library_api.models.Library;

@SpringBootApplication
public class VirtualLibraryApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(VirtualLibraryApiApplication.class, args);

		Book meuBook = new Book();
		meuBook.setTitle("Solid");
		System.out.println("o livro " + meuBook.toString());
		System.out.println(meuBook.getTitle());

		Library newLibrary = new Library();
		newLibrary.addBook(meuBook);
		System.out.println("o livro - " + meuBook + " foi cadastrado na biblioteca - " + newLibrary.listBooksAvailable());
	}

}
