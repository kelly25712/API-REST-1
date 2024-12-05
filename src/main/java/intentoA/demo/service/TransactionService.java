package intentoA.demo.service;

import intentoA.demo.model.Transaction;
import intentoA.demo.repository.TransactionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionService {
    @Autowired
	private TransactionRepository reposi;

	public List<Transaction> getAll() {
		return reposi.findAll();
	}

	public List<Transaction> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Transaction> transaction = reposi.findAll(pageReq);
		return transaction.getContent();
	} 

	public Transaction save(Transaction transaction) {
		return reposi.save(transaction);
	}

	public Transaction getByIdTransaction(Integer idTransaction) {
		return reposi.findById(idTransaction).get();
	}

	public void delete(Integer idTransaction) {
		reposi.deleteById(idTransaction);
	}
    
}
