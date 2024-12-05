package intentoA.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import intentoA.demo.model.Sections;
import intentoA.demo.repository.SectionsRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SectionsService {
    @Autowired
    private SectionsRepository reposit;
    
    public List<Sections> getAll(){
        return reposit.findAll();
    }

    public List<Sections> getAllPagination(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Sections> sections = reposit.findAll(pageReq);
		return sections.getContent();
	} 

    public Sections save(Sections sections){
        return reposit.save(sections);
    }
    public Sections getById(Integer idSections){
        return reposit.findById(idSections).get();
    }

    public void delete(Integer idSections){
        reposit.deleteById(idSections);
    }
}

