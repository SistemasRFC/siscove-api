package siscove.siscovejava.Produto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Produto.Entity.Produto;

@Repository(value = "ProdutoDao")
public interface ProdutoDao extends CrudRepository<Produto, String> {

	@Query(value="SELECT * FROM EN_PRODUTO  WHERE DSC_PRODUTO like %?1%", nativeQuery=true)
	public List<Produto> findByDscProduto(String dscProduto);
	


}
