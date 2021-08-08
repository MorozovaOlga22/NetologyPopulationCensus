package org.example;

public class Person {
    private final String name;
    private final String family;
    private final Integer age;
    private final Sex sex;
    private final Education education;

    Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    String getName() {
        return name;
    }

    String getFamily() {
        return family;
    }

    Integer getAge() {
        return age;
    }

    Sex getSex() {
        return sex;
    }

    Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}
