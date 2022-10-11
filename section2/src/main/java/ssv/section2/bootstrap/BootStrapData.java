package ssv.section2.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ssv.section2.domain.Author;
import ssv.section2.domain.Book;
import ssv.section2.repositories.AuthorRepository;
import ssv.section2.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started in Bootstrap");
		Author author = new Author("ToanNC", "Love");
		Book book = new Book("DemoNC", "Love");
		author.getBooks().add(book);
		book.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(book);
	}

}
