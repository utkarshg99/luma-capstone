package com.luma.luma.Repository;

import com.luma.luma.Model.Employee;
import com.luma.luma.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Employee> {

}
