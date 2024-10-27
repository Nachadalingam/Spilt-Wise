package SplitWise.example.SplitWise.repository;

import SplitWise.example.SplitWise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, User>{
    User findByEmail(String email);
}
