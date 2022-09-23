package siscove.siscovejava.Usuario.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Perfil.Entity.Perfil;

@NoArgsConstructor
@Data
@Entity (name = "SE_USUARIO")
public class Usuario{

	@Id
	@Column(name="COD_USUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codUsuario;
	
	@Column(name="NME_USUARIO")
	private String nmeUsuario;
	
	@Column(name="TXT_SENHA_W")
	private String txtSenhaW;
	
	@Column(name="NME_USUARIO_COMPLETO")
	private String nmeUsuarioCompleto;
	
	@Column(name="IND_LOGADO")
	private String indLogado;
	
	@Column(name="DATA_LOGADO")
	private LocalDate dataLogado;

	@Column(name="NRO_TEL_CELULAR")
	private String nroTelCelular;
	
	@Column(name="TXT_EMAIL")
	private String txtEmail;
	
	@Column(name="DTA_INATIVO")
	private LocalDate dtaInativo;
	
	@Column(name="COD_DEPOSITO")
	private Integer codDeposito;
	
	@ManyToOne
	@JoinColumn(name="COD_PERFIL_W", insertable = true, updatable = true)
	private Perfil perfil;

	
	@Column(name="VLR_PORCENTAGEM_SERVICO")
	private Float vlrPorcentagemServico;
	
	@Column(name="VLR_PORCENTAGEM_VENDA")
	private Float vlrPorcentagemVenda;
	
	@Column(name="VLR_PORCENTAGEM_GERENCIA")
	private Float vlrPorcentagemGerencia;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;

}

