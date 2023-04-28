package revisao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "revisao")
public class RevisaoEntity {

	
	
	
	public RevisaoEntity() {
	}

	public RevisaoEntity(RevisaoDTO revisaoDto) {
		this.numero = revisaoDto.getNumero();
		this.texto = revisaoDto.getTexto();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "texto_revisao")
	private String texto;
	
	@Column(name = "numero_revisao")
	private Integer numero;
	
}
