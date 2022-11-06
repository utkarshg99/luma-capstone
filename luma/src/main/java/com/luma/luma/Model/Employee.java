package com.luma.luma.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.luma.luma.Utility.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @GenericGenerator(
            name = "employee_seq",
            strategy = "com.luma.luma.Utility.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "E"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @Column(name = "employee_id")
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

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "eid")
    private List<Issue> issues;

    @JsonManagedReference
    @OneToMany(mappedBy = "eid")
    private List<Card> cards;
}
