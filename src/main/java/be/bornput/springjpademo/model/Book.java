package be.bornput.springjpademo.model;

import javax.persistence.*;
import java.time.LocalDate;
import static javax.persistence.GenerationType.SEQUENCE;

@Table( name = "book")
@Entity( name = "Book")
public class Book extends BaseEntity{

    private final static String SEQUENCE_NR_BOOK = "sequence_book_nr";

    @Id
    @SequenceGenerator( name = SEQUENCE_NR_BOOK,
                        sequenceName = SEQUENCE_NR_BOOK,
                        allocationSize = 1
    )
    @GeneratedValue( strategy = SEQUENCE,
                      generator = SEQUENCE_NR_BOOK
    )
    @Column( name = "id",
             updatable = false
    )
    private Long id;

    @Column( name = "book_title",
             nullable = false
    )
    private String bookTitle;

    @ManyToOne
    @JoinColumn ( name = "student_id",
                  nullable = false,
                  referencedColumnName = "id",
                  foreignKey =  @ForeignKey(  name = "student_book_fk")
    )
    private Student student;

    public Book(String bookTitle, LocalDate datePublished) {
        super(datePublished);
        this.bookTitle = bookTitle;
    }

    // jpa needs empty contructor
    public Book() {
        super();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return this.getDateCreated();
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", datePublished=" + this.getDateCreated() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        if (!bookTitle.equals(book.bookTitle)) return false;
        return this.getDateCreated().equals(book.getDateCreated());
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + bookTitle.hashCode();
        result = 31 * result + this.getDateCreated().hashCode();
        return result;
    }
}
