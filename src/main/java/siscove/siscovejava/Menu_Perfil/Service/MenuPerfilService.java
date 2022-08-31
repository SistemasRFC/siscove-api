package siscove.siscovejava.Menu_Perfil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Menu_Perfil.Dto.MenuPerfilDto;
import siscove.siscovejava.Menu_Perfil.Repository.MenuPerfilDao;

public class MenuPerfilService {


	@Autowired
	private MenuPerfilDao menuperfilDao;

	public static EnvelopeResponse<List<MenuPerfilDto>> getListaMenuPerfil() {
		// TODO Auto-generated method stub
		return null;
	}
}
