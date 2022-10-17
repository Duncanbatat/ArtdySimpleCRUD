package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int peopleCount;
    private List<Person> people;

    {
        people = new ArrayList() {{
           add(new Person(++peopleCount, "Tom", 22, "tommy_versety@gmail.com"));
           add(new Person(++peopleCount, "Katy", 22, "katyegorova98@yandex.ru"));
           add(new Person(++peopleCount, "Bob", 18, "bobbythecat@gmail.com"));
        }};
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
