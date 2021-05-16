package be.bornput.springjpademo.service;

import be.bornput.springjpademo.model.Book;
import be.bornput.springjpademo.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllbooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByStudentId(Long id) {
        return bookRepository.findBooksByStudents(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
