package siscove.siscovejava.Perfil.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "SE_PERFIL")
public class Perfil {

	@Id
	@Column(name="COD_PERFIL_W")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPerfilW;
	
	@Column(name="DSC_PERFIL_W")
	private String dscPerfilW;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;
}
