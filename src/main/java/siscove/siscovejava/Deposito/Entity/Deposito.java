package siscove.siscovejava.Deposito.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_DEPOSITO")
public class Deposito {

	@Id
	@Column(name="COD_DEPOSITO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codDeposito;
	
	@Column(name="DSC_DEPOSITO")
	private String dscDeposito;
	
	@Column(name="COD_CLIENTE_FINAL")
	private Integer codClienteFinal;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;
}

