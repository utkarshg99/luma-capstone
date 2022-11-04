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
@Table(name = "loan_card_master")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
    @GenericGenerator(
            name = "loan_seq",
            strategy = "com.luma.luma.Utility.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "L"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @Column(name = "loan_id")
    private String id;

    @Column(name = "loan_type", length = 20)
    private String type;

    @Column(name = "duration_in_years", length = 2, columnDefinition = "INT")
    private int duration;

    @JsonManagedReference
    @OneToMany(mappedBy = "lid")
    private List<Card> cards;
}
