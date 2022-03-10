package com.kacyper.library.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity(name = "Rent")
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Reader_Id")
    private Reader reader;

    @Column(name = "Rent_Date")
    private LocalDate rentDate;

    @Column(name = "Return_Date")
    private LocalDate returnDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Copy_Id")
    private Copy copy;

    public Rent(Reader reader, LocalDate rentDate, LocalDate returnDate, Copy copy) {
        this.reader = reader;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.copy = copy;
    }

    public Rent(Long id, Copy copy, Reader reader, LocalDate rentDate, LocalDate returnDate) {
        this.id = id;
        this.copy = copy;
        this.reader = reader;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}
