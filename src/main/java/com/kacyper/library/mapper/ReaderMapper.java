package com.kacyper.library.mapper;

import com.kacyper.library.domain.Reader;
import com.kacyper.library.dto.ReaderDto;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;


@Component
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getFirstName(),
                readerDto.getLastName()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getAccountCreationDate()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
