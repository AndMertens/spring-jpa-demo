package be.bornput.springjpademo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnrolmentIdTest {

    private  EnrolmentId EnrolmentIdUnderTest;

    @Test
    public void test_createNewEnRolmentIdWithConstructorAndRetrieveItsProperties() {
        EnrolmentIdUnderTest = new EnrolmentId(1L,2L);
        EnrolmentId EnrolmentIdToCompareWith = new EnrolmentId(1L,2L);;
        assertThat(EnrolmentIdUnderTest).isNotNull();
        assertThat(EnrolmentIdUnderTest.getStudentId()).isEqualTo(1L);
        assertThat(EnrolmentIdUnderTest.getCourseId()).isEqualTo(2L);
        assertThat(EnrolmentIdUnderTest).isEqualTo(EnrolmentIdToCompareWith);
        assertThat(EnrolmentIdUnderTest.toString()).isEqualTo(EnrolmentIdToCompareWith.toString());
        assertThat(EnrolmentIdUnderTest.hashCode()).isEqualTo(EnrolmentIdToCompareWith.hashCode());
    }

    @Test
    public void test_createNewEnrolmentIdWithEmptyConstructorAndSetAndRetrieveItsProperties() {
        EnrolmentIdUnderTest = new EnrolmentId();
        EnrolmentIdUnderTest.setCourseId(2L);
        EnrolmentIdUnderTest.setStudentId(2L);
        assertThat(EnrolmentIdUnderTest).isNotNull();
        assertThat(EnrolmentIdUnderTest.getStudentId()).isEqualTo(2L);
        assertThat(EnrolmentIdUnderTest.getCourseId()).isEqualTo(2L);
        assertThat(EnrolmentIdUnderTest.toString()).isEqualTo("EnrolmentId{studentId=2, courseId=2}");
        assertThat(EnrolmentIdUnderTest.hashCode()).isEqualTo(64);
    }
}
