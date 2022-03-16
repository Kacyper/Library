package com.kacyper.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kacyper.library.domain.Copy;
import com.kacyper.library.domain.Reader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder

public class RentDto {

    @JsonProperty("field_name")

    private Long id;
    private Reader readerId;
//    private LocalDate rentDate;
//    private LocalDate returnDate;
    private Copy copy;

//    public RentDto() {}

}
