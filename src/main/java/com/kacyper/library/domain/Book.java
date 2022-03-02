package com.kacyper.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "Book")
public class Book {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "Book_Id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "Title", unique = true)
    private String title;

    @NotNull
    @Column(name = "Author")
    private String author;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "Release_Date")
    private Integer releaseDate;

    //One to many to copy class

}
