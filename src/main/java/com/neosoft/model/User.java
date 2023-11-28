package com.neosoft.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailId;
    @OneToMany(mappedBy = "userId")
    private List<Policy> policyList;
    @OneToMany(mappedBy = "userId")
    private List<Nominee> nomineeList;

}
