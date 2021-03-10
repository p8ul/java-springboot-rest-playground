package com.playground.playground.api;

import com.playground.playground.models.Person;
import com.playground.playground.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person/")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Optional<Person> addPerson(@RequestBody Person person) {
       return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
       return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getAllPerson(@PathVariable("id") UUID id) {
        return personService.getPerson(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }


}
