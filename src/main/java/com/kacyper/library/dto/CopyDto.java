package com.kacyper.library.dto;

import com.kacyper.library.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CopyDto {

    private Long id;
    private Book book;
    private boolean inLibrary;
    private boolean destroyed;
    private boolean rent;

    public CopyDto(Book book, boolean inLibrary, boolean destroyed, boolean rent) {
        this.book = book;
        this.inLibrary = inLibrary;
        this.destroyed = destroyed;
        this.rent = rent;
    }
}
