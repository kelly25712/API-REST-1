package intentoA.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import intentoA.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
    
}
