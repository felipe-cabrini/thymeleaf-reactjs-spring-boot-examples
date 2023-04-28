package revisao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevisaoController {

	@Autowired
	private RevisaoService revisaoService;
	
	
	@PostMapping("/hello")
	public ResponseEntity<RevisaoDTO> helloWorld(@RequestBody RevisaoDTO revisaoDto) {
		
		RevisaoDTO result = revisaoService.persistValidRevisaoDTO(revisaoDto);
		return ResponseEntity.ok(result);
	}
}
