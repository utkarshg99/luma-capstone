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
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_master")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @GenericGenerator(
            name = "item_seq",
            strategy = "com.luma.luma.Utility.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "I"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @Column(name = "item_id")
    private String id;

    @Column(name = "item_description", length = 25)
    private String description;

    @Column(name = "issue_status", length = 1, columnDefinition = "CHAR")
    private char status;

    @Column(name = "item_make", length = 25)
    private String make;

    @Column(name = "item_category", length = 20)
    private String category;

    @Column(name = "item_valuation", length = 6, columnDefinition = "INT")
    private int valuation;

    @JsonManagedReference
    @OneToMany(mappedBy = "iid")
    private List<Issue> issues;
}
