package TipoProduto.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TipoProduto.Entity.TipoProduto;

@Repository(value = "TipoProdutoDao")
public interface TipoProdutoDao extends CrudRepository<TipoProduto, Integer> {

	public List<TipoProduto> getListarTipoProduto();
}	