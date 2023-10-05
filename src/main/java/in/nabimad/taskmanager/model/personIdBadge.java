package in.nabimad.taskmanager.model;


import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;
// Entity & Table description
@Entity(name = "PersonIdBadge")
@Table(
        name = "person_id_badge",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "person_id_badge_number_unique",
                        columnNames = "badge_number"
                )
        }
      )
//...............................................
//...............................................
public class personIdBadge {
    @Id
    @SequenceGenerator(
            name = "person_badge_id_sequence",
            sequenceName = "person_badge_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "person_badge_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    //...............................................
    @Column(
            name = "badge_number",
            nullable = false,
            length = 15
    )
    private String badgeNumber;
    //...............................................
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "person_id_fk"
            )
    )
    private Person person;
    //...............................................
    // Constructors
    //...............................................
    public personIdBadge(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public personIdBadge(String badgeNumber, Person person) {
        this.badgeNumber = badgeNumber;
        this.person = person;
    }

    public personIdBadge() {
    }


    //...............................................
    // Getters & Setters
    //...............................................
    public Long getId() {
        return id;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }
    //...............................................
    // To string
    //...............................................
    @Override
    public String toString() {
        return "PersonIdBadge{" +
                "id=" + id +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", person=" + person +
                '}';
    }

}