package com.luma.luma.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_card_details")
public class Card {

    @EmbeddedId
    private CardId cardid;

    @Column(name = "card_issue_date", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date cid;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @MapsId("eid")
    private Employee eid;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_id")
    @MapsId("lid")
    private Loan lid;

}
