package in.nabimad.taskmanager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
// Entity & Table description
@Entity(name = "Enrolment")
@Table(name = "enrolment")
//...............................................
//...............................................
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;
    //...............................................
    // Relations
    //...............................................
    @ManyToOne
    @MapsId("personId")
    @JoinColumn(
            name = "person_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_person_id_fk"
            )
    )
    private Person person;
    //...............................................
    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(
            name = "project_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_project_id_fk"
            )
    )
    private Project project;
    //...............................................
    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;
    //...............................................
    // Constructors
    //...............................................

    public Enrolment(EnrolmentId id,
                     Person person,
                     Project project,
                     LocalDateTime createdAt) {
        this.id = id;
        this.person = person;
        this.project = project;
        this.createdAt = createdAt;
    }

    public Enrolment(Person person,
                     Project project,
                     LocalDateTime createdAt) {
        this.person = person;
        this.project = project;
        this.createdAt = createdAt;
    }

    public Enrolment() {
    }

    public EnrolmentId getId() {
        return id;
    }
    //...............................................
    // Getters & Setters
    //...............................................

    public void setId(EnrolmentId id) {
        this.id = id;
    }
    //...............................................
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    //...............................................
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    //...............................................
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}