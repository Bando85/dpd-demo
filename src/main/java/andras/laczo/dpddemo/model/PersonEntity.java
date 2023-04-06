/*
 * Copyright (c) Andras Laczo. 2023.
 */

package andras.laczo.dpddemo.model;


import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    String name;
    LocalDate birth;
    String mother;
    Long taj;
    Long tax;
    String email;
    String address;
    String phone;

}
