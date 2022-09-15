package Produto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Menu.Entity.Menu;

	
	@Repository(value = "ProdutoDao")

	public interface ProdutoDao extends CrudRepository<Produto, Integer> {

		@Query(value = "SELECT u.* FROM EN_TIPO_PRODUTO u WHERE COD_TIPO_PRODUTO= ?1 AND DSC_TIPO_PRODUTO = ?2", nativeQuery = true)
		public Produto findbycodTipoProduto(Integer codTipoProduto, Integer dscTipoProduto);

		@Query(value="SELECT M.COD_TIPO_PRODUTO, "
				   + "       M.DSC_TIPO_PRODUTO, "
				   + "       M.COD_CLIENTE_FINAL, "
				   + "       M.IND_ATIVO, " 
				   
		public List<Object[]> getListaProduto();
		
		@Query(value="SELECT M.* "
				+ "  FROM EN_TIPO_PRODUTO U "
				+ " INNER JOIN EN_TIPO_PRODUTO M ON U.COD_TIPO_PRODUTO = M.COD_TIPO_PRODUTO "
				+ " WHERE COD_CLIENTE_FINAL = ?1"
				+ " ORDER BY M.DSC_TIPO_PRODUTO", nativeQuery=true)
		public List<Menu> findbyCodTipoProduto(Integer codClienteFinal);
		
	}

