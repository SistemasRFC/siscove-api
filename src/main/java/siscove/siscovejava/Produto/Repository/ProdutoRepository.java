package siscove.siscovejava.Produto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Produto.Entity.Produto;

@Repository(value = "ProdutoRepository")
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	@Query(value="select * from EN_PRODUTO WHERE DSC_PRODUTO like %?1% AND IND_ATIVO = 'S'", nativeQuery=true)
	public List<Produto> findBydscProduto(String dscProduto);
	
	

}
