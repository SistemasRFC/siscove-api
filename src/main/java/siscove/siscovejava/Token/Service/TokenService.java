package siscove.siscovejava.Token.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Entity.Token;
import siscove.siscovejava.Token.Repository.TokenDao;

@Service
public class TokenService {

	@Autowired
	private TokenDao tokenDao;

	public EnvelopeResponse<TokenDto> salvar(TokenDto tokenDto) {

		Token token = tokenDao.save(TokenDto.parse(tokenDto));

		tokenDto.setCodToken(token.getCodToken());

		return new EnvelopeResponse<TokenDto>(tokenDto);
	}
	
	public EnvelopeResponse<TokenDto> getByToken(String txtToken){
		
		Token token = tokenDao.getByTxtToken(txtToken);
		
		if(token==null) {
			return new EnvelopeResponse<TokenDto>(null);
		}
		TokenDto tokenDto = TokenDto.build(token);
		return new EnvelopeResponse<TokenDto>(tokenDto);
	}
	
	public void excluiTokenByTxtToken(String txtToken) {
		
		Token token = tokenDao.getByTxtToken(txtToken);
		
		tokenDao.delete(token);
	}
	
	public void excluiTokenByCodUsuario(Integer codUsuario){
		Token token = tokenDao.getByCodUsuario(codUsuario);
		
		tokenDao.delete(token);		
	}
	
	public void excluiTokensInvalidos(Integer tempoLimite) {
		tokenDao.excluiTokensInvalidos(tempoLimite);
	}
}