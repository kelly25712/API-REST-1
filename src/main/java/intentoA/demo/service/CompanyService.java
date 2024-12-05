package intentoA.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import intentoA.demo.model.RechargeCompanies;
import intentoA.demo.repository.CompanyRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompanyService {
   @Autowired
	private CompanyRepository reposit;

	public List<RechargeCompanies> getAll() {
		return reposit.findAll();
	}

	public List<RechargeCompanies>getALL(int page, int pageSize){
        PageRequest pageReq = PageRequest.of(page, pageSize);
        Page<RechargeCompanies> rechargeCompanies = reposit.findAll(pageReq);
        return rechargeCompanies.getContent();
    }

	public void save(RechargeCompanies rechargeCompanies) {
		reposit.save(rechargeCompanies);
	}

	public RechargeCompanies getByIdCompany(Integer idCompany) {
		return reposit.findById(idCompany).get();
	}

	public void delete(Integer idCompany) {
		reposit.deleteById(idCompany);
	}
}
