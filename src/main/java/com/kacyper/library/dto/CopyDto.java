package com.kacyper.library.dto;

import com.kacyper.library.domain.RentalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CopyDto {

    private Long id;
    private Long bookId;
    private RentalStatus rentalStatus;
}