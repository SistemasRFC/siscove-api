package siscove.siscovejava.Menu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Menu.Entity.Menu;

@Repository(value = "MenuDao")

public interface MenuDao extends CrudRepository<Menu, Integer> {

	@Query(value = "SELECT u.* FROM SE_MENU u WHERE COD_MENU_W = ?1 AND DSC_MENU_W = ?2", nativeQuery = true)
	public Menu findbycodPerfilW(Integer codMenuW, Integer dscMenuW);

	@Query(value="SELECT M.COD_MENU_W, "
			   + "       M.DSC_MENU_W, "
			   + "       M.NME_CONTROLLER, "
			   + "       M.IND_MENU_ATIVO_W, "
			   + "       M.COD_MENU_PAI_W, "
			   + "       M.NME_METHOD, "
			   + "       P.DSC_MENU_W AS DSC_MENU_PAI_W "
			   + "  FROM SE_MENU AS M "
			   + "  LEFT JOIN SE_MENU AS P ON M.COD_MENU_PAI_W = P.COD_MENU_W ", nativeQuery=true)
	public List<Object[]> getListaMenus();
	
	@Query(value="SELECT M.* "
			+ "  FROM SE_MENU_PERFIL U "
			+ " INNER JOIN SE_MENU M ON U.COD_MENU_W = M.COD_MENU_W "
			+ " WHERE COD_PERFIL_W = ?1"
			+ " ORDER BY M.DSC_MENU_W", nativeQuery=true)
	public List<Menu> findbyCodPerfilW(Integer codPerfilW);
	
	@Query(value="SELECT MENU.* FROM SE_MENU MENU WHERE COD_MENU_W NOT IN (SELECT M.COD_MENU_W "
			+ "  FROM SE_MENU_PERFIL U "
			+ " INNER JOIN SE_MENU M ON U.COD_MENU_W = M.COD_MENU_W "
			+ " WHERE COD_PERFIL_W = ?1)"
			+ " ORDER BY MENU.DSC_MENU_W", nativeQuery=true)
	public List<Menu> findbyCodPerfilWNotIn(Integer codPerfilW);
}
