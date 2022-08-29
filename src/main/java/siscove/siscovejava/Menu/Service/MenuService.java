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
		List<Object[]> listarMenu = (List<Object[]>) menuDao.getListaMenus();
		
		List<MenuDto> listarMenuDto = new ArrayList<MenuDto>();
		for (Object[] menu : listarMenu) {
			listarMenuDto.add(new MenuDto(
					Integer.valueOf(menu[0].toString()), 
					menu[1].toString(), 
					menu[2].toString(), 
					menu[3].toString(), 
					Integer.valueOf(menu[4].toString()), 
					null==menu[5]?"":menu[5].toString(), 
					null, 
					null, 
					null==menu[6]?"":menu[6].toString()));
		}
		return new EnvelopeResponse<List<MenuDto>>(listarMenuDto);
	}
	
	public EnvelopeResponse<List<MenuDto>> getListarAtivos(){
		List<Menu> listarAtivos = (List<Menu>) menuDao.findAll();
		
		List <MenuDto> listarAtivosDto = new ArrayList<MenuDto>();
		for (Menu menu : listarAtivos) {
			if (menu.getIndMenuAtivoW().equals("S")) 
			    listarAtivosDto.add(MenuDto.build(menu));
		}
		return new EnvelopeResponse<List<MenuDto>>(listarAtivosDto);
	}

	
	

}
