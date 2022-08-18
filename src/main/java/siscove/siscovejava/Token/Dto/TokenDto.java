package siscove.siscovejava.Token.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Token.Entity.Token;
import siscove.siscovejava.Usuario.Entity.Usuario;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenDto {

	private Integer codToken;
	private String txtToken;
	private LocalDate dtaToken;
	private Integer codUsuario;

	public static Token parse(TokenDto tokenDto) {
		Token token = new Token();
		token.setCodToken(tokenDto.getCodToken());
		token.setTxtToken(tokenDto.getTxtToken());
		token.setDtaToken(tokenDto.getDtaToken());
		
		Usuario usuario= new Usuario();
		usuario.setCodUsuario(tokenDto.getCodUsuario());
		token.setUsuario(usuario);	
		return token;
	}
}
