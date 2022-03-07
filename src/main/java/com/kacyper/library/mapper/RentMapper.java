package com.kacyper.library.mapper;

import com.kacyper.library.domain.Rent;
import com.kacyper.library.dto.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentMapper {

    public Rent mapToRent(final RentDto rentDto) {
        return new Rent(
                rentDto.getId(),
                rentDto.getReader(),
                rentDto.getRentDate(),
                rentDto.getReturnDate(),
                rentDto.getCopy()
        );
    }

    public RentDto mapToRentDto(final Rent rent) {
        return new RentDto(
                rent.getId(),
                rent.getReader(),
                rent.getRentDate(),
                rent.getReturnDate(),
                rent.getCopy()
        );
    }

    public List<RentDto> mapToRentDtoList(final List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
