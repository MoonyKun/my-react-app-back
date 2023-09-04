package com.moonykun.myreactappback.repository;

import com.moonykun.myreactappback.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Moonykun
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}