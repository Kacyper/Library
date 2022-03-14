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
    private Reader readerId;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Copy copy;

    public RentDto(Long id, Reader readerId, Copy copy, LocalDate rentDate, LocalDate returnDate) {
        this.id = id;
        this.readerId = readerId;
        this.copy = copy;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}
