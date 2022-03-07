package com.kacyper.library.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NamedQuery(
        name = "Copy.retrievedCopyQuantityByTitle",
        query = "SELECT COUNT(book) FROM Copy WHERE book.title = :bookTitle"
)

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Copy")
public class Copy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "Copy_Id", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Title")
    private Book book;

    @NotNull
    @Column(name = "In_Library")
    private boolean inLibrary;

    @NotNull
    @Column(name = "Destroyed")
    private boolean destroyed;

    @NotNull
    @Column(name = "Rent")
    private boolean rent;

    @OneToMany(targetEntity = Rent.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "copy")
    private List<Rent> rentList;

    public Copy(Book book, boolean inLibrary, boolean destroyed, boolean rent) {
        this.book = book;
        this.destroyed = false;
        this.rent = false;
        this.inLibrary = false;
    }
}
