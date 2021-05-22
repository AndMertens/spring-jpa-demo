package be.bornput.springjpademo.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(
        name= "student",
        uniqueConstraints = {
                @UniqueConstraint(name= "student_email_unique", columnNames = "email")
        }
)
@Entity(name="Student")
public class Student {

    private static final String STUDENT_SEQUENCE = "student_sequence";

    @Id
    @SequenceGenerator( name = STUDENT_SEQUENCE,
                        sequenceName = STUDENT_SEQUENCE,
                        initialValue = 1,
                        allocationSize = 1
    )
    @GeneratedValue( strategy = SEQUENCE,
                     generator = STUDENT_SEQUENCE
    )
    @Column( name = "id",
            updatable = false
    )
    private Long id;

    @Column( name = "first_name",
              nullable = false ,
              columnDefinition = "TEXT"
    )
    private String firstName;

    @Column( name = "last_name",
            nullable = false ,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column( name = "email",
            nullable = false
            //columnDefinition = "TEXT"
    )
    private String email;

    @Column( name = "age",
            nullable = false
    )
    private int age;

    @Column( name = "date_created",
            updatable = false,
            nullable = false
    )
    private LocalDateTime dateCreated;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_book",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    private List<Book> books = new ArrayList<>();

    @OneToMany ( mappedBy = "student",
                 cascade = { CascadeType.PERSIST, CascadeType.REMOVE }
    )
    List<Enrolment> enrolments = new ArrayList<>();

    public Student(String firstName,
                   String lastName,
                   String email,
                   int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student() { }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void removeBook(Book book) {
        if(books.contains(book)) {
            books.remove(book);
        }
        else {
            throw new IllegalStateException ("Book " + book.toString() + " was not found");
        }this.books.remove(book);
    }

    public void addBook( Book book) {
        if(!books.contains(book)) {
            books.add(book);
        }
        else {
            throw new IllegalStateException ("Book " + book.toString() + " already exists");
        }
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void addEnrolment( Enrolment enrolment) {
        if(!enrolments.contains(enrolment)) {
            enrolments.add(enrolment);
        }
        else {
            throw new IllegalStateException ("Enrolment " + enrolment.toString() + " already exists");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (!Objects.equals(id, student.id)) return false;
        if (!Objects.equals(firstName, student.firstName)) return false;
        if (!Objects.equals(lastName, student.lastName)) return false;
        return Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

}
