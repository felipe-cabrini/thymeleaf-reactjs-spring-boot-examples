package revisao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RevisaoRepository extends JpaRepository<RevisaoEntity,Integer>{ 

	
}
