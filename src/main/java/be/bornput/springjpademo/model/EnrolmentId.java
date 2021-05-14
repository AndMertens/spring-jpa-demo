package be.bornput.springjpademo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EnrolmentId implements Serializable {

    @Column ( name = "student_id")
    private Long studentId;

    @Column ( name = "course_id")
    private Long courseId;

    public EnrolmentId(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public EnrolmentId() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "EnrolmentId{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnrolmentId that = (EnrolmentId) o;

        if (!studentId.equals(that.studentId)) return false;
        return courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        int result = studentId.hashCode();
        result = 31 * result + courseId.hashCode();
        return result;
    }
}
