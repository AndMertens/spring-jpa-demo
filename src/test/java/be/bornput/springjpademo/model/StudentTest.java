package be.bornput.springjpademo.model;

import be.bornput.springjpademo.UtilHelperClass;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StudentTest {

    private Student studentUnderTest;
    private final LocalDateTime fixLocalDateNow = UtilHelperClass.getCustomLocalDateTime(2000,12,1);;
    private final Enrolment dummyEnrolment = new Enrolment(
            new EnrolmentId(1L, 1L),
            new Student("Andy", "Mertens", "andy.mertens@gmail.com", 51),
            new Course("Dummy course", "Dummy Department"),
            fixLocalDateNow);
    private final Book dummyBook = new Book( "Fourth Book into collection", fixLocalDateNow);

    @Test
    public void test_createNewCourseWithConstructorAndRetrieveItsProperties() {
        studentUnderTest = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
        studentUnderTest.setId(1L);
        Student studentToCompareWith = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
        studentToCompareWith.setId(1L);
        assertThat(studentUnderTest).isNotNull();
        assertThat(studentUnderTest.getId()).isEqualTo(1L);
        assertThat(studentUnderTest.getFirstName()).isEqualTo("Andy");
        assertThat(studentUnderTest.getLastName()).isEqualTo("Mertens");
        assertThat(studentUnderTest.getEmail()).isEqualTo("andy.mertens@gmail.com");
        assertThat(studentUnderTest.getAge()).isEqualTo(51);
        assertThat(studentUnderTest.toString()).isEqualTo("Student{id=1, firstName='Andy', lastName='Mertens', email='andy.mertens@gmail.com', age=51}");
        assertThat(studentUnderTest).isEqualTo(studentToCompareWith);
        assertThat(studentUnderTest.toString()).isEqualTo(studentToCompareWith.toString());
        assertThat(studentUnderTest.hashCode()).isEqualTo(studentToCompareWith.hashCode());
    }

    @Test
    public void test_createNewCourseWithEmptyConstructorAndSetAndRetrieveItsProperties() {
        studentUnderTest = new Student ();
        studentUnderTest.setId(1L);
        studentUnderTest.setFirstName("Andy");
        studentUnderTest.setLastName("Mertens");
        studentUnderTest.setEmail("andy.mertens@gmail.com");
        studentUnderTest.setAge(51);
        studentUnderTest.addEnrolment(dummyEnrolment);
        assertThat(studentUnderTest).isNotNull();
        assertThat(studentUnderTest.getId()).isEqualTo(1L);
        assertThat(studentUnderTest.getFirstName()).isEqualTo("Andy");
        assertThat(studentUnderTest.getLastName()).isEqualTo("Mertens");
        assertThat(studentUnderTest.getEmail()).isEqualTo("andy.mertens@gmail.com");
        assertThat(studentUnderTest.getAge()).isEqualTo(51);
        assertThat(studentUnderTest.toString()).isEqualTo("Student{id=1, firstName='Andy', lastName='Mertens', email='andy.mertens@gmail.com', age=51}");
        assertThat(studentUnderTest.hashCode()).isEqualTo(-1888383795);
    }

    @Test
    public void test_addEnrolmentToAStudent() {
        studentUnderTest = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
        studentUnderTest.setId(1L);
        assertThat(studentUnderTest.getEnrolments()).isEmpty();
        studentUnderTest.addEnrolment(dummyEnrolment);
        assertThat(studentUnderTest.getEnrolments()).containsExactly(dummyEnrolment);
    }

    @Test
    public void test_addBookToAStudent() {
        studentUnderTest = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
        studentUnderTest.setId(1L);
        studentUnderTest.addBook(dummyBook);
        assertThat(studentUnderTest.getBooks()).containsExactly(dummyBook);
        studentUnderTest.removeBook(dummyBook);
        assertThat(studentUnderTest.getBooks()).isEmpty();
    }

    @Test
    public void test_addEnrolmentToAStudentThatAlreadyExist() {
        studentUnderTest = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
        studentUnderTest.setId(1L);
        studentUnderTest.addEnrolment(dummyEnrolment);
        studentUnderTest.addBook(dummyBook);
        assertThatThrownBy(
                () -> studentUnderTest.addEnrolment(dummyEnrolment))
                .hasMessage("Enrolment " + dummyEnrolment + " already exists")
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void test_removeBookFromAStudentThatDoesNotExist() {
        studentUnderTest = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
        studentUnderTest.setId(1L);
        assertThatThrownBy(
                () -> studentUnderTest.removeBook(dummyBook))
                .hasMessage("Book " + dummyBook + " was not found")
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void test_addBookToAStudentThatAlreadyExist() {
        studentUnderTest = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
        studentUnderTest.setId(1L);
        dummyBook.setId(1l);
        studentUnderTest.addBook(dummyBook);
        assertThatThrownBy(
                () -> studentUnderTest.addBook(dummyBook))
                .hasMessage("Book " + dummyBook + " already exists")
                .isInstanceOf(IllegalStateException.class);
    }

}