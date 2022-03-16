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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "Reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Reader_Id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "First_Name")
    private String firstName;

    @NotNull
    @Column(name = "Last_Name")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "Account_Creation_Date")
    private LocalDate accountCreationDate;

    @OneToMany(targetEntity = Rent.class, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "readerId")
    @JsonIgnore
    private List<Rent> rentList;

    public Reader(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreationDate = LocalDate.now();
    }

}
