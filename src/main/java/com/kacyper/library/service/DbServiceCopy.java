package com.kacyper.library.service;

import com.kacyper.library.domain.Book;
import com.kacyper.library.domain.Copy;
import com.kacyper.library.domain.RentalStatus;
import com.kacyper.library.repository.BookRepository;
import com.kacyper.library.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbServiceCopy {
    @Autowired
    CopyRepository copyRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    DbServiceBook dbServiceBook;

    public List<Copy> getAllCopies() {
        return copyRepository.findAll();
    }

    public Optional<Copy> getCopyById(final Long id) {
        return copyRepository.findById(id);
    }

    public int getAllAvailableCopiesByTitle(final String title) {
        return copyRepository.retrievedCopyQuantityByTitle(title);
    }

    public Copy saveCopy(final Copy copy) {
        Optional<Book> bookOptional = dbServiceBook.getBookByTitle(copy.getBook().getTitle());
        Book book = bookOptional.get();

        copy.setBook(book);

        return copyRepository.save(copy);
    }

    public void deleteCopy(final Long copyId) {
        copyRepository.deleteById(copyId);
    }

    public void updateRentalStatus(Long copyId, RentalStatus rentalStatus) {
        Optional<Copy> optionalCopy = copyRepository.findById(copyId);
        Copy copy = optionalCopy.get();
        copy.setRentalStatus(rentalStatus);
        copyRepository.save(copy);
    }

}