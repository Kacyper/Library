package com.kacyper.library.dto;


import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate accountCreationDate = LocalDate.now();

}
