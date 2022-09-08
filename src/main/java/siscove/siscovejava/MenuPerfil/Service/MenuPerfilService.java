package siscove.siscovejava.MenuPerfil.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Menu.Dto.MenuDto;
import siscove.siscovejava.Menu.Entity.Menu;
import siscove.siscovejava.Menu.Repository.MenuDao;
import siscove.siscovejava.MenuPerfil.Repository.MenuPerfilDao;

@Service
public class MenuPerfilService {

	@Autowired
	private MenuPerfilDao menuPerfilDao;

	@Autowired
	private MenuDao menuDao;

	public EnvelopeResponse<List<MenuDto>> getListaMenuPerfil(Integer codPerfilW) {
		List<Menu> listaMenuPerfil = menuDao.findbyCodPerfilW(codPerfilW);

		List<MenuDto> listaMenuPerfilDto = new ArrayList<MenuDto>();
		for (Menu item : listaMenuPerfil) {
			listaMenuPerfilDto.add(MenuDto.build(item));
		}
		return new EnvelopeResponse<List<MenuDto>>(listaMenuPerfilDto);
	}

	public EnvelopeResponse<List<MenuDto>> getListaMenuPerfilDesvinculados(Integer codPerfilW) {
		List<Menu> listaMenuPerfil = menuDao.findbyCodPerfilWNotIn(codPerfilW);

		List<MenuDto> listaMenuPerfilDto = new ArrayList<MenuDto>();
		for (Menu item : listaMenuPerfil) {
			listaMenuPerfilDto.add(MenuDto.build(item));
		}
		return new EnvelopeResponse<List<MenuDto>>(listaMenuPerfilDto);
	}

	
}