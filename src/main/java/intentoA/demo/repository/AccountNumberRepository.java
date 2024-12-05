package intentoA.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intentoA.demo.model.Account;

@Repository
public interface  AccountNumberRepository extends JpaRepository<Account, Long>{

   // Account findByAccountNumber(Long accountNumber);

    public Account findByAccountNumber(Long accountNumber);
    
}
