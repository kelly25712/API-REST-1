package intentoA.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import intentoA.demo.model.Recharge;
import intentoA.demo.repository.RechargeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RechargeService {
    
    @Autowired
    private RechargeRepository reposi;
    
    public List<Recharge> getAll(){
        return reposi.findAll();
    }

    public List<Recharge> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Recharge> recharge = reposi.findAll(pageReq);
		return recharge.getContent();
	}

    public Recharge save(Recharge recharge){
        return reposi.save(recharge);
    }
    public Recharge getByIdRecharge(Integer idRecharge){
        return reposi.findById(idRecharge).get();
    }

    public void delete(Integer idRecharge){
        reposi.deleteById(idRecharge);
    }
}
