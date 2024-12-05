package intentoA.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intentoA.demo.model.RetreatCL;
 
@Repository
public interface RetreatCLRepository extends JpaRepository<RetreatCL, Integer>{

    
} 

