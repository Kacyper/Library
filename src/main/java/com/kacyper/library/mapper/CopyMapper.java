package com.kacyper.library.mapper;

import com.kacyper.library.domain.Copy;
import com.kacyper.library.dto.CopyDto;
import com.kacyper.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {

    @Autowired
    private BookRepository bookRepository;


    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
              copyDto.getId(),
                bookRepository.findById(copyDto.getBookId()).get(),
                copyDto.getRentalStatus()
        );
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getBook().getId(),
                copy.getRentalStatus()

        );
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }
}
