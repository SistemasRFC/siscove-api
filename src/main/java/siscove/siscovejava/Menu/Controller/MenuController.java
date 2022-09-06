package siscove.siscovejava.Menu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Menu.Dto.MenuDto;
import siscove.siscovejava.Menu.Service.MenuService;

@RestController
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<MenuDto> salvarMenu(@RequestBody MenuDto menuDto) {
		EnvelopeResponse<MenuDto> retorno = menuService.salvar(menuDto);
		return retorno;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MenuDto>> ListarMenu() {
		return menuService.getListarMenu();
	}

	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MenuDto>> ListarAtivos() {
		return menuService.getListarAtivos();
	}

	@RequestMapping(value = "/listar/{codPerfilW}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MenuDto>> ListarMenu(@PathVariable Integer codPerfilW) {
		return menuService.ListarMenu(codPerfilW);
	}

}
