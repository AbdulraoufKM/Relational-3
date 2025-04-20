package com.example.jparelationl.DTO;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @Id
    private Integer teacher_id;

    @NotEmpty
    @Column(columnDefinition = " varchar(10) not null ")
    private String area;

    @NotEmpty
    @Column(columnDefinition = " varchar(10) not null ")
    private String street;

    @NotEmpty
    @Column(columnDefinition = " varchar(10) not null ")
    private String building_number;

}
