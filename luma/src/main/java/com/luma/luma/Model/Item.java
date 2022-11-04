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
@Table(name = "item_master")
public class Item {

    @Id
    @Column(name = "item_id", nullable = false, length = 6)
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

    @OneToMany(mappedBy = "i_id")
    private List<Issue> issues;
}
