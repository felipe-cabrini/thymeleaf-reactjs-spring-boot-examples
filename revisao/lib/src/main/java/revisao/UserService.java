package revisao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public void save(User user) {
		userRepository.save(user);		
	}

	public Optional<User> findUserById(long id) {
		return userRepository.findById(id);
	}

	public void delete(User user) {
		userRepository.delete(user);		
	}

}
