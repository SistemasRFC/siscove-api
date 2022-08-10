package siscove.siscovejava.Login.Entity.Usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "SE_USUARIO")
public class Usuario{

	@Id
	@Column(name="COD_USUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codUsuario;
	
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
	private String codDeposito;
	
	@Column(name="COD_PERFIL_W")
	private String codPerfilW;
	
	@Column(name="VLR_PORCENTAGEM_SERVICO")
	private String vlrPorcentagemServico;
	
	@Column(name="VLR_PORCENTAGEM_VENDA")
	private String vlrPorcentagemVenda;
	
	@Column(name="VLR_PORCENTAGEM_GERENCIA")
	private String vlrPorcentagemGerencia;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNmeUsuario() {
		return nmeUsuario;
	}

	public void setNmeUsuario(String nmeUsuario) {
		this.nmeUsuario = nmeUsuario;
	}

	public String getTxtSenhaW() {
		return txtSenhaW;
	}

	public void setTxtSenhaW(String txtSenhaW) {
		this.txtSenhaW = txtSenhaW;
	}

	public String getNmeUsuarioCompleto() {
		return nmeUsuarioCompleto;
	}

	public void setNmeUsuarioCompleto(String nmeUsuarioCompleto) {
		this.nmeUsuarioCompleto = nmeUsuarioCompleto;
	}

	public String getIndLogado() {
		return indLogado;
	}

	public void setIndLogado(String indLogado) {
		this.indLogado = indLogado;
	}

	public LocalDate getDataLogado() {
		return dataLogado;
	}

	public void setDataLogado(LocalDate dataLogado) {
		this.dataLogado = dataLogado;
	}

	public String getNroTelCelular() {
		return nroTelCelular;
	}

	public void setNroTelCelular(String nroTelCelular) {
		this.nroTelCelular = nroTelCelular;
	}

	public String getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}

	public LocalDate getDtaInativo() {
		return dtaInativo;
	}

	public void setDtaInativo(LocalDate dtaInativo) {
		this.dtaInativo = dtaInativo;
	}

	public String getCodDeposito() {
		return codDeposito;
	}

	public void setCodDeposito(String codDeposito) {
		this.codDeposito = codDeposito;
	}

	public String getCodPerfilW() {
		return codPerfilW;
	}

	public void setCodPerfilW(String codPerfilW) {
		this.codPerfilW = codPerfilW;
	}

	public String getVlrPorcentagemServico() {
		return vlrPorcentagemServico;
	}

	public void setVlrPorcentagemServico(String vlrPorcentagemServico) {
		this.vlrPorcentagemServico = vlrPorcentagemServico;
	}

	public String getVlrPorcentagemVenda() {
		return vlrPorcentagemVenda;
	}

	public void setVlrPorcentagemVenda(String vlrPorcentagemVenda) {
		this.vlrPorcentagemVenda = vlrPorcentagemVenda;
	}

	public String getVlrPorcentagemGerencia() {
		return vlrPorcentagemGerencia;
	}

	public void setVlrPorcentagemGerencia(String vlrPorcentagemGerencia) {
		this.vlrPorcentagemGerencia = vlrPorcentagemGerencia;
	}

	public String getIndAtivo() {
		return indAtivo;
	}

	public void setIndAtivo(String indAtivo) {
		this.indAtivo = indAtivo;
	}

	
}
