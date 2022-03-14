package com.kacyper.library.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NamedQuery(
        name = "Copy.retrievedCopyQuantityByTitle",
        query = "SELECT COUNT(book) FROM Copy WHERE book.title = :bookTitle"
)

@NoArgsConstructor
@Data
@Entity(name = "Copy")
public class Copy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "Copy_Id", unique = true)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Book_Id")
    private Book book;

    @Column(name = "Status")
    private RentalStatus rentalStatus;

    @OneToMany(targetEntity = Rent.class, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "copy")
    @JsonIgnore
    private List<Copy> copyList;

    public Copy(RentalStatus rentalStatus){
        this.rentalStatus = rentalStatus;
    }

    public Copy(Book book, RentalStatus rentalStatus) {
        this.book = book;
        this.rentalStatus = rentalStatus;
    }

    public Copy(Long id, Book book, RentalStatus rentalStatus) {
        this.id = id;
        this.book = book;
        this.rentalStatus = rentalStatus;
    }
}

//    @NotNull
//    @Column(name = "In_Library")
//    private boolean inLibrary;
//
//    @NotNull
//    @Column(name = "Destroyed")
//    private boolean destroyed;
//
//    @NotNull
//    @Column(name = "Rent")
//    private boolean rent;

//    @OneToOne(targetEntity = Rent.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "copy")
//    pubList<Rent> rentList;

//    public Copy(Long id, Book book, boolean inLibrary, boolean rent, boolean destroyed) {
//        this.book = book;
//        this.destroyed = false;
//        this.rent = false;
//        this.inLibrary = false;
//    }
