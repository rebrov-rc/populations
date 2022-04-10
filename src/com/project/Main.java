package com.project;

import persons.Education;
import persons.Person;
import persons.Sex;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        Stream<Person> adult = persons.stream();

        long num = adult.filter(x -> x.getAge() < 18)
                .count();

        System.out.println(num);

        Stream<Person> soldier = persons.stream();

        List<String> str = soldier.filter(x -> x.getAge() >= 18 && x.getAge() < 27)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());

        System.out.println(str.toString());

        Stream<Person> familySorted = persons.stream();

        List<Person> str2 = familySorted.filter(x -> x.getEducation().equals("HIGHER"))
                    .sorted(Comparator.comparing(Person::getFamily))
                    .collect(Collectors.toList());

        System.out.println(str2);

    }
}
