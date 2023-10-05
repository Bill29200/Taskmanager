package in.nabimad.taskmanager.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;
// Entity & Table description
@Entity(name = "Project")
@Table(name = "project")
//...............................................
//...............................................
public class Project {

    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "project_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    //...............................................
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    //...............................................
    @Column(
            name = "department",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String descriptionProject;
    //...............................................
    // Relations
    //...............................................
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "project"
    )
    private List<Enrolment> enrolments = new ArrayList<>();
    //...............................................
    // Constructors
    //...............................................
    public Project(String name, String descriptionProject) {
        this.name = name;
        this.descriptionProject = descriptionProject;
    }
    //...............................................
    public Project() {
    }
    //...............................................
    // Getters & Setters
    //...............................................
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //...............................................
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //...............................................
    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }
    //...............................................
    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void addEnrolment(Enrolment enrolment) {
        if (!enrolments.contains(enrolment)) {
            enrolments.add(enrolment);
        }
    }
    //...............................................
    // functionality
    //...............................................
    public void removeEnrolment(Enrolment enrolment) {
        enrolments.remove(enrolment);
    }
    //...............................................
    // toString
    //...............................................
    @Override
    public String toString() {
        return "Croject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + descriptionProject + '\'' +
                '}';
    }
}