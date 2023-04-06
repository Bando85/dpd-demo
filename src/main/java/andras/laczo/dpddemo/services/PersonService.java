/*
 * Copyright (c) Andras Laczo. 2023.
 */

package andras.laczo.dpddemo.services;

import andras.laczo.dpddemo.dto.PersonDTO;
import andras.laczo.dpddemo.model.PersonEntity;
import andras.laczo.dpddemo.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonService {

    private final PersonRepository repository;

    public List<PersonDTO> getAllPerson() {
        return repository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public Optional<PersonDTO> getPersonById(Long id) {
        return repository.findById(id)
                .map(this::mapEntityToDto);
    }

    @Transactional
    public PersonDTO savePerson(PersonDTO personDTO) {
        PersonEntity personEntityToSave = mapDtoToEntity(personDTO);
        PersonEntity savedEntity = repository.save(personEntityToSave);
        return mapEntityToDto(savedEntity);
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void depersonalization(Long id) {
       Optional<PersonEntity> personEntity = repository.findById(id);
       if (personEntity.isPresent()) {
           PersonEntity person = personEntity.get();
           person.setName("");
           person.setBirth(null);
           person.setMother("");
           person.setAddress("");
           person.setTaj(0L);
           person.setTax(0L);
           person.setAddress("");
           repository.save(person);
       }
    }

    private PersonDTO mapEntityToDto(PersonEntity personEntity) {
        return PersonDTO.builder()
                .id(personEntity.getId())
                .name(personEntity.getName())
                .mother(personEntity.getMother())
                .taj(personEntity.getTaj())
                .tax(personEntity.getTax())
                .email(personEntity.getEmail())
                .address(personEntity.getAddress())
                .phone(personEntity.getPhone())
                .birth(birthMapper(personEntity.getBirth()))
                .build();
    }

    private PersonEntity mapDtoToEntity(PersonDTO personDTO) {


        return PersonEntity.builder()
                .id(personDTO.id())
                .name(personDTO.name())
                .mother(personDTO.mother())
                .taj(personDTO.taj())
                .tax(personDTO.tax())
                .email(personDTO.email())
                .address(personDTO.address())
                .phone(personDTO.phone())
                .birth(birthMapper(personDTO.birth()))
                .build();
    }

    private String birthMapper(LocalDate localDate) {
        return nonNull(localDate) ? localDate.format(DateTimeFormatter.ISO_DATE) : "";
    }

    private LocalDate birthMapper(String string) {
        LocalDate date = null;
        try {
            date = LocalDate.parse(string);
        } catch (DateTimeParseException d) {
        }
        return date;
    }
}
