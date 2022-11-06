package com.luma.luma.Repository;

import com.luma.luma.Model.Card;
import com.luma.luma.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, String> {
    List<Card> findByEid(Employee eid);
}
