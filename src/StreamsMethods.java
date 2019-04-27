import model.Gender;
import model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsMethods {

    public Person findOldestWoman(List<Person> people) {
        return people.stream()
                .filter(p -> p.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);

    }

    public List<String> getFullNamesUppercase(List<Person> people) {
        return people.stream()
                .map(p -> p.getFirstName().toUpperCase() + " " + p.getLastName().toUpperCase())
                .collect(Collectors.toList());

    }

    public Double getAverageAge(List<Person> people) {
        return people.stream()
                .collect(Collectors.averagingDouble(Person::getAge));
    }

    public Map<Gender, Double> getAverageAgeByGender(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(p -> p.getGender(), Collectors.averagingDouble(Person::getAge)));
    }
}
