package com.kacyper.library.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private LocalDate releaseDate;

}
