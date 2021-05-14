package be.bornput.springjpademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity( name = "BaseEntity")
abstract class BaseEntity {

    @Column( name = "date_created",
             updatable = false,
             nullable = false,
             columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime dateCreated;

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public BaseEntity(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public BaseEntity() {
       dateCreated = LocalDateTime.now();
    }
}
