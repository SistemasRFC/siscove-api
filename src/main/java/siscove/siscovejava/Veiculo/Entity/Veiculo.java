package siscove.siscovejava.Veiculo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_VEICULOS")
public class Veiculo {
	
	@Id
	@Column(name="COD_VEICULO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codVeiculo;
	
	@Column(name="DSC_VEICULO")
	private String dscVeiculo;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;

}
