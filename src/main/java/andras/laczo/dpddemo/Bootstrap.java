/*
 * Copyright (c) Andras Laczo. 2023.
 */

package andras.laczo.dpddemo;

import andras.laczo.dpddemo.model.PersonEntity;
import andras.laczo.dpddemo.repositories.PersonRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PersonRepository personRepository;

    public Bootstrap(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadData();
    }

    private void loadData() {

        ArrayList<PersonEntity> list = new ArrayList<>();

        list.add(PersonEntity.builder()
                .name("Chris Thompson")
                .birth(LocalDate.of(1990, 12, 19))
                .mother("Margareth Lowes")
                .taj(234567891L)
                .tax(12345678912L)
                .email("chris@of.com")
                .address("New York")
                .phone("+33-44-666678")
                .build());

        list.add(PersonEntity.builder()
                .name("Ben Franklin")
                .birth(LocalDate.of(1856, 12, 19))
                .mother("Julia Bates")
                .taj(111567891L)
                .tax(33345678912L)
                .email("ben@of.com")
                .address("New York;Washington")
                .phone("+33-44-666678;+44555-666678")
                .build());

        list.add(PersonEntity.builder()
                .name("Al Michaels")
                .birth(LocalDate.of(1956, 12, 30))
                .mother("Erica Roberts")
                .taj(211567891L)
                .tax(56345678912L)
                .email("al@of.com")
                .address("Kansas;Washington;Alabama")
                .phone("+33-55-665678;+45655-666678")
                .build());

        personRepository.saveAll(list);
    }
}
