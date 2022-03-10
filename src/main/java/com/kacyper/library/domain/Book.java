package com.kacyper.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NamedQuery(name = "Book.retrieveRequestedTitle",
                query = "FROM Books WHERE title = :Title")

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "Books")
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
    private LocalDate releaseDate;

    @OneToMany(targetEntity = Copy.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "book")
    @JsonIgnore
    private List<Copy> copyList;

    public Book(Long id, String title, String author, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }
}
