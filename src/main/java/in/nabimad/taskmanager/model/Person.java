package in.nabimad.taskmanager.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

// Entity & Table description
@Entity(name="Person")
@Table(
        name="person",
        uniqueConstraints = {
                @UniqueConstraint(name = "person_email_unique",columnNames="email")
        }
      )
//...............................................
//...............................................
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "person_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;
    //...............................................
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    //...............................................
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    //...............................................
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    //...............................................
    private LocalDate dob;
    //..............................................
    //  Relations
    //..............................................
    @OneToOne(
            mappedBy = "person",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private personIdBadge personIdBadge;

    @OneToMany(
            mappedBy = "person",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Mission> Missions = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "person"
    )
    private List<Enrolment> enrolments = new ArrayList<>();
    //..............................................
    //  Constructors
    //..............................................
    public Person() {
    }
    //..............................................
    public Person(Long id,
                  String firstName,
                  String LastName,
                  String email,
                  LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }
    //..............................................
    public Person(String firstName,
                  String LastName,
                  String email,
                  LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }
    //..............................................
    // Getters & Setters
    //..............................................


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //..............................................

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //..............................................

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //..............................................
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //..............................................
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    //..............................................


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
