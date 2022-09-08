package siscove.siscovejava.MenuPerfil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Menu.Dto.MenuDto;
import siscove.siscovejava.MenuPerfil.Service.MenuPerfilService;

@RestController
@RequestMapping(value = "/menuperfil")
public class MenuPerfilController extends BaseController {

	@Autowired
	private MenuPerfilService menuPerfilService;

	@RequestMapping(value = "/listar/menu/vinculados/{codPerfilW}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MenuDto>> ListaMenuPerfil(@PathVariable Integer codPerfilW) {
		return menuPerfilService.getListaMenuPerfil(codPerfilW);
	}

	@RequestMapping(value = "/listar/menu/desvinculados/{codPerfilW}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MenuDto>> ListaMenuPerfilDesvinculados(@PathVariable Integer codPerfilW) {
		return menuPerfilService.getListaMenuPerfilDesvinculados(codPerfilW);
	}

	

}
