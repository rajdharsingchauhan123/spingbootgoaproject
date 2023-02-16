package com.example.spingbootgoaproject.module;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private BigInteger phoneNumber;

}
