package siscove.siscovejava.Menu.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Menu.Dto.MenuDto;
import siscove.siscovejava.Menu.Entity.Menu;
import siscove.siscovejava.Menu.Repository.MenuDao;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	public EnvelopeResponse<MenuDto> salvar(MenuDto menuDto) {

		Menu menu = menuDao.save(MenuDto.parse(menuDto));

		menuDto.setCodMenuW(menu.getCodMenuW());

		return new EnvelopeResponse<MenuDto>(menuDto);
	}
	
	public EnvelopeResponse<List<MenuDto>> getListarMenu(){
		List<Menu> listarMenu = (List<Menu>) menuDao.findAll();
		
		List<MenuDto> listarMenuDto = new ArrayList<MenuDto>();
		for (Menu menu : listarMenu) {
			listarMenuDto.add(MenuDto.build(menu));
		}
		return new EnvelopeResponse<List<MenuDto>>(listarMenuDto);
	}
	
	public EnvelopeResponse<List<MenuDto>> getListarAtivos(){
		List<Menu> listarAtivos = (List<Menu>) menuDao.findAll();
		
		List <MenuDto> listarAtivosDto = new ArrayList<MenuDto>();
		for (Menu menu : listarAtivos) {
			if (menu.getIndMenuAtivoW  ().equals("S")) 
			    listarAtivosDto.add(MenuDto.build(menu));
		}
		return new EnvelopeResponse<List<MenuDto>>(listarAtivosDto);
	}

	
	

}
