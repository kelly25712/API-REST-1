package intentoA.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import intentoA.demo.model.RechargeCompanies;

@Repository
public interface  CompanyRepository extends JpaRepository<RechargeCompanies, Integer>{
    
}
