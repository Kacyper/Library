package com.kacyper.library.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Rent")
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Reader_Id")
    private Reader readerId;

    @Column(name = "Rent_Date")
    private LocalDate rentDate;

    @Column(name = "Return_Date")
    private LocalDate returnDate;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Copy_Id")
    private Copy copy;

}
