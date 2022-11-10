package siscove.siscovejava.Usuario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Usuario.Dto.UsuarioDto;
import siscove.siscovejava.Usuario.Service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController extends BaseController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<UsuarioDto> salvarUsuario(@RequestBody UsuarioDto usuarioDto) {
		EnvelopeResponse<UsuarioDto> envLogin = usuarioService.salvar(usuarioDto);
		return envLogin;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<UsuarioDto>> ListaUsuarios() {
		return usuarioService.getListaUsuarios();
	}

	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<UsuarioDto>> ListaUsuariosAtivos() {
		return usuarioService.getListaUsuariosAtivos();
	}
	
	@RequestMapping(value = "/listar/vendedores", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<UsuarioDto>> lista() {
		return usuarioService.getListaVendedores();
	}

	@RequestMapping(value = "/reniciar/senha/{codUsuario}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<UsuarioDto> reniciar(@PathVariable Integer codUsuario) {
		EnvelopeResponse<UsuarioDto> envLogin = usuarioService.reniciar(codUsuario);
		return envLogin;
	}
	
	@RequestMapping(value = "/listar/funcionarios", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<UsuarioDto>> ListarFuncionarios(@RequestBody String nmeUsuario) {
		return usuarioService.getListarFuncionarios(nmeUsuario);
	}
}
