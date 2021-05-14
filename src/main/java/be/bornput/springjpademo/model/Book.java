package be.bornput.springjpademo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Table( name = "book")
@Entity( name = "Book")
public class Book {

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
    private String title;

    @ManyToOne
    @JoinColumn ( name = "student_id",
                  nullable = false,
                  referencedColumnName = "id",
                  foreignKey =  @ForeignKey(  name = "student_book_fk")
    )
    private Student student;

    @Column( name = "date_created",
            updatable = false,
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime dateCreated;

    public Book(String title, LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        this.title = title;
    }

    // jpa needs empty contructor
    public Book() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", datePublished=" + this.getDateCreated().toLocalDate() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        if (!title.equals(book.title)) return false;
        return this.getDateCreated().toLocalDate().equals(book.getDateCreated().toLocalDate());
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + this.getDateCreated().toLocalDate().hashCode();
        return result;
    }
}
