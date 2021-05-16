package be.bornput.springjpademo.controller;

import be.bornput.springjpademo.model.Book;
import be.bornput.springjpademo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAllbooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id) {

        Book book = bookService.getBookById(id).get();
        if (bookService.getBookById(id).isPresent()) {
            return book;
        }
        else
        {
            Optional<Book> optionalbook = Optional.of(book);
            return optionalbook.get();
        }
    }

    @PostMapping("/book/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
