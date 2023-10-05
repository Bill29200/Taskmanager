package in.nabimad.taskmanager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

// Entity & Table description
@Entity(name = "Mission")
@Table(name = "mission")
//...............................................
//...............................................
public class Mission {
         @Id
        @SequenceGenerator(
                name = "mission_sequence",
                sequenceName = "mission_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = SEQUENCE,
                generator = "mission_sequence"
        )
        @Column(
                name = "id",
                updatable = false
        )
        private Long id;
    //...............................................
        @Column(
                name = "created_at",
                nullable = false,
                columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
        )
        private LocalDateTime createdAt;
    //...............................................
        @Column(
                name = "mission_name",
                nullable = false
        )
        private String description;
    //...............................................
    // Relations
    //...............................................
        @ManyToOne
        @JoinColumn(
                name = "person_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name = "person_mission_fk"
                )
        )
        private Person person;
    //...............................................
    // Constructors
    //...............................................
        public Mission() {
        }
    //...............................................
        public Mission(String description,
                    LocalDateTime createdAt) {
            this.createdAt = createdAt;
            this.description = description;
        }
    //...............................................
    // Getters & Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
        this.id = id;
    }
    //...............................................

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    //...............................................
        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
        this.person = person;
    }
    //...............................................
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
        this.description = description;
    }
    //...............................................
    // ToString
    //...............................................

        @Override
        public String toString() {
            return "Mission{" +
                    "id=" + id +
                    ", createdAt=" + createdAt +
                    ", missionName='" + description + '\'' +
                    ", person=" + person +
                    '}';
        }
}
