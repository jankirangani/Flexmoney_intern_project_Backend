package com.project.flexmoney_intern_project.Repository;

import com.project.flexmoney_intern_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
