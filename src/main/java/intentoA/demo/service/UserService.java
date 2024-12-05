package intentoA.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import intentoA.demo.model.User;
import intentoA.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
    @Autowired
	private UserRepository repo;


	public List<User> getAll() {
		return repo.findAll();
	}

	public List<User> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<User> user = repo.findAll(pageReq);
		return user.getContent();
	}

	public void save(User user) {
		repo.save(user);
	}

	public User getByIdUser(Integer idUser) {
		return repo.findById(idUser).get();
	}

	public void delete(Integer idUser) {
		repo.deleteById(idUser);
	}
	
}
