package ssv.section2.repositories;

import org.springframework.data.repository.CrudRepository;

import ssv.section2.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
