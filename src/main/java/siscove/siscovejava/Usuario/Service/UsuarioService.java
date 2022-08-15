package siscove.siscovejava.Usuario.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Usuario.Dto.UsuarioDto;
import siscove.siscovejava.Usuario.Entity.Usuario;
import siscove.siscovejava.Usuario.Repository.UsuarioDao;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public EnvelopeResponse<UsuarioDto> salvar(UsuarioDto usuarioDto) {

		Usuario usuario = usuarioDao.save(UsuarioDto.parse(usuarioDto));

		usuarioDto.setCodUsuario(usuario.getCodUsuario());

		return new EnvelopeResponse<UsuarioDto>(usuarioDto);
	}
}
