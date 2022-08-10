package siscove.siscovejava.Login.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class LoginDto {

	private int codUsuario;
	private String nmeUsuario;
	private String txtSenha;
	private String nmeUsuarioCompleto;
	private String indLogado;
	private LocalDate dataLogado;
	private String nroTelCelular;
	private String txtEmail;
	private LocalDate dtaInativo;
	private String codDeposito;
	private String codPerfilW;
	private String vlrPorcentagemServico;
	private String vlrPorcentagemVenda;
	private String vlrPorcentagemGerencia;
	private String indAtivo;
	
	public LoginDto() {
		
	}
	
	public LoginDto(int codUsuario, String nmeUsuario, String txtSenha, String nmeUsuarioCompleto, String indLogado, LocalDate dataLogado, String nroTelCelular, String txtEmail, LocalDate dtaInativo, String codDeposito, String codPerfilW, String vlrPorcentagemServico, String vlrPorcentagemVenda, String indAtivo) {
		this.codUsuario = codUsuario;
		this.nmeUsuario = nmeUsuario;
		this.txtSenha = txtSenha;
		this.nmeUsuarioCompleto = nmeUsuarioCompleto;
		this.indLogado = indLogado;
		this.dataLogado = dataLogado;
		this.nroTelCelular = nroTelCelular;
		this.txtEmail = txtEmail;
		this.dtaInativo = dtaInativo;
		this.codDeposito = codDeposito;
		this.codPerfilW = codPerfilW;
		this.vlrPorcentagemServico = vlrPorcentagemServico;
		this.vlrPorcentagemVenda = vlrPorcentagemVenda;
		this.vlrPorcentagemGerencia = vlrPorcentagemGerencia;		
		this.indAtivo = indAtivo;
	}

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

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
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
