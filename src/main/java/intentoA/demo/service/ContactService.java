package intentoA.demo.service;
import  java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import intentoA.demo.model.Contact;
import intentoA.demo.repository.ContacRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContactService {
    @Autowired
	private ContacRepository repos;

	public List<Contact> getAll() {
		return repos.findAll();
	}

	public List<Contact>getALL(int page, int pageSize){
        PageRequest pageReq = PageRequest.of(page, pageSize);
        Page<Contact> contact = repos.findAll(pageReq);
        return contact.getContent();
    }

	public Contact save(Contact contact) {
		return repos.save(contact);
	}

	public Contact getByIdContact(Integer idContact) {
		return repos.findById(idContact).get();
	}

	public void delete(Integer idContact) {
		repos.deleteById(idContact);
	}

	public List<Contact> getContactsByName(String name) {
		return repos.getContactsByName(name);
		//return repos.getFabricsByCompositionJPQL(name);
	}
	
}
