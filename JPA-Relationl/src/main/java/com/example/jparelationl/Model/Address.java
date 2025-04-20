package com.example.jparelationl.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = " varchar(10) not null ")
    private String area;

    @NotEmpty
    @Column(columnDefinition = " varchar(10) not null ")
    private String street;

    @NotEmpty
    @Column(columnDefinition = " varchar(10) not null ")
    private String building_number;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;


}
