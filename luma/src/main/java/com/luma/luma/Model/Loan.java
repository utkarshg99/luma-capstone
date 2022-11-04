package com.luma.luma.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "loan_id", nullable = false, length = 6)
    private String id;

    @Column(name = "loan_type", length = 20)
    private String type;

    @Column(name = "duration_in_years", length = 2, columnDefinition = "INT")
    private int duration;

    @OneToMany(mappedBy = "l_id")
    private List<Card> cards;
}
