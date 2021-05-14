package be.bornput.springjpademo.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.SEQUENCE;

@Table( name = "student_id_card",
        uniqueConstraints = {
            @UniqueConstraint ( name = "unique_student_id_card_nr", columnNames = "card_number")
        }
)
@Entity( name = "StudentIdCard")
public class StudentIdCard {

    private final String STUDENT_CARD_SEQUENCE = "student_id_card_sequence";

    @Id
    @SequenceGenerator( name = STUDENT_CARD_SEQUENCE,
            sequenceName = STUDENT_CARD_SEQUENCE,
            allocationSize = 1
    )
    @GeneratedValue( strategy = SEQUENCE,
            generator = STUDENT_CARD_SEQUENCE
    )
    @Column (name = "id",
             updatable = false )
    private Long id;

    @Column ( name = "student",
              nullable = false
    )
    private Student student;

    @Column ( name = "card_number",
            nullable = false
    )
    private String cardNumber;

    public StudentIdCard(Student student, String cardNumber) {
        this.student = student;
        this.cardNumber = cardNumber;
    }

    public StudentIdCard() {}

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", student=" + student +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentIdCard that = (StudentIdCard) o;

        if (!id.equals(that.id)) return false;
        if (!student.equals(that.student)) return false;
        return cardNumber.equals(that.cardNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + student.hashCode();
        result = 31 * result + cardNumber.hashCode();
        return result;
    }
}