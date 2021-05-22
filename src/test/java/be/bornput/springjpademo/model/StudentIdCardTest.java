package be.bornput.springjpademo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

class StudentIdCardTest {

    private final Student dummyStudent = new Student ( "Andy", "Mertens", "andy.mertens@gmail.com", 51 );


    @BeforeEach
    void setUp() {
        dummyStudent.setId(1L);
    }

    private StudentIdCard studenrCardUnderTest;
    
    @Test
    public void test_createNewStudentWithConstructorAndRetrieveItsProperties() {
        studenrCardUnderTest = new StudentIdCard (dummyStudent, "0000XXXX");
        studenrCardUnderTest.setId(1L);
        StudentIdCard studentCardToCompareWith = new StudentIdCard (dummyStudent, "0000XXXX");
        studentCardToCompareWith.setId(1L);
        Assertions.assertAll(
            () -> assertThat(studenrCardUnderTest).isNotNull(),
            () -> assertThat(studenrCardUnderTest.getStudent()).isEqualTo(dummyStudent),
            () -> assertThat(studenrCardUnderTest.getCardNumber()).isEqualTo("0000XXXX"),
            () -> assertThat(studenrCardUnderTest).hasToString("StudentIdCard{id=1, student=Student{id=1, firstName='Andy', lastName='Mertens', email='andy.mertens@gmail.com', age=51}, cardNumber='0000XXXX'}"),
            () -> assertThat(studenrCardUnderTest).isEqualTo(studentCardToCompareWith),
            () -> assertThat(studenrCardUnderTest).hasToString(studentCardToCompareWith.toString()),
            () -> assertThat(studenrCardUnderTest).hasSameHashCodeAs(studentCardToCompareWith));
    }

    @Test
    public void test_createNewStudentCardWithEmptyConstructorAndSetAndRetrieveItsProperties() {
        studenrCardUnderTest = new StudentIdCard ();
        studenrCardUnderTest.setStudent(dummyStudent);
        studenrCardUnderTest.setCardNumber("0000XXXX");
        studenrCardUnderTest.setId(1L);
        Assertions.assertAll(
            () -> assertThat(studenrCardUnderTest).isNotNull(),
            () -> assertThat(studenrCardUnderTest.getId()).isEqualTo(1L),
            () -> assertThat(studenrCardUnderTest.getStudent()).isEqualTo(dummyStudent),
            () -> assertThat(studenrCardUnderTest.getCardNumber()).isEqualTo("0000XXXX"),
            () -> assertThat(studenrCardUnderTest).hasToString("StudentIdCard{id=1, student=Student{id=1, firstName='Andy', lastName='Mertens', email='andy.mertens@gmail.com', age=51}, cardNumber='0000XXXX'}"),
            () -> assertThat(studenrCardUnderTest.hashCode()).isEqualTo(416936596));
    }
}