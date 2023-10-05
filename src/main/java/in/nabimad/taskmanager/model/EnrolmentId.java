package in.nabimad.taskmanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
//...............................................
//...............................................
@Embeddable
public class EnrolmentId implements Serializable {

    @Column(name = "person_id")
    private Long personId;
    //...............................................
    @Column(name = "project_id")
    private Long projectId;
    //...............................................
    // Constructor
    ///...............................................
    public EnrolmentId(Long personId, Long projectId) {
        this.personId = personId;
        this.projectId = projectId;
    }

    public EnrolmentId() {
    }
    //...............................................
    // Getters & Setters
    //...............................................
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    //...............................................
    // functionality
    //...............................................
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentId that = (EnrolmentId) o;
        return Objects.equals(personId, that.personId) && Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, projectId);
    }
}