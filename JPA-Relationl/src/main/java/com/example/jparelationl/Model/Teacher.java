package com.example.jparelationl.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = " varchar(10) not null ")
    private String name;

    @NotEmpty
    @Email
    @Column(columnDefinition = " varchar(20) not null ")
    private String email;

    @NotNull
    @Positive
    @Column(columnDefinition = " int not null ")
    private Integer age;

    @NotNull
    @PositiveOrZero
    @Column(columnDefinition = " int not null ")
    private Integer salary;



    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;




    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;

}
