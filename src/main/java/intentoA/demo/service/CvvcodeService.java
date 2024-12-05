package intentoA.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import intentoA.demo.model.CVVcode;
import intentoA.demo.repository.CVVcodeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class CvvcodeService {

    @Autowired
    private CVVcodeRepository repos;
    
    public List<CVVcode> getAll(){
        return repos.findAll();
    }

    public List<CVVcode>getAll(int page, int pageSize){
        PageRequest pageReq = PageRequest.of(page, pageSize);
        Page<CVVcode> cvvcode = repos.findAll(pageReq);
        return cvvcode.getContent();
    }

    public void save(CVVcode cvvcode){
        repos.save(cvvcode);
    }
    public CVVcode getByIdCVVcode(Integer idcvv){
        return repos.findById(idcvv).get();
    }

    public void delete(Integer idcvv){
        repos.deleteById(idcvv);
    }
}
