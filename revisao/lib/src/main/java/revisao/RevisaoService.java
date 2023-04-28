package revisao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevisaoService {
	
	@Autowired
	private RevisaoRepository revisaoRepository;
	
	public RevisaoDTO persistValidRevisaoDTO(RevisaoDTO revisaoDTO) {
		if(revisaoDTO !=null && revisaoDTO.getNumero() != null) {
			RevisaoEntity revisaoEntity = new RevisaoEntity(revisaoDTO);
			revisaoRepository.save(revisaoEntity);
		}
		return revisaoDTO;
	}

}
