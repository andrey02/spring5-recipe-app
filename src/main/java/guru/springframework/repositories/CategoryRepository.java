package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> { //don't need to specify @Component, spring already makes a Bean cause of CrudRepository.

    Optional<Category> findByDescription(String description); //return one instance
}
