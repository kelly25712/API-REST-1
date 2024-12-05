package intentoA.demo.service;

import intentoA.demo.model.RetreatCL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import intentoA.demo.repository.RetreatCLRepository;

@Service
public class RetreatCLService {

    @Autowired
    private RetreatCLRepository repository;

    public List<RetreatCL> getAll(){
        return  repository.findAll();
    }
       public List<RetreatCL> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<RetreatCL> retreatcl = repository.findAll(pageReq);
		return retreatcl.getContent();
	}

    public RetreatCL save(RetreatCL retreatCL) {
		return repository.save(retreatCL);
	}

	public RetreatCL getByIdRetreat(Integer idRetreatCL) {
		return repository.findById(idRetreatCL).get();
	}

	public void delete(Integer idRetreatCL) {
		repository.deleteById(idRetreatCL);
	}
	
}