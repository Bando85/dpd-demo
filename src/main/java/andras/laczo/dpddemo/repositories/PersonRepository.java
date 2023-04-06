/*
 * Copyright (c) Andras Laczo. 2023.
 */

package andras.laczo.dpddemo.repositories;

import andras.laczo.dpddemo.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
