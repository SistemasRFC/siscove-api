package siscove.siscovejava.Marca.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "EN_MARCA")
public class Marca {

	@Id
	@Column(name = "COD_MARCA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codMarca;
	
	@Column(name = "DSC_MARCA")
	private String dscMarca;
	
	@Column(name = "COD_CLIENTE_FINAL")
	private Integer codClienteFinal;
	
	@Column(name = "IND_ATIVA")
	private String indAtiva;
}