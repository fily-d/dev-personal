package com.cwa.crudspringboot.repository;

import com.cwa.crudspringboot.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void shouldGetAllPersons() {
        //Act
        List<Person> persons = personRepository.findAll();

        //Assert
        assertEquals(4, persons.size());
        assertEquals("Alice Diop", persons.get(3).getName());
    }

    @Test
    void shouldGetPersonById() {
        Person person = personRepository.findById(4L).get();

        assertEquals("Alice Diop", person.getName());
        assertEquals("Dakar", person.getCity());
        assertEquals("333-444-7841", person.getPhoneNumber());
    }

    @Test
    void shouldSavePerson() {
        Person person = new Person();
        person.setName("Armand");
        person.setCity("Paris");
        person.setPhoneNumber("142-569-8542");

        Person savedPerson = personRepository.save(person);

        assertNotNull(savedPerson.getId());
        assertEquals("Armand", savedPerson.getName());
        assertEquals("Paris", savedPerson.getCity());
        assertEquals("142-569-8542", savedPerson.getPhoneNumber());
    }

    @Test
    void shouldUpdatePerson() {
        Person person = personRepository.findById(1L).get();
        person.setCity("Lyon");

        Person savedPerson = personRepository.save(person);

        assertEquals("Lyon", savedPerson.getCity());
    }

    @Test
    void shouldDeletePerson() {
        personRepository.deleteById(3L);

        Optional<Person> person = personRepository.findById(3L);

        assertFalse(person.isPresent());
    }



}