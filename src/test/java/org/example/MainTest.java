package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Education.*;
import static org.example.Main.*;
import static org.example.Sex.MAN;
import static org.example.Sex.WOMAN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MainTest {
    private final List<Person> personsForTest = generateTestPersons();

    @Test
    void testCountMinorAge() {
        // given:
        final long expectedCount = 2;

        // when:
        final long actualCount = countMinorAge(personsForTest);

        // then:
        assertThat(actualCount, equalTo(expectedCount));
    }

    @Test
    void testGetConscriptLastNames() {
        // given:
        final String expectedLastName = "Young";

        // when:
        final List<String> actualLastNames = getConscriptLastNames(personsForTest);

        // then:
        assertThat(actualLastNames, hasSize(1));
        assertThat(actualLastNames, hasItem(expectedLastName));
    }

    @Test
    void testGetPotentialWorkers() {
        // given:
        final List<Person> expectedPersons = Arrays.asList(personsForTest.get(3), personsForTest.get(2));

        // when:
        final List<Person> actualPersons = getPotentialWorkers(personsForTest);

        // then:
        assertThat(actualPersons, equalTo(expectedPersons));
    }

    @Test
    void testGeneratePersonsCount() {
        // given:
        final int expectedPersonsCount = 10_000_000;

        // when:
        final Collection<Person> actualGeneratedPersons = generatePersons();

        // then:
        assertThat(actualGeneratedPersons, hasSize(expectedPersonsCount));
    }

    @Test
    void testGeneratePersonsAge() {
        // given:
        final int expectedMaxPersonsAge = 99;

        // when:
        final Collection<Integer> actualGeneratedAges = generatePersons().stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        // then:
        assertThat(actualGeneratedAges, everyItem(lessThanOrEqualTo(expectedMaxPersonsAge)));
    }

    private List<Person> generateTestPersons() {
        return Arrays.asList(
                new Person("Jack", "Evans", 10, MAN, ELEMENTARY),
                new Person("Ada", "Wilson", 17, WOMAN, HIGHER),
                new Person("Connor", "Young", 25, MAN, HIGHER),
                new Person("Harry", "Harris", 64, MAN, HIGHER),
                new Person("Sara", "Davies", 64, WOMAN, HIGHER),
                new Person("John", "Adamson", 50, MAN, SECONDARY));
    }
}
