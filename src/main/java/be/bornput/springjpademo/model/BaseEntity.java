package be.bornput.springjpademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity( name = "BaseEntity")
abstract class BaseEntity {

    @Column( name = "date_created",
             updatable = false,
             nullable = false,
             columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate dateCreated;

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public BaseEntity(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public BaseEntity() {
       // JPA needs empty constructor
    }
}
