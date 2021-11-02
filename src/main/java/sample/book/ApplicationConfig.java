package sample.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public BookRepository bookRepository() {
		return new BookRepository();
	}
	
	@Bean
	public BookService BookService() {
		BookService bookService = new BookService();
		// Dependency Injection.
		bookService.setBookRepository(bookRepository());
		return bookService;
	}
}
