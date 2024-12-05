package intentoA.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intentoA.demo.model.CVVcode;

@Repository
public interface CVVcodeRepository extends JpaRepository<CVVcode, Integer>{
    
}
