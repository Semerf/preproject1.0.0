package main.repository;

import main.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    void deleteAll();

    User deleteUserById(Integer id);

    User findUserById(Integer id);
}
