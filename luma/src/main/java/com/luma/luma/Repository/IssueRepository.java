package com.luma.luma.Repository;

import com.luma.luma.Model.Employee;
import com.luma.luma.Model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, String> {
    List<Issue> findByEid(Employee eid);
}
