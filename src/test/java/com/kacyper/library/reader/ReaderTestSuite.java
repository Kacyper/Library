package com.kacyper.library.reader;


import com.kacyper.library.domain.Reader;
import com.kacyper.library.repository.ReaderRepository;
import com.kacyper.library.service.DbServiceReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ReaderTestSuite {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private DbServiceReader dbServiceReader;

    @Test
    void testSaveReader() {
        //Given
        Reader reader = Reader.builder()
                .firstName("John")
                .lastName("Doe")
                .accountCreationDate(LocalDate.now().minusDays(1))
                .build();
        readerRepository.save(reader);

        //When
        List<Reader> readerList = readerRepository.findAll();
        Long idReader1 = reader.getId();

        //Then
        assertEquals(1, readerList.size());

        //CleanUp
        readerRepository.deleteById(idReader1);
    }

    @Test
    void testSaveReaders() {
        //Given
        Reader reader1 = Reader.builder()
                .firstName("John")
                .lastName("Doe")
                .accountCreationDate(LocalDate.now().minusDays(1))
                .build();
        readerRepository.save(reader1);

        Reader reader2 = Reader.builder()
                .firstName("Mike")
                .lastName("Bike")
                .accountCreationDate(LocalDate.now().minusDays(2))
                .build();
        readerRepository.save(reader2);

        //When
        List<Reader> readerList = readerRepository.findAll();
        Long idReader1 = reader1.getId();
        Long idReader2 = reader2.getId();

        //Then
        assertEquals(2, readerList.size());

        //CleanUp
        readerRepository.deleteById(idReader1);
        readerRepository.deleteById(idReader2);
    }

    @Test
    void testFindReader() {
        //Given
        Reader reader1 = Reader.builder()
                .firstName("John")
                .lastName("Doe")
                .accountCreationDate(LocalDate.now().minusDays(1))
                .build();
        readerRepository.save(reader1);

        Reader reader2 = Reader.builder()
                .firstName("Mike")
                .lastName("Bike")
                .accountCreationDate(LocalDate.now().minusDays(2))
                .build();
        readerRepository.save(reader2);

        //When
        Long idReader1 = reader1.getId();
        Long idReader2 = reader2.getId();

        //Then
        assertEquals(idReader1, reader1.getId());
        assertEquals(idReader2, reader2.getId());

        //CleanUp
        readerRepository.deleteById(idReader1);
        readerRepository.deleteById(idReader2);

    }

    @Test
    void testExistingReader() {
        //Given
        Reader reader1 = Reader.builder()
                .firstName("John")
                .lastName("Doe")
                .accountCreationDate(LocalDate.now().minusDays(1))
                .build();
        readerRepository.save(reader1);

        Reader reader2 = Reader.builder()
                .firstName("Mike")
                .lastName("Bike")
                .accountCreationDate(LocalDate.now().minusDays(2))
                .build();
        readerRepository.save(reader2);

        //When
        Long idReader1 = reader1.getId();
        Long idReader2 = reader2.getId();

        //Then
        assertNotNull(idReader1);
        assertNotNull(idReader2);


        //CleanUp
        readerRepository.deleteById(idReader1);
        readerRepository.deleteById(idReader2);

    }

    @Test
    void testDeleteReader() {
        //Given
        Reader reader1 = Reader.builder()
                .firstName("John")
                .lastName("Doe")
                .accountCreationDate(LocalDate.now().minusDays(1))
                .build();
        readerRepository.save(reader1);

        Reader reader2 = Reader.builder()
                .firstName("Mike")
                .lastName("Bike")
                .accountCreationDate(LocalDate.now().minusDays(2))
                .build();
        readerRepository.save(reader2);

        //When
        Long idReader1 = reader1.getId();
        Long idReader2 = reader2.getId();

        readerRepository.deleteById(idReader1);
        readerRepository.deleteById(idReader2);

        List<Reader> readerList = readerRepository.findAll();

        //Then
        assertEquals(0, readerList.size());

    }
}
