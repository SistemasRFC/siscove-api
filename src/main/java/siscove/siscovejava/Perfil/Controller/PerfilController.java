package siscove.siscovejava.Perfil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<PerfilDto>> getListaPerfil() {
		return perfilService.getListaPerfil();
	}
}
