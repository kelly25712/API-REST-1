package intentoA.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import intentoA.demo.model.Account;
 
@Repository
public interface AccountsRepository extends JpaRepository<Account, Integer>{

    //@Query(value = "SELECT * FROM accounts WHERE balance = :balance", nativeQuery = true)
    //List<AccountsModel> getAccountByBalance(@Param("balance") Float balance);

    //@Query(value = "SELECT f FROM AccountsModel am WHERE am.balance = :balance")
    //List<AccountsModel> getAccountByBalanceJPQL(@Param("balance") Float balance);

} 

