package siscove.siscovejava.Login.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
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
	private Float vlrPorcentagemServico;
	private Float vlrPorcentagemVenda;
	private Float vlrPorcentagemGerencia;
	private String indAtivo;
	
}
