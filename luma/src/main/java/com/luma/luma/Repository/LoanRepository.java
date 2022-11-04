package com.luma.luma.Repository;

import com.luma.luma.Model.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, String> {
    List<Loan> findByType(String type);
}
