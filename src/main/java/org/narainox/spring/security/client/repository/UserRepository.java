package org.narainox.spring.security.client.repository;

import org.narainox.spring.security.client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
