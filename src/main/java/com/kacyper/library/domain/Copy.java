package com.kacyper.library.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NamedQuery(
        name = "Copy.retrievedCopyQuantityByTitle",
        query = "SELECT COUNT(book) FROM Copy WHERE book.title = :bookTitle"
)

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @JoinColumn(name = "title")
    private String title;


    @OneToMany(targetEntity = Rent.class, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "copy")
    @JsonIgnore
    private List<Copy> copyList;



    public Copy(Long id, Long bookId, RentalStatus rentalStatus){
        this.rentalStatus = rentalStatus;
    }

//    public Copy(Book book, RentalStatus rentalStatus) {
//        this.book = book;
//        this.rentalStatus = rentalStatus;
//    }
//
//    public Copy(Long id, Book book, RentalStatus rentalStatus) {
//        this.id = id;
//        this.book = book;
//        this.rentalStatus = rentalStatus;
//    }

}
