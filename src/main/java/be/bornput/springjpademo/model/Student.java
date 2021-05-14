package be.bornput.springjpademo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Table(
        name= "student",
        uniqueConstraints = {
                @UniqueConstraint(name= "student_email_unique", columnNames = "email")
        }
)
@Entity(name="Student")
public class Student {

    private final String STUDENT_SEQUENCE = "student_sequence";

    @Id
    @SequenceGenerator( name = STUDENT_SEQUENCE,
                        sequenceName = STUDENT_SEQUENCE,
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
            nullable = false ,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column( name = "age",
            nullable = false
    )
    private int age;

    @OneToMany ( mappedBy = "student",
                 orphanRemoval = true,
                 cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
                 fetch = FetchType.LAZY
    )
    private List<Book> listOfBooks = new ArrayList<>();

    @OneToMany ( mappedBy = "student",
                 cascade = { CascadeType.PERSIST, CascadeType.REMOVE }
    )
    List<Enrolment> listOfEnrolments = new ArrayList<>();

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




    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void removeBook(Book book) {
        if(listOfBooks.contains(book)) {
            listOfBooks.remove(book);
        }
        else {
            throw new IllegalStateException ("Book" + book.toString() + "was not found");
        }this.listOfBooks.remove(book);
    }

    public void addEnrolment( Book book) {
        if(!listOfBooks.contains(book)) {
            listOfBooks.add(book);
        }
        else {
            throw new IllegalStateException ("Book" + book.toString() + "already exists");
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
