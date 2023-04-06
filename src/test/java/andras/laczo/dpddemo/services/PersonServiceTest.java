/*
 * Copyright (c) Andras Laczo. 2023.
 */

package andras.laczo.dpddemo.services;

import andras.laczo.dpddemo.dto.PersonDTO;
import andras.laczo.dpddemo.model.PersonEntity;
import andras.laczo.dpddemo.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonRepository repository;

    PersonService personService;

    @BeforeEach
    void setUp() {
        this.personService = new PersonService(this.repository);
    }

    @Test
    void getAllPerson() {
        when(repository.findAll()) .thenReturn(List.of(
                PersonEntity.builder()
                        .id(1L)
                        .name("test")
                        .build(),
                PersonEntity.builder()
                        .id(2L)
                        .name("test2")
                        .build()
        ));

        List<PersonDTO> result = personService.getAllPerson();
        assertEquals(2, result.size());
    }

    @Test
    void getPersonById() {
        when(repository.findById(2L)).thenReturn(Optional.of(
                PersonEntity.builder()
                        .id(2L)
                        .name("test2")
                        .mother("testMother2")
                        .tax(1950L)
                        .build()
        ));

        Optional<PersonDTO> personDTOOptional = personService.getPersonById(2L);
        assertEquals("test2", personDTOOptional.get().name());
        assertEquals("testMother2", personDTOOptional.get().mother());
        assertEquals(1950L, personDTOOptional.get().tax());
    }
}