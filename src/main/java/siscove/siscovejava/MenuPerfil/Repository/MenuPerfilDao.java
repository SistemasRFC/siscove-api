package siscove.siscovejava.MenuPerfil.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.MenuPerfil.Entity.MenuPerfil;

@Repository(value = "MenuPerfilDao")
public interface MenuPerfilDao extends CrudRepository<MenuPerfil, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="delete from se_menu_perfil where cod_perfil_w = ?1", nativeQuery=true)
	public void deleteByCodPerfil(Integer codPerfil);
}
