package be.bornput.springjpademo.repository;

import be.bornput.springjpademo.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findBooksByStudents(Long id);
}
