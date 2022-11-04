package com.luma.luma.Repository;

import com.luma.luma.Model.Employee;
import com.luma.luma.Model.Issue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IssueRepository extends CrudRepository<Issue, String> {
    List<Issue> findByEid(Employee eid);
}
