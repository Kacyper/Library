package com.kacyper.library.controller;

import com.kacyper.library.domain.Reader;
import com.kacyper.library.dto.ReaderDto;
import com.kacyper.library.exception.ReaderNotFoundException;
import com.kacyper.library.mapper.ReaderMapper;
import com.kacyper.library.service.DbServiceReader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class ReaderController {

    private final DbServiceReader dbServiceReader;
    private final ReaderMapper readerMapper;

    @GetMapping(value = "/getReaders")
    public List<ReaderDto> getReaderList() {
        List<Reader> readerList = dbServiceReader.getAllReaders();
        return readerMapper.mapToReaderDtoList(readerList);
    }

    @GetMapping(value = "/getReader/{id}")
    public ReaderDto getReader(@PathVariable Long id) throws ReaderNotFoundException {
        return readerMapper.mapToReaderDto(
                dbServiceReader.getReader(id).orElseThrow(ReaderNotFoundException::new)
        );
    }

    @DeleteMapping(value = "/deleteReader/{id}")
    void deleteReader(@PathVariable Long id) {
        dbServiceReader.deleteReader(id);
    }

    @PostMapping(value = "/createReader", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        dbServiceReader.saveReader(reader);
    }

}
