package siscove.siscovejava.MenuPerfil.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.MenuPerfil.Entity.MenuPerfil;

@Repository(value = "MenuPerfilDao")
public interface MenuPerfilDao extends CrudRepository<MenuPerfil, Integer> {
	

	
}
