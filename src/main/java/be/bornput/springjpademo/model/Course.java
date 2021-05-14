package be.bornput.springjpademo.model;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Table( name = "course")
@Entity( name = "Course")
public class Course {

    private static final String SEQUENCE_NR_COURSE = "sequence_nr_course";

    @Id
    @SequenceGenerator( name = SEQUENCE_NR_COURSE,
                        sequenceName = SEQUENCE_NR_COURSE,
                        allocationSize = 1
    )
    @GeneratedValue( generator = SEQUENCE_NR_COURSE,
                     strategy = SEQUENCE
    )
    @Column( name = "id",
             updatable = false
    )
    private Long id;

    @Column( name = "title",
             nullable = false,
             columnDefinition = "TEXT"
    )
    private String title;

    @Column( name = "department",
             nullable = false,
             columnDefinition = "TEXT"
    )
    private String department;

    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "course"
    )
    private final List<Enrolment> enrolments = new ArrayList<>();

    public Course() {
        // jpa needs empty contructor
    }

    public Course(String title, String department) {
        this.title = title;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void removeEnrolment( Enrolment enrolment) {
        if(enrolments.contains(enrolment)) {
            enrolments.remove(enrolment);
        }
        else {
            throw new IllegalStateException ("Enrolment " + enrolment.toString() + " was not found");
        }this.enrolments.remove(enrolment);
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
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (!id.equals(course.id)) return false;
        if (!title.equals(course.title)) return false;
        return  (Objects.equals(department, course.department)) ;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }
}
