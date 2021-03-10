package com.playground.playground.dao;

import com.playground.playground.models.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    Optional<Person> insertPerson(UUID id, Person person);

    default Optional<Person> insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
}
