package app.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.domain.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}