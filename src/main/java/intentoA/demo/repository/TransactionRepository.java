package intentoA.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import intentoA.demo.model.Transaction;

@Repository
public interface  TransactionRepository extends JpaRepository<Transaction, Integer>{
    
}
