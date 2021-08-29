package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final Collection<Person> persons = generatePersons();

        final long minorAgeCount = countMinorAge(persons);
        System.out.println("Количество несовершеннолетних: " + minorAgeCount);

        final List<String> conscriptLastNames = getConscriptLastNames(persons);
        System.out.println("Список призывников");
        System.out.println(String.join(", ", conscriptLastNames));

        final List<Person> potentialWorkers = getPotentialWorkers(persons);
        System.out.println("Список потенциально работоспособных людей с высшим образованием");
        potentialWorkers.forEach(System.out::println);
    }

    private static Collection<Person> generatePersons() {
        final List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        final List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        final Collection<Person> persons = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(random.nextInt(names.size())),
                    families.get(random.nextInt(families.size())),
                    random.nextInt(100),
                    Sex.values()[random.nextInt(Sex.values().length)],
                    Education.values()[random.nextInt(Education.values().length)])
            );
        }
        return persons;
    }

    static long countMinorAge(Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
    }

    static List<String> getConscriptLastNames(Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .filter(person -> person.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
    }

    static List<Person> getPotentialWorkers(Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> {
                    final int maxAge = person.getSex() == Sex.MAN ? 65 : 60;
                    final Integer personAge = person.getAge();
                    return personAge >= 18 && personAge < maxAge;
                })
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }
}
