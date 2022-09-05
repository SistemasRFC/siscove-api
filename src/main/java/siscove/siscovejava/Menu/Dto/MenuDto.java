	package siscove.siscovejava.Menu.Dto;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Menu.Entity.Menu;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuDto {
	
	private Integer codMenuW;
	private String dscMenuW;
	private String nmeController;
	private String indMenuAtivoW;
	private Integer codMenuPaiW;
	private String nmeMethod;
	private String dscCaminhoImagem;
	private String indAtalho;
	private String dscMenuPai;
	
//	public MenuDto(Menu menu) {
//		codMenuW = menu.getCodMenuW(); 
//		dscMenuW = menu.getDscMenuW();
//		nmeController = menu.getNmeController();
//		indMenuAtivoW = menu.getIndMenuAtivoW();
//		codMenuPaiW = menu.getCodMenuPaiW();
//	}
	
	public static Menu parse(MenuDto menuDto) {
		Menu menu = new Menu();
		menu.setCodMenuW(menuDto.getCodMenuW());
		menu.setDscMenuW(menuDto.getDscMenuW());
		menu.setNmeController(menuDto.getNmeController());
		menu.setIndMenuAtivoW(menuDto.getIndMenuAtivoW());
		menu.setCodMenuPaiW(menuDto.getCodMenuPaiW());
		menu.setNmeMethod(menuDto.getNmeMethod());
		menu.setDscCaminhoImagem(menuDto.getDscCaminhoImagem());
		menu.setIndAtalho(menuDto.getIndAtalho());
		return menu;
	}

	public static MenuDto build(Menu menu) {
		MenuDto menuDto = new MenuDto(
		menu.getCodMenuW(), 
		menu.getDscMenuW(),
		menu.getNmeController(),
		menu.getIndMenuAtivoW(),
		menu.getCodMenuPaiW(),
		menu.getNmeMethod(),
		menu.getDscCaminhoImagem(),
		menu.getIndAtalho(),
		null);
		return menuDto;
	}

}

		
	