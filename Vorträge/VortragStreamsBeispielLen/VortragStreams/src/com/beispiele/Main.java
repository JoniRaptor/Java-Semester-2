package com.beispiele;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina", 33, Gender.FEMALE),
                new Person("Helen", 57, Gender.FEMALE),
                new Person("Alex", 14, Gender.MALE),
                new Person("Jamie", 99, Gender.FEMALE),
                new Person("Anna", 7, Gender.FEMALE),
                new Person("Zelda", 120, Gender.FEMALE)
        );
    }
}