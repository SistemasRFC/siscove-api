package siscove.siscovejava.Cliente.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_CLIENTE")
public class Cliente {
	
	@Id
	@Column(name="COD_CLIENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codCliente;
	
	@Column(name="DSC_CLIENTE")
	private String dscCliente;
	
	@Column(name="IND_TIPO_CLIENTE")
	private String indTipoCliente;
	
	@Column(name="NRO_CEP")
	private String nroCep;
	
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

	@Column(name="TXT_UNIDADE")
	private String txtUnidade;

	@Column(name="COD_IBGE")
	private String codIbge;

	@Column(name="COD_GIA")
	private String codGia;

	@Column(name="NRO_TELEFONE_CONTATO")
	private String nroTelefoneContato;
	
	@Column(name="NRO_TELEFONE_CELULAR")
	private String nroTelefoneCelular;
	
	@Column(name="NRO_CPF")
	private String nroCpf;
	
	@Column(name="NRO_CNPJ")
	private String nroCnpj;

	@Column(name="NRO_IE")
	private String nroIe;

	@Column(name="COD_CLIENTE_FINAL")
	private Integer codClienteFinal;

	@Column(name="DTA_NASCIMENTO")
	private LocalDate dtaNascimento;

	@Column(name="TXT_EMAIL")
	private String txtEmail;

}

