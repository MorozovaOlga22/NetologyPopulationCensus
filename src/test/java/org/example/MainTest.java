package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Education.*;
import static org.example.Main.*;
import static org.example.Sex.MAN;
import static org.example.Sex.WOMAN;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

class MainTest {
    private final List<Person> personsForTest = generateTestPersons();

    @Test
    void testCountMinorAge() {
        // given:
        final long expectedCount = 2;

        // when:
        final long actualCount = countMinorAge(personsForTest);

        // then:
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testGetConscriptLastNames() {
        // given:
        final String expectedLastName = "Young";

        // when:
        final List<String> actualLastNames = getConscriptLastNames(personsForTest);

        // then:
        assertEquals(1, actualLastNames.size());
        assertEquals(expectedLastName, actualLastNames.get(0));
    }

    @Test
    void testGetPotentialWorkers() {
        // given:
        final List<Person> expectedPersons = Arrays.asList(personsForTest.get(3), personsForTest.get(2));

        // when:
        final List<Person> actualPersons = getPotentialWorkers(personsForTest);

        // then:
        assertEquals(expectedPersons, actualPersons);
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
