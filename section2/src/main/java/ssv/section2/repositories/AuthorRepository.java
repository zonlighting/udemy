package ssv.section2.repositories;

import org.springframework.data.repository.CrudRepository;

import ssv.section2.domain.Author;


public interface AuthorRepository extends CrudRepository<Author, Long> {

}
