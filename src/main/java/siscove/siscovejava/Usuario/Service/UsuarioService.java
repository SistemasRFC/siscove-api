 package siscove.siscovejava.Usuario.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

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
		Usuario usuario = UsuarioDto.parse(usuarioDto);

		if (usuarioDto.getCodUsuario() != null) {
			Optional<Usuario> usuarioSenha = usuarioDao.findById(usuarioDto.getCodUsuario());
			usuario.setTxtSenhaW(usuarioSenha.get().getTxtSenhaW());
		}

		usuario = usuarioDao.save(usuario);

		usuarioDto.setCodUsuario(usuario.getCodUsuario());

		return new EnvelopeResponse<UsuarioDto>(usuarioDto);
	}

	public EnvelopeResponse<List<UsuarioDto>> getListaUsuarios() {
		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDao.findAll();

		List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
		for (Usuario usuario : listaUsuarios) {
			listaUsuariosDto.add(UsuarioDto.build(usuario));
		}
		return new EnvelopeResponse<List<UsuarioDto>>(listaUsuariosDto);

	}
	
	public EnvelopeResponse<List<UsuarioDto>> getListarFuncionarios() {
		List<Usuario> listarFuncionarios = usuarioDao.getListaFuncionarios();

		List<UsuarioDto> listarUsuarioDto = new ArrayList<UsuarioDto>();
		for (Usuario usuario : listarFuncionarios) {
			UsuarioDto usuarioDto = UsuarioDto.build(usuario);
			listarUsuarioDto.add(usuarioDto);
		}
		
		return new EnvelopeResponse<List<UsuarioDto>>(listarUsuarioDto);
	}

	public EnvelopeResponse<List<UsuarioDto>> getListaUsuariosAtivos() {
		List<Usuario> listaUsuariosAtivos = (List<Usuario>) usuarioDao.findAll();

		List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
		for (Usuario usuario : listaUsuariosAtivos) {
			if (usuario.getIndAtivo().equals("S")) {
				listaUsuariosDto.add(UsuarioDto.build(usuario));
			}
		}
		return new EnvelopeResponse<List<UsuarioDto>>(listaUsuariosDto);
	}

	public EnvelopeResponse<UsuarioDto> reniciar(Integer codUsuario) {
		Usuario usuario = usuarioDao.findById(codUsuario).get();

		try {
			byte[] decodedValue = Base64.getEncoder().encode("123459".getBytes());
			String senhaEncriptada;
			senhaEncriptada = new String(decodedValue, StandardCharsets.UTF_8.toString());
			usuario.setTxtSenhaW(senhaEncriptada);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario = usuarioDao.save(usuario);
		return new EnvelopeResponse<UsuarioDto>(UsuarioDto.build(usuario));
	}

	public EnvelopeResponse<UsuarioDto> getUsuarioByCodigoUsuario(Integer codigoUsuario){
		Usuario usuario = usuarioDao.findById(codigoUsuario).get();
		return new EnvelopeResponse<UsuarioDto>(UsuarioDto.build(usuario));
	}

	public EnvelopeResponse<List<UsuarioDto>> getListaVendedores() {
		List<Usuario> listaVendedores = usuarioDao.getListaVendedores();
		
		List<UsuarioDto> listaVendedoresDto = new ArrayList<UsuarioDto>();
		for (Usuario vendedor : listaVendedores) {
			listaVendedoresDto.add(UsuarioDto.build(vendedor));
		}
		
		return new EnvelopeResponse<List<UsuarioDto>>(listaVendedoresDto);
	}
		
}