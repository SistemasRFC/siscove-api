package siscove.siscovejava.ClienteFinal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_CLIENTE_FINAL")
public class ClienteFinal {

	@Id
	@Column(name="COD_CLIENTE_FINAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codClienteFinal;
	
	@Column(name="NME_CLIENTE_FINAL")
	private String nmeClienteFinal;
	
	@Column(name="DSC_CAMINHO_LOGO")
	private String dscCaminhoLogo;
	
	@Column(name="IND_TIPO_CLIENTE")
	private String indTipoCliente;
	
	@Column(name="NRO_CPF")
	private Integer nroCpf;
	
	@Column(name="NRO_CNPJ")
	private Integer nroCnpj;
	
	
	@Column(name="IND_ATIVO")
	private String indAtivo;
}

