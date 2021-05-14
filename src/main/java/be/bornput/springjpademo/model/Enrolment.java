package be.bornput.springjpademo.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Enrolment")
@Table(name = "enrolment")
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_student_id_fk"
            )
    )
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_course_id_fk"
            )
    )
    private Course course;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dateCreated;


    public Enrolment(EnrolmentId id,
                     Student student,
                     Course course,
                     LocalDateTime dateCreated) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.dateCreated = dateCreated;
    }

    public Enrolment(Student student,
                     Course course,
                     LocalDateTime dateCreated) {
        this.student = student;
        this.course = course;
        this.dateCreated = dateCreated;
    }

    public Enrolment() {
    }

    public EnrolmentId getId() {
        return id;
    }

    public void setId(EnrolmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", dateCreated=" + dateCreated.toLocalDate() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrolment enrolment = (Enrolment) o;

        if (!id.equals(enrolment.id)) return false;
        if (!student.equals(enrolment.student)) return false;
        if (!course.equals(enrolment.course)) return false;
        return Objects.equals(dateCreated.toLocalDate(), enrolment.dateCreated.toLocalDate());
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + student.hashCode();
        result = 31 * result + course.hashCode();
        result = 31 * result + (dateCreated != null ? dateCreated.toLocalDate().hashCode() : 0);
        return result;
    }
}
