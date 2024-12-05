package intentoA.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import intentoA.demo.model.Account;
import intentoA.demo.repository.AccountNumberRepository;
import intentoA.demo.repository.AccountsRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountsService {
@Autowired
	private AccountsRepository repo;
	private AccountNumberRepository repository;

	public Account getByAccountNumber(Long accountNumber) {
        return repository.findByAccountNumber(accountNumber);
    }

	public List<Account> getAll() {
		return repo.findAll();
	}

	public List<Account> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Account> accounts = repo.findAll(pageReq);
		return accounts.getContent();
	}

	public Account save(Account account) {
		return repo.save(account);
	}

	public Account getById(Integer idAccount) {
		return repo.findById(idAccount).get();
	}


	public void delete(Integer idAccount) {
		repo.deleteById(idAccount);
	}
	
	
}