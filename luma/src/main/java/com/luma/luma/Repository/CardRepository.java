package com.luma.luma.Repository;

import com.luma.luma.Model.Card;
import com.luma.luma.Model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, String> {
    List<Card> findByEid(Employee eid);
}
