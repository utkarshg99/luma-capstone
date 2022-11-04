package com.luma.luma.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_master")
public class Employee {

    @Id
    @Column(name = "employee_id", nullable = false, length = 6)
    private String id;

    @Column(name = "employee_name", length = 20)
    private String name;

    @Column(name = "designation", length = 25)
    private String designation;

    @Column(name = "department", length = 25)
    private String department;

    @Column(name = "gender", length = 1, columnDefinition = "CHAR")
    private char gender;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "date_of_joining", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date doj;

    @OneToMany(mappedBy = "e_id")
    private List<Issue> issues;

    @OneToMany(mappedBy = "e_id")
    private List<Card> cards;
}
