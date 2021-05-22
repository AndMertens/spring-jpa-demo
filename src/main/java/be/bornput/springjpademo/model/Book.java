package be.bornput.springjpademo.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table( name = "book")
@Entity( name = "Book")
public class Book {

    private static final String BOOK_SEQUENCE = "book_sequence";

    @Id
    @SequenceGenerator( name = BOOK_SEQUENCE,
                        sequenceName = BOOK_SEQUENCE,
                        initialValue = 1,
                        allocationSize = 1
    )
    @GeneratedValue( strategy = SEQUENCE,
                     generator = BOOK_SEQUENCE
    )
    @Column( name = "id",
             updatable = false
    )
    private Long id;

    @Column( name = "book_title",
             nullable = false
    )
    private String title;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    @Column( name = "date_created",
            updatable = false,
            nullable = false
            )
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

    public List<Student> getStudents() {
        if(!this.students.isEmpty()) {
            return students;
        }
        else {
            return Collections.emptyList();
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
