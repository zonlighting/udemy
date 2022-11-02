package ssv.com.udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ssv.com.udemy.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
