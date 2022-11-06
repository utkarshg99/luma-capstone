package com.luma.luma.Repository;

import com.luma.luma.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, String> {
    List<Loan> findByType(String type);
}
