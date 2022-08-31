package siscove.siscovejava.Menu_Perfil.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Menu_Perfil.Dto.MenuPerfilDto;
import siscove.siscovejava.Menu_Perfil.Service.MenuPerfilService;

@RestController
@RequestMapping(value = "/menuperfil")
public class MenuPerfilController extends BaseController {


	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MenuPerfilDto>> ListaMenuPerfil() {
		return MenuPerfilService.getListaMenuPerfil();
	}
}