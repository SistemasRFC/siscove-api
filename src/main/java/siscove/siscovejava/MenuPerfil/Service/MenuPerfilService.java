package siscove.siscovejava.MenuPerfil.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.MenuPerfil.Dto.MenuPerfilDto;
import siscove.siscovejava.MenuPerfil.Entity.MenuPerfil;
import siscove.siscovejava.MenuPerfil.Repository.MenuPerfilDao;

@Service
public class MenuPerfilService {

	@Autowired
	private MenuPerfilDao menuPerfilDao;;

	public EnvelopeResponse<List<MenuPerfilDto>> getListaMenuPerfil(Integer codPerfilW) {
		MenuPerfil menuperfil = menuPerfilDao.findById(codPerfilW).get();

		List<MenuPerfilDto> listaMenuPerfilDto = new ArrayList<MenuPerfilDto>();
		{
			listaMenuPerfilDto.add(MenuPerfilDto.build(menuperfil));
		}
		return new EnvelopeResponse<List<MenuPerfilDto>>(listaMenuPerfilDto);
	}

	
}