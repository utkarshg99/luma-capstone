package com.luma.luma.Model;

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
@Table(name = "employee_issue_details")
public class Issue {

    @Id
    @Column(name = "issue_id", nullable = false, length = 6)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee e_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item i_id;

    @Column(name = "issue_date", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date issue_date;
}
