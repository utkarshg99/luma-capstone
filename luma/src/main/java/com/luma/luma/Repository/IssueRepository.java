package com.luma.luma.Repository;

import com.luma.luma.Model.Issue;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Integer> {

}
