package com.kacyper.library.controller;

import com.kacyper.library.domain.Book;
import com.kacyper.library.dto.BookDto;
import com.kacyper.library.exception.BookNotFoundException;
import com.kacyper.library.mapper.BookMapper;
import com.kacyper.library.service.DbServiceBook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final DbServiceBook dbServiceBook;
    private final BookMapper bookMapper;

    @GetMapping(value = "/getBooks")
    public List<BookDto> getBooksList() {
        List<Book> bookList = dbServiceBook.getAllBooks();
        return bookMapper.mapToBookDtoList(bookList);
    }

    @GetMapping(value = "/getBook/{id}")
    public BookDto getReader(@PathVariable Long id) throws BookNotFoundException {
        return bookMapper.mapToBookDto(
                dbServiceBook.getBook(id)
        );
    }

    @DeleteMapping(value = "/deleteBook/{id}")
    void deleteBook(@PathVariable Long id) {
        dbServiceBook.deleteBook(id);
    }

    @PostMapping(value = "/createBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        dbServiceBook.saveBook(book);
    }

    @PutMapping(value = "/updateBook/{id}")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Book saveBook = dbServiceBook.saveBook(book);
        return bookMapper.mapToBookDto(saveBook);
    }


}
