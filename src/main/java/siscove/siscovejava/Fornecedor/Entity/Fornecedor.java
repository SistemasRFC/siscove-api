package siscove.siscovejava.Fornecedor.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_FORNECEDOR")
public class Fornecedor {
	
	@Id
	@Column(name="COD_FORNECEDOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codFornecedor;
	
	@Column(name="DSC_FORNECEDOR")
	private String dscFornecedor;
	
	@Column(name="NRO_TELEFONE")
	private String nroTelefone;
	
	@Column(name="TXT_OBS")
	private String txtObs;
	
	@Column(name="COD_CLIENTE_FINAL")
	private Integer codClienteFinal;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;
	
	@Column(name="NRO_CNPJ")
	private String nroCnpj;

	@Column(name="NRO_IE")
	private String nroIe;
	
	@Column(name="TXT_LOGRADOURO")
	private String txtLogradouro;
	
	@Column(name="TXT_COMPLEMENTO")
	private String txtComplemento;

	@Column(name="NME_BAIRRO")
	private String nmeBairro;
	
	@Column(name="TXT_LOCALIDADE")
	private String txtLocalidade;
	
	@Column(name="SGL_UF")
	private String sglUf;

	@Column(name="NRO_CEP")
	private String nroCep;

}

