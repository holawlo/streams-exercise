import model.Gender;
import model.Person;
import org.junit.jupiter.api.Test;

import java.util.*;

import static model.Gender.FEMALE;
import static model.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class StreamsMethodsTest {

    private StreamsMethods instance = new StreamsMethods();

    @Test
    void findOldestWoman() {
        // given
        List<Person> people = prepareData();

        // when
        Person result = instance.findOldestWoman(people);

        // then
        assertEquals(result, new Person("Estera", "Kowalska", 67, FEMALE));
    }


    @Test
    void getFullNamesUppercase() {
        // given
        List<Person> people = prepareData();
        List<String> expected = Arrays.asList("JOHN SMITH", "ADAM NOWAK", "ESTERA KOWALSKA", "JULIA WOŹNIAK", "ANDRZEJ PIASECZNY", "RYOYU KOBAYASHI");

        // when
        List<String> result = instance.getFullNamesUppercase(people);

        // then
        assertIterableEquals(expected, result);
    }

    @Test
    void getAverageAge() {
        // given
        List<Person> people = prepareData();
        Double expected = 33.0;

        // when
        Double result = instance.getAverageAge(people);

        // then
        assertEquals(expected, result);
    }

    @Test
    void getAverageAgeByGender() {
        // given
        List<Person> people = prepareData();
        Map<Gender, Double> expected = new HashMap<>();
        expected.put(MALE, 29.75);
        expected.put(FEMALE, 39.5);


        // when
        Map<Gender, Double> result = instance.getAverageAgeByGender(people);

        // then
        assertEquals(result, expected);
    }

    private List<Person> prepareData() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Smith", 32, MALE));
        people.add(new Person("Adam", "Nowak", 18, MALE));
        people.add(new Person("Estera", "Kowalska", 67, FEMALE));
        people.add(new Person("Julia", "Woźniak", 12, FEMALE));
        people.add(new Person("Andrzej", "Piaseczny", 47, MALE));
        people.add(new Person("Ryoyu", "Kobayashi", 22, MALE));
        return people;
    }
}