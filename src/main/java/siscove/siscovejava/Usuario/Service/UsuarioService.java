package siscove.siscovejava.Usuario.Service;

import java.util.ArrayList;
import java.util.List;

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

	public EnvelopeResponse<List<UsuarioDto>> getListaUsuarios(){
		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDao.findAll();
		
		List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
		for (Usuario usuario : listaUsuarios) {
			listaUsuariosDto.add(UsuarioDto.build(usuario));
		}
		return new EnvelopeResponse<List<UsuarioDto>>(listaUsuariosDto);
		
	}

	public EnvelopeResponse<List<UsuarioDto>> getListaUsuariosAtivos(){
		List<Usuario> listaUsuariosAtivos = (List<Usuario>) usuarioDao.findAll();
		
		List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
		for (Usuario usuario : listaUsuariosAtivos) {
			if (usuario.getIndAtivo().equals("S")) {
				listaUsuariosDto.add(UsuarioDto.build(usuario));
			}
		}
		return new EnvelopeResponse<List<UsuarioDto>>(listaUsuariosDto);
	}
}