package be.bornput.springjpademo.model;

import be.bornput.springjpademo.UtilHelperClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


class EnrolmentTest {

    private final LocalDateTime fixLocalDateNow = UtilHelperClass.getCustomLocalDateTime(2000,12,1);
    private final Student dummyStudent = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
    private final Course dummyCourse = new Course ("Add 4th course to collection", "Department 4");
    private EnrolmentId dummyEnrolmentId;
    private Enrolment enrolmentUnderTest;
    private Enrolment dummyEnrolment ;

    @BeforeEach
    void setUp(){
        dummyStudent.setId(1L);
        dummyCourse.setId(1L);
        dummyEnrolmentId = new EnrolmentId(dummyStudent.getId(), dummyCourse.getId());
        dummyEnrolment = new Enrolment(
                dummyEnrolmentId,
                dummyStudent,
                dummyCourse,
                fixLocalDateNow);

    }

    @Test
    public void test_createNewEnrolmentWithConstructor() {
        enrolmentUnderTest = new Enrolment ( dummyEnrolmentId, dummyStudent ,dummyCourse, fixLocalDateNow);
        Student studentToCompare = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );
        studentToCompare.setId(1L);
        Course courseToCompare = new Course ("Add 4th course to collection", "Department 4");
        courseToCompare.setId(1L);
        EnrolmentId enrolmentIdToCompare = new EnrolmentId(studentToCompare.getId(), courseToCompare.getId());
        Enrolment enrolmentToCompareWith = new Enrolment (
                enrolmentIdToCompare, studentToCompare, courseToCompare, fixLocalDateNow);
        assertThat(enrolmentUnderTest).isNotNull();
        assertThat(enrolmentUnderTest.getId()).isEqualTo(dummyEnrolmentId);
        assertThat(enrolmentUnderTest.getStudent()).isEqualTo(dummyStudent);
        assertThat(enrolmentUnderTest.getCourse()).isEqualTo(dummyCourse);
        assertThat(enrolmentUnderTest.getDateCreated().toLocalDate()).isEqualTo(fixLocalDateNow.toLocalDate());
        assertThat(enrolmentUnderTest).isEqualTo(enrolmentToCompareWith);
        assertThat(enrolmentUnderTest.toString()).isEqualTo(enrolmentToCompareWith.toString());
        assertThat(enrolmentUnderTest.hashCode()).isEqualTo(enrolmentToCompareWith.hashCode());
    }

    @Test
    public void test_createNewEnrolmentWithEmptyConstructor() {
        enrolmentUnderTest = new Enrolment ();
        enrolmentUnderTest.setId(dummyEnrolmentId);
        enrolmentUnderTest.setCourse(dummyCourse);
        enrolmentUnderTest.setStudent(dummyStudent);
        enrolmentUnderTest.setDateCreated(LocalDateTime.now());
        assertThat(enrolmentUnderTest).isNotNull();
        assertThat(enrolmentUnderTest.getCourse().getEnrolments()).isEmpty();
        assertThat(enrolmentUnderTest.getCourse().getId()).isEqualTo(1L);
        assertThat(enrolmentUnderTest.getCourse().getTitle()).isEqualTo("Add 4th course to collection");
        assertThat(enrolmentUnderTest.getCourse().getDepartment()).isEqualTo("Department 4");
        assertThat(enrolmentUnderTest.getStudent().getEnrolments().isEmpty());
        assertThat(enrolmentUnderTest.getStudent().getId()).isEqualTo(1L);
        assertThat(enrolmentUnderTest.getStudent().getFirstName()).isEqualTo("Andy");
        assertThat(enrolmentUnderTest.getStudent().getLastName()).isEqualTo("Mertens");
        assertThat(enrolmentUnderTest.getStudent().getEmail()).isEqualTo("andy.mertens@gmail.com");
        assertThat(enrolmentUnderTest.getStudent().getAge()).isEqualTo(51);
        assertThat(enrolmentUnderTest.getId().getStudentId()).isEqualTo(1L);
        assertThat(enrolmentUnderTest.getId().getCourseId()).isEqualTo(1L);
        assertThat(enrolmentUnderTest.toString()).isEqualTo(
                "Enrolment{id=EnrolmentId{studentId=1, courseId=1}," +
                " student=Student{id=1, firstName='Andy', lastName='Mertens', email='andy.mertens@gmail.com', age=51}," +
                " course=Course{id=1, title='Add 4th course to collection', department='Department 4'}," +
                " dateCreated=2021-05-14}");
        assertThat(enrolmentUnderTest.hashCode()).isEqualTo(1951610857);
    }

    @Test
    public void test_createNewEnrolmentWithConstructorWithoutEnrolmentId() {
        enrolmentUnderTest = new Enrolment ( dummyEnrolmentId, dummyStudent ,dummyCourse, fixLocalDateNow);
        assertThat(enrolmentUnderTest).isNotNull();
        assertThat(enrolmentUnderTest.getId()).isEqualTo(dummyEnrolmentId);
        assertThat(enrolmentUnderTest.getStudent()).isEqualTo(dummyStudent);
        assertThat(enrolmentUnderTest.getCourse()).isEqualTo(dummyCourse);
        assertThat(enrolmentUnderTest.getDateCreated().toLocalDate()).isEqualTo(fixLocalDateNow.toLocalDate());
        assertThat(enrolmentUnderTest.hashCode()).isEqualTo(1951568284);
    }

}