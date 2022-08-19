package siscove.siscovejava.Login.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Login.Dto.LoginDto;
import siscove.siscovejava.Usuario.Entity.Usuario;
import siscove.siscovejava.Usuario.Repository.UsuarioDao;

@Service
public class LoginService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	
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
			return new EnvelopeResponse<LoginDto>(loginDto, true, "");
		}
	
		return new EnvelopeResponse<LoginDto>(null, false, "Sem registros!");
	}
}
