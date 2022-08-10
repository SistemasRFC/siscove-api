package siscove.siscovejava.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Login.Dto.LoginDto;
import siscove.siscovejava.Login.Entity.Usuario.Usuario;
import siscove.siscovejava.Login.Respositry.UsuarioDao;

@Service
public class LoginService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	
	public EnvelopeResponse<Boolean> validaLogin(LoginDto loginDto) {
		
		if (loginDto.getNmeUsuario()==null || loginDto.getNmeUsuario()=="") {
			return new EnvelopeResponse<Boolean>(false, false, "Favor preencher o nome do usuário!");
		}
		
		if (loginDto.getTxtSenha()==null || loginDto.getTxtSenha()=="") {
			return new EnvelopeResponse<Boolean>(false, false, "Favor preencher a senha do usuário!");
		}
		
		Usuario usuario= usuarioDao.usuarioLogin(loginDto.getNmeUsuario(), loginDto.getTxtSenha());
		
		if (null!=usuario && usuario.getCodUsuario()>0) {
			loginDto.setCodUsuario(usuario.getCodUsuario());
			return new EnvelopeResponse<Boolean>(true, true, "");
		}
	
		return new EnvelopeResponse<Boolean>(false, false, "Sem registros!");
	}
}
