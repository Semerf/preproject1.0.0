package main.repository;

import main.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    void deleteAll();

    void deleteById(Integer id);

    User findUserById(Integer id);

    User findByUsername(String username);
}
