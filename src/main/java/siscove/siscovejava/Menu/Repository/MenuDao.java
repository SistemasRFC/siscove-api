package siscove.siscovejava.Menu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Menu.Entity.Menu;

@Repository(value = "MenuDao")
public interface MenuDao extends CrudRepository<Menu, Integer>{


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
}
