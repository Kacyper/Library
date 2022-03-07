package com.kacyper.library.dto;

import com.kacyper.library.domain.Copy;
import com.kacyper.library.domain.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {

    private Long id;
    private Reader reader;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Copy copy;

}
