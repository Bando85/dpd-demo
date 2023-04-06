/*
 * Copyright (c) Andras Laczo. 2023.
 */

package andras.laczo.dpddemo.controller;

import andras.laczo.dpddemo.dto.PersonDTO;
import andras.laczo.dpddemo.model.PersonEntity;
import andras.laczo.dpddemo.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonController {

    private final Logger log = LoggerFactory.getLogger(PersonEntity.class);

    private final PersonService personService;

    @GetMapping("/persons")
    public List<PersonDTO> getPersons() {
        return personService.getAllPerson();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Long id) {
        Optional<PersonDTO> personDTO = personService.getPersonById(id);
        return personDTO.isPresent()
                ? ResponseEntity.ok().body(personDTO.get())
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/person")
    public ResponseEntity<PersonDTO> createTeam(@Valid @RequestBody PersonDTO personDTO) throws URISyntaxException {
        log.info("Request to create: {}", personDTO);
        PersonDTO savedPersonDTO = personService.savePerson(personDTO);
        return ResponseEntity.created(new URI("/api/person/" + savedPersonDTO.id()))
                .body(savedPersonDTO);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@Valid @RequestBody PersonDTO personDTO) {
        log.info("Request to update: {}", personDTO);
        PersonDTO updatedPersonDTO = personService.savePerson(personDTO);
        return ResponseEntity.ok().body(updatedPersonDTO);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        log.info("Request to delete: {}", id);
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/depersonalization/{id}")
    public ResponseEntity<?> depersonalization(@PathVariable Long id) {
        log.info("Request to depersonalization: {}", id);
        personService.depersonalization(id);
        return ResponseEntity.ok().build();
    }
}
