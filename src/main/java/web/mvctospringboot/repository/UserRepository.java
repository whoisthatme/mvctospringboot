package web.mvctospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.mvctospringboot.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

}
