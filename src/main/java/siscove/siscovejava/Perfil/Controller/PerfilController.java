package siscove.siscovejava.Perfil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Perfil.Dto.PerfilDto;
import siscove.siscovejava.Perfil.Service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilController extends BaseController {

	@Autowired
	private PerfilService perfilService;


	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<PerfilDto>> getListaPerfilAtivos() {
		return perfilService.getListaPerfilAtivos();
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<PerfilDto>> ListarPerfil() {
		return perfilService.getListaPerfil();
	}
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<PerfilDto> salvarPerfil(@RequestBody PerfilDto perfilDto){
		EnvelopeResponse<PerfilDto> retorno = perfilService.salvar(perfilDto);
		return retorno;
	}
}
