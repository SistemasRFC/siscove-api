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
}