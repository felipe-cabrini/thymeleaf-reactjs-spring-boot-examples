package br.com.fiap.repository;

import br.com.fiap.usercrudapi.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
