package intentoA.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intentoA.demo.model.Sections;

@Repository
public interface SectionsRepository extends JpaRepository<Sections, Integer>{
    
}
