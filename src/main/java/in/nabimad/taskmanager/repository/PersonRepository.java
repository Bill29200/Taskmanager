package in.nabimad.taskmanager.repository;


import in.nabimad.taskmanager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
