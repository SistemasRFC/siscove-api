package siscove.siscovejava.MenuPerfil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.MenuPerfil.Dto.MenuPerfilDto;
import siscove.siscovejava.MenuPerfil.Service.MenuPerfilService;

@RestController
@RequestMapping(value = "/menuperfil")
public class MenuPerfilController extends BaseController {

	@Autowired
	private MenuPerfilService menuPerfilService;

	@RequestMapping(value = "/listar/{codPerfilW}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MenuPerfilDto>> ListaMenuPerfil(@PathVariable Integer codPerfilW) {
		return menuPerfilService.getListaMenuPerfil(codPerfilW);
		}
	}
