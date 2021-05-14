package be.bornput.springjpademo.model;

import be.bornput.springjpademo.UtilHelperClass;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CourseTest {

    private Course courseUnderTest;
    private final LocalDateTime fixLocalDateNow = UtilHelperClass.getCustomLocalDateTime(2000,12,1);;
    private final Enrolment dummyEnrolment = new Enrolment(
            new EnrolmentId(1L, 1L),
            new Student("Andy", "Mertens", "andy.mertens@gmail.com", 51),
            new Course("Dummy course", "Dummy Department"),
            fixLocalDateNow);

    @Test
    public void test_createNewCourseWithConstructorAndRetrieveItsProperties() {
        courseUnderTest = new Course ("Add 4th course to collection", "Department 4");
        courseUnderTest.setId(4L);
        Course courseToCompareWith = new Course ("Add 4th course to collection", "Department 4");
        courseToCompareWith.setId(4L);
        assertThat(courseUnderTest).isNotNull();
        assertThat(courseUnderTest.getId()).isEqualTo(4L);
        assertThat(courseUnderTest.getDepartment()).isEqualTo("Department 4");
        assertThat(courseUnderTest.toString()).isEqualTo("Course{id=4, title='Add 4th course to collection', department='Department 4'}");
        assertThat(courseUnderTest.getTitle()).isEqualTo("Add 4th course to collection");
        assertThat(courseUnderTest.getDepartment()).isEqualTo(courseToCompareWith.getDepartment());
        assertThat(courseUnderTest).isEqualTo(courseToCompareWith);
        assertThat(courseUnderTest.toString()).isEqualTo(courseToCompareWith.toString());
        assertThat(courseUnderTest.hashCode()).isEqualTo(courseToCompareWith.hashCode());
    }

    @Test
    public void test_createNewCourseWithEmptyConstructorAndSetAndRetrieveItsProperties() {
        courseUnderTest = new Course ();
        courseUnderTest.setTitle("Add 4th course to collection");
        courseUnderTest.setId(4L);
        courseUnderTest.setDepartment("Department 4");
        courseUnderTest.addEnrolment(dummyEnrolment);
        assertThat(courseUnderTest).isNotNull();
        assertThat(courseUnderTest.getId()).isEqualTo(4L);
        assertThat(courseUnderTest.getTitle()).isEqualTo("Add 4th course to collection");
        assertThat(courseUnderTest.getDepartment()).isEqualTo("Department 4");
        assertThat(courseUnderTest.getEnrolments()).containsOnly(dummyEnrolment);
        assertThat(courseUnderTest.toString()).isEqualTo("Course{id=4, title='Add 4th course to collection', department='Department 4'}");

    }

    @Test
    public void test_addEnrolmentToACourse() {
        courseUnderTest = new Course ("Add course to collection", "Department");
        courseUnderTest.setId(1L);
        assertThat(courseUnderTest.getEnrolments()).isEmpty();
        courseUnderTest.addEnrolment(dummyEnrolment);
        assertThat(courseUnderTest.getEnrolments()).containsExactly(dummyEnrolment);
    }

    @Test
    public void test_removeEnrolmentFromACourse() {
        courseUnderTest = new Course ("Add course to collection", "Department");
        courseUnderTest.setId(1L);
        courseUnderTest.addEnrolment(dummyEnrolment);
        assertThat(courseUnderTest.getEnrolments()).containsExactly(dummyEnrolment);
        courseUnderTest.removeEnrolment(dummyEnrolment);
        assertThat(courseUnderTest.getEnrolments()).isEmpty();
    }

    @Test
    public void test_removeEnrolmentFromACourseThatDoesNotExist() {
        courseUnderTest = new Course ("Add course to collection", "Department");
        courseUnderTest.setId(1L);
        assertThatThrownBy(
                () -> courseUnderTest.removeEnrolment(dummyEnrolment))
                        .hasMessage("Enrolment " + dummyEnrolment + " was not found")
                        .isInstanceOf(IllegalStateException.class);

    }

    @Test
    public void test_addEnrolmentToACourseThatAlreadyExist() {
        courseUnderTest = new Course ("Add course to collection", "Department");
        courseUnderTest.setId(1L);
        courseUnderTest.addEnrolment(dummyEnrolment);
        assertThatThrownBy(
                () -> courseUnderTest.addEnrolment(dummyEnrolment))
                .hasMessage("Enrolment " + dummyEnrolment + " already exists")
                .isInstanceOf(IllegalStateException.class);

    }

}