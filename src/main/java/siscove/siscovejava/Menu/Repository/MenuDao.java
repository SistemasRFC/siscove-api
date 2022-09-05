package siscove.siscovejava.Menu.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Menu.Entity.Menu;

@Repository(value = "MenuDao")
public interface MenuDao extends CrudRepository<Menu, Integer> {

	@Query(value = "SELECT u.* FROM SE_MENU u WHERE COD_MENU_W = ?1 AND DSC_MENU_W = ?2", nativeQuery = true)
	public Menu findbycodPerfilW(Integer codMenuW, Integer dscMenuW);
}
