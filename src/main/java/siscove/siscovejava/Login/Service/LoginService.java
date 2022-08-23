package siscove.siscovejava.Login.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Login.Dto.LoginDto;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Entity.Token;
import siscove.siscovejava.Token.Repository.TokenDao;
import siscove.siscovejava.Token.Service.TokenService;
import siscove.siscovejava.Usuario.Entity.Usuario;
import siscove.siscovejava.Usuario.Repository.UsuarioDao;

@Slf4j
@Service
public class LoginService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private TokenService tokenService;
	
	public EnvelopeResponse<LoginDto> validaLogin(LoginDto loginDto) throws UnsupportedEncodingException {
		
		if (loginDto.getNmeUsuario()==null || loginDto.getNmeUsuario()=="") {
			return new EnvelopeResponse<LoginDto>(null, false, "Favor preencher o nome do usuário!");
		}
		
		if (loginDto.getTxtSenha()==null || loginDto.getTxtSenha()=="") {
			return new EnvelopeResponse<LoginDto>(null, false, "Favor preencher a senha do usuário!");
		}
		
        byte[] decodedValue = Base64.getEncoder().encode(loginDto.getTxtSenha().getBytes());
        String senhaEncriptada = new String(decodedValue, StandardCharsets.UTF_8.toString());
		
		Usuario usuario= usuarioDao.usuarioLogin(loginDto.getNmeUsuario(), senhaEncriptada);
		
		if (null!=usuario && usuario.getCodUsuario()>0) {
			loginDto.setCodUsuario(usuario.getCodUsuario());
			TokenDto tokenDto = this.salvarToken(loginDto);
			loginDto.setTxtToken(tokenDto.getTxtToken());
			return new EnvelopeResponse<LoginDto>(loginDto, true, "");
		}
	
		return new EnvelopeResponse<LoginDto>(null, false, "Sem registros!");
	}
	
	private TokenDto salvarToken(LoginDto loginDto) {
		try {
			MessageDigest m;
			m = MessageDigest.getInstance("SHA-256");
			m.update((LocalDateTime.now().toString()+loginDto.getNmeUsuario()+":"+loginDto.getTxtSenha()).getBytes("UTF-8"));
			byte[] hash = m.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : hash) {
				sb.append(String.format("%02x", b));
			}
			
			TokenDto tokenDto = new TokenDto(null, sb.toString(), LocalDateTime.now(), loginDto.getCodUsuario());
			
			return tokenService.salvar(tokenDto).getObjeto();
		} catch (NoSuchAlgorithmException e) {
			log.info(e.getMessage());
			return null;
		} catch (UnsupportedEncodingException uee) {
			log.info(uee.getMessage());
			return null;
		}
	}
}
