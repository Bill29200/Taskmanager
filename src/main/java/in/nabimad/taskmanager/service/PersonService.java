package in.nabimad.taskmanager.service;

import in.nabimad.taskmanager.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class PersonService {

    public List<Person> persons()
    {

        return List.of(
                new Person(1L,
                        "imad",
                        "imad",
                        "imad@gmail.com",
                        LocalDate.of(2000, Month.DECEMBER,12)),

                new Person(2L,
                        "nabil",
                        "nabil",
                        "nabil@gmail.com",
                        LocalDate.of(1980, Month.MARCH,15))

        );
    }
}
