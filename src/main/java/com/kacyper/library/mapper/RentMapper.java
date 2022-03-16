package com.kacyper.library.mapper;

import com.kacyper.library.domain.Rent;
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
        return Rent.builder()
                .id(rentDto.getId())
                .copy(rentDto.getCopy())
                .readerId(rentDto.getReaderId())
//                .rentDate(rentDto.getRentDate())
//                .returnDate(rentDto.getReturnDate())
                .build();
    }

    public RentDto mapToRentDto(final Rent rent) {
        return RentDto.builder()
                .id(rent.getId())
                .copy(rent.getCopy())
                .readerId(rent.getReaderId())
//                .rentDate(rent.getRentDate())
//                .returnDate(rent.getReturnDate())
                .build();

    }

    public List<RentDto> mapToRentDtoList(final List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
//    public Rent mapToRent(final RentDto rentDto) {
//        return new Rent(
//                rentDto.getId(),
//                rentDto.getReaderId(),
//                rentDto.getCopy(),
//                rentDto.getRentDate(),
//                rentDto.getReturnDate()
//        );
//    }

//    public RentDto mapToRentDto(final Rent rent) {
//        return new RentDto(
//                rent.getId(),
//                rent.getReaderId(),
//                rent.getCopy(),
//                rent.getRentDate(),
//                rent.getReturnDate()
//        );
//    }