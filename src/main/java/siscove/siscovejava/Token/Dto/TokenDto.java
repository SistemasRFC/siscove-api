package siscove.siscovejava.Token.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.ClienteFinal.Entity.ClienteFinal;
import siscove.siscovejava.Token.Entity.Token;
import siscove.siscovejava.Usuario.Entity.Usuario;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenDto {

	private Integer codToken;
	private String txtToken;
	private LocalDateTime dtaToken;
	private Integer codUsuario;
	private Integer codClienteFinal;

	public static Token parse(TokenDto tokenDto) {
		Token token = new Token();
		token.setCodToken(tokenDto.getCodToken());
		token.setTxtToken(tokenDto.getTxtToken());
		token.setDtaToken(tokenDto.getDtaToken());
		
		Usuario usuario= new Usuario();
		usuario.setCodUsuario(tokenDto.getCodUsuario());
		token.setUsuario(usuario);
		
		ClienteFinal clienteFinal = new ClienteFinal();
		clienteFinal.setCodClienteFinal(tokenDto.getCodClienteFinal());
		token.setClienteFinal(clienteFinal);
		
		return token;
	}
	
	public static TokenDto build(Token token) {
		if (null==token.getClienteFinal()) {
			ClienteFinal clienteFinal = new ClienteFinal();
			token.setClienteFinal(clienteFinal);
		}
		
		return new TokenDto(token.getCodToken(), token.getTxtToken(), token.getDtaToken(), token.getUsuario().getCodUsuario(), token.getClienteFinal().getCodClienteFinal());
	}
}
