package com.kacyper.library.copy;

import com.kacyper.library.domain.Book;
import com.kacyper.library.domain.Copy;
import com.kacyper.library.repository.BookRepository;
import com.kacyper.library.repository.CopyRepository;
import com.kacyper.library.service.DbServiceBook;
import com.kacyper.library.service.DbServiceCopy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CopyTestSuite {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private DbServiceCopy dbServiceCopy;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DbServiceBook dbServiceBook;

    @Test
    void testSaveCopy() {
        //Given
        Book book = Book.builder()
                .author("Adam Mickiewicz")
                .title("Pan Tadeusz")
                .releaseDate(1834)
                .build();
        bookRepository.save(book);
        List<Book> bookList = bookRepository.findAll();
        Long idBook1 = book.getId();

        //When
        Copy copy = new Copy(book);

        copyRepository.save(copy);
        Long idCopy = copy.getId();

        Copy result = dbServiceCopy.getCopyById(idCopy).get();

        //Then
        assertEquals(1, bookList.size());
        assertEquals(idCopy, result.getId());

        //CleanUp
        bookRepository.deleteById(idBook1);
        copyRepository.deleteById(idCopy);
        dbServiceCopy.deleteCopy(idCopy);
    }

}
