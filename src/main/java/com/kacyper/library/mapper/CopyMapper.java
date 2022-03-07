package com.kacyper.library.mapper;

import com.kacyper.library.domain.Copy;
import com.kacyper.library.dto.CopyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getBook(),
                copyDto.isInLibrary(),
                copyDto.isDestroyed(),
                copyDto.isRent()
        );
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getBook(),
                copy.isInLibrary(),
                copy.isDestroyed(),
                copy.isRent()
        );
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }
}
