package siscove.siscovejava.BaixaEstoque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.BaixaEstoque.Entity.BaixaEstoque;

@Repository(value = "BaixaEstoqueDao")
public interface BaixaEstoqueDao extends CrudRepository<BaixaEstoque, Integer> {

	@Query(value="SELECT * FROM EN_ENTRADA_ESTOQUE  WHERE COD_PRODUTO like %?1%", nativeQuery=true)
	public List<BaixaEstoque> findBycodProduto(String codProduto);
	

}	