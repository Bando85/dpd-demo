/*
 * Copyright (c) Andras Laczo. 2023.
 */

package andras.laczo.dpddemo.dto;

import lombok.Builder;

@Builder
public record PersonDTO(
        Long id,
        String name,
        String birth,
        String mother,
        Long taj,
        Long tax,
        String email,
        String address,
        String phone
) {};



