package com.kacyper.library.mapper;

import com.kacyper.library.domain.Rent;
import com.kacyper.library.dto.CopyDto;
import com.kacyper.library.dto.RentDto;
import com.kacyper.library.repository.CopyRepository;
import com.kacyper.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentMapper {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private ReaderRepository readerRepository;

    public Rent mapToRent(final RentDto rentDto) {
        return new Rent(
                rentDto.getId(),
                copyRepository.findById(rentDto.getId()).get(),
                readerRepository.findById(rentDto.getReader().getId()).get(),
                rentDto.getRentDate(),
                rentDto.getReturnDate()
        );
    }

    public RentDto mapToRentDto(final Rent rent) {
        return new RentDto(
                rent.getId(),
                rent.getCopy().getId(),
                rent.getReader().getId(),
                rent.getRentDate(),
                rent.getReturnDate()
        );
    }

    public List<RentDto> mapToRentDtoList(final List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
