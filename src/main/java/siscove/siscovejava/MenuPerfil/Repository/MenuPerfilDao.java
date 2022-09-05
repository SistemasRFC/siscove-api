package siscove.siscovejava.MenuPerfil.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.MenuPerfil.Entity.MenuPerfil;

@Repository(value = "MenuPerfilDao")
public interface MenuPerfilDao extends CrudRepository<MenuPerfil, Integer> {
	
	@Query(value="SELECT u.* FROM SE_MENU_PERFIL u WHERE COD_PERFIL_W = ?1 AND COD_MENU_W = ?2", nativeQuery=true)
	public MenuPerfil findbycodPerfilW(Integer codPerfilW , Integer codMenuW);
	
}
